import java.util.LinkedList;
import java.util.Queue;

public class Tianchi221022T2 {
    // 0:up 1:left 2:down 3:right
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    public int getLength(String[] grid) {
        int M = grid.length;
        int N = grid[0].length();

        char[][] chars = new char[M][N];
        for (int i = 0; i < M; i++) {
            chars[i] = grid[i].toCharArray();
        }

        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 2});
        while (!queue.isEmpty()) {
            int[] tuple = queue.remove();
            int curM = tuple[0];
            int curN = tuple[1];
            int dir = tuple[2];
            cnt++;

            if (chars[curM][curN] == 'L') {
                if (dir == 0) {
                    dir = 3;
                } else if (dir == 1) {
                    dir = 2;
                } else if (dir == 2) {
                    dir = 1;
                } else {
                    dir = 0;
                }
            } else if (chars[curM][curN] == 'R') {
                if (dir == 0) {
                    dir = 1;
                } else if (dir == 1) {
                    dir = 0;
                } else if (dir == 2) {
                    dir = 3;
                } else {
                    dir = 2;
                }
            }
            int nextM = curM + DX[dir];
            int nextN = curN + DY[dir];
            if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N) {
                queue.add(new int[]{nextM, nextN, dir});
            }
        }
        return cnt;
    }
}
/*
221021天池-02. 光线反射
https://leetcode.cn/contest/tianchi2022/problems/8KXuKl/

工程师正在研究一个 N*M 大小的光线反射装置，装置内部的构造记录于 grid 中，其中
- '.' 表示空白区域，不改变光的传播方向
- 'R' 表示向右倾斜的 双面 均可反射光线的镜子，改变光的传播方向
- 'L' 表示向左倾斜的 双面 均可反射光线的镜子，改变光的传播方向
假如光线从装置的左上方垂直向下进入装置，请问在离开装置前，光线在装置内部经过多长的路线。
示例 1：
输入：grid = ["...","L.L","RR.","L.R"]
输出：12
解释：如图所示，光线经过路线长度为 12
示例 2：
输入：grid = ["R.",".."]
输出：1
解释：如图所示，光线经过路线长度为 1
提示：
1 <= grid.length, grid[i].length <= 100
grid[i][j] 仅为 'L'、'R' 和 '.'

模拟。感觉跟秋季赛个人赛 T3 有点渊源。
相似题目: LCP 63. 弹珠游戏
https://leetcode.cn/problems/EXvqDp/
 */