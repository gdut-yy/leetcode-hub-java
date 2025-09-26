public class Solution3680 {
    public int[][] generateSchedule(int n) {
        if (n < 5) {
            return new int[0][];
        }

        int[][] ans = new int[n * (n - 1)][];
        int idx = 0;

        // 处理 d=2,3,...,n-2
        for (int d = 2; d < n - 1; d++) {
            for (int i = 0; i < n; i++) {
                ans[idx++] = new int[]{i, (i + d) % n};
            }
        }

        // 交错排列 d=1 与 d=n-1（或者说 d=-1）
        for (int i = 0; i < n; i++) {
            ans[idx++] = new int[]{i, (i + 1) % n};
            ans[idx++] = new int[]{(i + n - 1) % n, (i + n - 2) % n};
        }

        return ans;
    }
}
/*
3680. 生成赛程
https://leetcode.cn/problems/generate-schedule/description/

第 165 场双周赛 T3。

给你一个整数 n，表示 n 支队伍。你需要生成一个赛程，使得：
- 每支队伍与其他队伍 正好比赛两次：一次在主场，一次在客场。
- 每天 只有一场 比赛；赛程是一个 连续的 天数列表，schedule[i] 表示第 i 天的比赛。
- 没有队伍在 连续 两天内进行比赛。
返回一个 2D 整数数组 schedule，其中 schedule[i][0] 表示主队，schedule[i][1] 表示客队。如果有多个满足条件的赛程，返回 其中任意一个 。
如果没有满足条件的赛程，返回空数组。
提示：
2 <= n <= 50

幽默 T3。考察 构造题。
听说这就是 贝格尔编排法，在国内排球比赛中广泛使用。
时间复杂度 O(n^2)。
 */