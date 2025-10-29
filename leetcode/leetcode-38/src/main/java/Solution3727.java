import java.util.Arrays;

public class Solution3727 {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(a);

        long ans = 0;
        for (int i = 0; i < n / 2; i++) ans -= a[i];
        for (int i = n / 2; i < n; i++) ans += a[i];
        return ans;
    }
}
/*
3727. 最大交替平方和
https://leetcode.cn/problems/maximum-alternating-sum-of-squares/description/

第 473 场周赛 T2。

给你一个整数数组 nums。你可以以任意顺序 重新排列元素 。
数组 arr 的 交替得分 定义为：
- score = arr[0]^2 - arr[1]^2 + arr[2]^2 - arr[3]^2 + ...
在对 nums 重新排列后，返回其 最大可能的交替得分。
提示：
1 <= nums.length <= 10^5
-4 * 104 <= nums[i] <= 4 * 10^4

绝对值排序。贪心。
时间复杂度 O(nlogn)。
 */