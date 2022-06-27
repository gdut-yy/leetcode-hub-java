import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // nums 的一个快照
        List<Integer> snapshotNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int len = nums.length;
        dfs(res, snapshotNums, len, 0);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param res          结果集
     * @param snapshotNums nums 的一种排列
     * @param len          nums.length
     * @param curI         当前发生交互位置下标
     */
    private void dfs(List<List<Integer>> res, List<Integer> snapshotNums, int len, int curI) {
        if (curI == len) {
            // 记录当前快照的副本
            res.add(new ArrayList<>(snapshotNums));
        }
        for (int i = curI; i < len; i++) {
            // 操作
            Collections.swap(snapshotNums, curI, i);
            // 下一迭代
            dfs(res, snapshotNums, len, curI + 1);
            // 回退操作
            Collections.swap(snapshotNums, curI, i);
        }
    }
}
/*
46. 全排列
https://leetcode.cn/problems/permutations/

给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
提示：
1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同

回溯算法。
时间复杂度 O(n×n!)
空间复杂度 O(n)
 */