package Solution.Structure;

import java.util.HashMap;

/**
 * @author BorisMirage
 * Time: 2019/07/03 15:09
 * Created with IntelliJ IDEA
 */

public class Trie_208 {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie_208() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     *
     * @param word word to be inserted to trie
     */
    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.containsChild(word.charAt(i))) {
                temp.addChild(word.charAt(i));
            }
            temp = temp.getChild(word.charAt(i));
        }
        temp.setEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     *
     * @param word given word
     * @return if word is in trie
     */
    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (temp.containsChild(word.charAt(i))) {
                temp = temp.getChild(word.charAt(i));
            } else {
                return false;
            }
        }
        return temp.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     *
     * @param prefix given prefix
     * @return if prefix is in trie
     */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.containsChild(prefix.charAt(i))) {
                temp = temp.getChild(prefix.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * Nodes in trie.
     */
    class TrieNode {
        char val;       // value of current node
        HashMap<Character, TrieNode> m = new HashMap<>();       // save children of current trie
        boolean end = false;

        /**
         * Initialization.
         */
        TrieNode() {
        }


        /**
         * Set current node's value.
         *
         * @param val value to be set
         */
        void setVal(char val) {
            this.val = val;
        }

        /**
         * Add child to current node.
         *
         * @param val children value
         */
        void addChild(char val) {
            this.m.put(val, new TrieNode());
            this.m.get(val).setVal(val);
        }

        /**
         * Mark current node as end of word.
         *
         * @param b boolean to be set
         */
        void setEnd(boolean b) {
            this.end = b;
        }

        /**
         * Check if current node is an end of a word.
         *
         * @return true if current node is an end of a word, false otherwise
         */
        boolean isEnd() {
            return this.end;
        }

        /**
         * Return the child based on given value.
         *
         * @param val value of child
         * @return child node
         */
        TrieNode getChild(char val) {
            return m.get(val);
        }

        /**
         * Get value of current node.
         *
         * @return value in current node
         */
        char getVal() {
            return this.val;
        }

        /**
         * Check if given char is contained in current node's child.
         *
         * @param val given value
         * @return true if given char is in child
         */
        boolean containsChild(char val) {
            return m.containsKey(val);
        }
    }

    public static void main(String[] args) {
        Trie_208 test = new Trie_208();
        test.insert("app");
        test.insert("apple");
        test.insert("beer");
        test.insert("add");
        test.insert("jam");
        test.insert("rental");
        System.out.println(test.search("app"));
        System.out.println(test.search("apps"));
        System.out.println(test.startsWith("beer"));
        test.insert("app");
        System.out.println(test.search("app"));
    }
}
