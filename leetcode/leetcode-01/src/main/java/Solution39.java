import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    private int[] candidates;
    private int target;
    private LinkedList<Integer> combination;
    private List<List<Integer>> combinationList;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        combination = new LinkedList<>();
        combinationList = new ArrayList<>();

        dfs(0, 0);
        return combinationList;
    }

    private void dfs(int i, int sum) {
        if (sum == target) {
            combinationList.add(new ArrayList<>(combination));
            return;
        }
        if (i == candidates.length || sum > target) {
            return;
        }
        // 不选（当前）
        dfs(i + 1, sum);
        // 选（当前）
        combination.add(candidates[i]);
        dfs(i, sum + candidates[i]);
        combination.removeLast();
    }
}
/*
39. 组合总和
https://leetcode.cn/problems/combination-sum/

给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
对于给定的输入，保证和为 target 的不同组合数少于 150 个。
提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都 互不相同
1 <= target <= 500

官方题解 https://leetcode.cn/problems/combination-sum/solution/zu-he-zong-he-by-leetcode-solution/
 */