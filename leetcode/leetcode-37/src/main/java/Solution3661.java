import java.util.Arrays;
import java.util.Comparator;

public class Solution3661 {
    private int[][] a;
    private int[] walls;
    private int[][] memo;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        this.walls = walls;
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = robots[i];
            a[i][1] = distance[i];
        }
        Arrays.sort(a, Comparator.comparingInt(p -> p[0]));
        Arrays.sort(walls);

        memo = new int[n][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(n - 1, 1);
    }

    private int dfs(int i, int j) {
        if (i < 0) return 0;
        // 之前计算过
        if (memo[i][j] != -1) return memo[i][j];

        // 往左射
        int leftX = a[i][0] - a[i][1];
        if (i > 0) {
            leftX = Math.max(leftX, a[i - 1][0] + 1); // 不能到达左边那个机器人
        }
        int left = lowerBound(walls, leftX);
        int cur = lowerBound(walls, a[i][0] + 1);
        int res = dfs(i - 1, 0) + cur - left; // [left, cur-1] 中的墙都能摧毁

        // 往右射
        int rightX = a[i][0] + a[i][1];
        if (i + 1 < a.length) {
            int x2 = a[i + 1][0];
            if (j == 0) { // 右边那个机器人往左射
                x2 -= a[i + 1][1];
            }
            rightX = Math.min(rightX, x2 - 1); // 不能到达右边那个机器人（或者他往左射到的墙）
        }
        int right = lowerBound(walls, rightX + 1);
        cur = lowerBound(walls, a[i][0]);
        res = Math.max(res, dfs(i - 1, 1) + right - cur); // [cur, right-1] 中的墙都能摧毁
        return memo[i][j] = res; // 记忆化
    }

    private int lowerBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
3661. 可以被机器人摧毁的最大墙壁数目
https://leetcode.cn/problems/maximum-walls-destroyed-by-robots/description/

第 464 场周赛 T4。

一条无限长的直线上分布着一些机器人和墙壁。给你整数数组 robots ，distance 和 walls：
- robots[i] 是第 i 个机器人的位置。
- distance[i] 是第 i 个机器人的子弹可以行进的 最大 距离。
- walls[j] 是第 j 堵墙的位置。
每个机器人有 一颗 子弹，可以向左或向右发射，最远距离为 distance[i] 米。
子弹会摧毁其射程内路径上的每一堵墙。机器人是固定的障碍物：如果子弹在到达墙壁前击中另一个机器人，它会 立即 在该机器人处停止，无法继续前进。
返回机器人可以摧毁墙壁的 最大 数量。
注意：
- 墙壁和机器人可能在同一位置；该位置的墙壁可以被该位置的机器人摧毁。
- 机器人不会被子弹摧毁。
提示:
1 <= robots.length == distance.length <= 10^5
1 <= walls.length <= 10^5
1 <= robots[i], walls[j] <= 10^9
1 <= distance[i] <= 10^5
robots 中的所有值都是 互不相同 的
walls 中的所有值都是 互不相同 的

记忆化搜索 + 二分。
时间复杂度 O(nlogn + mlogm + nlogm)，其中 n 是 robots 的长度，m 是 walls 的长度。
rating 2505 (clist.by)
 */