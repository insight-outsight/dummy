package com.selffun.clover.datastructures;

/**
 * Each trie node can only contains 'a'-'z' characters. So we can use a small array 
 * to store the character.
 * 
 * If the same words can be inserted more than once, what do you
 *  need to change to make it work?
 *
 * @Ref https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 *
 *【未测试】
 */
public class TrieV3 {

    private TrieNode root;
    
    public TrieV3() {
        root = new TrieNode();
    }
 
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index]=temp;
                p = temp;
            }else{
                p=p.arr[index];
            }
        }
        p.isEnd=true;
    }
 
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if(p==null){
            return false;
        }else{
            if(p.isEnd)
                return true;
        }
 
        return false;
    }
 
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if(p==null){
            return false;
        }else{
            return true;
        }
    }
 
    public TrieNode searchNode(String s){
        TrieNode p = root;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            int index = c-'a';
            if(p.arr[index]!=null){
                p = p.arr[index];
            }else{
                return null;
            }
        }
 
        if(p==root)
            return null;
 
        return p;
    }
    
    private static class TrieNode {
        TrieNode[] arr;
        boolean isEnd;
        // Initialize your data structure here.
        public TrieNode() {
            this.arr = new TrieNode[26];
        }
    }
}
