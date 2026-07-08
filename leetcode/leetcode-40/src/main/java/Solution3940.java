import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3940 {
    public int[] limitOccurrences(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int v : nums) {
            if (cnt.merge(v, 1, Integer::sum) <= k) {
                ans.add(v);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
3940. 限制有序数组中的元素出现次数
https://leetcode.cn/problems/limit-occurrences-in-sorted-array/description/

第 503 场周赛 T1。

给你一个 按升序排序 的整数数组 nums 和一个整数 k。
返回一个数组，使得每个 不同 元素最多出现 k 次，同时保持 nums 中元素的相对顺序不变。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
nums 按非递减顺序排序。
1 <= k <= nums.length
进阶：
你能使用原地算法，并仅使用 O(1) 额外空间解决该问题吗？
注意：用于返回结果或调整结果大小所占用的空间不计入上述空间复杂度，因为有些语言不支持原地调整数组大小。

计数。
时间复杂度 O(n)。
 */