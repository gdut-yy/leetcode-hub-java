package keyence2020;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Keyence2020_d {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static int ans;
    static int[] c, d;

    private static String solve() {
        ans = 999;
        c = new int[n];
        d = new int[n];

        f(0, false);
        if (ans == 999) {
            ans = -1;
        }
        return String.valueOf(ans);
    }

    static void f(int i, boolean odd) {
        if (i == n) {
            if (odd) {
                return;
            }
            int[] cc = c.clone();
            Arrays.sort(cc);
            int[] dd = d.clone();
            int res = 0;

            label:
            for (int ii = 0; ii < cc.length; ii++) {
                int v = cc[ii];
                for (int j = ii; j < n; j++) {
                    int w = dd[j];
                    if (v != w && v != -w || (w < 0) != (((ii - j) & 1) > 0)) {
                        continue;
                    }
                    res += j - ii;
                    for (int k = j - 1; k >= ii; k--) {
                        dd[k] = -dd[k];
                        // dd[k], dd[k+1] = dd[k+1], dd[k]
                        int tmp = dd[k];
                        dd[k] = dd[k + 1];
                        dd[k + 1] = tmp;
                    }
                    continue label;
                }
                return;
            }
            ans = Math.min(ans, res);
            return;
        }
        c[i] = a[i];
        d[i] = a[i];
        f(i + 1, odd);
        c[i] = b[i];
        d[i] = -b[i];
        f(i + 1, !odd);
    }
}
/*
D - Swap and Flip
https://atcoder.jp/contests/keyence2020/tasks/keyence2020_d

灵茶の试炼 2022-12-15
题目大意：
输入 n(≤18) 和两个长为 n 的数组 a b，元素范围在 [1,50]。
a[i] 和 b[i] 表示第 i 张牌的正面数字和背面数字。
初始所有牌正面朝上。
每次操作你可以交换第 i 和 i+1 张牌的位置，同时翻转这两张牌。
输出让看到的数字从左往右是递增（允许相等）所需要的最小操作次数。
如果无法做到，输出 -1。

https://atcoder.jp/contests/keyence2020/submissions/37285193
提示 1：无论操作多少次，背面朝上的卡牌数总是偶数。
提示 2：一张牌从位置 i 交换至位置 j，如果 |i-j| 是偶数则正面朝上，否则背面朝上。
提示 3：写一个爆搜，枚举每张牌是正面向上还是背面向上，
到边界时，把当前的牌和排序后的牌对比，仿照冒泡排序那样模拟操作。
======

Input 1
3
3 4 3
3 2 3
Output 1
1

Input 2
2
2 1
1 2
Output 2
-1

Input 3
4
1 2 3 4
5 6 7 8
Output 3
0

Input 4
5
28 15 22 43 31
20 22 43 33 32
Output 4
-1

Input 5
5
4 46 6 38 43
33 15 18 27 37
Output 5
3
 */