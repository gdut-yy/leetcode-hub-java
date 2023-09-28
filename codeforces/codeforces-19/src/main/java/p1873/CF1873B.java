package p1873;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1873B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(a);
        a[0]++;
        long ans = 1;
        for (int v : a) {
            ans *= v;
        }
        return String.valueOf(ans);
    }
}
/*
B. Good Kid
https://codeforces.com/contest/1873/problem/B

题目大意：
斯拉夫正在为朋友准备生日礼物。他有一个 n 位数字的数组，present 就是所有这些数字的乘积。因为斯拉维奇是一个想要做出最大产品的好孩子，他想把 1 加到他的一个数字上。
斯拉夫能生产的最大数量是多少?

加到最小的数字上
======

input
4
4
2 2 1 2
3
0 1 2
5
4 3 2 3 4
9
9 9 9 9 9 9 9 9 9
output
16
2
432
430467210
 */
