package p1759;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1759C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(solve(l, r, x, a, b));
        }
    }

    private static String solve(int l, int r, int x, int a, int b) {
        // 不用调
        if (a == b) {
            return "0";
        }

        // swap a < b
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        // case1: a->b
        if (b - a >= x) {
            return "1";
        }
        // case2: a->r->b or a->l->b
        if (a - l >= x || r - b >= x) {
            return "2";
        }
        // case3: a->r->l->b
        if (r - a >= x && r - l >= x && b - l >= x) {
            return "3";
        }
        return "-1";
    }
}
/*
C. Thermostat
https://codeforces.com/contest/1759/problem/C

题目大意：
给定整数 l,r,x,a,b。温度变化范围 [l,r] 和最小温度变化 x，初始温度 a 和最终温度 b。求从温度 a 得到温度 b 所需的最小操作数，如果不可能输出 -1。

分类讨论，可以证明最多只有 3 种可行解：
case1: a->b
case2: a->r->b or a->l->b
case3: a->r->l->b
======

input
10
3 5 6
3 3
0 15 5
4 5
0 10 5
3 7
3 5 6
3 4
-10 10 11
-5 6
-3 3 4
1 0
-5 10 8
9 2
1 5 1
2 5
-1 4 3
0 2
-6 3 6
-1 -4

output
0
2
3
-1
1
-1
3
1
3
-1
 */