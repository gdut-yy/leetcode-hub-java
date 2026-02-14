import java.util.ArrayList;
import java.util.Arrays;

public class Solution3825 {
    public int longestSubsequence(int[] nums) {
        final int BITS = 31;
        ArrayList<Integer>[] tails = new ArrayList[BITS];
        Arrays.setAll(tails, e -> new ArrayList<>());
        for (int num : nums) {
            for (int bit = 0; bit < BITS; bit++) {
                if (((num >> bit) & 1) == 1) {
                    ArrayList<Integer> tail = tails[bit];
                    int left = 0, right = tail.size();
                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (tail.get(mid) >= num) {
                            right = mid;
                        } else {
                            left = mid + 1;
                        }
                    }
                    if (left < tail.size()) {
                        tail.set(left, num);
                    } else {
                        tail.add(num);
                    }
                }
            }
        }
        int maxLen = 0;
        for (int bit = 0; bit < BITS; bit++) {
            maxLen = Math.max(maxLen, tails[bit].size());
        }
        return maxLen;
    }
}
/*
3825. 按位与结果非零的最长上升子序列
https://leetcode.cn/problems/longest-strictly-increasing-subsequence-with-non-zero-bitwise-and/description/

第 175 场双周赛 T3。

给你一个整数数组 nums。
返回 nums 中按位 与（AND） 结果为 非零 的 最长严格递增子序列 的长度。如果不存在这样的 子序列，返回 0。
子序列 是指从另一个数组中删除一些或不删除元素，且不改变剩余元素顺序而得到的 非空 数组。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

枚举比特位 + LIS
https://chat.deepseek.com/a/chat/s/cb6505b2-f476-4d63-a546-9d916c640d5d
时间复杂度 O(30 nlogn)。
 */