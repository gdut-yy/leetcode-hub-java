public class Solution4083 {
    public int minDeletions(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                ans++;
            }
        }
        return ans;
    }
}
/*
4083. 使相邻元素按位异或非零的最少删除次数
https://leetcode.cn/problems/minimum-deletions-to-make-array-sharp/description/

第 524 场周赛 T1。

给你一个整数数组 nums。
你可以从 nums 中删除任意数量的元素。剩余元素保持原有的相对顺序。
如果结果数组 a 中每一对 相邻 元素的 按位异或 结果都 不为 0，则称数组 a 是 相邻异或非零数组 。也就是说，对于每个满足 0 <= i < a.length - 1 的下标 i，都有 a[i] XOR a[i + 1] != 0。长度不超过 1 的数组也被视为相邻异或非零数组。
返回使 nums 变为相邻异或非零数组所需的 最少 删除次数。
按位异或 会逐位比较两个整数对应的二进制位。如果对应位不同，则结果中的该位为 1；否则为 0。
示例 1：
输入： nums = [1,1,2,2,2,3]
输出： 3
示例 2：
输入： nums = [4,4,9,4]
输出： 1
提示：
2 <= nums.length <= 100
1 <= nums[i] <= 100

中国时间 2026-10-18 周日 10:30
佛山。新城医院。
脑筋急转弯。
删除元素，使得 nums 中任意相邻元素均不等。
时间复杂度 O(n)。
 */