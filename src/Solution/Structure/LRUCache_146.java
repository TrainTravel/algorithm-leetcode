package Solution.Structure;

import Lib.CacheLine;

import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * get(key): Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value): Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * Example:
 * LRUCache_146 cache = new LRUCache_146(2);
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // since size limit reached and key 2 is least used, evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 * @author BorisMirage
 * Time: 2018/09/28 21:04
 * Created with IntelliJ IDEA
 */

public class LRUCache_146 {
    private int capacity;
    private CacheLine head;
    private CacheLine end;
    private int c = 0;      // count total cache size
    private HashMap<Integer, CacheLine> cache = new HashMap<>();

    /**
     * Structure of cache:
     * Basically, use node to store key and value. A hash map in this cache is to store key-node pair for searching key.
     * CacheLine works as a double linked list, which contains previous CacheLine and next CacheLine.
     * When <code>put</code> operation finds a existing key, move corresponding node to top of the list.
     * When put a new pair into cache, first check size to avoid oversize, then add this node to top of list.
     * If cache is oversize, then remove last CacheLine in double linked list. And remove corresponding key as well.
     *
     * @param capacity cache capacity
     */
    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        this.head = new CacheLine();
        head.previous = null;
        this.end = new CacheLine();
        end.next = null;
        head.next = end;
        end.previous = head;
    }

    /**
     * <code>get</code> operation. Return -1 if key is not found in cache.
     *
     * @param key requesting key
     * @return corresponding value, or -1.
     */
    public int get(int key) {
        CacheLine temp = cache.get(key);
        if (temp == null) {
            return -1;
        }
        lastUsed(temp);
        return temp.val;
    }

    /**
     * <code>put</code> operation, put new key-value pair into cache.
     * If cache is oversize, it will remove Least Recently Used (LRU) CacheLine store in cache.
     *
     * @param key   new key
     * @param value new value
     */
    public void put(int key, int value) {

        CacheLine node = cache.get(key);

        if (node == null) {
            CacheLine add = new CacheLine();
            add.key = key;
            add.val = value;
            c++;
            if (c > capacity) {
                cache.remove(popEnd().key);
                addNode(add);
                cache.put(key, add);
                c--;
            } else {
                addNode(add);
                cache.put(key, add);
            }
        } else {
            cache.get(key).val = value;
            lastUsed(cache.get(key));
        }
    }

    /**
     * Remove given CacheLine.
     *
     * @param node given CacheLine
     */
    private void removeNode(CacheLine node) {
        CacheLine pre = node.previous;
        CacheLine next = node.next;
        pre.next = next;
        next.previous = pre;
    }

    /**
     * Move given node next to head node.
     * Note that this node will be removed.
     *
     * @param node
     */
    private void lastUsed(CacheLine node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * Add a new CacheLine next to head.
     *
     * @param node CacheLine to be moved
     */
    private void addNode(CacheLine node) {
        node.previous = head;
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
    }

    /**
     * Remove last CacheLine.
     * Hash map needs to know which key to remove, hence pop node is required.
     *
     * @return pop node
     */
    private CacheLine popEnd() {
        CacheLine old = end.previous;
        this.removeNode(old);
        return old;
    }

    public static void main(String[] args) {
        LRUCache_146 testCache = new LRUCache_146(2);

        testCache.put(1, 1);
        testCache.put(2, 2);
        System.out.println(testCache.get(1));
        testCache.put(3, 3);
        System.out.println(testCache.get(2));
        testCache.put(4, 4);
        System.out.println(testCache.get(1));
        System.out.println(testCache.get(3));
        System.out.println(testCache.get(4));
        System.out.println(testCache);
    }
}

