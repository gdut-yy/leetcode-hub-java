import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3488 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> posMp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            posMp.computeIfAbsent(nums[i], e -> new ArrayList<>()).add(i);
        }
        for (List<Integer> p : posMp.values()) {
            // 前后各加一个哨兵
            int i0 = p.getFirst();
            p.addFirst(p.getLast() - n);
            p.add(i0 + n);
        }

        List<Integer> ans = new ArrayList<>();
        for (int qi : queries) {
            List<Integer> p = posMp.get(nums[qi]);
            if (p.size() == 3) {
                ans.add(-1);
            } else {
                int j = Collections.binarySearch(p, qi); // 二分
                ans.add(Math.min(qi - p.get(j - 1), p.get(j + 1) - qi));
            }
        }
        return ans;
    }
}
/*
3488. 距离最小相等元素查询
https://leetcode.cn/problems/closest-equal-element-queries/description/

第 441 场周赛 T2。

给你一个 循环 数组 nums 和一个数组 queries 。
对于每个查询 i ，你需要找到以下内容：
- 数组 nums 中下标 queries[i] 处的元素与 任意 其他下标 j（满足 nums[j] == nums[queries[i]]）之间的 最小 距离。如果不存在这样的下标 j，则该查询的结果为 -1 。
返回一个数组 answer，其大小与 queries 相同，其中 answer[i] 表示查询i的结果。
提示：
1 <= queries.length <= nums.length <= 10^5
1 <= nums[i] <= 10^6
0 <= queries[i] < nums.length

二分查找。
时间复杂度 O(n + qlogn)。
 */