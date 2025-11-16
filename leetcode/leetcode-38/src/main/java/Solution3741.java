import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3741 {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> groupMp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            groupMp.computeIfAbsent(nums[i], e -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;
        for (List<Integer> posList : groupMp.values()) {
            for (int i = 2; i < posList.size(); i++) {
                ans = Math.min(ans, (posList.get(i) - posList.get(i - 2)) * 2);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
/*
3741. 三个相等元素之间的最小距离 II
https://leetcode.cn/problems/minimum-distance-between-three-equal-elements-ii/description/

第 475 场周赛 T2。

给你一个整数数组 nums。
如果满足 nums[i] == nums[j] == nums[k]，且 (i, j, k) 是 3 个 不同 下标，那么三元组 (i, j, k) 被称为 有效三元组 。
有效三元组 的 距离 被定义为 abs(i - j) + abs(j - k) + abs(k - i)，其中 abs(x) 表示 x 的 绝对值 。
返回一个整数，表示 有效三元组 的 最小 可能距离。如果不存在 有效三元组 ，返回 -1。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= n

按照相同元素分组。贪心。
时间复杂度 O(n)。
 */