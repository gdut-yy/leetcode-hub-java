import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3868 {
    public int minCost(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> cnt1 = new HashMap<>();
        Map<Integer, Integer> cnt2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cnt1.merge(nums1[i], 1, Integer::sum);
            cnt2.merge(nums2[i], 1, Integer::sum);
        }
        Set<Integer> keys = new HashSet<>(cnt1.keySet());
        keys.addAll(cnt2.keySet());

        int ans = 0;
        for (int v : keys) {
            int c1 = cnt1.getOrDefault(v, 0);
            int c2 = cnt2.getOrDefault(v, 0);
            int total = c1 + c2;
            if (total % 2 != 0) {
                return -1;
            }
            int target = total / 2;
            if (c1 > target) {
                ans += c1 - target;
            }
        }
        return ans;
    }
}
/*
3868. 通过交换使数组相等的最小花费
https://leetcode.cn/problems/minimum-cost-to-equalize-arrays-using-swaps/description/

第 178 场双周赛 T3。

给你两个大小为 n 的整数数组 nums1 和 nums2。
你可以对这两个数组执行以下两种操作任意次：
- 在同一个数组内交换：选择两个下标 i 和 j。然后，选择交换 nums1[i] 和 nums1[j]，或者交换 nums2[i] 和 nums2[j]。此操作是 免费的。
- 在两个数组之间交换：选择一个下标 i。然后，交换 nums1[i] 和 nums2[i]。此操作 花费为 1。
返回一个整数，表示使 nums1 和 nums2 相同 的 最小花费。如果不可能做到，返回 -1。
提示：
2 <= n == nums1.length == nums2.length <= 8 * 10^4
1 <= nums1[i], nums2[i] <= 8 * 10^4

https://chat.deepseek.com/a/chat/s/d3ef0a0e-3933-4b39-829b-cde6e86c8bc2
时间复杂度 O(n)。
 */