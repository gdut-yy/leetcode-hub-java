public class SolutionP3540 {
    public long minTotalTime(int[] forward, int[] backward, int[] queries) {
        int n = forward.length;
        // 前缀和
        long[] preForward = new long[n * 2 + 1];
        long[] preBackward = new long[n * 2 + 1];
        for (int i = 0; i < n * 2; i++) {
            preForward[i + 1] = preForward[i] + forward[i % n];
            preBackward[i + 1] = preBackward[i] + backward[i % n];
        }

        long ans = 0;
        int pre = 0;
        for (int cur : queries) {
            long forwardSum = preForward[(cur > pre ? cur : cur + n)] - preForward[pre];
            long backwardSum = preBackward[(cur < pre ? pre : pre + n) + 1] - preBackward[cur + 1];
            ans += Math.min(forwardSum, backwardSum);
            pre = cur;
        }
        return ans;
    }
}
/*
$3540. 访问所有房屋的最短时间
https://leetcode.cn/problems/minimum-time-to-visit-all-houses/description/

给定两个整数数组 forward 和 backward，长度都为 n。同时给定另一个整数数组 queries。
有 n 个排列为环形的房屋。房屋通过道路以特殊方式相连：
- 对于所有的 0 <= i <= n - 2，房屋 i 通过一条长度为 forward[i] 米的道路连接到房屋 i + 1。另外，房屋 n - 1 通过一条长度为 forward[n - 1] 米的道路连接回房屋 0，形成一个环。
- 对于所有的 1 <= i <= n - 1，房屋 i 通过一条长度为 backward[i] 米的道路连接到房屋 i - 1。另外，房屋 0 通过一条长度为 backward[0] 米的道路连接回房屋 n - 1，形成一个环。
你可以以 1 米每秒的速度行走。从房屋 0 开始，找到按照 queries 指定的顺序访问每所房屋的 最小 时间。
返回访问房屋所需的 最短 总时间。
提示：
2 <= n <= 10^5
n == forward.length == backward.length
1 <= forward[i], backward[i] <= 10^5
1 <= queries.length <= 10^5
0 <= queries[i] < n
queries[i] != queries[i + 1]
queries[0] 非 0。

前缀和 + 枚举。
时间复杂度 O(n)。
 */