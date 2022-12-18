public class Solution2213 {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int k = queryCharacters.length();

        int[] res = new int[k];
        SegmentTree segmentTree = new SegmentTree(chars);
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            segmentTree.chars[idx] = queryCharacters.charAt(i);
            segmentTree.update(1, n, 1, idx + 1);
            res[i] = segmentTree.tree[1].max;
        }
        return res;
    }

    private static class SegmentTree {
        private static class Node {
            int pre;
            int suf;
            int max;

            public Node(int pre, int suf, int max) {
                this.pre = pre;
                this.suf = suf;
                this.max = max;
            }
        }

        private final Node[] tree;
        private final char[] chars;

        public SegmentTree(char[] chars) {
            int N = chars.length;
            this.chars = chars;
            tree = new Node[4 * N];
            for (int i = 0; i < 4 * N; i++) {
                tree[i] = new Node(0, 0, 0);
            }
            build(1, N, 1);
        }

        private void build(int s, int t, int p) {
            if (s == t) {
                tree[p].pre = 1;
                tree[p].suf = 1;
                tree[p].max = 1;
                return;
            }
            int mid = s + (t - s) / 2;
            build(s, mid, p * 2);
            build(mid + 1, t, p * 2 + 1);
            maintain(s, t, p);
        }

        private void maintain(int s, int t, int p) {
            Node lNode = tree[p * 2];
            Node rNode = tree[p * 2 + 1];

            tree[p].pre = lNode.pre;
            tree[p].suf = rNode.suf;
            tree[p].max = Math.max(lNode.max, rNode.max);
            int mid = s + (t - s) / 2;
            // 中间字符相同，可以合并
            if (chars[mid - 1] == chars[mid]) {
                if (lNode.suf == mid - s + 1) {
                    tree[p].pre += rNode.pre;
                }
                if (rNode.suf == t - mid) {
                    tree[p].suf += lNode.suf;
                }
                tree[p].max = Math.max(tree[p].max, lNode.suf + rNode.pre);
            }
        }

        private void update(int s, int t, int p, int i) {
            if (s == t) {
                return;
            }
            int mid = s + (t - s) / 2;
            if (i <= mid) {
                update(s, mid, p * 2, i);
            } else {
                update(mid + 1, t, p * 2 + 1, i);
            }
            maintain(s, t, p);
        }
    }
}
/*
2213. 由单个字符重复的最长子字符串
https://leetcode.cn/problems/longest-substring-of-one-repeating-character/

第 285 场周赛 T4。

给你一个下标从 0 开始的字符串 s 。另给你一个下标从 0 开始、长度为 k 的字符串 queryCharacters ，一个下标从 0 开始、长度也是 k 的整数 下标 数组 queryIndices ，这两个都用来描述 k 个查询。
第 i 个查询会将 s 中位于下标 queryIndices[i] 的字符更新为 queryCharacters[i] 。
返回一个长度为 k 的数组 lengths ，其中 lengths[i] 是在执行第 i 个查询 之后 s 中仅由 单个字符重复 组成的 最长子字符串 的 长度 。
提示：
1 <= s.length <= 10^5
s 由小写英文字母组成
k == queryCharacters.length == queryIndices.length
1 <= k <= 10^5
queryCharacters 由小写英文字母组成
0 <= queryIndices[i] < s.length

和字符集大小无关的线段树做法。主要逻辑是 maintain 的写法。
https://leetcode.cn/problems/longest-substring-of-one-repeating-character/solution/by-endlesscheng-qpbw/
 */