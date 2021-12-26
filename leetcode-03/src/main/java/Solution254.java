import java.util.ArrayList;
import java.util.List;

public class Solution254 {
    public List<List<Integer>> getFactors(int n) {
        // 因子必须大于 1 并且小于 n。
        int factorLen = n - 2;
        List<List<Integer>> resList = new ArrayList<>();
        if (factorLen <= 0) {
            return resList;
        }
        int[] nums = new int[factorLen];
        for (int i = 0; i < factorLen; i++) {
            nums[i] = i + 2;
        }
        // 回溯
        helper(n, nums, 0, resList, new ArrayList<>());
        return resList;
    }

    private void helper(int n, int[] nums, int idx, List<List<Integer>> resList, List<Integer> path) {
        if (n == 1) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < nums.length && nums[i] <= n; i++) {
            if (n % nums[i] == 0) {
                path.add(nums[i]);
                helper(n / nums[i], nums, i, resList, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
/*
$254. 因子的组合
https://leetcode-cn.com/problems/factor-combinations/

整数可以被看作是其因子的乘积。

回溯。
 */