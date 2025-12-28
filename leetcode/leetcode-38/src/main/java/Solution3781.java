import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3781 {
    public long maximumScore(int[] nums, String s) {
        int n = nums.length;
        long ans = 0L;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
            if (s.charAt(i) == '1') {
                ans += pq.poll();
            }
        }
        return ans;
    }
}
/*
3781. 二进制交换后的最大分数
https://leetcode.cn/problems/maximum-score-after-binary-swaps/description/

第 172 场双周赛 T3。

给你一个长度为 n 的整数数组 nums 和一个相同长度的二进制字符串 s。
一开始，你的分数为 0。对于每一个 s[i] = '1' 的下标 i，都会为分数贡献 nums[i]。
你可以执行 任意 次操作（包括零次）。在一次操作中，你可以选择一个下标 i（0 <= i < n - 1），满足 s[i] = '0' 且 s[i + 1] = '1'，并交换这两个字符。
返回一个整数，表示你可以获得的 最大可能分数。
提示：
n == nums.length == s.length
1 <= n <= 10^5
1 <= nums[i] <= 10^9
s[i] 是 '0' 或 '1'

优先队列。
时间复杂度 O(nlogn)。
 */