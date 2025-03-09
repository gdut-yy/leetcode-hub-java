import java.util.Arrays;

public class Solution3479 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        LazySegmentTree seg = new LazySegmentTree(n);
        seg.build(baskets, 1, 0, n - 1);
        int ans = 0;
        for (int fr : fruits) {
            int pos = seg.findFirst(1, 0, n - 1, fr);
            if (pos == -1) {
                ans++;
            } else {
                seg.modify(1, 0, n - 1, pos, pos, 0);
            }
        }
        return ans;
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class LazySegmentTree {
        static class Info {
            int max0; // 区间最长连续 0 的个数
            int lazy; // 懒标记

            public Info(int max0, int lazy) {
                this.max0 = max0;
                this.lazy = lazy;
            }
        }

        Info mergeInfo(Info a, Info b, int l, int r) {
            int m = (l + r) >> 1;

            int max0 = Math.max(a.max0, b.max0);
            return new Info(max0, -1);
        }

        void _do(int p, int l, int r, int qv) {
//            int size = qv <= 0 ? r - l + 1 : 0;
//            info[p].pre0 = info[p].suf0 = info[p].max0 = size;
            info[p].max0 = qv;
            info[p].lazy = qv;
        }

        int n;
        Info[] info;

        public LazySegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
            Arrays.setAll(info, e -> new Info(0, -1));
        }

        void build(int[] A, int p, int l, int r) {
//            _do(p, l, r, -1);
            if (l == r) {
                info[p] = new Info(A[l], -1);
                return;
            }
            int m = (l + r) >> 1;
            build(A, p << 1, l, m);
            build(A, p << 1 | 1, m + 1, r);
            maintain(p, l, r);
        }

        void maintain(int p, int l, int r) {
            info[p] = mergeInfo(info[p << 1], info[p << 1 | 1], l, r);
        }

        void spread(int p, int l, int r) {
            int v = info[p].lazy;
            if (v == -1) return;
            int m = (l + r) >> 1;
            _do(p << 1, l, m, v);
            _do(p << 1 | 1, m + 1, r, v);
            info[p].lazy = -1;
        }

        void modify(int p, int l, int r, int ql, int qr, int qv) {
            if (ql <= l && r <= qr) {
                _do(p, l, r, qv);
                return;
            }
            spread(p, l, r);
            int m = (l + r) >> 1;
            if (ql <= m) modify(p << 1, l, m, ql, qr, qv);
            if (qr > m) modify(p << 1 | 1, m + 1, r, ql, qr, qv);
            maintain(p, l, r);
        }

        Info query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            spread(p, l, r);
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr), l, r);
        }

        // 线段树二分，找最左边的区间左端点，满足区间全为 0 且长度 >= size
        // 如果不存在这样的区间，返回 -1
        public int findFirst(int p, int l, int r, int size) {
            if (info[p].max0 < size) {
                return -1;
            }
            if (l == r) {
                return l;
            }
            spread(p, l, r);
            int m = (l + r) / 2;
            int idx = findFirst(p << 1, l, m, size); // 递归左子树
            if (idx == -1) {
                // 左子树的后缀 0 个数 + 右子树的前缀 0 个数 >= size
//                if (info[p << 1].suf0 + info[p << 1 | 1].pre0 >= size) {
//                    return m - info[p << 1].suf0 + 1;
//                }
                idx = findFirst(p << 1 | 1, m + 1, r, size); // 递归右子树
            }
            return idx;
        }
    }
}
/*
3479. 将水果装入篮子 III
https://leetcode.cn/problems/fruits-into-baskets-iii/description/

第 440 场周赛 T3。

给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量，baskets[j] 表示第 j 个篮子的 容量。
你需要对 fruits 数组从左到右按照以下规则放置水果：
- 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
- 每个篮子只能装 一种 水果。
- 如果一种水果 无法放入 任何篮子，它将保持 未放置。
返回所有可能分配完成后，剩余未放置的水果种类的数量。
提示：
n == fruits.length == baskets.length
1 <= n <= 10^5
1 <= fruits[i], baskets[i] <= 10^9

线段树二分。
相似题目: 2502. 设计内存分配器
https://leetcode.cn/problems/design-memory-allocator/
 */