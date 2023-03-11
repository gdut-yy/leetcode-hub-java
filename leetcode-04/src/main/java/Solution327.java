import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 离散化
        TreeSet<Long> set = new TreeSet<>();
        for (long x : preSum) {
            set.add(x);
            set.add(x - lower);
            set.add(x - upper);
        }
        Map<Long, Integer> map = new HashMap<>();
        int id = 0;
        for (Long x : set) {
            map.put(x, id++);
        }

        int res = 0;
        Fenwick fenwick = new Fenwick(map.size());
        for (long x : preSum) {
            int l = map.get(x - upper);
            int r = map.get(x - lower);
            res += fenwick.getSum(r + 1) - fenwick.getSum(l);
            fenwick.add(map.get(x) + 1, 1);
        }
        return res;
    }

    private static class Fenwick {
        private final int n;
        private final int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        int lowbit(int x) {
            return x & -x;
        }

        void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        int getSum(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
327. 区间和的个数
https://leetcode.cn/problems/count-of-range-sum/

给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
提示：
1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
-10^5 <= lower <= upper <= 10^5
题目数据保证答案是一个 32 位 的整数

离散化树状数组
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */