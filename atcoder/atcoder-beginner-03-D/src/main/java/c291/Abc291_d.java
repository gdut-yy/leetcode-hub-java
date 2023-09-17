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
        System.out.println(solve());
    }

    private static String solve() {
        memo = new HashMap<>();
        int res = dfs(0, -1);
        return String.valueOf(res);
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

题目大意：
N 张从 1 到 N 的卡片排成一行。对于每个 i(1≤i<N)，纸牌 i 与纸牌(i+1)相邻。卡片 i 的正面写着 A i，背面写着 B i。最初，所有的牌都是正面朝上的。
考虑从 N 张牌中选择 0 张或更多张牌。在选择翻转牌的 2n 种方法中，求出下列方法的模 998244353 的个数:
- 当被选中的牌被翻转时，对于每一对相邻的牌，写在它们正面上的整数是不同的。

记忆化搜索。
======

Input 1
3
1 2
4 2
3 4
Output 1
4

Input 2
4
1 5
2 6
3 7
4 8
Output 2
16

Input 3
8
877914575 602436426
861648772 623690081
476190629 262703497
971407775 628894325
822804784 450968417
161735902 822804784
161735902 822804784
822804784 161735902
Output 3
48
 */