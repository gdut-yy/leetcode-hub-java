import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3731 {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int x = nums[0] + 1; x < nums[n - 1]; x++) {
            int j = Arrays.binarySearch(nums, x);
            if (j < 0) ans.add(x);
        }
        return ans;
    }
}
/*
3731. 找出缺失的元素
https://leetcode.cn/problems/find-missing-elements/description/

第 474 场周赛 T1。

给你一个整数数组 nums ，数组由若干 互不相同 的整数组成。
数组 nums 原本包含了某个范围内的 所有整数 。但现在，其中可能 缺失 部分整数。
该范围内的 最小 整数和 最大 整数仍然存在于 nums 中。
返回一个 有序 列表，包含该范围内缺失的所有整数，并 按从小到大排序。如果没有缺失的整数，返回一个 空 列表。
提示：
2 <= nums.length <= 100
1 <= nums[i] <= 100

中国时间 2025-11-02 周日 10:30
深圳·龙华。
模拟。二分查找不需要额外空间。
时间复杂度 O(nlogn)。
 */