public class Solution677 {
    static class MapSum {
        private static class TrieNode {
            TrieNode[] children;
            boolean isWord;
            int value;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        TrieNode root;

        /**
         * 初始化 MapSum 对象
         */
        public MapSum() {
            root = new TrieNode();
        }

        /**
         * 插入 key-val 键值对，字符串表示键 key，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
         *
         * @param key key
         * @param val val
         */
        public void insert(String key, int val) {
            TrieNode node = root;
            for (char ch : key.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.value = val;
        }

        /**
         * 返回所有以该前缀 prefix 开头的键 key 的值的总和。
         *
         * @param prefix prefix
         * @return int
         */
        public int sum(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    return 0;
                }
                node = node.children[ch - 'a'];
            }
            return getSum(node);
        }

        private int getSum(TrieNode node) {
            if (node == null) {
                return 0;
            }
            int res = node.value;
            for (TrieNode child : node.children) {
                res += getSum(child);
            }
            return res;
        }
    }
}
/*
677. 键值映射
https://leetcode.cn/problems/map-sum-pairs/

实现一个 MapSum 类，支持两个方法，insert 和 sum：

前缀树。
 */