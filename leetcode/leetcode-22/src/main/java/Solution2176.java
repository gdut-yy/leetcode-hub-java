import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2176 {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // O(nlogn) 数学做法，枚举右维护左
    static class V2 {
        private static final int MX = 101;
        private static final List<Integer>[] divisors = new ArrayList[MX];

        static {
            Arrays.setAll(divisors, e -> new ArrayList<>());
            // 预处理每个数的因子
            for (int i = 1; i < MX; i++) {
                for (int j = i; j < MX; j += i) {
                    divisors[j].add(i);
                }
            }
        }

        public int countPairs(int[] nums, int k) {
            int ans = 0;
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int j = 0; j < nums.length; j++) { // 枚举 j，计算左边有多少个符合要求的 i
                int x = nums[j];
                if (j > 0 && x == nums[0]) {
                    ans++; // 单独统计 i=0 的情况
                }
                int k2 = k / getGCD(k, j); // i 必须是 k2 的倍数
                // 用位运算把二元组 (x, k2) 合并成一个整数
                ans += cnt.getOrDefault(k2 << 10 | x, 0);
                for (int d : divisors[j]) { // j 是 d 的倍数
                    cnt.merge(d << 10 | x, 1, Integer::sum); // cnt[d<<10|x]++
                }
            }
            return ans;
        }

        private int getGCD(int num1, int num2) {
            return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
        }
    }
}
/*
2176. 统计数组中相等且可以被整除的数对
https://leetcode.cn/problems/count-equal-and-divisible-pairs-in-an-array/

第 72 场双周赛 T1。

给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，请你返回满足 0 <= i < j < n ，nums[i] == nums[j] 且 (i * j) 能被 k 整除的数对 (i, j) 的 数目 。
提示：
1 <= nums.length <= 100
1 <= nums[i], k <= 100

暴力模拟。
时间复杂度 O(n^2)
 */