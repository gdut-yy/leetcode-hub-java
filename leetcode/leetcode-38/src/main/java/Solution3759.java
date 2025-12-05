import java.util.Arrays;

public class Solution3759 {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) return n;
        Arrays.sort(nums);
        for (int i = n - 1 - k; i >= 0; i--) {
            if (nums[i] < nums[n - k]) return i + 1;
        }
        return 0;
    }
}
/*
3759. 统计合格元素的数目
https://leetcode.cn/problems/count-elements-with-at-least-k-greater-values/description/

第 478 场周赛 T1。

给你一个长度为 n 的整数数组 nums 和一个整数 k。
如果数组 nums 中的某个元素满足以下条件，则称其为 合格元素：存在 至少 k 个元素 严格大于 它。
返回一个整数，表示数组 nums 中合格元素的总数。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= k < n

枚举。
时间复杂度 O(n)。
 */