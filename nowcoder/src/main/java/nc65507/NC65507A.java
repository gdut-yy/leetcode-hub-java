package nc65507;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NC65507A {
    static int n;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        rotate();
        rotate();

        return Arrays.stream(a)
                .map(o -> Arrays.stream(o).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static void rotate() {
        // 上下翻转
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = tmp;
        }
        // 对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = tmp;
            }
        }
    }
}
/*
牛客周赛 Round 13
矩阵转置置
https://ac.nowcoder.com/acm/contest/65507/A

题目描述
小红拿到了一个  n 行 n 列的矩阵，她将矩阵水平方向和垂直方向各翻转一次，请你将翻转后的矩阵输出。
显然答案是唯一的，翻转顺序不影响最终结果。
输入描述:
第一行输入一个正整数 n ，代表矩阵的行数和列数。
接下来的 n 行，每行输入 n 个正整数，用来表示小红拿到的矩阵。
1≤n≤100
输出描述:
输出 n 行，每行输出 n 个正整数，用来表示翻转后的矩阵。

模拟
======

示例1
输入
2
1 2
3 4
输出
4 3
2 1

示例2
输入
3
3 5 1
2 2 4
3 2 6
输出
6 2 3
4 2 2
1 5 3
 */