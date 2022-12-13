import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2502 {
    static class Allocator {
        private final int n;
        private final Map<Integer, List<Integer>> mIdListMap;
        private final DynamicSegTreeUpd dynamicSegTreeUpd;

        public Allocator(int n) {
            this.n = n;
            mIdListMap = new HashMap<>();
            dynamicSegTreeUpd = new DynamicSegTreeUpd();
        }

        public int allocate(int size, int mID) {
            for (int i = 0; i + size - 1 < n; i++) {
                int r = i + size - 1;
                if (dynamicSegTreeUpd.getSum(i, r) == 0) {
                    dynamicSegTreeUpd.update(i, r, 1);
                    for (int j = i; j <= r; j++) {
                        mIdListMap.computeIfAbsent(mID, key -> new ArrayList<>()).add(j);
                    }
                    return i;
                }
            }
            return -1;
        }

        public int free(int mID) {
            List<Integer> idList = mIdListMap.getOrDefault(mID, new ArrayList<>());
            for (int id : idList) {
                dynamicSegTreeUpd.update(id, id, 0);
            }
            mIdListMap.put(mID, new ArrayList<>());
            return idList.size();
        }

        private static class DynamicSegTreeUpd {
            private static final int N = 1005;
            private final Node root = new Node();

            private static class Node {
                Node ls, rs;
                long sum, max, lazy;
            }

            // 区间 [l,r] 置为 val
            public void update(int l, int r, int val) {
                this.update(l, r, val, 0, N, root);
            }

            // 区间 [l,r] 求和
            public long getSum(int l, int r) {
                return this.getSum(l, r, 0, N, root);
            }

            // 区间 [l,r] 最大值
            public long getMax(int l, int r) {
                return this.getMax(l, r, 0, N, root);
            }

            private void update(int l, int r, int val, int s, int t, Node node) {
                if (l <= s && t <= r) {
                    node.sum = (t - s + 1L) * val;
                    node.max = val;
                    node.lazy = val;
                    return;
                }
                int mid = s + (t - s) / 2;
                pushDown(node, s, t, mid);
                if (l <= mid) {
                    update(l, r, val, s, mid, node.ls);
                }
                if (r > mid) {
                    update(l, r, val, mid + 1, t, node.rs);
                }
                pushUp(node);
            }

            private long getSum(int l, int r, int s, int t, Node node) {
                if (l <= s && t <= r) {
                    return node.sum;
                }
                int mid = s + (t - s) / 2;
                pushDown(node, s, t, mid);
                long sum = 0;
                if (l <= mid) {
                    sum = getSum(l, r, s, mid, node.ls);
                }
                if (r > mid) {
                    sum += getSum(l, r, mid + 1, t, node.rs);
                }
                return sum;
            }

            private long getMax(int l, int r, int s, int t, Node node) {
                if (l <= s && t <= r) {
                    return node.max;
                }
                int mid = s + (t - s) / 2;
                pushDown(node, s, t, mid);
                long max = 0;
                if (l <= mid) {
                    max = getMax(l, r, s, mid, node.ls);
                }
                if (r > mid) {
                    max = Math.max(max, getMax(l, r, mid + 1, t, node.rs));
                }
                return max;
            }

            private void pushDown(Node node, int s, int t, int mid) {
                if (node.ls == null) {
                    node.ls = new Node();
                }
                if (node.rs == null) {
                    node.rs = new Node();
                }
                if (node.lazy > 0) {
                    node.ls.sum = node.lazy * (mid - s + 1L);
                    node.rs.sum = node.lazy * (t - mid);
                    node.ls.max = node.lazy;
                    node.rs.max = node.lazy;
                    node.ls.lazy = node.lazy;
                    node.rs.lazy = node.lazy;
                    node.lazy = 0;
                }
            }

            private void pushUp(Node node) {
                node.sum = node.ls.sum + node.rs.sum;
                node.max = Math.max(node.ls.max, node.rs.max);
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
- int allocate(int size, int mID) 找出大小为 size 个连续空闲内存单元且位于  最左侧 的块，分配并赋 id mID 。返回块的第一个下标。如果不存在这样的块，返回 -1 。
- int free(int mID) 释放 id mID 对应的所有内存单元。返回释放的内存单元数目。
提示：
1 <= n, size, mID <= 1000
最多调用 allocate 和 free 方法 1000 次

暂没想到啥非暴力做法，套了个线段树板子。。。
 */