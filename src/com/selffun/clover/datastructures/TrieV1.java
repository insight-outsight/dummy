package com.selffun.clover.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an implementation of a java trie. It is a tree structure representing words.
 *  Each node in the tree represents a single character, as shown below;
Trie with the words car, cat and dog added.
               root
              /    \
             c      d
            /         \
           a           o
          /  \          \
         r    t          g
The trie can be searched by prefix, returning a list of words which begin with the 
prefix. There are two classes, Trie and TrieNode. I've done a moderate amount of 
testing, but any improvements welcome. If anybody has any very large lists of words 
I'd be interested in doing some performance testing.


1. Re: Java Trie
807591
Newbie
807591 2008-5-14 下午3:18 （回复 611760）
Looks like it'll work to me.

A couple checks you should add:
1. Trie.addWord(String word) should check if word.isEmpty() (otherwise I think it'll throw an IndexOutofBoundsException).
2. TrieNode.addWord() will fail if invalid characters are in the String. Preferrably, check for them in Trie.addWord() and throw an IllegalArgumentException (if you check for them in TrieNode instead of in Trie, you could end up with partially added words in your tree).

If you want to improve performance, toString() could be written using a loop instead of using recursion (this would allow you to make use of a StringBuilder or other such mutable CharSequence).

getWords() could also be sped up by passing a List around instead of creating a List for every single node in the tree.

Adding support for removing words (which would actually remove nodes, not just reset the isWord flag) could be your next expansion.

 * @Ref https://community.oracle.com/thread/2070706
 *
 * 【未测试】
 */
public class TrieV1 {
    private TrieNode root;
    
    /**
     * Constructor
     */
    public TrieV1()
    {
       root = new TrieNode();
    }
    
    /**
     * Adds a word to the Trie
     * @param word
     */
    public void addWord(String word)
    {
       root.addWord(word.toLowerCase());
    }
    
    /**
     * Get the words in the Trie with the given
     * prefix
     * @param prefix
     * @return a List containing String objects containing the words in
     *         the Trie with the given prefix.
     */
    public List<String> getWords(String prefix)
    {
       //Find the node which represents the last letter of the prefix
       TrieNode lastNode = root;
       for (int i=0; i<prefix.length(); i++)
       {
       lastNode = lastNode.getNode(prefix.charAt(i));
       
       //If no node matches, then no words exist, return empty list
       if (lastNode == null) return new ArrayList<String>();      
       }
       
       //Return the words which eminate from the last node
       return lastNode.getWords();
    }
    
    private static class TrieNode {
        private TrieNode parent;
        private TrieNode[] children;
        private boolean isLeaf; // Quick way to check if any children exist
        private boolean isWord; // Does this node represent the last character of a word
        private char character; // The character this node represents

        /**
         * Constructor for top level root node.
         */
        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = true;
            isWord = false;
        }

        /**
         * Constructor for child node.
         */
        public TrieNode(char character) {
            this();
            this.character = character;
        }

        /**
         * Adds a word to this node. This method is called recursively and adds child
         * nodes for each successive letter in the word, therefore recursive calls will
         * be made with partial words.
         * 
         * @param word the word to add
         */
        protected void addWord(String word) {
            isLeaf = false;
            int charPos = word.charAt(0) - 'a';

            if (children[charPos] == null) {
                children[charPos] = new TrieNode(word.charAt(0));
                children[charPos].parent = this;
            }

            if (word.length() > 1) {
                children[charPos].addWord(word.substring(1));
            } else {
                children[charPos].isWord = true;
            }
        }

        /**
         * Returns the child TrieNode representing the given char, or null if no node
         * exists.
         * 
         * @param c
         * @return
         */
        protected TrieNode getNode(char c) {
            return children[c - 'a'];
        }

        /**
         * Returns a List of String objects which are lower in the hierarchy that this
         * node.
         * 
         * @return
         */
        protected List<String> getWords() {
            // Create a list to return
            List<String> list = new ArrayList<String>();

            // If this node represents a word, add it
            if (isWord) {
                list.add(toString());
            }

            // If any children
            if (!isLeaf) {
                // Add any words belonging to any children
                for (int i = 0; i < children.length; i++) {
                    if (children[i] != null) {
                        list.addAll(children[i].getWords());
                    }
                }
            }
            return list;

        }

        /**
         * 
         * Gets the String that this node represents.
         * 
         * For example, if this node represents the character t, whose parent
         * 
         * represents the charater a, whose parent represents the character
         * 
         * c, then the String would be "cat".
         * 
         * @return
         * 
         */

        public String toString()
        {
            if (parent == null)
            {
                return "";
            }
            else
            {
                return parent.toString() + new String(new char[] { character });
            }
        }

    }

}
