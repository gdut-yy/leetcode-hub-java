import java.util.HashMap;
import java.util.Map;

public class SolutionO57 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 2  => 0
            // 7  => 1
            // 11 => 2
            // 15 => 3
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int want = target - nums[i];
            // complement => 9 - 2 = 7
            if (map.containsKey(want) && map.get(want) != i) {
                // 下标 从 1 开始计数
                return new int[]{nums[i], want};
            }
        }
        return new int[]{};
    }
}
/*
剑指 Offer 57. 和为s的两个数字
https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/

输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

类似题目: 167. 两数之和 II - 输入有序数组
https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/

注意返回对应元素还是对应元素下标。
 */