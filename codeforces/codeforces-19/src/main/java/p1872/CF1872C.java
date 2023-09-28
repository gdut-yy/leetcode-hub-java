package p1872;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1872C {
    static int l, r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            l = scanner.nextInt();
            r = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static final int MAX_N = (int) 1e7;
    private static int[] lpf;

    private static String solve() {
        if (lpf == null) {
            // 埃氏筛 预处理 最小质因子
            lpf = new int[MAX_N + 1];
            for (int i = 2; i <= MAX_N; i++) {
                if (lpf[i] == 0) {
                    for (int j = i; j <= MAX_N; j += i) {
                        if (lpf[j] == 0) {
                            lpf[j] = i;
                        }
                    }
                }
            }
        }

        for (int i = l; i <= r; i++) {
            if (lpf[i] != 0 && i - lpf[i] > 0) {
                return lpf[i] + " " + (i - lpf[i]);
            }
        }
        return "-1";
    }
}
/*
C. Non-coprime Split
https://codeforces.com/contest/1872/problem/C

题目大意：
给定两个整数 l≤r。要求正整数 a 和 b 同时满足以下条件:
l≤a+b≤r
gcd(a,b)≠1
或者报告说它们不存在。
gcd(a,b) 表示数字 a 和 b 的最大公约数。例如, gcd(6,9)=3 , gcd(8,9)=1 , gcd(4,2)=2 .

分解出最小质因子
3137*3137
======

input
11
11 15
1 3
18 19
41 43
777 777
8000000 10000000
2000 2023
1791791 1791791
1 4
2 3
9840769 9840769
output
6 9
-1
14 4
36 6
111 666
4000000 5000000
2009 7
-1
2 2
-1
6274 9834495
 */
