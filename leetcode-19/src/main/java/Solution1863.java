import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1863 {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = solution78subsets(nums);
        int cnt = 0;
        for (List<Integer> subset : subsets) {
            if (subset.size() != 0) {
                int sum = subset.get(0);
                for (int i = 1; i < subset.size(); i++) {
                    sum ^= subset.get(i);
                }
                cnt += sum;
            }
        }
        return cnt;
    }

    private List<List<Integer>> solution78subsets(int[] nums) {
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
}
/*
1863. 找出所有子集的异或总和再求和
https://leetcode-cn.com/problems/sum-of-all-subset-xor-totals/

基于第 78 题 https://leetcode-cn.com/problems/subsets/
子集回溯法。时间复杂度 O(2^n)
 */