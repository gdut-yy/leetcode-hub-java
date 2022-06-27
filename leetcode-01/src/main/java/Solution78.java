import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length == 0) {
            return resList;
        }
        helper(nums, 0, new LinkedList<>(), resList);
        return resList;
    }

    private void helper(int[] nums, int idx, LinkedList<Integer> subset, List<List<Integer>> resList) {
        if (idx == nums.length) {
            // 副本
            resList.add(new ArrayList<>(subset));
        } else if (idx < nums.length) {
            helper(nums, idx + 1, subset, resList);
            subset.add(nums[idx]);
            helper(nums, idx + 1, subset, resList);
            subset.removeLast();
        }
    }

    /**
     * 状态压缩 DP
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int len = nums.length;
        // 状态压缩 dp
        for (int state = 0; state < (1 << len); state++) {
            List<Integer> curList = new ArrayList<>();
            for (int k = 0; k < len; k++) {
                // 第 k 位被选中
                if (((state >> k) & 1) == 1) {
                    curList.add(nums[k]);
                }
            }
            resList.add(curList);
        }
        return resList;
    }
}
/*
78. 子集
https://leetcode.cn/problems/subsets/

给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同

回溯法。
时间复杂度 O(2^n)
 */