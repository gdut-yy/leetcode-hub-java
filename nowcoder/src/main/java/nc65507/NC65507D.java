package nc65507;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class NC65507D {
    static int n, m;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        System.out.println(solve());
    }

    private static final int mod = (int) (1e9 + 7);
    // inverse of 2
    private static final int mod2 = (mod + 1) / 2;

    // https://ac.nowcoder.com/acm/contest/view-submission?submissionId=64003586
    private static String solve() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int[] d = new int[n];
        Arrays.fill(d, -1);
        d[0] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (Integer y : g[x]) {
                if (d[y] == -1) {
                    d[y] = d[x] + 1;
                    q.add(y);
                }
            }
        }

        long val = 0, cnt = 1;
        for (int x = 1; x < n; x++) {
            val += d[x];
            int c = 0;
            for (Integer y : g[x]) {
                if (d[y] + 1 == d[x]) {
                    c++;
                }
            }
            long p = 1;
            for (int i = 0; i < c; i++) {
                cnt = cnt * mod2 % mod;
                p = p * 2 % mod;
            }
            cnt = cnt * (p - 1) % mod;
        }
        for (int i = 0; i < m; i++) {
            cnt = cnt * 2 % mod;
        }
        return val % mod + " " + cnt;
    }
}
/*
小红的转账设置方式
https://ac.nowcoder.com/acm/contest/65507/D

题目描述
小红有 n 张银行卡，其中的某些银行卡之间可以互相转账（只能单向转）。但是有些银行卡则不能转账。
由于转账是单向的，对于可以转账的银行卡，小红可以设置转账的方向。如果 a 银行卡和 b 银行卡可以互相转账，那么小红可以设置成 a 银行卡向 b 银行卡转账。当设置结束后，b 银行卡就无法向 a 银行卡转账了。也就是说，设置完结束后，对于 a、b 这一对银行卡，a 只能作为转账方，b 只能作为收账方。
为了用钱方便，小红希望设置转账的方向后，所有银行卡的钱有一种方式可以转入 1 号银行卡。定义每张银行卡的代价为该银行卡转入 1 号银行卡的最少转账次数。现希望所有银行卡的代价之和尽可能小，小红想知道，有多少种不同的转账设置方案？答案请对 10^9 +7 取模。
输入描述:
第一行输入两个正整数 n 和 m，代表银行卡数量以及可以互相转账的银行卡对数。
接下来的 m 行，每行输入两个正整数 u 和 v，代表 u 号银行卡和 v 号银行卡之前可以设置转账方向。
1≤n,m≤200000
1≤u,v≤n 且 u≠v
保证任意两个银行卡之间最多一种直接转账方式。
保证至少存在一种方案使得所有卡都可以转入 1 号银行卡。
输出描述:
输出两个正整数 val 和 cnt，分别代表最小的代价之和、以及能达到这个最小和的方案数。
答案请对 10^9 +7 取模（代价之和、方案数都需要取模再输出）。

建图 + bfs + 乘法逆元
======

示例1
输入
4 4
1 2
1 3
2 4
3 4
输出
4 3
说明
最小的代价之和是4，有以下方案：
方案1：转账方向设置为，2号->1号，3号->1号，4号->2号，4->3号。1号银行卡的代价是0，2号银行卡的代价是1，3号银行卡的代价是1，4号银行卡的代价是2。
方案2：转账方向设置为，2号->1号，3号->1号，4号->2号，3->4号。1号银行卡的代价是0，2号银行卡的代价是1，3号银行卡的代价是1，4号银行卡的代价是2。
方案3：转账方向设置为，2号->1号，3号->1号，2号->4号，4->3号。1号银行卡的代价是0，2号银行卡的代价是1，3号银行卡的代价是1，4号银行卡的代价是2。
其它方案的代价之和都大于4。
 */