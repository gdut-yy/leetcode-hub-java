public class Solution3439 {
    private int eventTime;
    private int[] startTime, endTime;

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        this.eventTime = eventTime;
        this.startTime = startTime;
        this.endTime = endTime;

        int n = startTime.length;
        int s = 0;
        for (int i = 0; i < k; i++) {
            s += get(i);
        }
        int ans = s;
        for (int i = k; i <= n; i++) {
            s += get(i);
            ans = Math.max(ans, s);
            s -= get(i - k);
        }
        return ans;
    }

    private int get(int i) {
        if (i == 0) {
            return startTime[0];
        }
        int n = startTime.length;
        if (i == n) {
            return eventTime - endTime[n - 1];
        }
        return startTime[i] - endTime[i - 1];
    }
}
/*
3439. 重新安排会议得到最多空余时间 I
https://leetcode.cn/problems/reschedule-meetings-for-maximum-free-time-i/description/

第 149 场双周赛 T2。

给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。
同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为 [startTime[i], endTime[i]] 。
你可以重新安排 至多 k 个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 相邻两个会议之间的 最长 连续空余时间。
移动前后所有会议之间的 相对 顺序需要保持不变，而且会议时间也需要保持互不重叠。
请你返回重新安排会议以后，可以得到的 最大 空余时间。
注意，会议 不能 安排到整个活动的时间以外。
提示：
1 <= eventTime <= 10^9
n == startTime.length == endTime.length
2 <= n <= 10^5
1 <= k <= n
0 <= startTime[i] < endTime[i] <= eventTime
endTime[i] <= startTime[i + 1] 其中 i 在范围 [0, n - 2] 之间。

定长滑动窗口。
问题等价于：给你 n+1 个空余时间段，合并其中 k+1 个连续的空余时间段，得到的最大长度是多少？
时间复杂度 O(n)。
相似题目: 3440. 重新安排会议得到最多空余时间 II
https://leetcode.cn/problems/reschedule-meetings-for-maximum-free-time-ii/description/
 */