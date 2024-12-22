package p1932;

import java.util.Scanner;

public class CF1932E {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] a = new int[n];
        int[] diff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int v = s[i] - '0';
            a[i] = v;
            diff[i] += v;
            diff[n] -= v;
        }
        int[] res = new int[n + 1];
        res[1] = a[0];
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + diff[i - 1];
        }

        char[] t = new char[n + 1];
        for (int i = n; i >= 1; i--) {
            res[i - 1] += res[i] / 10;
            t[i] = (char) (res[i] % 10 + '0');
        }
        t[0] = (char) (res[0] % 10 + '0');
        String ans = new String(t);
        // 去掉前缀 0
        return ans.replaceAll("^0+", "");
    }
}
/*
E. Final Countdown
https://codeforces.com/contest/1932/problem/E

题目大意：
你在一个即将爆炸并毁灭地球的核实验室里。你必须在最后的倒计时达到零之前拯救地球。
倒计时由 n(1≤n≤4⋅10^5)个机械指示器组成，每个指示器显示一位十进制数字。你注意到，当倒计时从 x 改变到 x - 1 时，它不是一次移动就发生的。相反，每改变一个个位数需要一秒钟。
因此，例如，如果倒计时显示 42，那么它将在一秒钟内变为 41，因为只更改了一位数字，但是如果倒计时显示 2300，那么它将在三秒钟内变为 2299，因为最后三位数字更改了。
看看倒数到零之前还剩多少时间。

13715 = 12345+1234+123+12+1
      = 12345+1111+222+33+4
差分 + 竖式加法
======

Input
5
2
42
5
12345
2
99
4
0005
27
456480697259671309012631002
Output
46
13715
108
5
507200774732968121125145546
 */
