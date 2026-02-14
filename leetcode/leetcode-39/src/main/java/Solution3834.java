import java.util.ArrayList;
import java.util.List;

public class Solution3834 {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> st = new ArrayList<>();
        for (long v : nums) {
            while (!st.isEmpty() && st.getLast() == v) {
                st.removeLast();
                v *= 2;
            }
            st.add(v);
        }
        return st;
    }
}
/*
3834. 合并相邻且相等的元素
https://leetcode.cn/problems/merge-adjacent-equal-elements/description/

第 488 场周赛 T2。

给你一个整数数组 nums。
你需要 重复 执行以下合并操作，直到无法再进行任何更改：
- 如果数组中存在 两个相邻且相等的元素，选择当前数组中 最左侧 的这对相邻元素，并用它们的 和 替换它们。
每次合并操作后，数组的大小 减少 1。对更新后的数组重复此过程，直到无法再进行任何操作。
返回完成所有可能的合并操作后的最终数组。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

栈模拟。
时间复杂度 O(n)。
 */