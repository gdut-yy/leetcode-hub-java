import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length >= 3) {
            Arrays.sort(nums);
        }
        int i = 0;
        while (i < nums.length - 2) {
            // “两数之和” 双指针法
            twoSum(nums, i, res);
            int tmp = nums[i];
            // 去除重复的元组
            while (i < nums.length && nums[i] == tmp) {
                i++;
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[i] + nums[left] + nums[right] == 0) {
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                int tmp = nums[left];
                // 去除重复的元组
                while (nums[left] == tmp && left < right) {
                    left++;
                }
            } else if (nums[i] + nums[left] + nums[right] < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}
/*
15. 三数之和
https://leetcode-cn.com/problems/3sum/

给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
提示：
0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5

两数之和 升级版。先选出一个数，余下两个数用双指针方法解决
时间复杂度 O(n^2)
其中排序时间复杂度 O(nlogn)
相似题目: 1. 两数之和
https://leetcode-cn.com/problems/two-sum/
167. 两数之和 II - 输入有序数组
https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */