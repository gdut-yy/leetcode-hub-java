public class Solution3978 {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int num : nums) {
            if (num == nums[n / 2]) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}
/*
3978. 唯一中间元素
https://leetcode.cn/problems/unique-middle-element/description/

第 186 场双周赛 T1。

给你一个长度为奇数 n 的整数数组 nums 。
如果 nums 的下标中间元素在数组中 恰好 出现一次，返回 true 。否则返回 false 。
提示：
1 <= n == nums.length <= 100
n 是奇数。
1 <= nums[i] <= 100

遍历。
时间复杂度 O(n)。
 */