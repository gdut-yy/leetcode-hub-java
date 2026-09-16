public class Solution4020 {
    public int elevatorRequests(int n, int[] requests) {
        int ans = 0;
        int pre = 0;
        for (int r : requests) {
            ans += Math.abs(r - pre);
            pre = r;
        }
        return ans;
    }
}
/*
4020. 电梯请求 I
https://leetcode.cn/problems/elevator-requests-i/description/

第 189 场双周赛 T1。

给你一个整数 n ，表示一栋楼房的楼层数，楼层编号从 0 到 n - 1 。
同时给你一个整数数组 requests ，其中 requests 表示楼层请求的序列。
一部电梯初始在 0 层，遵循以下规则：
- 电梯每秒移动一层。
- 电梯按给定的顺序处理请求。
- 如果电梯已经在请求的楼层，则不需要移动。
- 处理完一个请求后，电梯立即开始向下一个请求的楼层移动。
返回处理所有请求所需的 总时间 （以秒为单位）。
提示：
1 <= n <= 100
1 <= requests.length <= 100
0 <= requests[i] <= n - 1

中国时间 2026-08-15 周六 22:30
佛山。
遍历。
时间复杂度 O(m)。
 */