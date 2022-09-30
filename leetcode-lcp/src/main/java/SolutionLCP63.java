import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionLCP63 {
    // up left down right
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[][] ballGame(int num, String[] plate) {
        int M = plate.length;
        int N = plate[0].length();
        char[][] chars = new char[M][N];
        for (int i = 0; i < M; i++) {
            chars[i] = plate[i].toCharArray();
        }

        // [startM, startN, curM, curN, dir]
        Queue<int[]> queue = new LinkedList<>();
        for (int j = 1; j < N - 1; j++) {
            // 上边界往下走
            if (chars[0][j] == '.') {
                queue.add(new int[]{0, j, 0, j, 2});
            }
            // 下边界往上走
            if (chars[M - 1][j] == '.') {
                queue.add(new int[]{M - 1, j, M - 1, j, 0});
            }
        }
        for (int i = 1; i < M - 1; i++) {
            // 左边界往右走
            if (chars[i][0] == '.') {
                queue.add(new int[]{i, 0, i, 0, 1});
            }
            // 右边界往左走
            if (chars[i][N - 1] == '.') {
                queue.add(new int[]{i, N - 1, i, N - 1, 3});
            }
        }

        List<int[]> resList = new ArrayList<>();
        while (!queue.isEmpty() && num >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int startM = tuple[0];
                int startN = tuple[1];
                int curM = tuple[2];
                int curN = tuple[3];
                int dir = tuple[4];

                if (chars[curM][curN] == 'O') {
                    resList.add(new int[]{startM, startN});
                    continue;
                } else if (chars[curM][curN] == 'E') {
                    // "E" 表示顺时针转向器（弹珠经过时方向将顺时针旋转 90 度）；
                    dir = (dir + 1) % 4;
                } else if (chars[curM][curN] == 'W') {
                    // "W" 表示逆时针转向器（弹珠经过时方向将逆时针旋转 90 度）；
                    dir = (dir + 3) % 4;
                }
                int nextM = curM + dx[dir];
                int nextN = curN + dy[dir];
                if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N) {
                    queue.add(new int[]{startM, startN, nextM, nextN, dir});
                }
            }
            num--;
        }

        return resList.toArray(new int[resList.size()][]);
    }
}
/*
LCP 63. 弹珠游戏
https://leetcode.cn/problems/EXvqDp/

LCCUP 力扣杯 2022 秋季编程大赛个人赛 T3。

欢迎各位来到「力扣嘉年华」，接下来将为各位介绍在活动中广受好评的弹珠游戏。
N*M 大小的弹珠盘的初始状态信息记录于一维字符串型数组 plate 中，数组中的每个元素为仅由 "O"、"W"、"E"、"." 组成的字符串。其中：
- "O" 表示弹珠洞（弹珠到达后会落入洞中，并停止前进）；
- "W" 表示逆时针转向器（弹珠经过时方向将逆时针旋转 90 度）；
- "E" 表示顺时针转向器（弹珠经过时方向将顺时针旋转 90 度）；
- "." 表示空白区域（弹珠可通行）。
游戏规则要求仅能在边缘位置的 空白区域 处（弹珠盘的四角除外）沿 与边缘垂直 的方向打入弹珠，并且打入后的每颗弹珠最多能 前进 num 步。
请返回符合上述要求且可以使弹珠最终入洞的所有打入位置。你可以 按任意顺序 返回答案。
注意：
若弹珠已到达弹珠盘边缘并且仍沿着出界方向继续前进，则将直接出界。
提示：
1 <= num <= 10^6
1 <= plate.length, plate[i].length <= 1000
plate[i][j] 仅包含 "O"、"W"、"E"、"."

本题疑似存在卡常，需从 '.' 到 'O'，逆向的话会 TLE。
 */
