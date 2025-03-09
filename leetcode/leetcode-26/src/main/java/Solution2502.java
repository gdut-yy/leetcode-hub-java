import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2502 {
    static class Allocator2 {
        private final int n;
        private final int[] arr;

        public Allocator2(int n) {
            this.n = n;
            arr = new int[n];
        }

        public int allocate(int size, int mID) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    cnt = 0;
                } else {
                    cnt++;
                    if (cnt == size) {
                        Arrays.fill(arr, i - size + 1, i + 1, mID);
                        return i - size + 1;
                    }
                }
            }
            return -1;
        }

        public int freeMemory(int mID) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == mID) {
                    cnt++;
                    arr[i] = 0;
                }
            }
            return cnt;
        }
    }

    static class Allocator {
        int n;
        LazySegmentTree seg;
        Map<Integer, List<int[]>> blocks;

        public Allocator(int n) {
            this.n = n;
            seg = new LazySegmentTree(n);
            seg.build(null, 1, 0, n - 1);
            blocks = new HashMap<>();
        }

        public int allocate(int size, int mID) {
            int i = seg.findFirst(1, 0, n - 1, size);
            if (i < 0) { // 无法分配内存
                return -1;
            }
            // 分配内存 [i, i+size-1]
            blocks.computeIfAbsent(mID, e -> new ArrayList<>()).add(new int[]{i, i + size - 1});
            seg.modify(1, 0, n - 1, i, i + size - 1, 1);
            return i;
        }

        public int freeMemory(int mID) {
            int ans = 0;
            List<int[]> list = blocks.get(mID);
            if (list != null) {
                for (int[] range : list) {
                    ans += range[1] - range[0] + 1;
                    seg.modify(1, 0, n - 1, range[0], range[1], 0); // 释放内存
                }
                blocks.remove(mID);
            }
            return ans;
        }

        // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
        static class LazySegmentTree {
            static class Info {
                int pre0; // 区间前缀连续 0 的个数
                int suf0; // 区间后缀连续 0 的个数
                int max0; // 区间最长连续 0 的个数
                int lazy; // 懒标记

                public Info(int pre0, int suf0, int max0, int lazy) {
                    this.pre0 = pre0;
                    this.suf0 = suf0;
                    this.max0 = max0;
                    this.lazy = lazy;
                }
            }

            Info mergeInfo(Info a, Info b, int l, int r) {
                int m = (l + r) >> 1;

                int pre0 = a.pre0;
                if (a.pre0 == m - l + 1) pre0 += b.pre0;

                int suf0 = b.suf0;
                if (b.suf0 == r - m) suf0 += a.suf0;

                int max0 = Math.max(Math.max(a.max0, b.max0), a.suf0 + b.pre0);
                return new Info(pre0, suf0, max0, -1);
            }

            void _do(int p, int l, int r, int qv) {
                int size = qv <= 0 ? r - l + 1 : 0;
                info[p].pre0 = info[p].suf0 = info[p].max0 = size;
                info[p].lazy = qv;
            }

            int n;
            Info[] info;

            public LazySegmentTree(int n) {
                this.n = n;
                info = new Info[4 * n];
                Arrays.setAll(info, e -> new Info(0, 0, 0, -1));
            }

            void build(int[] A, int p, int l, int r) {
                _do(p, l, r, -1);
                if (l == r) {
//                    info[p] = new Info(0, 0, 0, -1);
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
                if (idx < 0) {
                    // 左子树的后缀 0 个数 + 右子树的前缀 0 个数 >= size
                    if (info[p << 1].suf0 + info[p << 1 | 1].pre0 >= size) {
                        return m - info[p << 1].suf0 + 1;
                    }
                    idx = findFirst(p << 1 | 1, m + 1, r, size); // 递归右子树
                }
                return idx;
            }
        }
    }
}
/*
2502. 设计内存分配器
https://leetcode.cn/problems/design-memory-allocator/

第 323 场周赛 T3。

给你一个整数 n ，表示下标从 0 开始的内存数组的大小。所有内存单元开始都是空闲的。
请你设计一个具备以下功能的内存分配器：
1. 分配 一块大小为 size 的连续空闲内存单元并赋 id mID 。
2. 释放 给定 id mID 对应的所有内存单元。
注意：
- 多个块可以被分配到同一个 mID 。
- 你必须释放 mID 对应的所有内存单元，即便这些内存单元被分配在不同的块中。
实现 Allocator 类：
- Allocator(int n) 使用一个大小为 n 的内存数组初始化 Allocator 对象。
- int allocate(int size, int mID) 找出大小为 size 个连续空闲内存单元且位于 最左侧 的块，分配并赋 id mID 。返回块的第一个下标。如果不存在这样的块，返回 -1 。
- int free(int mID) 释放 id mID 对应的所有内存单元。返回释放的内存单元数目。
提示：
1 <= n, size, mID <= 1000
最多调用 allocate 和 free 方法 1000 次

暴力 / 线段树二分
相似题目: 3479. 将水果装入篮子 III
https://leetcode.cn/problems/fruits-into-baskets-iii/description/
 */