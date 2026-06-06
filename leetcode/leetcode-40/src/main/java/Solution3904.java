import java.util.Arrays;

public class Solution3904 {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] mx = new int[n];
        mx[0] = nums[0];
        for (int i = 1; i < n; i++) {
            mx[i] = Math.max(mx[i - 1], nums[i]);
        }
        int[] mn = new int[n];
        Arrays.fill(mn, Integer.MAX_VALUE);
        mn[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            mn[i] = Math.min(mn[i+1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (mx[i] - mn[i] <= k) return i;
        }
        return -1;
    }
}
/*
3904. 最小稳定下标 II
https://leetcode.cn/problems/smallest-stable-index-ii/description/

第 498 场周赛 T2。

给你一个长度为 n 的整数数组 nums 和一个整数 k。
对于每个下标 i，定义它的 不稳定值 为 max(nums[0..i]) - min(nums[i..n - 1])。
换句话说：
- max(nums[0..i]) 表示从下标 0 到下标 i 的元素中的 最大值 。
- min(nums[i..n - 1]) 表示从下标 i 到下标 n - 1 的元素中的 最小值 。
如果某个下标 i 的不稳定值 小于等于 k，则称该下标为 稳定下标 。
返回 最小 的稳定下标。如果不存在这样的下标，则返回 -1。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= k <= 10^9

前后缀分解。
时间复杂度 O(n)。
 */