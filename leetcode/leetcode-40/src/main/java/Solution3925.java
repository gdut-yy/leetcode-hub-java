public class Solution3925 {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int ansLen = n * 2;
        int[] ans = new int[ansLen];
        for (int i = 0; i < n; i++) {
            ans[i] = ans[ansLen - 1 - i] = nums[i];
        }
        return ans;
    }
}
/*
3925. 连接逆序数组
https://leetcode.cn/problems/concatenate-array-with-reverse/description/

第 501 场周赛 T1。

给你一个长度为 n 的整数数组 nums。
构造一个新的长度为 2 * n 的数组 ans，其中前 n 个元素与 nums 相同，后 n 个元素为 nums 的逆序。
具体而言，对于 0 <= i <= n - 1：
- ans[i] = nums[i]
- ans[i + n] = nums[n - i - 1]
返回整数数组 ans。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

中国时间 2026-05-10 周日 10:30
深圳。
模拟。
时间复杂度 O(n)。
 */