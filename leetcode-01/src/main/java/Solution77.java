import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        helper(n, k, 1, new LinkedList<>(), resList);
        return resList;
    }

    private void helper(int n, int k, int i, LinkedList<Integer> combination, List<List<Integer>> resList) {
        if (combination.size() == k) {
            resList.add(new ArrayList<>(combination));
        } else if (i <= n) {
            helper(n, k, i + 1, combination, resList);
            combination.add(i);
            helper(n, k, i + 1, combination, resList);
            combination.removeLast();
        }
    }
}
/*
77. 组合
https://leetcode-cn.com/problems/combinations/

给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。

组合也是子集。在第 78 题增加一个限制条件即可，即只找出包含 k 个数字的组合。
回溯法。
 */