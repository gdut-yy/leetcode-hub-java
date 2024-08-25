package p176;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF176B {
    static String s, t;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next();
        t = scanner.next();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        int n = s.length();
        String ss = s + s;
        long c = 0;
        for (int i = 0; i < n; i++) {
            if (ss.startsWith(t, i)) {
                c++;
            }
        }
        long f = 0;
        if (s.equals(t)) {
            f = 1;
        }
        long g = f ^ 1;
        for (int i = 0; i < k; i++) {
            // f, g = (f*(c-1)+g*c)%mod, (f*(int64(n)-c)+g*(int64(n)-c-1))%mod
            long f0 = f;
            f = (f * (c - 1) + g * c) % MOD;
            g = (f0 * (n - c) + g * (n - c - 1)) % MOD;
        }
        return String.valueOf(f);
    }
}
/*
B. Word Cut
https://codeforces.com/contest/176/problem/B

灵茶の试炼 2023-06-21
题目大意：
输入两个长度相等的字符串 s 和 t，长度在 [2,1000] 内，只包含小写字母。
然后输入 k(0≤k≤1e5) 表示操作次数。
你需要恰好执行 k 次操作。
每次操作你可以把 s 分割成两个非空字符串 s1 和 s2，然后替换 s = s2 + s1。
把 s 变成 t 有多少种方案？模 1e9+7。

rating 1700
https://codeforces.com/contest/176/submission/210387377
手玩一下发现操作与「把 s 循环右移（左移）」是一样的。
假设有 c 种不同的循环右移可以让 s=t。那么有 n-c 种不同的循环右移让 s≠t。
定义 f[i] 表示操作 i 次后 s=t，g[i] 表示表示操作 i 次后 s≠t。
那么
f[i] = f[i-1] * (c-1) + g[i-1] * c
g[i] = f[i-1] * (n-c) + g[i-1] * (n-c-1)
初始值 f[0]=(s==t), g[0]=f[0]^1
======

input
ab
ab
2
output
1

input
ababab
ababab
1
output
2

input
ab
ba
2
output
0
 */
