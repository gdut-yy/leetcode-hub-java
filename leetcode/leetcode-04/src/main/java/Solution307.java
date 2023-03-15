public class Solution307 {
    static class NumArray {
        private final Fenwick fenwick;

        public NumArray(int[] nums) {
            fenwick = new Fenwick(nums);
        }

        public void update(int index, int val) {
            int add = val - fenwick.getSum(index, index);
            fenwick.add(index + 1, add);
        }

        public int sumRange(int left, int right) {
            return fenwick.getSum(left, right);
        }

        private static class Fenwick {
            private final int n;
            private final int[] tree;

            public Fenwick(int n) {
                this.n = n;
                this.tree = new int[n + 1];
            }

            // O(n) 建树
            public Fenwick(int[] nums) {
                this.n = nums.length;
                this.tree = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    tree[i] += nums[i - 1];
                    int j = i + lowbit(i);
                    if (j <= n) {
                        tree[j] += tree[i];
                    }
                }
            }

            int lowbit(int x) {
                return x & -x;
            }

            // nums[x] add k
            void add(int x, int k) {
                while (x <= n) {
                    tree[x] += k;
                    x += lowbit(x);
                }
            }

            // nums [1,x] 的和
            int getSum(int x) {
                int ans = 0;
                while (x > 0) {
                    ans += tree[x];
                    x -= lowbit(x);
                }
                return ans;
            }

            // nums [l,r] 的和
            int getSum(int l, int r) {
                return getSum(r + 1) - getSum(l);
            }
        }
    }

    // 线段树
    static class NumArray2 {
        private final SegmentTree segmentTree;

        public NumArray2(int[] nums) {
            segmentTree = new SegmentTree(nums);
        }

        public void update(int index, int val) {
            segmentTree.update(index + 1, index + 1, val);
        }

        public int sumRange(int left, int right) {
            return segmentTree.getSum(left + 1, right + 1);
        }

        private static class SegmentTree {
            private final int N;
            private final int[] nums;
            private final int[] tree;
            private final int[] lazy;

            public SegmentTree(int[] nums) {
                this.N = nums.length;
                this.nums = nums;
                tree = new int[N * 4];
                lazy = new int[N * 4];
                build(1, N, 1);
            }

            private void build(int s, int t, int p) {
                // 对 [s,t] 区间建立线段树,当前根的编号为 p
                if (s == t) {
                    tree[p] = nums[s - 1];
                    return;
                }
                int mid = s + (t - s) / 2;
                build(s, mid, p * 2);
                build(mid + 1, t, p * 2 + 1);
                // 递归对左右区间建树
                pushUp(p);
            }

            // [l,r] 范围置为 c
            private void update(int l, int r, int val, int s, int t, int p) {
                if (l <= s && t <= r) {
                    tree[p] = (t - s + 1) * val;
                    lazy[p] = val;
                    return;
                }
                int mid = s + (t - s) / 2;
                pushDown(s, t, p, mid);
                if (l <= mid) {
                    update(l, r, val, s, mid, p * 2);
                }
                if (r > mid) {
                    update(l, r, val, mid + 1, t, p * 2 + 1);
                }
                pushUp(p);
            }

            // [l,r] 范围求和
            private int getSum(int l, int r, int s, int t, int p) {
                if (l <= s && t <= r) {
                    return tree[p];
                }
                int mid = s + (t - s) / 2;
                pushDown(s, t, p, mid);
                int sum = 0;
                if (l <= mid) {
                    sum = getSum(l, r, s, mid, p * 2);
                }
                if (r > mid) {
                    sum += getSum(l, r, mid + 1, t, p * 2 + 1);
                }
                return sum;
            }

            private void pushDown(int s, int t, int p, int mid) {
                if (lazy[p] > 0) {
                    tree[p * 2] = lazy[p] * (mid - s + 1);
                    tree[p * 2 + 1] = lazy[p] * (t - mid);
                    lazy[p * 2] = lazy[p];
                    lazy[p * 2 + 1] = lazy[p];
                    lazy[p] = 0;
                }
            }

            private void pushUp(int p) {
                tree[p] = tree[p * 2] + tree[p * 2 + 1];
            }

            void update(int l, int r, int val) {
                update(l, r, val, 1, N, 1);
            }

            int getSum(int l, int r) {
                return getSum(l, r, 1, N, 1);
            }
        }
    }

    static class NumArray3 {
        private final DynamicSegTreeUpd dynamicSegTreeUpd;

        public NumArray3(int[] nums) {
            dynamicSegTreeUpd = new DynamicSegTreeUpd();
            dynamicSegTreeUpd.nums = nums;
            dynamicSegTreeUpd.build();
        }

        public void update(int index, int val) {
            dynamicSegTreeUpd.update(index + 1, index + 1, val);
        }

        public int sumRange(int left, int right) {
            return (int) dynamicSegTreeUpd.getSum(left + 1, right + 1);
        }

        static class DynamicSegTreeUpd {
            int N;
            int[] nums;
            private final Node root = new Node();

            private static class Node {
                Node ls, rs;
                long sum, max, lazy;
            }

            private void build() {
                N = nums.length;
                build(1, N, root);
            }

            private void build(int s, int t, Node node) {
                if (s == t) {
                    node.sum = nums[s - 1];
                    return;
                }
                if (node.ls == null) {
                    node.ls = new Node();
                }
                if (node.rs == null) {
                    node.rs = new Node();
                }
                int mid = s + (t - s) / 2;
                build(s, mid, node.ls);
                build(mid + 1, t, node.rs);
                pushUp(node);
            }

            // 区间 [l,r] 置为 val
            public void update(int l, int r, int val) {
                this.update(l, r, val, 1, N, root);
            }

            // 区间 [l,r] 求和
            public long getSum(int l, int r) {
                return this.getSum(l, r, 1, N, root);
            }

            // 区间 [l,r] 最大值
            public long getMax(int l, int r) {
                return this.getMax(l, r, 1, N, root);
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
307. 区域和检索 - 数组可修改
https://leetcode.cn/problems/range-sum-query-mutable/

给你一个数组 nums ，请你完成两类查询。
1.其中一类查询要求 更新 数组 nums 下标对应的值
2.另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
实现 NumArray 类：
- NumArray(int[] nums) 用整数数组 nums 初始化对象
- void update(int index, int val) 将 nums[index] 的值 更新 为 val
- int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
提示：

1 <= nums.length <= 3 * 10^4
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
调用 pdate 和 sumRange 方法次数不大于 3 * 10^4

树状数组/线段树
 */