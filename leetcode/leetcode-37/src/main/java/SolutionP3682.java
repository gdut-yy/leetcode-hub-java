import java.util.HashMap;
import java.util.Map;

public class SolutionP3682 {
    public int minimumSum(int[] nums1, int[] nums2) {
        Map<Integer, Integer> posMp = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            posMp.putIfAbsent(nums1[i], i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (posMp.containsKey(nums2[i])) {
                ans = Math.min(ans, posMp.get(nums2[i]) + i);
            }
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
/*
$3682. 公共元素的最小索引和
https://leetcode.cn/problems/minimum-index-sum-of-common-elements/description/

给定两个整数数组 nums1 和 nums2，长度都为 n。
如果 nums1[i] == nums2[j]，我们定义下标对 (i, j) 是 好数对。
返回所有可能的好数对中 i + j 的最小索引和。如果不存在这样的数对，则返回 -1。
提示：
1 <= nums1.length == nums2.length <= 10^5
-10^5 <= nums1[i], nums2[i] <= 10^5

哈希表，类似两数之和。
时间复杂度 O(n)。
 */