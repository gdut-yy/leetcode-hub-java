import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionLCP79 {
    public static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int extractMantra(String[] matrix, String mantra) {
        int m = matrix.length;
        int n = matrix[0].length();
        int l = mantra.length();

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        boolean[][][] visited = new boolean[m][n][l];
        visited[0][0][0] = true;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1], cl = tuple[2];
                // 可以提取
                if (matrix[cx].charAt(cy) == mantra.charAt(cl)) {
                    if (cl == l - 1) {
                        return step;
                    }
                    if (!visited[cx][cy][cl + 1]) {
                        visited[cx][cy][cl + 1] = true;
                        queue.add(new int[]{cx, cy, cl + 1});
                    }
                }

                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0], ny = cy + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (!visited[nx][ny][cl]) {
                            visited[nx][ny][cl] = true;
                            queue.add(new int[]{nx, ny, cl});
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
/*
LCP 79. 提取咒文
https://leetcode.cn/problems/kjpLFZ/

LCCUP'23 春季战队赛 T3。

随着兽群逐渐远去，一座大升降机缓缓的从地下升到了远征队面前。借由这台升降机，他们将能够到达地底的永恒至森。
在升降机的操作台上，是一个由魔法符号组成的矩阵，为了便于辨识，我们用小写字母来表示。 matrix[i][j] 表示矩阵第 i 行 j 列的字母。该矩阵上有一个提取装置，可以对所在位置的字母提取。
提取装置初始位于矩阵的左上角 [0,0]，可以通过每次操作移动到上、下、左、右相邻的 1 格位置中。提取装置每次移动或每次提取均记为一次操作。
远征队需要按照顺序，从矩阵中逐一取出字母以组成 mantra，才能够成功的启动升降机。请返回他们 最少 需要消耗的操作次数。如果无法完成提取，返回 -1。
注意：
- 提取装置可对同一位置的字母重复提取，每次提取一个
- 提取字母时，需按词语顺序依次提取
提示：
0 < matrix.length, matrix[i].length <= 100
0 < mantra.length <= 100
matrix 和 mantra 仅由小写字母组成

BFS。
比赛时候想歪了，写成多个路径，途径多个中间点。最终 TLE。。
时间复杂度 O(mnl)
 */