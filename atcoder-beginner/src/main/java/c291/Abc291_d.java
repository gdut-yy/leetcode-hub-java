package c291;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc291_d {
    private static final int MOD = 998244353;
    private static int[] a, b;
    static Map<Integer, Map<Integer, Integer>> memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        memo = new HashMap<>();
        int res = dfs(0, -1);
        System.out.println(res);
    }

    private static int dfs(int i, int fa) {
        if (i == a.length) {
            return 1;
        }
        if (memo.containsKey(i) && memo.get(i).containsKey(fa)) {
            return memo.get(i).get(fa);
        }
        int res = 0;
        if (a[i] != fa) {
            res = (res + dfs(i + 1, a[i])) % MOD;
        }
        if (b[i] != fa) {
            res = (res + dfs(i + 1, b[i])) % MOD;
        }
        memo.computeIfAbsent(i, key -> new HashMap<>()).put(fa, res);
        return res;
    }
}
/*
D - Flip Cards
https://atcoder.jp/contests/abc291/tasks/abc291_d

记忆化搜索
 */