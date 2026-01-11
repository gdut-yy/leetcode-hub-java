package p1073;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1073E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        lowS = scanner.next();
        highS = scanner.next();
        k = scanner.nextInt();

        n = highS.length();
        diffLH = n - lowS.length();

        memo = new Pair[n][1 << 10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << 10); j++) {
                memo[i][j] = new Pair(-1, 0);
            }
        }

        Pair result = dfs(0, 0, true, true);
        out.print(result.sum);
    }

    static final int MOD = 998244353;

    static class Pair {
        long num, sum;

        Pair(long num, long sum) {
            this.num = num;
            this.sum = sum;
        }
    }

    static Pair[][] memo;
    static String lowS, highS;
    static int k, n, diffLH;

    static Pair dfs(int i, int mask, boolean limitLow, boolean limitHigh) {
        if (i == n) {
            return new Pair(1, 0);
        }
        if (!limitLow && !limitHigh && memo[i][mask].num >= 0) return memo[i][mask];

        int lo = 0;
        if (limitLow && i >= diffLH) {
            lo = lowS.charAt(i - diffLH) - '0';
        }
        int hi = 9;
        if (limitHigh) {
            hi = highS.charAt(i) - '0';
        }

        int d = lo;
        Pair res = new Pair(0, 0);
        if (limitLow && i < diffLH) {
            res = dfs(i + 1, 0, true, false);
            d = 1;
        }
        for (; d <= hi; d++) {
            int newMask = mask | (1 << d);
            if (Integer.bitCount(newMask) > k) {
                continue;
            }
            Pair sub = dfs(i + 1, newMask, limitLow && d == lo, limitHigh && d == hi);
            res.num = (res.num + sub.num) % MOD;
            long v = (d * (long) Math.pow(10, n - 1 - i)) % MOD;
            res.sum = (res.sum + sub.sum + v * sub.num % MOD) % MOD;
        }
        if (!limitLow && !limitHigh) {
            memo[i][mask] = res;
        }
        return res;
    }
}
/*
E. Segment Sum
https://codeforces.com/contest/1073/problem/E

灵茶の试炼 2025-11-27
题目大意：
输入 L R(1≤L≤R<1e18) 和 k(1≤k≤10)。
如果一个整数至多包含 k 种数字，那么称其为好整数。
例如 112 包含两种数字 1 和 2。
输出 [L,R] 中的好整数之和，模 998244353。

rating 2300
前置题目：LC2376. 统计特殊整数。
和 LC2376 一样，需要一个参数 mask（二进制数），记录选了哪些数。
如果 mask 中的 1 的个数超过 k，那么不合法。
但本题要求的不是个数，而是和。
考虑贡献法，当前填的这个数，对答案的贡献是多少？
例如百位填 d = 3，那么 d 在整个数中的数值是 300。有多少个 300？取决于十位和个位有多少种合法填法。
一般地，当前数位填 d，那么 d 在整个数中的数值是 v = d * pow(10, n-1-i)，其中 n 是 R 的十进制长度。
贡献为 v * subCnt，其中 subCnt 表示后面继续填有多少种填法。
详细解释见上周双周赛第四题 我的题解 的方法二。
代码 https://codeforces.com/contest/1073/submission/350425571
代码备份（上面打不开的同学看这个）
======

Input
10 50 2
Output
1230

Input
1 2345 10
Output
2750685

Input
101 154 2
Output
2189

427896435961371452 630581697708338740 1
716070897
 */
