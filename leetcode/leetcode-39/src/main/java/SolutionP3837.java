public class SolutionP3837 {
    static final int MAX_N = (int) 1e5;

    public int[] delayedCount(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] cnt = new int[MAX_N + 1];
        for (int i = n - k - 2; i >= 0; i--) {
            cnt[nums[i + k + 1]]++;
            ans[i] = cnt[nums[i]];
        }
        return ans;
    }
}
/*
$3837. 相等元素的延迟计数
https://leetcode.cn/problems/delayed-count-of-equal-elements/description/

给定一个长度为 n 的整数数组 nums 和一个整数 k。
对于每个下标 i，将 延迟计数 定义为满足以下条件的索引 j 的数量：
- i + k < j <= n - 1，且
- nums[j] == nums[i]
返回一个数组 ans，其中 ans[i] 是下标 i 的 延迟计数。
示例 1：
输入：nums = [1,2,1,1], k = 1
输出：[2,0,0,0]
示例 2：
输入：nums = [3,1,3,1], k = 0
输出：[1,1,0,0]
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^5
0 <= k <= n - 1
 */