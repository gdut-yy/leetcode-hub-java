package p1245;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1245F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    record Args(int p, boolean a, boolean b, boolean c, boolean d) {
    }

    private static void solve() {
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        Map<Args, Long> memo = new HashMap<>();
        long result = dfs(Integer.toBinaryString(r).length() - 1, true, true, true, true, l, r, memo);
        out.println(result);
    }

    private static long dfs(int p, boolean limHigh1, boolean limLow1, boolean limHigh2, boolean limLow2, int l, int r, Map<Args, Long> memo) {
        if (p < 0) {
            return 1;
        }

        Args t = new Args(p, limHigh1, limLow1, limHigh2, limLow2);
        if (memo.containsKey(t)) {
            return memo.get(t);
        }

        int hi1 = 1;
        if (limHigh1) {
            hi1 = (r >> p) & 1;
        }
        int lo1 = 0;
        if (limLow1) {
            lo1 = (l >> p) & 1;
        }

        int hi2 = 1;
        if (limHigh2) {
            hi2 = (r >> p) & 1;
        }
        int lo2 = 0;
        if (limLow2) {
            lo2 = (l >> p) & 1;
        }

        long res = 0;
        for (int i = lo1; i <= hi1; i++) {
            for (int j = lo2; j <= hi2; j++) {
                if (i == 0 || j == 0) {
                    res += dfs(p - 1, limHigh1 && i == hi1, limLow1 && i == lo1, limHigh2 && j == hi2, limLow2 && j == lo2, l, r, memo);
                }
            }
        }

        memo.put(t, res);
        return res;
    }
}
/*
F. Daniel and Spring Cleaning
https://codeforces.com/contest/1245/problem/F

灵茶の试炼 2025-11-21
题目大意：
输入 T(≤100) 表示 T 组数据。
每组数据输入 L R(0≤L≤R≤1e9)。
输出有多少对整数 (a,b) 满足如下条件：
L ≤ a ≤ R
L ≤ b ≤ R
a + b = a XOR b

rating 2300
由于 a + b = (a XOR b) + 2 * (a AND b)
所以 a + b = a XOR b 意味着 a AND b = 0。
换句话说，a 和 b 在同一个比特位上不能都是 1。
考虑上下界数位 DP。模板见我的动态规划题单。
本题有两个互相独立的变量 a 和 b，那就用 4 个参数 limitHigh1、limitLow1、limitHigh2、limitLow2，分别约束 a 的上下界，b 的上下界。
枚举 a 在当前比特位填 0 还是 1，b 在当前数位填 0 还是 1。注意不能都填 1。
递归到终点时返回 1，表示找到了一个合法 (a,b) 对。
注：本题前导零不影响答案。
思考题：如果要求 b < a，怎么做？如果 a 和 b 的范围不同呢？a 在 [L1,R1] 中，b 在 [L2,R2] 中。
一般来说，保留上面的 4 个参数，再额外增加一个 limit 参数，表示 b 是否受到 a 的约束。如果某个数位 b 小于 a，那么 b 后面就不受到 a 的约束。
读者可以做做 洛谷 P6669 [清华集训 2016] 组合数问题。https://www.luogu.com.cn/problem/P6669
代码 https://codeforces.com/problemset/submission/1245/349791055
代码备份（上面打不开的同学看这个）
======

Input
3
1 4
323 323
1 1000000
Output
8
0
3439863766
 */
