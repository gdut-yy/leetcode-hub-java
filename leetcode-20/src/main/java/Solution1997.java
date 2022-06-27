public class Solution1997 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        // dp[i][0] 表示奇数次到达 i 时需要的天数
        // dp[i][1] 表示偶数次到达 i 时需要的天数
        long[][] dp = new long[nextVisit.length][2];
        // 第 2 次到达 0 时需要一天
        dp[0][1] = 1;
        int mod = 1000000007;
        for (int i = 1; i < nextVisit.length; i++) {
            // 第 1 次到达 i 时, 得到达两次 i-1, 才能达到 i
            dp[i][0] = (dp[i - 1][1] + 1) % mod;
            // 第二次到达 i 是在第一次的基础上
            // +1 到达奇数次 dp[nextVisit[i]][0], 此时想要再次到达 i, 需要先偶数次的到达 i-1
            // + (dp[i - 1][1] - dp[nextVisit[i]][0]), 再次到达 i-1 需要的天数
            // 再 +1 第二次到达 i
            // 注意: 这里相减可能会出现负数, 所以加上 mod
            dp[i][1] = (dp[i][0] + 1 + (mod + dp[i - 1][1] - dp[nextVisit[i]][0]) + 1) % mod;
        }
        return (int) dp[dp.length - 1][0];
    }
}
/*
1997. 访问完所有房间的第一天
https://leetcode.cn/problems/first-day-where-you-have-been-in-all-the-rooms/

第 257 场周赛 T3。

你需要访问 n 个房间，房间从 0 到 n - 1 编号。同时，每一天都有一个日期编号，从 0 开始，依天数递增。你每天都会访问一个房间。
最开始的第 0 天，你访问 0 号房间。给你一个长度为 n 且 下标从 0 开始 的数组 nextVisit 。在接下来的几天中，你访问房间的 次序 将根据下面的 规则 决定：
- 假设某一天，你访问 i 号房间。
- 如果算上本次访问，访问 i 号房间的次数为 奇数 ，那么 第二天 需要访问 nextVisit[i] 所指定的房间，其中 0 <= nextVisit[i] <= i 。
- 如果算上本次访问，访问 i 号房间的次数为 偶数 ，那么 第二天 需要访问 (i + 1) mod n 号房间。
请返回你访问完所有房间的第一天的日期编号。题目数据保证总是存在这样的一天。由于答案可能很大，返回对 109 + 7 取余后的结果。

动态规划。
codeforces https://codeforces.com/contest/1552/problem/F
字节跳动2018招聘测试开发方向（第四批）附加题 https://www.nowcoder.com/test/8536903/summary
 */