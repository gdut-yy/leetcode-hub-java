import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionLCP45 {
    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        int M = terrain.length;
        int N = terrain[0].length;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> resList = new ArrayList<>();
        // position[0] position[1] speed
        queue.add(new int[]{position[0], position[1], 1});
        boolean[][][] visited = new boolean[M][N][105];
        visited[position[0]][position[1]][1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int[] dir : direction) {
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
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        return resArray;
    }
}
/*
LCP 45. 自行车炫技赛场
https://leetcode-cn.com/problems/kplEvH/

广度优先搜索。
注意简单地开一个二维 visited 数组
要用带状态 visited 数组（三维数组。经过不同轨迹到达到同一坐标位置的速度可能不一样，需要分开考虑）
 */