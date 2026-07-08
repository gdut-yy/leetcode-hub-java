import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3957 {
    public long maximumSum(int[] nums, int m, int l, int r) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        long bestOne = Long.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int add = i - l;
            if (add >= 0) {
                while (!dq.isEmpty() && pre[dq.peekLast()] >= pre[add]) {
                    dq.pollLast();
                }
                dq.addLast(add);
            }
            while (!dq.isEmpty() && dq.peekFirst() < i - r) {
                dq.pollFirst();
            }
            if (!dq.isEmpty()) {
                bestOne = Math.max(bestOne, pre[i] - pre[dq.peekFirst()]);
            }
        }
        long lo = 0, hi = (long) 1e14;
        long ans = bestOne;
        while (lo <= hi) {
            long penalty = lo + (hi - lo) / 2;
            long[] resFewer = solve(pre, penalty, l, r, n, true);
            long[] resMore = solve(pre, penalty, l, r, n, false);
            long bestVal = resFewer[0];
            long cntMin = resFewer[1];
            long cntMax = resMore[1];
            if (resMore[0] > bestVal) {
                bestVal = resMore[0];
                cntMin = resMore[1];
                cntMax = resMore[1];
            } else if (resMore[0] == bestVal) {
                if (cntMin > cntMax) {
                    long tmp = cntMin;
                    cntMin = cntMax;
                    cntMax = tmp;
                }
            }
            if (cntMax == 0) {
                hi = penalty - 1;
                continue;
            }
            if (cntMin <= m) {
                long cand;
                if (m <= cntMax) {
                    cand = bestVal + penalty * m;
                } else {
                    cand = bestVal + penalty * cntMax;
                }
                ans = Math.max(ans, cand);
            }
            if (cntMin > m) {
                lo = penalty + 1;
            } else {
                hi = penalty - 1;
            }
        }
        return ans;
    }

    private long[] solve(long[] pre, long penalty, int l, int r, int n, boolean preferFewer) {
        long[] dp = new long[n + 1];
        int[] cnt = new int[n + 1];
        Deque<Integer> win = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            cnt[i] = cnt[i - 1];
            int addIdx = i - l;
            if (addIdx >= 0) {
                long val = dp[addIdx] - pre[addIdx];
                while (!win.isEmpty()) {
                    int last = win.peekLast();
                    long lastVal = dp[last] - pre[last];
                    if (lastVal < val) {
                        win.pollLast();
                    } else if (lastVal == val) {
                        boolean remove;
                        if (preferFewer) {
                            remove = cnt[last] >= cnt[addIdx];
                        } else {
                            remove = cnt[last] <= cnt[addIdx];
                        }
                        if (remove) {
                            win.pollLast();
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                win.addLast(addIdx);
            }
            while (!win.isEmpty() && win.peekFirst() < i - r) {
                win.pollFirst();
            }
            if (!win.isEmpty()) {
                int j = win.peekFirst();
                long cand = pre[i] + (dp[j] - pre[j]) - penalty;
                int candCnt = cnt[j] + 1;
                if (cand > dp[i]) {
                    dp[i] = cand;
                    cnt[i] = candCnt;
                } else if (cand == dp[i]) {
                    if (preferFewer ? candCnt < cnt[i] : candCnt > cnt[i]) {
                        cnt[i] = candCnt;
                    }
                }
            }
        }
        return new long[]{dp[n], cnt[n]};
    }
}
/*
3957. M 个非重叠子数组最大和 II
https://leetcode.cn/problems/maximum-sum-of-m-non-overlapping-subarrays-ii/description/

第 505 场周赛 T4。

给你一个长度为 n 的整数数组 nums，以及三个整数 m、l 和 r。
你的任务是从 nums 中选择 至少 一个且 至多 m 个 互不重叠的子数组，并满足：
- 每个被选择的 子数组 的长度都在 [l, r] 范围内（包含两端）。
- 所有被选择 子数组 的总和 最大 。
返回你能够取得的 最大 总和。
子数组 是数组中一个连续的 非空 元素序列。
提示：
1 <= n == nums.length <= 10^5
-10^5 <= nums[i] <= 10^5
1 <= m <= n
1 <= l <= r <= n

WQS 二分？
 */