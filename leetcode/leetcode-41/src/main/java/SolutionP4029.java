import java.util.Arrays;
import java.util.Comparator;

public class SolutionP4029 {
    public long elevatorRequests(int n, int start, int[][] requests) {
        int m = requests.length + 2; // 不含哨兵的下标范围是 [1, m-2]
        int[][] a = Arrays.copyOf(requests, m);
        a[m - 2] = new int[]{0, -1};
        a[m - 1] = new int[]{0, n}; // 插入两个哨兵
        Arrays.sort(a, Comparator.comparingInt(p -> p[1])); // 按楼层排序

        long[][][] memo = new long[m][m][2];
        for (long[][] mat : memo) {
            for (long[] row : mat) {
                Arrays.fill(row, -1); // -1 表示该状态没有计算过
            }
        }

        // 枚举最后一个完成的请求
        long ans = Long.MAX_VALUE;
        for (int i = 1; i < m - 1; i++) {
            ans = Math.min(ans, dfs(i, i, 0, start, a, memo)); // 这里 0 和 1 是一样的
        }
        return ans;
    }

    // dfs(i, j, 0) 返回完成请求 [1,i] ∪ [j+1,m-2] 所需的最短时间，此时电梯在 floor[i]（最后一个完成的请求是 i）
    // dfs(i, j, 1) 返回完成请求 [1,i-1] ∪ [j,m-2] 所需的最短时间，此时电梯在 floor[j]（最后一个完成的请求是 j）
    private long dfs(int i, int j, int isRight, int start, int[][] requests, long[][][] memo) {
        int m = requests.length;
        if (i == 0 || j == m - 1) { // 出界
            return Long.MAX_VALUE / 2;
        }

        long res = memo[i][j][isRight];
        if (res != -1) {
            return res;
        }

        int[] req = requests[isRight > 0 ? j : i];
        int t = req[0];
        int x = req[1];
        if (i == 1 && j == m - 2) { // 当前请求是第一个请求
            res = Math.max(Math.abs(x - start), t); // 从 start 到当前楼层
        } else {
            res = Math.min(Math.max(dfs(i - 1, j, 0, start, requests, memo) + x - requests[i - 1][1], t),  // 从 floor[i-1] 到当前楼层
                    Math.max(dfs(i, j + 1, 1, start, requests, memo) + requests[j + 1][1] - x, t)); // 从 floor[j+1] 到当前楼层
        }

        memo[i][j][isRight] = res; // 记忆化
        return res;
    }
}
/*
$4029. 电梯请求 IV
https://leetcode.cn/problems/elevator-requests-iv/description/

给你一个整数 n 表示一栋建筑的楼层数，楼层编号从 0 到 n - 1 。
同时给你一个整数 start ，表示电梯的起始楼层，以及一个二维整数数组 requests ，其中 requests[i] = [arrivali, floori] 表示在时间 arrivali 发出了一个前往楼层 floori 的请求。
在时间 0 ，电梯在楼层 start 。
每一秒钟，电梯可以 向上 移动一层、向下 移动一层，或者 停留 在当前楼层。
一个请求 只能 在其到达时间或之后被处理；从请求到达时起，只要电梯在任意时刻位于该请求对应的楼层，该请求就会被 立即 处理。
返回处理所有请求所需的 最短 时间。
示例 1：
输入： n = 9, start = 0, requests = [[0,8],[6,5]]
输出： 9
示例 2：
输入： n = 8, start = 5, requests = [[1,7],[7,3]]
输出： 7
示例 3：
输入： n = 7, start = 3, requests = [[0,5],[0,1],[6,3]]
输出： 8
提示：
1 <= n <= 10^9
1 <= requests.length <= 500
requests[i] == [arrivali, floori]
0 <= arrivali <= 10^9
0 <= start, floori <= n - 1

O(m^2) 区间 DP。
相似题目: 4027. 电梯请求 III
https://leetcode.cn/problems/elevator-requests-iii/description/
 */