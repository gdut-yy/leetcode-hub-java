import java.util.Arrays;

public class Solution3670 {
    public long maxProduct(int[] nums) {
        int mx = Arrays.stream(nums).max().orElseThrow();
        int w = 32 - Integer.numberOfLeadingZeros(mx);
        int n = 1 << w;
        int U = n - 1;
        long[] maxVal = new long[n];
        for (int num : nums) {
            if (num > maxVal[num]) {
                maxVal[num] = num;
            }
        }
        long[] f = new long[n];
        System.arraycopy(maxVal, 0, f, 0, n);
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < n; i++) {
                if ((i >> j & 1) == 1) {
                    if (f[i] < f[i ^ (1 << j)]) {
                        f[i] = f[i ^ (1 << j)];
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (maxVal[i] > 0 && f[U ^ i] > 0) {
                long product = maxVal[i] * f[U ^ i];
                if (product > ans) {
                    ans = product;
                }
            }
        }
        return ans;
    }
}
/*
3670. 没有公共位的整数最大乘积
https://leetcode.cn/problems/maximum-product-of-two-integers-with-no-common-bits/description/

第 465 场周赛 T3。

给你一个整数数组 nums。
请你找到两个 不同 的下标 i 和 j，使得 nums[i] * nums[j] 的 乘积最大化 ，并且 nums[i] 和 nums[j] 的二进制表示中没有任何公共的置位 (set bit)。
返回这样一对数的 最大 可能乘积。如果不存在这样的数对，则返回 0。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

高维前缀和（Sum Over Subsets DP，SOS DP）
https://chat.deepseek.com/a/chat/s/287693a9-151d-47f1-99c1-b93864dbe0bd
时间复杂度 O(n + UlogU)。
rating 2276 (clist.by)
 */