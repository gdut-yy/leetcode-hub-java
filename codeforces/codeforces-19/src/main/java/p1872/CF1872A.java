package p1872;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1872A {
    static int a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        double d = Math.abs(a - b) / 2.0;
        int ans = (int) Math.ceil(d / c);
        return String.valueOf(ans);
    }
}
/*
Codeforces Round 895 (Div. 3)
A. Two Vessels
https://codeforces.com/contest/1872/problem/A

题目大意：
你有两个盛水的容器。第一个容器装了 a 克水，第二个容器装了 b 克水。两个容器都非常大，可以容纳任何数量的水。
你还有一个空杯子，可以装 c 克水。
在一个动作中，你可以从任何容器中舀出多达 c 克的水，然后倒入另一个容器中。注意，在一次移动中倒入的水的质量不一定是整数。
要使容器里的水的质量相等，最少要走多少步?请注意，除了所描述的移动之外，您不能执行任何操作。

数学
======

input
6
3 7 2
17 4 3
17 17 1
17 21 100
1 100 1
97 4 3
output
1
3
0
1
50
16
 */
