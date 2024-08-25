package p1179;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1179B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(solve(n, m));
    }

    private static String solve(int n, int m) {
        List<String> resList = new ArrayList<>();
        int x1 = 1, y1 = 1, x2 = n, y2 = m;
        boolean flag = true;
        for (int i = 0; i < n * m; i++) {
            resList.add(x1 + " " + y1);
            if (flag) {
                if (y1 < m) {
                    y1++;
                } else {
                    x1++;
                }
            } else {
                if (y1 > 1) {
                    y1--;
                } else {
                    x1++;
                }
            }
            i++;
            if (i == n * m) {
                break;
            }

            resList.add(x2 + " " + y2);
            if (!flag) {
                if (y2 < m) {
                    y2++;
                } else {
                    x2--;
                    flag = true;
                }
            } else {
                if (y2 > 1) {
                    y2--;
                } else {
                    x2--;
                    flag = false;
                }
            }
        }
        return String.join(System.lineSeparator(), resList);
    }
}
/*
B. Tolik and His Uncle
https://codeforces.com/contest/1179/problem/B

灵茶の试炼 2023-02-23
题目大意：
输入 n m (n*m≤1e6)，表示一个 n 行 m 列的棋盘，行列编号从 1 开始。
初始时，你在 (1,1)。每一步，你可以使用一个方向向量 (dx,dy)，然后从当前位置 (x,y) 移动到 (x+dx,y+dy)。
你需要访问每个格子恰好一次，且每一步使用的方向向量互不相同。
如果存在这样的移动方案，输出任意一组符合要求的 n*m 个坐标，表示你每一步所在的位置。否则输出 -1。

rating 1800
constructive algorithms
https://codeforces.com/contest/1179/submission/108111481
提示 1：方案一定存在。
提示 2：从左上角跳到右下角，这个方向向量以后绝不会再用到了。
提示 3：然后再从右下角跳到 (1,2)，这个方向向量以后也绝不会再用到了。
======

input
2 3
output
1 1
1 3
1 2
2 2
2 3
2 1

input
1 1
output
1 1
 */
