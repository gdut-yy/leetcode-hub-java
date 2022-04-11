import java.util.Arrays;

public class Solution2234 {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;
        Arrays.sort(flowers);

        // 全为 完善 花园
        if (flowers[0] >= target) {
            return (long) n * full;
        }

        // flowers[] 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + flowers[i];
        }

        long max = 0;
        // 枚举 完善 花园数目 (0 ~ n)
        for (int fullNum = 0; fullNum <= n; fullNum++) {
            int i = n - fullNum;

            // 完善 花园 用掉一部分花
            if (i < n && flowers[i] <= target) {
                newFlowers -= (target - flowers[i]);
                if (newFlowers < 0) {
                    return max;
                }
            }

            // 剩余 newFlowers 朵花
            if (fullNum == n) {
                max = Math.max(max, (long) n * full);
            } else {
                // 剩余 newFlowers
                int left = flowers[0];
                int right = target;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 边界二分 F, F,..., F, [T, T,..., T] checkMid(mid) == T
                    // ----------------------^
                    if (!checkMid(flowers, preSum, i, newFlowers, mid)) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                left -= 1;
//                System.out.println("i=" + i + " left=" + left);
                max = Math.max(max, (long) fullNum * full + (long) left * partial);
            }
        }
        return max;
    }

    // O(n^2logn)
    private boolean checkMid(int[] flowers, long[] preSum, int i, long newFlowers, int mid) {
        long sum = 0;
        for (int j = 0; j < i; j++) {
            if (flowers[j] <= mid) {
                sum += (mid - flowers[j]);
            } else {
                return sum <= newFlowers;
            }
        }
        return sum <= newFlowers;
    }
}
/*
2234. 花园的最大总美丽值
https://leetcode-cn.com/problems/maximum-total-beauty-of-the-gardens/

第 288 场周赛 T4。

Alice 是 n 个花园的园丁，她想通过种花，最大化她所有花园的总美丽值。
给你一个下标从 0 开始大小为 n 的整数数组 flowers ，其中 flowers[i] 是第 i 个花园里已经种的花的数目。已经种了的花 不能 移走。
同时给你 newFlowers ，表示 Alice 额外可以种花的 最大数目 。同时给你的还有整数 target ，full 和 partial 。
如果一个花园有 至少 target 朵花，那么这个花园称为 完善的 ，花园的 总美丽值 为以下分数之 和 ：
- 完善 花园数目乘以 full.
- 剩余 不完善 花园里，花的 最少数目 乘以 partial 。如果没有不完善花园，那么这一部分的值为 0 。
请你返回 Alice 种最多 newFlowers 朵花以后，能得到的 最大 总美丽值。
提示：
1 <= flowers.length <= 10^5
1 <= flowers[i], target <= 10^5
1 <= newFlowers <= 10^10
1 <= full, partial <= 10^5
 */