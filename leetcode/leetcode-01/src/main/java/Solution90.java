import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution90 {
    private int[] nums;
    private LinkedList<Integer> subset;
    private List<List<Integer>> subsetList;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
        dfs(getNext(i));
        // 选
        subset.add(nums[i]);
        dfs(i + 1);
        subset.removeLast();
    }

    private int getNext(int i) {
        int next = i;
        while (next < nums.length && nums[next] == nums[i]) {
            next++;
        }
        return next;
    }

    // 时间复杂度 O(n * 2^n)
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> resSet = new HashSet<>();
        // 状态压缩 dp
        for (int state = 0; state < (1 << len); state++) {
            List<Integer> curList = new ArrayList<>();
            for (int k = 0; k < len; k++) {
                // 第 k 位被选中
                if (((state >> k) & 1) == 1) {
                    curList.add(nums[k]);
                }
            }
            resSet.add(curList);
        }
        return new ArrayList<>(resSet);
    }
}
/*
90. 子集 II
https://leetcode.cn/problems/subsets-ii/

给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10

思路类似 第 39 题与第 40 题差异，Arrays.sort() + getNext() 去重同理
相似题目: 78. 子集
https://leetcode.cn/problems/subsets/
39. 组合总和
https://leetcode.cn/problems/combination-sum/
40. 组合总和 II
https://leetcode.cn/problems/combination-sum-ii/
 */