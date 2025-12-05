import java.util.HashMap;
import java.util.Map;

public class Solution3755 {
    public int maxBalancedSubarray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int maxLen = 0;
        Map<String, Integer> mp = new HashMap<>();
        int xor = 0;
        int balance = 0;
        mp.put("0,0", -1);
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
            balance += (nums[i] % 2 == 1) ? 1 : -1;
            String key = xor + "," + balance;
            if (mp.containsKey(key)) {
                int prevIndex = mp.get(key);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                mp.put(key, i);
            }
        }
        return maxLen;
    }
}
/*
3755. 最大平衡异或子数组的长度
https://leetcode.cn/problems/find-maximum-balanced-xor-subarray-length/description/

第 477 场周赛 T2。

给你一个整数数组 nums，返回同时满足以下两个条件的 最长子数组的长度 ：
1.子数组的按位异或（XOR）为 0。
2.子数组包含的 偶数 和 奇数 数量相等。
如果不存在这样的子数组，则返回 0。
子数组 是数组中的一个连续、非空 元素序列。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

前缀和 + 哈希表。
时间复杂度 O(n)。
 */