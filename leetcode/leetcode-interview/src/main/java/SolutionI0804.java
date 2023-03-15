import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionI0804 {
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
}
/*
面试题 08.04. 幂集
https://leetcode.cn/problems/power-set-lcci/

幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
说明：解集不能包含重复的子集。

同: 78. 子集
https://leetcode.cn/problems/subsets/
 */