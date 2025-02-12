import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution3420 {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] posR = new int[n];
        Arrays.fill(posR, n);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (!st.isEmpty() && x >= nums[st.peek()]) {
                posR[st.pop()] = i;
            }
            // 循环结束后，栈顶就是左侧 > x 的最近元素了
            if (!st.isEmpty()) {
                g[st.peek()].add(i);
            }
            st.push(i);
        }

        long ans = 0;
        int cnt = 0;
        int l = 0; // 窗口左端点
        Deque<Integer> dq = new ArrayDeque<>(); // 单调队列维护最大值
        for (int r = 0; r < n; r++) { // 窗口右端点
            int x = nums[r];
            // x 进入窗口
            while (!dq.isEmpty() && nums[dq.peekLast()] <= x) {
                dq.pollLast(); // 维护 q 的单调性
            }
            dq.addLast(r);

            // 由于队首到队尾单调递减，所以窗口最大值就是队首
            cnt += nums[dq.peekFirst()] - x;

            // 操作次数太多，缩小窗口
            while (cnt > k) {
                int out = nums[l]; // 离开窗口的元素
                for (int i : g[l]) {
                    if (i > r) {
                        break;
                    }
                    cnt -= (out - nums[i]) * (Math.min(posR[i], r + 1) - i);
                }
                l++;

                // 队首已经离开窗口了
                if (!dq.isEmpty() && dq.peekFirst() < l) {
                    dq.pollFirst();
                }
            }

            ans += r - l + 1;
        }

        return ans;
    }
}
/*
3420. 统计 K 次操作以内得到非递减子数组的数目
https://leetcode.cn/problems/count-non-decreasing-subarrays-after-k-operations/description/

第 432 场周赛 T4。

给你一个长度为 n 的数组 nums 和一个整数 k 。
对于 nums 中的每一个子数组，你可以对它进行 至多 k 次操作。每次操作中，你可以将子数组中的任意一个元素增加 1 。
注意 ，每个子数组都是独立的，也就是说你对一个子数组的修改不会保留到另一个子数组中。
请你返回最多 k 次操作以内，有多少个子数组可以变成 非递减 的。
如果一个数组中的每一个元素都大于等于前一个元素（如果前一个元素存在），那么我们称这个数组是 非递减 的。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= 10^9

单调栈+单调队列。
左端点元素离开窗口 本题的难点。
时间复杂度 O(n)。
rating 2868 (clist.by)
 */