import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    private int[] nums;
    private LinkedList<Integer> subset;
    private List<List<Integer>> subsetList;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        subset = new LinkedList<>();
        subsetList = new ArrayList<>();
        dfs(0);
        return subsetList;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            subsetList.add(new ArrayList<>(subset));
            return;
        }
        // 不选
        dfs(i + 1);
        // 选
        subset.add(nums[i]);
        dfs(i + 1);
        subset.removeLast();
    }

    // 状态压缩
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int len = nums.length;
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