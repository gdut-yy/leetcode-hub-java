public class Solution2006 {
    public int countKDifference(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
2006. 差的绝对值为 K 的数对数目
https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/

第 61 场双周赛 T1。
1 <= nums.length <= 200
1 <= nums[i] <= 100
1 <= k <= 99
用例数值范围很小，直接暴力即可。

时间复杂度 O(n^2)
 */