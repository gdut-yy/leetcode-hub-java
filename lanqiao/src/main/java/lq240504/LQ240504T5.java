package lq240504;

import java.util.Scanner;

public class LQ240504T5 {
    static int n, m;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[][] up_left = new int[n + 1][m + 1];
        int[][] up_right = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '*') {
                    up_left[i][j] = 1;
                    up_right[i][j] = 1;
                    if (i - 1 >= 0) {
                        if (j - 1 >= 0) up_left[i][j] += up_left[i - 1][j - 1];
                        if (j + 1 < m) up_right[i][j] += up_right[i - 1][j + 1];
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, Math.min(up_left[i][j], up_right[i][j]));
            }
        }
        return String.valueOf(ans - 1);
    }
}
/*
Yaya 与字符画【算法赛】

我们对于整个字符矩形，维护左上 45 度、右上 45 度各自连续的 ‘*’ 数量即可。这可以 O(nm) 预处理。
在此之后，我们可以枚举 V 字形的顶点，然后检查一下它能否向上形成 V 字形，更新答案即可。
需要小心的是，由于 v 字形两侧的端点向上延伸一格之后可能一边是星号、一边是点号，因此要对两边的长度取最小值。
总时间复杂度 O(nm)。
---
斜向前缀和。
相似题目: 1878. 矩阵中最大的三个菱形和
https://leetcode.cn/problems/get-biggest-three-rhombus-sums-in-a-grid/description/
 */