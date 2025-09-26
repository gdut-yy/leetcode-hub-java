import java.util.HashSet;
import java.util.Set;

public class Solution3678 {
    public int smallestAbsent(int[] nums) {
        int n = nums.length;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int v : nums) {
            sum += v;
            set.add(v);
        }

        int ans = (sum + n - 1) / n;
        if (ans * n == sum) ans++;
        ans = Math.max(ans, 1);
        while (set.contains(ans)) ans++;
        return ans;
    }
}
/*
3678. 大于平均值的最小未出现正整数
https://leetcode.cn/problems/smallest-absent-positive-greater-than-average/description/

第 165 场双周赛 T1。

给你一个整数数组 nums。
返回 nums 中 严格大于 nums 中所有元素 平均值 的 最小未出现正整数。
数组的 平均值 定义为数组中所有元素的总和除以元素的数量。
提示:
1 <= nums.length <= 100
-100 <= nums[i] <= 100

阅读理解题。
 */