package p1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;

public class MainE {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String[] line0s = reader.readLine().split(" ");
        int H = Integer.parseInt(line0s[0]);
        int W = Integer.parseInt(line0s[1]);
        char[][] chars = new char[H][W];
        for (int i = 0; i < H; i++) {
            chars[i] = reader.readLine().toCharArray();
        }
        System.out.println(solve(H, W, chars));
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static String solve(int H, int W, char[][] chars) {
        int sx = -1;
        int sy = -1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (chars[i][j] == 'S') {
                    sx = i;
                    sy = j;
                    break;
                }
            }
            if (sx != -1) {
                break;
            }
        }

        for (int[] dir : DIRECTIONS) {
            int nextM = sx + dir[0];
            int nextN = sy + dir[1];
            if (nextM >= 0 && nextM < H && nextN >= 0 && nextN < W && chars[nextM][nextN] == '.') {
                if (check(H, W, chars, nextM, nextN, sx, sy)) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    private static boolean check(int H, int W, char[][] chars, int sx, int sy, int tx, int ty) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        boolean[][] visited = new boolean[H][W];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curM = cur[0];
                int curN = cur[1];
                if (curM == tx && curN == ty) {
                    return true;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextM = curM + dir[0];
                    int nextN = curN + dir[1];
                    if (nextM >= 0 && nextM < H && nextN >= 0 && nextN < W
                            && chars[nextM][nextN] != '#' && !visited[nextM][nextN]
                            // 不能原路返回
                            && !(curM == sx && curN == sy && nextM == tx && nextN == ty)
                    ) {
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
        return false;
    }
}
/*
2 2
S.
..

 */