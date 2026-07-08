package c441;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc441_f {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] w = new int[n], v = new int[n];
        long[][] pre = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
            for (int j = 0; j < w[i]; j++) pre[i + 1][j] = pre[i][j];
            for (int j = w[i]; j <= m; j++) {
                pre[i + 1][j] = Math.max(pre[i][j], pre[i][j - w[i]] + v[i]);
            }
        }
        long maxS = pre[n][m];
        char[] ans = new char[n];
        long[] suf = new long[m + 1];
        for (int i = n - 1; i >= 0; i--) {
            long notChoose = 0, choose = 0;
            for (int j = 0; j <= m; j++) {
                notChoose = Math.max(notChoose, pre[i][j] + suf[m - j]);
                if (j <= m - w[i]) {
                    choose = Math.max(choose, pre[i][j] + v[i] + suf[m - w[i] - j]);
                }
            }
            if (notChoose < maxS) ans[i] = 'A';
            else if (choose < maxS) ans[i] = 'C';
            else ans[i] = 'B';
            for (int j = m; j >= w[i]; j--) {
                suf[j] = Math.max(suf[j], suf[j - w[i]] + v[i]);
            }
        }
        out.println(new String(ans));
    }
}
/*
F - Must Buy
https://atcoder.jp/contests/abc441/tasks/abc441_f

灵茶の试炼 2026-06-04
题目大意：
输入 n(1≤n≤1e3) m(1≤m≤5e4) 和 n 个物品。
每个物品输入体积 w(1≤w≤m) 和价值 v(1≤v≤1e9)。
你想选择一些体积之和至多为 m 的物品，最大化所选物品的价值之和。
对于每个物品：
- 如果该物品必选，输出 A。
- 如果该物品选或不选都可以，输出 B。
- 如果该物品一定不能选，输出 C。

rating
先跑一遍 0-1 背包，算出最大价值和 maxS。
分类讨论：
- 如果不选第 i 个物品时，最大价值和 < maxS，那么该物品必选。
- 如果选第 i 个物品时，最大价值和 < maxS，那么该物品一定不能选。
- 否则选不选第 i 个物品，最大价值和都等于 maxS，那么该物品可选可不选。
如果不选第 i 个物品，我们需要计算剩余 n-1 个物品的 0-1 背包。这可以用前后缀分解加速。
设第 1 ~ i-1 个物品的 DP 数组为 pre[i-1]，第 i+1 ~ n 个物品的 DP 数组为 suf[i+1]。
枚举分配 j 的容量给前缀，分配 m-j 的容量给后缀，那么不选第 i 个物品时的最大价值和为
max(pre[i-1][j] + suf[i+1][m-j] for j=0,1,2,...,m)
如果选第 i 个物品，枚举分配 j 的容量给前缀，分配 m-w[i]-j 的容量给后缀，那么选第 i 个物品时的最大价值和为
max(pre[i-1][j] + v[i] + suf[i+1][m-w[i]-j] for j=0,1,2,...,m-w[i])
代码实现时，suf 可以优化成一维数组。
代码 https://atcoder.jp/contests/abc441/submissions/76158221
======

Input 1
5 7
2 5
2 5
3 5
3 10
3 20
Output 1
BBCBA

Input 2
7 3
1 1
1 1
1 2
1 2
1 2
1 3
1 3
Output 2
CCBBBAA
 */
