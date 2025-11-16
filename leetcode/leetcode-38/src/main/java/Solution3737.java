import java.util.HashMap;
import java.util.Map;

public class Solution3737 {
    public int countMajoritySubarrays(int[] nums, int target) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1); // 为什么加个 0？见 525 题我的题解
        int ans = 0;
        int s = 0;
        int f = 0;
        for (int x : nums) {
            if (x == target) {
                f += cnt.getOrDefault(s, 0);
                s++;
            } else {
                s--;
                f -= cnt.getOrDefault(s, 0);
            }
            ans += f;
            cnt.merge(s, 1, Integer::sum); // cnt[s]++
        }
        return ans;
    }
}
/*
3737. 统计主要元素子数组数目 I
https://leetcode.cn/problems/count-subarrays-with-majority-element-i/description/

第 169 场双周赛 T2。

给你一个整数数组 nums 和一个整数 target。
返回数组 nums 中满足 target 是 主要元素 的 子数组 的数目。
一个子数组的 主要元素 是指该元素在该子数组中出现的次数 严格大于 其长度的 一半 。
子数组 是数组中的一段连续且 非空 的元素序列。
提示:
1 <= nums.length <= 1000
1 <= nums[i] <= 10^9
1 <= target <= 10^9

同: 3739. 统计主要元素子数组数目 II
https://leetcode.cn/problems/count-subarrays-with-majority-element-ii/description/
 */