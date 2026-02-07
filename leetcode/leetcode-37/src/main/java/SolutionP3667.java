import java.util.Arrays;
import java.util.Comparator;

public class SolutionP3667 {
    public int[] sortByAbsoluteValue(int[] nums) {
        int n = nums.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(i -> Math.abs(nums[i])));
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[ids[i]];
        }
        return ans;
    }
}
/*
$3667. 按绝对值排序数组
https://leetcode.cn/problems/sort-array-by-absolute-value/description/

给定一个整数数组 nums。
将 nums 中的元素按照它们的绝对值 非递减 顺序排列。
返回 任何 满足此条件的重新排列数组。
注意：整数 x 的绝对值定义为：
- x 若 x >= 0
- -x 若 x < 0
提示：
1 <= nums.length <= 100
-100 <= nums[i] <= 100

自定义排序。
时间复杂度 O(nlogn)。
 */