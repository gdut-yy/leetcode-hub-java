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
https://leetcode-cn.com/problems/first-day-where-you-have-been-in-all-the-rooms/

第 257 场周赛 T3。
动态规划。
codeforces https://codeforces.com/contest/1552/problem/F
字节跳动2018招聘测试开发方向（第四批）附加题 https://www.nowcoder.com/test/8536903/summary
 */