package com.selffun.clover.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * A trie node should contains the character, its children and the flag that marks if 
 * it is a leaf node. You can use the trie in the following diagram to walk though the 
 * Java solution.
 * <img alt="althernative text" style="width:300;height:200" src ="https://www.programcreek.com/wp-content/uploads/2014/05/implement-trie-prefix-tree-768x402.png" />
 * 
 * @Ref https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 *
 *【未测试，但看起通用性强，不限于字典字符查找】
 */
public class TrieV2 {

    private TrieNode root;

    public TrieV2() {
            root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            // set leaf node
            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if (t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }

    private static class TrieNode {
        private char c;
        private HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        private boolean isLeaf;
     
        public TrieNode() {}
     
        public TrieNode(char c){
            this.c = c;
        }
    }
    
}
