public class Solution3440 {
    private int eventTime;
    private int[] startTime, endTime;

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        this.eventTime = eventTime;
        this.startTime = startTime;
        this.endTime = endTime;

        int n = startTime.length;
        // 最大的三个空位所在的位置（下标）分别是 a,b,c。
        int a = 0, b = -1, c = -1;
        for (int i = 1; i <= n; i++) {
            int sz = get(i);
            if (sz > get(a)) {
                c = b;
                b = a;
                a = i;
            } else if (b < 0 || sz > get(b)) {
                c = b;
                b = i;
            } else if (c < 0 || sz > get(c)) {
                c = i;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sz = endTime[i] - startTime[i];
            if (i != a && i + 1 != a && sz <= get(a) ||
                    i != b && i + 1 != b && sz <= get(b) ||
                    sz <= get(c)) {
                ans = Math.max(ans, get(i) + sz + get(i + 1));
            } else {
                ans = Math.max(ans, get(i) + get(i + 1));
            }
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
3440. 重新安排会议得到最多空余时间 II
https://leetcode.cn/problems/reschedule-meetings-for-maximum-free-time-ii/description/

第 149 场双周赛 T3。

给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。
同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为 [startTime[i], endTime[i]] 。
你可以重新安排 至多 一个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 相邻两个会议之间的 最长 连续空余时间。
请你返回重新安排会议以后，可以得到的 最大 空余时间。
注意，会议 不能 安排到整个活动的时间以外，且会议之间需要保持互不重叠。
注意：重新安排会议以后，会议之间的顺序可以发生改变。
提示：
1 <= eventTime <= 10^9
n == startTime.length == endTime.length
2 <= n <= 10^5
0 <= startTime[i] < endTime[i] <= eventTime
endTime[i] <= startTime[i + 1] 其中 i 在范围 [0, n - 2] 之间。

维护前三大的空位+枚举+分类讨论。
时间复杂度 O(n)。
相似题目: 3439. 重新安排会议得到最多空余时间 I
https://leetcode.cn/problems/reschedule-meetings-for-maximum-free-time-i/description/
 */