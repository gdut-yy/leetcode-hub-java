import java.util.HashMap;
import java.util.Map;

public class Solution992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> cntMap1 = new HashMap<>();
        Map<Integer, Integer> cntMap2 = new HashMap<>();
        // 双指针
        int left1 = 0;
        int left2 = 0;
        int right = 0;
        int res = 0;
        while (right < len) {
            cntMap1.put(nums[right], cntMap1.getOrDefault(nums[right], 0) + 1);
            cntMap2.put(nums[right], cntMap2.getOrDefault(nums[right], 0) + 1);
            right++;

            while (cntMap1.size() > k) {
                cntMap1.put(nums[left1], cntMap1.get(nums[left1]) - 1);
                if (cntMap1.get(nums[left1]) == 0) {
                    cntMap1.remove(nums[left1]);
                }
                left1++;
            }
            // 第三指针
            while (cntMap2.size() > k - 1) {
                cntMap2.put(nums[left2], cntMap2.get(nums[left2]) - 1);
                if (cntMap2.get(nums[left2]) == 0) {
                    cntMap2.remove(nums[left2]);
                }
                left2++;
            }
            res += left2 - left1;
        }
        return res;
    }
}
/*
992. K 个不同整数的子数组
https://leetcode.cn/problems/subarrays-with-k-different-integers/

给定一个正整数数组 nums和一个整数 k ，返回 num 中 「好子数组」 的数目。
如果 nums 的某个子数组中不同整数的个数恰好为 k，则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
- 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
子数组 是数组的 连续 部分。
提示：
1 <= nums.length <= 2 * 10^4
1 <= nums[i], k <= nums.length

双指针（没见过的三指针版本）
对于每一个右指针下标，找到左区间 [left1, left2]
 */