package c313;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc313_a {
    static int n;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (p[i] >= p[0]) {
                ans = Math.max(ans, p[i] - p[0] + 1);
            }
        }
        return String.valueOf(ans);
    }
}
/*
A - To Be Saikyo
https://atcoder.jp/contests/abc313/tasks/abc313_a

题目大意：
一共有 N 个人，编号从 1 到 N，每个人都有一个称为编程能力的整数分数;人 i 的编程能力是 P i 分。人 1 还需要多少分，才会成为最强的人?换句话说，对于所有 i / r =1，使 p1 +x> p1 的最小非负整数 x 是多少?

======

Input 1
4
5 15 2 10
Output 1
11

Input 2
4
15 5 2 10
Output 2
0

Input 3
3
100 100 100
Output 3
1
 */