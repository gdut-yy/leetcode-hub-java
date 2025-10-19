import java.util.HashSet;
import java.util.Set;

public class Solution3719 {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> evenSet = new HashSet<>();
            Set<Integer> oddSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                int num = nums[j];
                if (num % 2 == 0) {
                    evenSet.add(num);
                } else {
                    oddSet.add(num);
                }
                if (evenSet.size() == oddSet.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
/*
3719. 最长平衡子数组 I
https://leetcode.cn/problems/longest-balanced-subarray-i/description/

第 472 场周赛 T2。

给你一个整数数组 nums。
如果子数组中 不同偶数 的数量等于 不同奇数 的数量，则称该 子数组 是 平衡的 。
返回 最长 平衡子数组的长度。
子数组 是数组中连续且 非空 的一段元素序列。
提示:
1 <= nums.length <= 1500
1 <= nums[i] <= 10^5

暴力 非常好写。线性复杂度详见 T4。
时间复杂度 O(n^2)。
 */