package lq240113;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class LQ240113T6 {
    static int n, m, t;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        t = scanner.nextInt();
        xy = new int[t][2];
        for (int i = 0; i < t; i++) {
            xy[i][0] = scanner.nextInt() - 1;
            xy[i][1] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    private static String solve() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];
        for (int[] p : xy) {
            queue.add(p);
            vis[p[0]][p[1]] = true;
        }
        int ans = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();
                for (int[] dir : DIRECTIONS8) {
                    int nx = p[0] + dir[0];
                    int ny = p[1] + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }
        return String.valueOf(ans);
    }
}
/*
暖气冰场【算法赛】

BFS。
 */