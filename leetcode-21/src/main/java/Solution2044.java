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
1 <= nums.length <= 16
考虑 时间复杂度 O(2^n) 的枚举子集。
类似题目: 78. 子集
https://leetcode-cn.com/problems/subsets/
 */