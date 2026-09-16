import java.util.Arrays;

public class Solution4023 {
    public long elevatorRequests(int n, int start, int[] requests) {
        int m = requests.length + 3;
        int[] a = Arrays.copyOf(requests, m);
        // 插入 start 和两个哨兵
        a[m - 3] = start;
        a[m - 2] = -1;
        a[m - 1] = n;
        Arrays.sort(a);

        long[][][] memo = new long[m - 1][m - 1][2];
        for (long[][] mat : memo) {
            for (long[] row : mat) {
                Arrays.fill(row, -1);  // -1 表示该状态没有计算过
            }
        }

        int i = Arrays.binarySearch(a, start);
        return dfs(i, i, 0, a, memo); // 这里 0 和 1 是一样的
    }

    // 已处理完 requests 的子数组 [i, j]
    // isRight = 0 表示电梯在 requests[i]
    // isRight = 1  表示电梯在 requests[j]
    private long dfs(int i, int j, int isRight, int[] a, long[][][] memo) {
        int m = a.length;
        if (i == 0 || j == m - 1) { // 出界
            return Long.MAX_VALUE / 2;
        }
        if (i == 1 && j == m - 2) { // 已处理完所有请求
            return 0;
        }
        long res = memo[i][j][isRight];
        // 之前计算过
        if (res != -1) return res;

        int x = a[isRight > 0 ? j : i];
        int remain = m - 3 - j + i;
        res = Math.min(dfs(i - 1, j, 0, a, memo) + (long) (x - a[i - 1]) * remain,  // 往左
                dfs(i, j + 1, 1, a, memo) + (long) (a[j + 1] - x) * remain); // 往右
        return memo[i][j][isRight] = res; // 记忆化
    }
}
/*
4023. 电梯请求 II
https://leetcode.cn/problems/elevator-requests-ii/description/

第 189 场双周赛 T4。

给你一个整数 n 表示一栋建筑的楼层数，楼层编号从 0 到 n - 1 。
同时给你一个整数 start ，表示电梯的起始楼层，以及一个整数数组 requests ，其中 requests[i] 是电梯需要到达的楼层。requests 中的所有楼层都是 互不相同 的。
在时间 0 ，电梯在楼层 start ，所有请求都是 同时 发出的。
在所有请求被处理完之前的每一秒钟，电梯 恰好 移动一层，可以是 向上 也可以是 向下 。当电梯到达请求的楼层时，该请求会被 立即 处理。如果 start 出现在 requests 中，则该请求在时间 0 被处理。
对于每个未被处理的请求，每一秒钟你会受到 1 点惩罚。等价地说，在时间 t 处理一个请求，它对总惩罚的贡献是 t 。
返回处理所有请求所需的 最小 总惩罚。
提示：
1 <= n <= 10^9
1 <= requests.length <= 1500
0 <= start, requests[i] <= n - 1
requests 中的所有值都是 互不相同 的。

记忆化搜索。
时间复杂度 O(m^2)。
 */