package p1881;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1881B {
    static int[] abc;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            abc = new int[3];
            abc[0] = scanner.nextInt();
            abc[1] = scanner.nextInt();
            abc[2] = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(abc);
        int cnt = 0;
        for (int i = 1; i < 3; i++) {
            if (abc[i] % abc[0] == 0) {
                cnt += abc[i] / abc[0] - 1;
            } else {
                return "NO";
            }
        }
        return cnt <= 3 ? "YES" : "NO";
    }
}
/*
B. Three Threadlets
https://codeforces.com/contest/1881/problem/B

题目大意：
从前，酒保德西姆找到了三条线和一把剪刀。
在一个操作中，Decim 选择任意线程并将其切割成两个线程，两个线程的长度为正整数，并且它们的和等于被切割线程的长度。
例如，他可以把长度为 5 的针线切成长度为 2 和 3 的针线，但他不能把它切成长度为 2.5 和 2.5，或长度为 0 和 5，或长度为 3 和 4 的针线。
Decim 最多可以执行三种操作。他可以把以前剪过的线剪掉。他能把所有的线都织得一样长吗?

倍数统计。
======

input
15
1 3 2
5 5 5
6 36 12
7 8 7
6 3 3
4 4 12
12 6 8
1000000000 1000000000 1000000000
3 7 1
9 9 1
9 3 6
2 8 2
5 3 10
8 4 8
2 8 4
output
YES
YES
NO
NO
YES
YES
NO
YES
NO
NO
YES
YES
NO
YES
NO
 */
