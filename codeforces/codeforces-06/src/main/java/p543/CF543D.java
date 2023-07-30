package p543;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF543D {
    static int n;
    static Map<Integer, List<Integer>> adj;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        adj = new HashMap<>();
        for (int w = 1; w < n; w++) {
            int v = scanner.nextInt() - 1;
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(w);
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);
    private static long[][] f, ans;

    private static String solve() {
        f = new long[n][2];
        dfs(0);

        ans = new long[n][2];
        ans[0] = f[0];
        reroot(0);

        return Arrays.stream(ans).map(p -> String.valueOf(p[0] > 0 ? 0 : p[1])).collect(Collectors.joining(" "));
    }

    private static void dfs(int x) {
        f[x][1] = 1;
        for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
            dfs(y);
            f[x] = mul(f[x], add1(f[y]));
        }
    }

    private static void reroot(int x) {
        for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
            long[] p = div(ans[x], add1(f[y]));
            ans[y] = mul(f[y], add1(p));
            reroot(y);
        }
    }

    private static long[] add1(long[] p) {
        if (p[0] > 0) return new long[]{0, 1};
        if (p[1] == MOD - 1) return new long[]{1, 1};
        return new long[]{0, p[1] + 1};
    }

    private static long[] mul(long[] p, long[] q) {
        return new long[]{p[0] + q[0], p[1] * q[1] % MOD};
    }

    private static long[] div(long[] p, long[] q) {
        return new long[]{p[0] - q[0], p[1] * quickPow(q[1], MOD - 2) % MOD};
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
D. Road Improvement
https://codeforces.com/contest/543/problem/D

灵茶の试炼 2023-07-21
题目大意：
输入 n(2≤n≤2e5) 和 n-1 个数 p2,p3,...,pn，表示一棵 n 个节点的无根树，节点编号从 1 开始，i 与 pi(1≤pi≤i-1) 相连。
定义 a(x) 表示以 x 为根时的合法标记方案数，模 1e9+7。其中【合法标记】定义为：对树的某些边做标记，使得 x 到任意点的简单路径上，至多有一条边是被标记的。
输出 a(1),a(2),...,a(n)。

https://codeforces.com/contest/543/submission/214621886
换根 DP。不了解的同学请看右边的链接。 https://leetcode.cn/problems/sum-of-distances-in-tree/solution/tu-jie-yi-zhang-tu-miao-dong-huan-gen-dp-6bgb/
先来计算 a(1)，此时 1 为树根。
定义 f(i) 表示子树 i 的合法标记方案数。
对于 i 的儿子 j，考虑 i-j 这条边是否标记：
- 标记：那么子树 j 的所有边都不能标记，方案数为 1。
- 不标记：那么方案数就是 f(j)。
i 的每个儿子互相独立，所以根据乘法原理有
f(i) = (f(j1)+1) * (f(j2)+1) * ... * (f(jm)+1)
其中 j1,j2,...,jm 是 i 的儿子。
然后来计算其余 a(i)。
考虑把根从 i 换到 j：
对于 j 来说，方案数需要在 f(j) 的基础上，再乘上【父亲 i】这棵子树的方案数，即 a(i) / (f(j)+1)。
所以 a(j) = f(j) * (a(i)/(f(j)+1) + 1)
本题的一个易错点是，f(j)+1 可能等于 M=1e9+7，取模会变成 0，但是 0 没有逆元。
处理方式有很多，我的做法是定义二元组 (k,x) 表示 M^k * x % M，在这基础上定义：
- 乘法运算：(k1, x1) * (k2, x2) = (k1+k2, x1*x2%M)
- 除法运算：(k1, x1) / (k2, x2) = (k1-k2, x1*inv(x2)%M)  这里 k1>=k2
- 加一运算：请读者思考（需要分类讨论，具体见代码）
当 k>0 时，(k,x) 的实际值为 0；当 k=0 时，(k,x) 的实际值为 x。
======

input
3
1 1
output
4 3 3

input
5
1 2 3 4
output
5 8 9 8 5
 */
