package p1848;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1848E {
    static int x, q, M;
    static int[] qx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        x = scanner.nextInt();
        q = scanner.nextInt();
        M = scanner.nextInt();
        qx = new int[q];
        for (int i = 0; i < q; i++) {
            qx[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static int MAX = 2000000;
    static long[] inv;
    static long ans;
    static int e;

    // https://codeforces.com/problemset/submission/1848/214068686
    private static String solve() {
        x >>= Integer.numberOfTrailingZeros(x);

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                int cnt = 0;
                while (x % i == 0) {
                    cnt++;
                    x /= i;
                }
                mp.put(i, cnt);
            }
        }
        if (x > 1) {
            mp.put(x, 1);
        }

        inv = new long[MAX];
        inv[1] = 1;
        for (int i = 2; i < MAX && i < M; i++) {
            inv[i] = M - inv[M % i] * (M / i) % M;
        }
        ans = 1;
        e = 0;
        for (Integer se : mp.values()) {
            multiply(se + 1);
        }
        int[] pr = new int[MAX + 1];
        Arrays.fill(pr, -1);
        for (int i = 2; i <= MAX; i++) {
            if (pr[i] == -1) {
                for (int j = i; j <= MAX; j += i) {
                    pr[j] = i;
                }
            }
        }

        long[] res = new long[q];
        for (int i = 0; i < q; i++) {
            int x2 = qx[i];
            x2 >>= Integer.numberOfTrailingZeros(x2);
            while (x2 != 1) {
                int p = pr[x2];
                int cnt = 0;
                while (x2 % p == 0) {
                    x2 /= p;
                    cnt++;
                }
                divide(mp.getOrDefault(p, 0) + 1);
                mp.put(p, mp.getOrDefault(p, 0) + cnt);
                multiply(mp.get(p) + 1);
            }
            res[i] = (e > 0) ? 0 : ans;
        }
        return Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }


    private static void multiply(int x) {
        while (x % M == 0) {
            e++;
            x /= M;
        }
        ans *= x % M;
        ans %= M;
    }

    private static void divide(int x) {
        while (x % M == 0) {
            e--;
            x /= M;
        }
        ans *= inv[x % M];
        ans %= M;
    }
}
/*
E. Vika and Stone Skipping
https://codeforces.com/contest/1848/problem/E

题目大意：
在维卡的家乡符拉迪沃斯托克，有一片美丽的大海。
你经常可以看到孩子们在捡石头。这是把一块石头以一个小角度扔进海里，使它飞得很远，在水面上反弹几次的过程。
维卡已经擦过石头很多次了，他知道如果你用 f 的力把一块石头垂直于海岸线从岸上扔出去，它首先会在距离海岸 f 的地方接触到水，然后反弹回来，在距离上一次接触点 f−1 的地方再次接触到水。石头将继续沿直线飞行，减少它接触水的点之间的距离，直到它落入大海。
形式上，石头接触水面的点将具有以下坐标:f, f+(f−1)，f+(f−1)+(f−2),...,f+(f−1)+(f−2)+…+1(假设 0 为海岸线坐标)。
有一次，傍晚沿着海参崴的堤岸散步时，维卡看到一群人把石头扔过大海，用不同的力量从同一个地方扔出去。
她开始感兴趣的是用力 fi 发射石头的最大人数是多少，所以所有 fi 都是不同的正整数，所有 n 块石头都在坐标 x 的点接触到水(假设 0 是海岸线的坐标)。
想了一会儿，维卡回答了她的问题。之后，她开始分析如果她将坐标 x 乘以一些正整数 x1, x2，…，她的问题的答案会有什么变化。xq，她选择它来分析。
Vika 发现自己很难应付这样的分析，所以她向你寻求帮助。
形式上，Vika 感兴趣的是坐标 X1=x·X1, X2=X1·X2,...,Xq=Xq−1·Xq。由于这种坐标的答案可能相当大，所以求它以 M 为模。可以保证 M 是素数。

rating 2600
======

input
1 2 179
2 3
output
1
2

input
7 5 998244353
2 13 1 44 179
output
2
4
4
8
16

input
1000000000 10 179
58989 49494 8799 9794 97414 141241 552545 145555 548959 774175
output
120
4
16
64
111
43
150
85
161
95
 */
