package c160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc160_f {
    static int n;
    static List<Integer>[] g;
    static long fac;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        fac = 1;
        for (int i = 2; i <= n; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
            fac = fac * i % MOD;
        }
        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);
    static long[] ans, size;

    private static String solve() {
        ans = new long[n];
        ans[0] = 1;
        size = new long[n];
        dfs(0, -1);
        reroot(0, -1);
        ans = Arrays.stream(ans).map(v -> fac * quickPow(v, MOD - 2) % MOD).toArray();
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static void dfs(int x, int fa) {
        size[x] = 1;
        for (Integer y : g[x]) {
            if (y != fa) {
                dfs(y, x);
                size[x] += size[y];
            }
        }
        ans[0] = ans[0] * size[x] % MOD;
    }

    static void reroot(int x, int fa) {
        for (Integer y : g[x]) {
            if (y != fa) {
                ans[y] = ans[x] * quickPow(size[y], MOD - 2) % MOD * (n - size[y]) % MOD;
                reroot(y, x);
            }
        }
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
F - Distributing Integers
https://atcoder.jp/contests/abc160/tasks/abc160_f

灵茶の试炼 2025-01-24
题目大意：
输入 n(2≤n≤2e5) 和一棵无向树的 n-1 条边，节点编号从 1 到 n。
定义 f(i) 为如下过程的方案数：
首先，在节点 i 写下数字 1。
然后，选择一个与写下数字节点相邻的节点（没有写过数字），写下数字 2。
继续，重复上述过程，依次写下数字 3,4,...,n。
输出 f(1),f(2),...,f(n)。

1916. 统计为蚁群构筑房间的不同顺序 换根 DP 版。
f(1) 怎么算？
写下所有数字后，如果 DFS 遍历这棵树，按顺序记录遍历到的数字，会得到一个 1~n 的排列，总共有 n! 种，其中肯定有不合法的。
比如，这个排列肯定要以 1 开头，所有不以 1 开头的排列都是不合法的。以 1 开头的排列个数是 (n-1)!，相当于把 n! 除以 n。
同理，对于每棵子树 v 而言（对应着 1~n 排列中的一个子序列），不以 v 的标记数字开头的排列都是不合法的，同样要把方案数除以 size[v]，即子树 v 的大小。
所以 f(1) = n! / (size[1] * size[2] * ... * size[n])。
对于其他 f(i)，我们可以在 f(1) 的基础上，用换根 DP 快速计算上式的分母。
从节点 x 换到节点 y，先除以 size[y]，对于不在子树 y 中的节点，会形成一棵 y 的子树，所以要乘以 (n-size[y])。
由于上述过程有除法，需要用逆元（费马小定理）计算。
代码 https://atcoder.jp/contests/abc160/submissions/61950975
======

Input 1
3
1 2
1 3
Output 1
2
1
1

Input 2
2
1 2
Output 2
1
1

Input 3
5
1 2
2 3
3 4
3 5
Output 3
2
8
12
3
3

Input 4
8
1 2
2 3
3 4
3 5
3 6
6 7
6 8
Output 4
40
280
840
120
120
504
72
72
 */
