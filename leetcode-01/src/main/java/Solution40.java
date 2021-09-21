import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resList = new ArrayList<>();
        helper(candidates, target, 0, new LinkedList<>(), resList);
        return resList;
    }

    private void helper(int[] candidates, int target, int i,
                        LinkedList<Integer> combination, List<List<Integer>> resList) {
        if (target == 0) {
            resList.add(new ArrayList<>(combination));
        } else if (target > 0 && i < candidates.length) {
            helper(candidates, target, getNext(candidates, i), combination, resList);
            combination.addLast(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, combination, resList);
            combination.removeLast();
        }
    }

    private int getNext(int[] candidates, int idx) {
        int next = idx;
        while (next < candidates.length && candidates[next] == candidates[idx]) {
            next++;
        }
        return next;
    }
}
/*
40. 组合总和 II
https://leetcode-cn.com/problems/combination-sum-ii/

给定一个数组 candidates 和一个目标数 target，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
注意：解集不能包含重复的组合。

第 39 题升级版。可包含重复数字。
回溯法。
避免重复的组合的方法是当在某一步决定跳过某个值为 m 的数字时，跳过所有值为 m 的数字。
 */