package Mirage.LeetCodeSolution;

/**
 * Design a HashMap without using any built-in hash table libraries.
 * To be specific, your design should include these functions:
 * - put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * - get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * - remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * @author BorisMirage
 * Time: 2018/10/07 17:49
 * Created with IntelliJ IDEA
 * No.100
 */

public class MyHashMap {
    private int[] map;

    /**
     * Initialize map.
     */
    public MyHashMap() {
        this.map = new int[1000001];
    }

    /**
     * Value will always be non-negative.
     *
     * @param key   given key
     * @param value given value
     */
    public void put(int key, int value) {
        map[key] = value + 1;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     *
     * @param key given key
     * @return corresponding value
     */
    public int get(int key) {
        return map[key] - 1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     *
     * @param key given key
     */
    public void remove(int key) {
        map[key] = 0;
    }
}
