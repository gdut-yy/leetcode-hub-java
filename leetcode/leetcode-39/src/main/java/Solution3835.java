import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3835 {
    public long countSubarrays(int[] nums, long k) {
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        long ans = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            // 1. 入：元素进入窗口
            int x = nums[r];
            while (!minQ.isEmpty() && x <= nums[minQ.peekLast()]) {
                minQ.pollLast();
            }
            minQ.addLast(r);
            while (!maxQ.isEmpty() && x >= nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }
            maxQ.addLast(r);
            // 2. 出：如果窗口不满足要求，左端点离开窗口
            // 只需改下面这行代码，其余逻辑和 2762 题完全一致
            while ((long) (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()]) * (r - l + 1) > k) {
                l++;
                if (minQ.peekFirst() < l) {
                    minQ.pollFirst();
                }
                if (maxQ.peekFirst() < l) {
                    maxQ.pollFirst();
                }
            }
            // 3. 更新答案
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}
/*
3835. 开销小于等于 K 的子数组数目
https://leetcode.cn/problems/count-subarrays-with-cost-less-than-or-equal-to-k/description/

第 488 场周赛 T3。

给你一个整数数组 nums，和一个整数 k。
对于任意子数组 nums[l..r]，其 开销 定义为：
cost = (max(nums[l..r]) - min(nums[l..r])) * (r - l + 1)。
返回一个整数，表示 nums 中开销 小于或等于 k 的子数组数量。
子数组 是数组中连续的 非空 元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= k <= 10^15

单调队列 + 越短越合法型滑动窗口
https://leetcode.cn/problems/count-subarrays-with-cost-less-than-or-equal-to-k/solutions/3898726/on-zuo-fa-dan-diao-dui-lie-yue-duan-yue-l09a0/
时间复杂度 O(n)
 */