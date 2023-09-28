package p1872;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1872D {
    static int n, x, y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            x = scanner.nextInt();
            y = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long lcm = (long) x / getGCD(x, y) * y;
        long cntL = n / lcm;
        long cntX = n / x - cntL;
        long cntY = n / y - cntL;

        long hi = (n + (n - cntX + 1)) * cntX / 2;
        long lo = (1 + cntY) * cntY / 2;
        return String.valueOf(hi - lo);
    }

    private static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
D. Plus Minus Permutation
https://codeforces.com/contest/1872/problem/D

题目大意：
已知 3 个整数，n x y。设一个排列的分数†p1，…，pn 为以下值:
换句话说，一个排列的分数是所有指标 i 能被 x 整除的和，减去所有指标 i 能被 y 整除的和。
你需要在所有长度为 n 的排列中找到最大可能得分。
例如，如果 n=7, x=2, y=3，则通过排列[2,6 -，1 -，7 -，5,4 -，3]获得的最大分数等于(6+7+4)−(1+4)=17−5=12。
†长度为 n 的排列是由 n 个不同的整数组成的数组，从 1 到 n 的任意顺序。例如，[2,3,1,5,4]是一个排列，但[1,2,2]不是一个排列(数字 2 在数组中出现了两次)，[1,3,4]也不是一个排列(n=3，但数组包含 4)。

贪心，数学，最小公倍数，
======

input
8
7 2 3
12 6 3
9 1 9
2 2 2
100 20 50
24 4 6
1000000000 5575 25450
4 4 1
output
12
-3
44
0
393
87
179179179436104
-6
 */
