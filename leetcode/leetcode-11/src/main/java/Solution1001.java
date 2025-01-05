import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1001 {
    private static final int[][] DIRECTIONS9 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}, {0, 0}};

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diagonal = new HashMap<>();
        Map<Integer, Integer> antiDiagonal = new HashMap<>();
        Set<Long> points = new HashSet<>();
        for (int[] lamp : lamps) {
            if (!points.add(hash(lamp[0], lamp[1]))) {
                continue;
            }
            row.merge(lamp[0], 1, Integer::sum);
            col.merge(lamp[1], 1, Integer::sum);
            diagonal.merge(lamp[0] - lamp[1], 1, Integer::sum);
            antiDiagonal.merge(lamp[0] + lamp[1], 1, Integer::sum);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (row.getOrDefault(x, 0) > 0) {
                ans[i] = 1;
            } else if (col.getOrDefault(y, 0) > 0) {
                ans[i] = 1;
            } else if (diagonal.getOrDefault(x - y, 0) > 0) {
                ans[i] = 1;
            } else if (antiDiagonal.getOrDefault(x + y, 0) > 0) {
                ans[i] = 1;
            }
            for (int[] d : DIRECTIONS9) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (points.remove(hash(nx, ny))) {
                    row.merge(nx, -1, Integer::sum);
                    col.merge(ny, -1, Integer::sum);
                    diagonal.merge(nx - ny, -1, Integer::sum);
                    antiDiagonal.merge(nx + ny, -1, Integer::sum);
                }
            }
        }
        return ans;
    }

    private long hash(int x, int y) {
        return (long) x + ((long) y << 32);
    }
}
/*
1001. 网格照明
https://leetcode.cn/problems/grid-illumination/description/

在大小为 n x n 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。
给你一个由灯的位置组成的二维数组 lamps ，其中 lamps[i] = [rowi, coli] 表示 打开 位于 grid[rowi][coli] 的灯。即便同一盏灯可能在 lamps 中多次列出，不会影响这盏灯处于 打开 状态。
当一盏灯处于打开状态，它将会照亮 自身所在单元格 以及同一 行 、同一 列 和两条 对角线 上的 所有其他单元格 。
另给你一个二维数组 queries ，其中 queries[j] = [rowj, colj] 。对于第 j 个查询，如果单元格 [rowj, colj] 是被照亮的，则查询结果为 1 ，否则为 0 。在第 j 次查询之后 [按照查询的顺序] ，关闭 位于单元格 grid[rowj][colj] 上及相邻 8 个方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。
返回一个整数数组 ans 作为答案， ans[j] 应等于第 j 次查询 queries[j] 的结果，1 表示照亮，0 表示未照亮。
提示：
1 <= n <= 10^9
0 <= lamps.length <= 20000
0 <= queries.length <= 20000
lamps[i].length == 2
0 <= rowi, coli < n
queries[j].length == 2
0 <= rowj, colj < n

哈希表。
时间复杂度 O(l + q)。其中 l 和 q 分别是 lamps 和 queries 的长度。
 */