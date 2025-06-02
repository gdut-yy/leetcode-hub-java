import java.util.ArrayList;
import java.util.List;

public class Solution3568 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private record Node(int x, int y, int e, int mask) {
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] idx = new int[m][n];
        int cntL = 0, sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            String row = classroom[i];
            for (int j = 0; j < n; j++) {
                char b = row.charAt(j);
                if (b == 'L') {
                    idx[i][j] = cntL++; // 给垃圾分配编号
                } else if (b == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }

        int full = (1 << cntL) - 1;
        boolean[][][][] vis = new boolean[m][n][energy + 1][full + 1];
        vis[sx][sy][energy][0] = true;

        List<Node> q = new ArrayList<>();
        q.add(new Node(sx, sy, energy, 0));
        for (int ans = 0; !q.isEmpty(); ans++) {
            List<Node> tmp = q;
            q = new ArrayList<>();
            for (Node p : tmp) {
                if (p.mask == full) { // 所有垃圾清理完毕
                    return ans;
                }
                if (p.e == 0) { // 走不动了
                    continue;
                }
                for (int[] d : DIRECTIONS) {
                    int x = p.x + d[0], y = p.y + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && classroom[x].charAt(y) != 'X') {
                        int newE = classroom[x].charAt(y) == 'R' ? energy : p.e - 1;
                        int newMask = classroom[x].charAt(y) == 'L' ? p.mask | (1 << idx[x][y]) : p.mask;
                        if (!vis[x][y][newE][newMask]) {
                            vis[x][y][newE][newMask] = true;
                            q.add(new Node(x, y, newE, newMask));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
/*
3568. 清理教室的最少移动
https://leetcode.cn/problems/minimum-moves-to-clean-the-classroom/description/

第 452 场周赛 T3。

给你一个 m x n 的网格图 classroom，其中一个学生志愿者负责清理散布在教室里的垃圾。网格图中的每个单元格是以下字符之一：
- 'S' ：学生的起始位置
- 'L' ：必须收集的垃圾（收集后，该单元格变为空白）
- 'R' ：重置区域，可以将学生的能量恢复到最大值，无论学生当前的能量是多少（可以多次使用）
- 'X' ：学生无法通过的障碍物
- '.' ：空白空间
同时给你一个整数 energy，表示学生的最大能量容量。学生从起始位置 'S' 开始，带着 energy 的能量出发。
每次移动到相邻的单元格（上、下、左或右）会消耗 1 单位能量。如果能量为 0，学生此时只有处在 'R' 格子时可以继续移动，此区域会将能量恢复到 最大 能量值 energy。
返回收集所有垃圾所需的 最少 移动次数，如果无法完成，返回 -1。
提示：
1 <= m == classroom.length <= 20
1 <= n == classroom[i].length <= 20
classroom[i][j] 是 'S'、'L'、'R'、'X' 或 '.' 之一
1 <= energy <= 50
网格图中恰好有 一个 'S'。
网格图中 最多 有 10 个 'L' 单元格。

BFS + 优化。
https://leetcode.cn/problems/minimum-moves-to-clean-the-classroom/solutions/3690747/bfs-by-endlesscheng-rpk6/
 */