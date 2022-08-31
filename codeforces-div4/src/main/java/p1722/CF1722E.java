package p1722;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1722E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[][] hw = new int[n][2];
            for (int j = 0; j < n; j++) {
                hw[j][0] = scanner.nextInt();
                hw[j][1] = scanner.nextInt();
            }
            int[][] queries = new int[q][4];
            for (int j = 0; j < q; j++) {
                queries[j][0] = scanner.nextInt();
                queries[j][1] = scanner.nextInt();
                queries[j][2] = scanner.nextInt();
                queries[j][3] = scanner.nextInt();
            }

            List<String> res = solve(n, q, hw, queries);
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static final int MAX_LEN = 1005;

    // logn
    private static List<String> solve(int n, int q, int[][] hw, int[][] queries) {
        long[][] matrix = new long[MAX_LEN][MAX_LEN];
        for (int[] tuple : hw) {
            matrix[tuple[0]][tuple[1]] += (long) tuple[0] * tuple[1];
        }

        // 预处理前缀和
        long[][] preSum2d = new long[MAX_LEN][MAX_LEN];
        for (int i = 1; i < MAX_LEN; i++) {
            for (int j = 1; j < MAX_LEN; j++) {
                // 当前格 = 上 + 左 - 左上 + 原值
                preSum2d[i][j] = preSum2d[i - 1][j] + preSum2d[i][j - 1] - preSum2d[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        List<String> resList = new ArrayList<>();
        for (int[] query : queries) {
            int row1 = query[0] + 1;
            int col1 = query[1] + 1;
            int row2 = query[2] - 1;
            int col2 = query[3] - 1;

            long res = preSum2d[row2 + 1][col2 + 1] - preSum2d[row2 + 1][col1] - preSum2d[row1][col2 + 1] + preSum2d[row1][col1];
            resList.add(String.valueOf(res));
        }
        return resList;
    }
}
/*
E. Counting Rectangles
https://codeforces.com/contest/1722/problem/E

题目大意：
给定整数 n, q：n 行 hi, wi 分别代表矩形高和宽；q 行 hs, ws, hb, wb 分别代表小矩形 hs, ws 大矩形 hb, wb。求大于能装下小矩形和被大矩形装下矩形的面积和。

二维前缀和。
时间复杂度 O(mn) 构建，O(1) 查询。
======

input
3
2 1
2 3
3 2
1 1 3 4
5 5
1 1
2 2
3 3
4 4
5 5
3 3 6 6
2 1 4 5
1 1 2 10
1 1 100 100
1 1 3 3
3 1
999 999
999 999
999 998
1 1 1000 1000

output
6
41
9
0
54
4
2993004
 */