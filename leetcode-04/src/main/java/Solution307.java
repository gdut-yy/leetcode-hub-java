public class Solution307 {
    // 树状数组
    static class NumArray {
        private final BIT bit;

        public NumArray(int[] nums) {
            bit = new BIT(nums);
        }

        public void update(int index, int val) {
            int add = val - bit.getsum(index, index);
            bit.add(index + 1, add);
        }

        public int sumRange(int left, int right) {
            return bit.getsum(left, right);
        }

        private static class BIT {
            private final int N;
            private final int[] tree;

            // O(n) 建树
            public BIT(int[] nums) {
                this.N = nums.length;
                this.tree = new int[N + 1];

                for (int i = 1; i <= N; i++) {
                    tree[i] += nums[i - 1];
                    int j = i + lowbit(i);
                    if (j <= N) {
                        tree[j] += tree[i];
                    }
                }
            }

            public int lowbit(int x) {
                return x & (-x);
            }

            // nums[x] add k
            public void add(int x, int k) {
                while (x <= N) {
                    tree[x] += k;
                    x += lowbit(x);
                }
            }

            // nums [1,x] 的和
            public int getsum(int x) {
                int ans = 0;
                while (x >= 1) {
                    ans += tree[x];
                    x -= lowbit(x);
                }
                return ans;
            }

            // nums [l,r] 的和
            public int getsum(int l, int r) {
                return getsum(r + 1) - getsum(l);
            }
        }
    }

    // 线段树
    static class NumArray2 {
        private final int N;
        private final SegmentTree segmentTree;

        public NumArray2(int[] nums) {
            N = nums.length;
            segmentTree = new SegmentTree(nums);
        }

        public void update(int index, int val) {
            segmentTree.update(index + 1, index + 1, val, 1, N, 1);
        }

        public int sumRange(int left, int right) {
            return segmentTree.getsum(left + 1, right + 1, 1, N, 1);
        }

        private static class SegmentTree {
            private final int[] nums;
            private final int[] tree;
            private final int[] lazy;

            public SegmentTree(int[] nums) {
                int N = nums.length;
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
                int m = s + ((t - s) >> 1);
                // 移位运算符的优先级小于加减法，所以加上括号
                // 如果写成 (s + t) >> 1 可能会超出 int 范围
                build(s, m, p * 2);
                build(m + 1, t, p * 2 + 1);
                // 递归对左右区间建树
                tree[p] = tree[p * 2] + tree[(p * 2) + 1];
            }

            // [l,r] 范围置为 c
            private void update(int l, int r, int c, int s, int t, int p) {
                if (l <= s && t <= r) {
                    tree[p] = (t - s + 1) * c;
                    lazy[p] = c;
                    return;
                }
                int m = s + ((t - s) >> 1);
                if (lazy[p] > 0) {
                    tree[p * 2] = lazy[p] * (m - s + 1);
                    tree[p * 2 + 1] = lazy[p] * (t - m);
                    lazy[p * 2] = lazy[p * 2 + 1] = lazy[p];
                    lazy[p] = 0;
                }
                if (l <= m) {
                    update(l, r, c, s, m, p * 2);
                }
                if (r > m) {
                    update(l, r, c, m + 1, t, p * 2 + 1);
                }
                tree[p] = tree[p * 2] + tree[p * 2 + 1];
            }

            // [l,r] 范围求和
            private int getsum(int l, int r, int s, int t, int p) {
                if (l <= s && t <= r) {
                    return tree[p];
                }
                int m = s + ((t - s) >> 1);
                if (lazy[p] > 0) {
                    tree[p * 2] = lazy[p] * (m - s + 1);
                    tree[p * 2 + 1] = lazy[p] * (t - m);
                    lazy[p * 2] = lazy[p * 2 + 1] = lazy[p];
                    lazy[p] = 0;
                }
                int sum = 0;
                if (l <= m) {
                    sum = getsum(l, r, s, m, p * 2);
                }
                if (r > m) {
                    sum += getsum(l, r, m + 1, t, p * 2 + 1);
                }
                return sum;
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