package nc65051;

import java.util.Scanner;

public class NC65051D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve1());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long left = i + 1, right = n - j;
                int xor = a[i] ^ a[j];
                ans += left * right % MOD * xor % MOD;
                ans %= MOD;
            }
        }
        return String.valueOf(ans);
    }

    private static String solve1() {
        long ans = 0;
        for (int j = 0; j < 30; j++) {
            long c = 0, d = 0;
            for (int i = 0; i < n; i++) {
                if ((a[i] >> j & 1) == 1) {
                    ans += d * (1L << j) % MOD * (n - i);
                    ans %= MOD;
                    c += i + 1;
                } else {
                    ans += c * (1L << j) % MOD * (n - i);
                    ans %= MOD;
                    d += i + 1;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
小美的区间异或和
https://ac.nowcoder.com/acm/contest/65051/D

题目描述
小美定义一个数组的权值为：数组中任选两个数的异或之和。例如，数组[2,1,3]的权值为：(2 xor 1)+(2 xor 3)+(1 xor 3)=3+1+2=6。
小美拿到了一个数组，她想知道该数组的所有连续子数组的权值和是多少？答案对 10^9 +7 取模。
输入描述:
第一行输入一个正整数 n，代表数组的大小。
第二行输入 n 个正整数 ai，代表小美拿到的数组。
1≤n≤10^5
1≤ai≤10^9
输出描述:
所有子数组的权值之和，对 10^9 +7 取模的值。

2 3 1 2
---
2^3
3^1
1^2
---
2^3
2^1
3^1
---
3^1
3^2
1^2
---
2^3 (3)
2^1 (2)
2^2 (1)
3^1 (4)
3^2 (2)
1^2 (3)
看不出任何规律，，
---
拆位
======

示例1
输入
4
2 3 1 2
输出
28
说明
长度为1的子数组无法取两个数，权值为0。
子数组[2,3]的权值为1。
子数组[3,1]的权值为2。
子数组[1,2]的权值为3。
子数组[2,3,1]的权值为6。
子数组[3,1,2]的权值为6。
子数组[2,3,1,2]的权值为10。
权值之和为1+2+3+6+6+10=28。
 */