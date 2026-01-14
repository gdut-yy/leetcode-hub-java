public class Solution3777 {
    public int[] minDeletions(String s, int[][] queries) {
        int size = 0;
        for (int[] q : queries) {
            size += q[0] - 1;
        }

        SegmentTree t = new SegmentTree(s);
        int[] ans = new int[size];
        int idx = 0;
        for (int[] q : queries) {
            if (q[0] == 1) {
                t.flip(q[1]);
            } else {
                ans[idx++] = t.query(q[1], q[2]);
            }
        }
        return ans;
    }

    static class SegmentTree {
        private static class Data {
            byte lc; // 区间左端点字母
            byte rc; // 区间右端点字母
            int del = 0; // 区间删除次数
        }

        private Data merge(Data l, Data r) {
            Data res = new Data();
            res.lc = l.lc;
            res.rc = r.rc;
            res.del = l.del + r.del + (l.rc == r.lc ? 1 : 0); // 端点相同时，合并后多删一次
            return res;
        }

        private final int n;
        private final Data[] t;

        public SegmentTree(String s) {
            n = s.length();
            t = new Data[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
            build(s.toCharArray(), 1, 0, n - 1);
        }

        public void flip(int i) {
            flip(1, 0, n - 1, i);
        }

        public int query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr).del;
        }

        private void maintain(int node) {
            t[node] = merge(t[node * 2], t[node * 2 + 1]);
        }

        private void build(char[] a, int node, int l, int r) {
            t[node] = new Data();
            if (l == r) { // 叶子
                t[node].lc = t[node].rc = (byte) (a[l] - 'A');
                return;
            }
            int m = (l + r) / 2;
            build(a, node * 2, l, m); // 初始化左子树
            build(a, node * 2 + 1, m + 1, r); // 初始化右子树
            maintain(node);
        }

        private void flip(int node, int l, int r, int i) {
            if (l == r) { // 叶子（到达目标）
                t[node].lc ^= 1;
                t[node].rc ^= 1;
                return;
            }
            int m = (l + r) / 2;
            if (i <= m) { // i 在左子树
                flip(node * 2, l, m, i);
            } else { // i 在右子树
                flip(node * 2 + 1, m + 1, r, i);
            }
            maintain(node);
        }

        private Data query(int node, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) { // 当前子树完全在 [ql, qr] 内
                return t[node];
            }
            int m = (l + r) / 2;
            if (qr <= m) { // [ql, qr] 在左子树
                return query(node * 2, l, m, ql, qr);
            }
            if (ql > m) { // [ql, qr] 在右子树
                return query(node * 2 + 1, m + 1, r, ql, qr);
            }
            Data lRes = query(node * 2, l, m, ql, qr);
            Data rRes = query(node * 2 + 1, m + 1, r, ql, qr);
            return merge(lRes, rRes);
        }
    }
}
/*
3777. 使子字符串变交替的最少删除次数
https://leetcode.cn/problems/minimum-deletions-to-make-alternating-substring/description/

第 480 场周赛 T4。

给你一个长度为 n 的字符串 s，其中仅包含字符 'A' 和 'B'。
你还获得了一个长度为 q 的二维整数数组 queries，其中每个 queries[i] 是以下形式之一：
- [1, j]：反转 s 中下标为 j 的字符，即 'A' 变为 'B'（反之亦然）。此操作会修改 s 并影响后续查询。
- [2, l, r]：计算 使 子字符串 s[l..r] 变成 交替字符串 所需的 最小 字符删除数。此操作不会修改 s；s 的长度保持为 n。
如果 子字符串 中不存在两个 相邻 字符 相等 的情况，则该子字符串是 交替字符串。长度为 1 的子字符串始终是交替字符串。
返回一个整数数组 answer，其中 answer[i] 是第 i 个类型为 [2, l, r] 的查询的结果。
子字符串 是字符串中一段连续的 非空 字符序列。
提示：
1 <= n == s.length <= 10^5
s[i] 要么是 'A'，要么是 'B'。
1 <= q == queries.length <= 10^5
queries[i].length == 2 或 3
queries[i] == [1, j] 或
queries[i] == [2, l, r]
0 <= j <= n - 1
0 <= l <= r <= n - 1

线段树。
时间复杂度 O(n+qlogn)。
rating 2215 (clist.by)
 */