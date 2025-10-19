import java.util.HashSet;
import java.util.Set;

public class Solution3718 {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int v : nums) set.add(v);

        int ans = k;
        while (set.contains(ans)) ans += k;
        return ans;
    }
}
/*
3718. 缺失的最小倍数
https://leetcode.cn/problems/smallest-missing-multiple-of-k/description/

第 472 场周赛 T1。

给你一个整数数组 nums 和一个整数 k，请返回从 nums 中缺失的、最小的正整数 k 的倍数。
倍数 指能被 k 整除的任意正整数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= 100

模拟。
时间复杂度 O(n)。
 */