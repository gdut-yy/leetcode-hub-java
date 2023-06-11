package p1832;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1832C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        int[] d = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            d[i] = a[i + 1] - a[i];
        }
        int cnt = 1;
        int pre = 0;
        for (int x : d) {
            if (x < 0) {
                if (pre != -1) cnt++;
                pre = -1;
            } else if (x > 0) {
                if (pre != 1) cnt++;
                pre = 1;
            }
        }
        return String.valueOf(cnt);
    }
}
/*
C. Contrast Value
https://codeforces.com/contest/1832/problem/C

题目大意：
对于整数数组[a1,a2,...,an]，我们将值|a1−a2|+|a2−a3|+...+|a[n−1]−an|称为数组的对比度。注意，大小为 1 的数组的对比度等于 0。
给你一个整数数组 a。你的任务是建立一个 b 的数组，使其满足以下所有条件:
B 不为空，即至少有一个元素;
B 是 a 的子序列，即 B 可以通过从 a 中删除一些元素(可能为零)来生成;
b 的对比等于 a 的对比。
数组 b 的最小可能大小是多少?

计算邻项差值，去掉 0，差值按正负分组，答案为 组数+1
======

input
4
5
1 3 3 3 7
2
4 2
4
1 1 1 1
7
5 4 2 1 0 0 4
output
2
2
1
3
 */
