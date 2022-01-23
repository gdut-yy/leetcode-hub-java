import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solution2044 {
    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> subsets = subsets(nums);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (List<Integer> subset : subsets) {
            if (subset.size() > 0) {
                int res = subset.get(0);
                for (int i = 1; i < subset.size(); i++) {
                    res |= subset.get(i);
                }
                if (treeMap.containsKey(res)) {
                    treeMap.put(res, treeMap.get(res) + 1);
                } else {
                    treeMap.put(res, 1);
                }
            }
        }
        return treeMap.lastEntry().getValue();
    }

    private List<List<Integer>> subsets(int[] nums) {
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
2044. 统计按位或能得到最大值的子集数目
https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/

第 263 场周赛 T3。

给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。
对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。

1 <= nums.length <= 16
考虑 时间复杂度 O(2^n) 的枚举子集。
相似题目: 78. 子集
https://leetcode-cn.com/problems/subsets/
 */