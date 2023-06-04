package c279;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc279_d {
    static long a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        a = scanner.nextLong();
        b = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        long l = 0, r = a / b;
        while (r - l > 2) {
            long m1 = (l * 2 + r) / 3;
            long m2 = (l + r * 2) / 3;
            if (f(m1) > f(m2)) {
                l = m1;
            } else {
                r = m2;
            }
        }
        double res = a;
        for (long i = l; i <= r; i++) {
            res = Math.min(res, f(i));
        }
        return String.format("%.10f%n", res);
    }

    private static double f(long n) {
        return (double) b * n + (double) a / Math.sqrt(n + 1);
    }
}
/*
D - Freefall
https://atcoder.jp/contests/abc279/tasks/abc279_d

题目大意：
超人高桥正准备从屋顶上跳下来帮助地面上的一个有麻烦的人。高桥的行星有一个常数
g 表示重力强度，他开始下落后到达地面所需的时间为 A/sqrt(g)
现在是时间 0,g=1。Takahashi 将执行以下操作，他想执行多少次就执行多少次(可能为零)。
- 使用超能力将 g 的值增加 1。这需要花费 B 的时间。
然后，他会跳楼。在开始下降后，他不能改变 g 的值。另外，我们只考虑执行操作和下降所需的时间。
找到高桥能到达地面的最早时间。

凹函数，三分法取最小值。
https://atcoder.jp/contests/abc279/submissions/37250161
mumuxinfei: java的精度 没法过, 就这样，太sb了
======

Input 1
10 1
Output 1
7.7735026919

Input 2
5 10
Output 2
5.0000000000

Input 3
1000000000000000000 100
Output 3
8772053214538.5976562500
 */