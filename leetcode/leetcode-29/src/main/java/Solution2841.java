import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        TreeMap<Integer, Integer> multiSet = new TreeMap<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            insert(multiSet, nums.get(i));
            sum += nums.get(i);
        }
        long ans = 0;
        if (multiSet.size() >= m) {
            ans = sum;
        }
        for (int i = k; i < n; i++) {
            insert(multiSet, nums.get(i));
            erase(multiSet, nums.get(i - k));
            sum += nums.get(i) - nums.get(i - k);
            if (multiSet.size() >= m) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    private void erase(TreeMap<Integer, Integer> map, int v) {
        map.put(v, map.getOrDefault(v, 0) - 1);
        if (map.get(v) == 0) map.remove(v);
    }

    private void insert(TreeMap<Integer, Integer> map, int v) {
        map.put(v, map.getOrDefault(v, 0) + 1);
    }

    public long maxSum2(List<Integer> nums, int m, int k) {
        int n = nums.size();

        int size = 0;
        long sum = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int v = nums.get(i);
            sum += v;
            cntMap.put(v, cntMap.getOrDefault(v, 0) + 1);
            if (cntMap.get(v) == 1) size++;
        }
        long ans = (size >= m) ? sum : 0;
        for (int i = k; i < n; i++) {
            int add = nums.get(i);
            int rm = nums.get(i - k);
            sum += add - rm;
            cntMap.put(add, cntMap.getOrDefault(add, 0) + 1);
            if (cntMap.get(add) == 1) size++;
            cntMap.put(rm, cntMap.getOrDefault(rm, 0) - 1);
            if (cntMap.get(rm) == 0) size--;
            if (size >= m) ans = Math.max(ans, sum);
        }
        return ans;
    }
}
/*
2841. 几乎唯一子数组的最大和
https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/

第 112 场双周赛 T3。

给你一个整数数组 nums 和两个正整数 m 和 k 。
请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
子数组指的是一个数组中一段连续 非空 的元素序列。
提示：
1 <= nums.length <= 2 * 10^4
1 <= m <= k <= nums.length
1 <= nums[i] <= 10^9

滑动窗口
 */