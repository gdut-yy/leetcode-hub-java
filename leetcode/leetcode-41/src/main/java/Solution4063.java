public class Solution4063 {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] seen = new int[k];
        int token = 0;
        int best = 0;
        for (int l = 0; l < n; l++) {
            token++;
            long sum = 0;
            for (int r = l; r < n; r++) {
                sum += nums[r];
                int s = (int) (((sum % k) + k) % k);
                int c = (int) (((nums[r] * 2L) % k + k) % k);
                seen[c] = token;
                if (s == 0 || seen[s] == token) {
                    int len = r - l + 1;
                    if (len > best) {
                        best = len;
                    }
                }
            }
        }
        return best;
    }
}
/*
4063. 至多一次取反能被 K 整除的最长子数组 I
https://leetcode.cn/problems/longest-subarray-divisible-by-k-with-at-most-one-negation-i/description/

第 192 场双周赛 T3。

给你一个整数数组 nums 和一个整数 k。
如果一个子数组的和能够被 k 整除，或者在 将该子数组中的一个元素取反 后能使和被 k 整除，则称该子数组是 有效的 。
将一个元素取反意味着将其值 x 替换为 -x。
返回 最长有效子数组的长度 。如果不存在有效的子数组，则返回 0。
子数组 是数组中一个连续且非空的元素序列。
示例 1：
输入： nums = [4,1,2], k = 3
输出： 3
示例 2：
输入： nums = [5,3,4], k = 7
输出： 2
示例 3：
输入： nums = [2,2,5], k = 6
输出： 2
提示：
1 <= nums.length <= 1000
-10^5 <= nums[i] <= 10^5
1 <= k <= 10^5

枚举。
时间复杂度 O(n^2)。
 */