package p1829;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1829G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static final int MAX_N = 1414;
    private static long[][] grid;
    private static long[][] pre;
    private static long[][] ans;
    private static Map<Integer, int[]> map;

    private static String solve(int n) {
        // (1+1414) * 1414 / 2 = 1,000,405 > 1e6
        if (grid == null) {
            grid = new long[MAX_N][MAX_N];
            pre = new long[MAX_N][MAX_N];
            ans = new long[MAX_N][MAX_N];
            map = new HashMap<>();
            int J = 1;
            int num = 1;
            for (int i = 0; i < MAX_N; i++) {
                for (int j = 0; j < J; j++) {
                    grid[i][j] = num;
                    map.put(num, new int[]{i, j});
                    num++;
                }
                J++;
            }

            // 列上 前缀平方和
            pre[0][0] = 1L;
            for (int j = 0; j < MAX_N; j++) {
                for (int i = 1; i < MAX_N; i++) {
                    pre[i][j] = pre[i - 1][j] + grid[i][j] * grid[i][j];
                }
            }

            for (int i = 0; i < MAX_N; i++) {
                ans[i][0] = pre[i][0];
            }
            for (int j = 1; j < MAX_N; j++) {
                for (int i = 1; i < MAX_N; i++) {
                    ans[i][j] = ans[i - 1][j - 1] + pre[i][j];
                }
            }
        }

        int[] tuple = map.get(n);
        int cx = tuple[0], cy = tuple[1];
        return String.valueOf(ans[cx][cy]);
    }
}
/*
G. Hits Different
https://codeforces.com/contest/1829/problem/G

题目大意：
在一个嘉年华游戏中，有一个巨大的金字塔，有 2023 排罐头，按照规则的模式编号，如图所示。
如果第 9^2 罐被击中，那么上图中所有红色的罐子都会掉下来。
你向金字塔扔一个球，它会击中一个编号为 n^2 的罐子。这导致所有堆积在这个罐子上面的罐子都掉下来(也就是说，n2 罐掉下来，然后 n2 上方的罐子掉下来，然后这些罐子正上方的罐子掉下来，以此类推)。例如，上面的图片显示了如果 92 号罐被击中，罐子会掉下来。
所有掉下来的罐子上的数字之和是多少?回想一下 n^2=n×n。

找规律。打表
======

input
10
9
1
2
3
4
5
6
10
1434
1000000
output
156
1
5
10
21
39
46
146
63145186
58116199242129511
 */

