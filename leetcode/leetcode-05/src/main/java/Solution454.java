import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> n1_plus_n2_mp = new HashMap<>();
        Map<Integer, Integer> n3_plus_n4_mp = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                n1_plus_n2_mp.merge(n1 + n2, 1, Integer::sum);
            }
        }
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                n3_plus_n4_mp.merge(n3 + n4, 1, Integer::sum);
            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : n1_plus_n2_mp.entrySet()) {
            int n1n2 = entry.getKey(), cnt_n1n2 = entry.getValue();
            int n3n4 = -n1n2;
            if (n3_plus_n4_mp.containsKey(n3n4)) {
                int cnt_n3n4 = n3_plus_n4_mp.get(n3n4);
                ans += cnt_n1n2 * cnt_n3n4;
            }
        }
        return ans;
    }
}
/*
454. 四数相加 II
https://leetcode.cn/problems/4sum-ii/

给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
- 0 <= i, j, k, l < n
- nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 提示：
n == nums1.length
n == nums2.length
n == nums3.length
n == nums4.length
1 <= n <= 200
-2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28

nums1/nums2，nums3/nums4 两两组合
时间复杂度 O(n^2)
 */