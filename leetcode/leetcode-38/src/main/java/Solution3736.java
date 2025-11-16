import java.util.Arrays;

public class Solution3736 {
    public int minMoves(int[] nums) {
        int mx = Arrays.stream(nums).max().orElseThrow();
        int ans = 0;
        for (int v : nums) {
            ans += mx - v;
        }
        return ans;
    }
}
/*
3736. 最小操作次数使数组元素相等 III
https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-iii/description/

第 169 场双周赛 T1。

给你一个整数数组 nums。
在一步操作中，你可以将任意单个元素 nums[i] 的值 增加 1。
返回使数组中的所有元素都 相等 所需的 最小总操作次数 。
提示:
1 <= nums.length <= 100
1 <= nums[i] <= 100

中国时间 2025-11-08 周六 22:30
佛山。
相似题目: 453. 最小操作次数使数组元素相等
https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/
 */