public class Solution820 {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);
        int[] total = {0};
        dfs(root, 1, total);
        return total[0];
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
        }
        return root;
    }

    private void dfs(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1, total);
            }

        }
        if (isLeaf) {
            total[0] += length;
        }
    }

    private static class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
/*
820. 单词的压缩编码
https://leetcode-cn.com/problems/short-encoding-of-words/

单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：

前缀树。
字符串倒序，后缀变为前缀。
 */