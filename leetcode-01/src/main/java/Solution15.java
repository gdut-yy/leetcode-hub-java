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
            // 双指针 “两数之和”
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

两数之和 升级版，先选出一个数，余下两个数用双指针方法解决
时间复杂度 O(n^2)
其中排序时间复杂度 O(nlogn)
 */