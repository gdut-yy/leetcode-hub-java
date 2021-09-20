import java.util.List;

public class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);
        String[] sentences = sentence.split(" ");
        for (int i = 0; i < sentences.length; i++) {
            String prefix = findPrefix(root, sentences[i]);
            if (prefix.length() != 0) {
                sentences[i] = prefix;
            }
        }
        return String.join(" ", sentences);
    }

    private TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String dict : dictionary) {
            TrieNode node = root;
            for (char ch : dict.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    private String findPrefix(TrieNode root, String sentence) {
        TrieNode node = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : sentence.toCharArray()) {
            if (node.isWord || node.children[ch - 'a'] == null) {
                break;
            }
            stringBuilder.append(ch);
            node = node.children[ch - 'a'];
        }
        return node.isWord ? stringBuilder.toString() : "";
    }

    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
/*
648. 单词替换
https://leetcode-cn.com/problems/replace-words/

给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
需要输出替换之后的句子。
输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
输出："the cat was rat by the bat"

前缀树。
 */