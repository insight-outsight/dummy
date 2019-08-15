package com.selffun.clover.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树又称单词查找树，Trie树，是一种树形结构，是一种哈希树的变种。典型应用是用于统计，排序和保存大
 * 量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。它的优点是：利用字符串的公
 * 共前缀来节约存储空间，最大限度地减少无谓的字符串比较，查询效率比哈希表高。
 * 
 * 字典树与字典很相似,当你要查一个单词是不是在字典树中,首先看单词的第一个字母是不是在字典的第一层,如果
 * 不在,说明字典树里没有该单词,如果在就在该字母的孩子节点里找是不是有单词的第二个字母,没有说明没有该单词,
 * 有的话用同样的方法继续查找.字典树不仅可以用来储存字母,也可以储存数字等其它数据。
 * 
 * @Ref https://www.cnblogs.com/gaopeng527/p/4887765.html
 *
 *【未测试】
 */
public class TrieV4 {
    private TrieNode root;

    public TrieV4() {
        root = new TrieNode();
        root.wordEnd = false;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = new Character(word.charAt(i));
            if (!node.childdren.containsKey(c)) {
                node.childdren.put(c, new TrieNode());
            }
            node = node.childdren.get(c);
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        boolean found = true;
        for (int i = 0; i < word.length(); i++) {
            Character c = new Character(word.charAt(i));
            if (!node.childdren.containsKey(c)) {
                return false;
            }
            node = node.childdren.get(c);
        }
        return found && node.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        boolean found = true;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = new Character(prefix.charAt(i));
            if (!node.childdren.containsKey(c)) {
                return false;
            }
            node = node.childdren.get(c);
        }
        return found;
    }

    private static class TrieNode {
        Map<Character, TrieNode> childdren;
        boolean wordEnd;

        public TrieNode() {
            childdren = new HashMap<Character, TrieNode>();
            wordEnd = false;
        }
    }
    
}
