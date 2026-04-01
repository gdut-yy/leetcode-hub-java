public class Solution3862 {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        long mul = 1; // [i+1,n-1] 之积
        for (int i = n - 1; i > 0; i--) {
            if (ps[i] == mul) { // [0,i-1] 之和等于 [i+1,n-1] 之积
                return i;
            }
            // 如果 mul * nums[i] > sum[i-1]，那么继续向左遍历，mul 越来越大（或者不变），sum 越来越小，不可能找到答案
            // 为避免乘法溢出，改成等价的除法
            if (mul > ps[i - 1] / nums[i]) {
                break;
            }
            mul *= nums[i];
        }
        return -1;
    }
}
/*
3862. 找出最小平衡下标
https://leetcode.cn/problems/find-the-smallest-balanced-index/description/

第 492 场周赛 T2。

给你一个整数数组 nums。
如果某个下标 i 满足以下条件，则称其为 平衡下标： i 左侧所有元素的总和等于 i 右侧所有元素的乘积。
如果左侧没有元素，则总和视为 0。同样，如果右侧没有元素，则乘积视为 1。
要求返回最小的 平衡下标，如果不存在平衡下标，则返回 -1。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

前后缀分解。
时间复杂度 O(n)。
 */