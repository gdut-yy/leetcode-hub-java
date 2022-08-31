import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionLCP45 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        int M = terrain.length;
        int N = terrain[0].length;

        Queue<int[]> queue = new LinkedList<>();
        List<int[]> resList = new ArrayList<>();
        // position[0] position[1] speed
        queue.add(new int[]{position[0], position[1], 1});
        boolean[][][] visited = new boolean[M][N][105];
        visited[position[0]][position[1]][1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();

            for (int[] dir : DIRECTIONS) {
                int nextM = cur[0] + dir[0];
                int nextN = cur[1] + dir[1];
                int curSpeed = cur[2];
                if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N) {
                    int nextSpeed = curSpeed + terrain[cur[0]][cur[1]] - terrain[nextM][nextN] - obstacle[nextM][nextN];
                    // 骑行过程中速度不能为零或负值
                    if (nextSpeed > 0 && !visited[nextM][nextN][nextSpeed]) {
                        visited[nextM][nextN][nextSpeed] = true;
                        if (nextSpeed == 1) {
                            resList.add(new int[]{nextM, nextN});
                        }
                        queue.add(new int[]{nextM, nextN, nextSpeed});
                    }
                }
            }
        }

        // List<int[]> => int[][]
        int resLen = resList.size();
        int[][] resArray = new int[resLen][];
        for (int i = 0; i < resLen; i++) {
            resArray[i] = resList.get(i);
        }
        Arrays.sort(resArray, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        return resArray;
    }
}
/*
LCP 45. 自行车炫技赛场
https://leetcode.cn/problems/kplEvH/

LCCUP 力扣杯 2021 秋季编程大赛战队赛 T2。

「力扣挑战赛」中 N*M 大小的自行车炫技赛场的场地由一片连绵起伏的上下坡组成，场地的高度值记录于二维数组 terrain 中，场地的减速值记录于二维数组 obstacle 中。
若选手骑着自行车从高度为 h1 且减速值为 o1 的位置到高度为 h2 且减速值为 o2 的相邻位置（上下左右四个方向），速度变化值为 h1-h2-o2（负值减速，正值增速）。
选手初始位于坐标 position 处且初始速度为 1，请问选手可以刚好到其他哪些位置时速度依旧为 1。请以二维数组形式返回这些位置。
若有多个位置则按行坐标升序排列，若有多个位置行坐标相同则按列坐标升序排列。
- 注意： 骑行过程中速度不能为零或负值
提示：
n == terrain.length == obstacle.length
m == terrain[i].length == obstacle[i].length
1 <= n <= 100
1 <= m <= 100
0 <= terrain[i][j], obstacle[i][j] <= 100
position.length == 2
0 <= position[0] < n
0 <= position[1] < m

广度优先搜索。
注意简单地开一个二维 visited 数组
要用带状态 visited 数组（三维数组。经过不同轨迹到达到同一坐标位置的速度可能不一样，需要分开考虑）
 */