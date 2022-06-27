public class Solution676 {
    static class MagicDictionary {
        private static class TrieNode {
            TrieNode[] children;
            boolean isWord;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        private final TrieNode root;

        /**
         * 初始化对象
         */
        public MagicDictionary() {
            root = new TrieNode();
        }

        /**
         * 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
         *
         * @param dictionary dictionary
         */
        public void buildDict(String[] dictionary) {
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
        }

        /**
         * 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。
         * 如果可以，返回 true ；否则，返回 false 。
         *
         * @param searchWord searchWord
         * @return true/false
         */
        public boolean search(String searchWord) {
            return dfs(root, searchWord, 0, 0);
        }

        private boolean dfs(TrieNode root, String searchWord, int idx, int edit) {
            if (root == null) {
                return false;
            }
            if (root.isWord && idx == searchWord.length() && edit == 1) {
                return true;
            }
            if (idx < searchWord.length() && edit <= 1) {
                boolean found = false;
                for (int i = 0; i < 26 && !found; i++) {
                    int next;
                    if (i == searchWord.charAt(idx) - 'a') {
                        next = edit;
                    } else {
                        next = edit + 1;
                    }
                    found = dfs(root.children[i], searchWord, idx + 1, next);
                }
                return found;
            }
            return false;
        }
    }
}
/*
676. 实现一个魔法字典
https://leetcode.cn/problems/implement-magic-dictionary/

设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同。
如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。

前缀树。
 */