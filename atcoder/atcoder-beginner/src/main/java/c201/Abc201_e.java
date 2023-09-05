package c201;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc201_e {
    static int n;
    static Map<Integer, List<long[]>> g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        g = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            long wt = scanner.nextLong();
            g.computeIfAbsent(v, key -> new ArrayList<>()).add(new long[]{w, wt});
            g.computeIfAbsent(w, key -> new ArrayList<>()).add(new long[]{v, wt});
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);
    private static long[] cnt;

    private static String solve() {
        cnt = new long[60];
        dfs(1, 0, 0);

        long ans = 0;
        for (int i = 0; i < cnt.length; i++) {
            ans += (1L << i) % MOD * cnt[i] % MOD * (n - cnt[i]);
            ans %= MOD;
        }
        return String.valueOf(ans);
    }

    private static void dfs(int x, int fa, long xor) {
        for (int i = 0; i < cnt.length; i++) {
            cnt[i] += (int) (xor >> i & 1);
        }
        for (long[] p : g.getOrDefault(x, new ArrayList<>())) {
            int y = (int) p[0];
            long wt = p[1];
            if (y != fa) {
                dfs(y, x, xor ^ wt);
            }
        }
    }
}
/*
E - Xor Distances
https://atcoder.jp/contests/abc201/tasks/abc201_e

灵茶の试炼 2022-11-03
题目大意：
输入 n(≤2e5) 和一棵有边权的树的 n-1 条边，节点编号从 1 开始，边权范围 [0,2^60)。
定义 xor(i,j) 表示从 i 到 j 的简单路径上的边权的异或和。
累加所有满足 1≤i<j≤n 的 xor(i,j)，对结果模 1e9+7 后输出。

https://atcoder.jp/contests/abc201/submissions/36166044
提示 1：逐位考虑。也就是假设边权只有 0 和 1。
提示 2：xor(i,j) = xor(1,i) ^ xor(1,j)。
提示 3：DFS，统计 xor(1,i) 中 1 的个数，记作 c。由于只有 1 和 0 异或才能是 1，这个比特位上的答案为 c * (n-c)。
======

Input 1
3
1 2 1
1 3 3
Output 1
6

Input 2
5
3 5 2
2 3 2
1 5 1
4 5 13
Output 2
62

Input 3
10
5 7 459221860242673109
6 8 248001948488076933
3 5 371922579800289138
2 5 773108338386747788
6 10 181747352791505823
1 3 803225386673329326
7 8 139939802736535485
9 10 657980865814127926
2 4 146378247587539124
Output 3
241240228
 */