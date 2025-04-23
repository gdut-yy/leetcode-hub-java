package c100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Abc100_d {
    static int n, m;
    static tuple[] a;

    record tuple(long x, long y, long z) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new tuple[n];
        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            long z = scanner.nextLong();
            a[i] = new tuple(x, y, z);
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        for (int i = -1; i < 2; i += 2) {
            for (int j = -1; j < 2; j += 2) {
                for (int k = -1; k < 2; k += 2) {
                    // java 真是麻瓜
                    int finalI = i;
                    int finalJ = j;
                    int finalK = k;
                    Arrays.sort(a, Comparator.comparingLong(o -> -o.x * finalI + o.y * finalJ + o.z * finalK));

                    long s1 = 0, s2 = 0, s3 = 0;
                    for (int l = 0; l < m; l++) {
                        tuple p = a[l];
                        s1 += p.x;
                        s2 += p.y;
                        s3 += p.z;
                    }
                    ans = Math.max(ans, Math.abs(s1) + Math.abs(s2) + Math.abs(s3));
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
D - Patisserie ABC
https://atcoder.jp/contests/abc100/tasks/abc100_d

灵茶の试炼 2025-02-19
题目大意：
输入 n(1≤n≤1000) m(0≤m≤n) 和一个 n 行 3 列的矩阵 a。
从 n 行中选择 m 行，输出 abs(第一列元素和) + abs(第二列元素和) + abs(第三列元素和) 的最大值。

假设第一列元素和 >= 0，第二列元素和 < 0，第三列元素和 >= 0。
去掉绝对值，要计算的式子就是：
  第一列元素和 - 第二列元素和 + 第三列元素和
= sum(a[i][0] - a[i][1] + a[i][2])
要让答案尽量大，按照 a[i][0] - a[i][1] + a[i][2] 从大到小排序，计算前 m 项的 abs(第一列元素和) + abs(第二列元素和) + abs(第三列元素和)。
一般地，枚举 2^3=8 种元素和的正负号组合，这样可以把绝对值拆开，方便我们做式子变形 + 排序。
代码 https://atcoder.jp/contests/abc100/submissions/62217818
======

Input 1
5 3
3 1 4
1 5 9
2 6 5
3 5 8
9 7 9
Output 1
56

Input 2
5 3
1 -2 3
-4 5 -6
7 -8 -9
-10 11 -12
13 -14 15
Output 2
54

Input 3
10 5
10 -80 21
23 8 38
-94 28 11
-26 -2 18
-69 72 79
-26 -86 -54
-72 -50 59
21 65 -32
40 -94 87
-62 18 82
Output 3
638

Input 4
3 2
2000000000 -9000000000 4000000000
7000000000 -5000000000 3000000000
6000000000 -1000000000 8000000000
Output 4
30000000000
 */
