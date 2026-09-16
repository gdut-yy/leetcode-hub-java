import java.util.Arrays;

public class Solution4027 {
    public long elevatorRequests(int n, int start, int[][] requests) {
        int m = requests.length;
        long[][] memo = new long[1 << m][m];
        for (long[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) { // 枚举最后处理的请求
            ans = Math.min(ans, dfs((1 << m) - 1, i, start, requests, memo));
        }
        return ans;
    }

    // 返回处理完请求集合 mask，且电梯停在 requests[i][1]，所需的最短时间
    private long dfs(int mask, int i, int start, int[][] requests, long[][] memo) {
        mask ^= 1 << i; // 这里去掉了 i
        int[] req = requests[i];
        int t = req[0];
        int x = req[1];
        if (mask == 0) {
            // i 是第一个被处理的请求
            return Math.max(Math.abs(x - start), t);
        }
        // 之前计算过
        if (memo[mask][i] != -1) return memo[mask][i];

        long res = Long.MAX_VALUE;
        for (int j = 0; j < requests.length; j++) {
            if ((mask >> j & 1) > 0) {
                // 处理完请求 j 的时间 + 从 j 到 i 的时间
                res = Math.min(res, dfs(mask, j, start, requests, memo) + Math.abs(x - requests[j][1]));
            }
        }
        // 处理完请求 i 的时间不能早于 t
        res = Math.max(res, t);
        return memo[mask][i] = res; // 记忆化;
    }
}
/*
4027. 电梯请求 III
https://leetcode.cn/problems/elevator-requests-iii/description/

第 515 场周赛 T4。

给你一个整数 n 表示一栋建筑的楼层数，楼层编号从 0 到 n - 1 。
同时给你一个整数 start ，表示电梯的起始楼层，以及一个二维整数数组 requests ，其中 requests[i] = [arrivali, floori] 表示在时间 arrivali 发出了一个前往楼层 floori 的请求。
在时间 0 ，电梯在楼层 start 。
每一秒钟，电梯可以 向上 移动一层、向下 移动一层，或者 停留 在当前楼层。
一个请求 只能 在其到达时间或之后被处理；从请求到达时起，只要电梯在任意时刻位于该请求对应的楼层，该请求就会被 立即 处理。
返回处理所有请求所需的 最短 时间。
提示：
1 <= n <= 10^9
1 <= requests.length <= 16
requests[i] == [arrivali, floori]
0 <= arrivali <= 10^9
0 <= start, floori <= n - 1

状压 DP / 区间 DP。
https://leetcode.cn/problems/elevator-requests-iii/solutions/4012846/zhuang-ya-dplei-si-tsp-wen-ti-pythonjava-lxwv/
 */