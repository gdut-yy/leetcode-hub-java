import java.util.Arrays;

public class Solution3684 {
    public int[] maxKDistinct(int[] nums, int k) {
        int[] a = Arrays.stream(nums).distinct().sorted().toArray();
        int ansLen = Math.min(k, a.length);
        int[] ans = new int[ansLen];
        for (int i = 0; i < ansLen; i++) {
            ans[i] = a[a.length - 1 - i];
        }
        return ans;
    }
}
/*
3684. 至多 K 个不同元素的最大和
https://leetcode.cn/problems/maximize-sum-of-at-most-k-distinct-elements/description/

第 467 场周赛 T2。

给你一个 正整数 数组 nums 和一个整数 k。
从 nums 中选择最多 k 个元素，使它们的和最大化。但是，所选的数字必须 互不相同 。
返回一个包含所选数字的数组，数组中的元素按 严格递减 顺序排序。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 10^9
1 <= k <= nums.length

哈希表去重，贪心。
时间复杂度 O(nlogn)。
 */