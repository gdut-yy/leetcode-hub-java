package lq240309;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LQ240309T7 {
    static int m, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            String str = scanner.next();
            to_insert(str.toCharArray());
        }
        get_Ac_next(ch, nexp);
        int now = 0, pre = 1;
        dp[now][0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            now ^= 1;
            pre ^= 1;
            for (int[] arr : dp[now]) Arrays.fill(arr, 0);
            for (int j = 0; j <= idx; ++j) {
                for (int c = 0; c < 26; ++c) {
                    int k = ch[j][c];
                    if (cnt[k] == 0) {
                        dp[now][k][0] += dp[pre][j][0];
                        dp[now][k][1] += dp[pre][j][1];
                        if (dp[now][k][0] >= MOD) dp[now][k][0] -= MOD;
                        if (dp[now][k][1] >= MOD) dp[now][k][1] -= MOD;

                    } else if (cnt[k] == 1) {
                        dp[now][k][1] += dp[pre][j][0];
                        if (dp[now][k][1] >= MOD) dp[now][k][1] -= MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j <= idx; ++j) {
            ans += dp[now][j][0];
            ans %= MOD;
            ans += dp[now][j][1];
            ans %= MOD;
        }
        System.out.println(ans);
    }

    static final int lim = 2006;
    static final int MOD = 998244353;
    static int idx = 0;
    static int[][] ch = new int[lim][26];
    static int[] nexp = new int[lim];
    static int[] cnt = new int[lim];
    static char[] s = new char[lim];
    static int[][][] dp = new int[2][1206][2];

    static void to_insert(char[] s) {
        int p = 0;
        for (int i = 0; i < s.length; ++i) {
            if (ch[p][s[i] - 'a'] == 0) ch[p][s[i] - 'a'] = ++idx;
            p = ch[p][s[i] - 'a'];
        }
        cnt[p]++;
    }

    static void get_Ac_next(int[][] ch, int[] next) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; ++i) {
            if (ch[0][i] != 0) q.add(ch[0][i]);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            cnt[u] += cnt[next[u]];
            for (int i = 0; i < 26; ++i) {
                int v = ch[u][i];
                if (v == 0) ch[u][i] = ch[next[u]][i];
                else {
                    next[v] = ch[next[u]][i];
                    q.add(v);
                }
            }
        }
    }
}
/*
独特的串【算法赛】

解题思路
本题考察 AC 自动机，动态规划。
回顾 AC 自动机的 fail 树 性质：
fail 树：fail 树代表的是前缀匹配序列，建立好 fail 树后，每个节点表达的意义是，从根到当前点，所有点的代表的前缀都可以匹配到。
那么我们用一个 cnt 数组表示当前这个节点匹配到了多少个字符串。
我们先对所有的字符串建立 AC 自动机，然后在 AC 自动机上做动态规划转移。
我们定义 dp_i,j,0/1 代表当前构造在第 i 个字符时，匹配到了 AC 自动机的第 j 个节点，并且已经匹配到了 0/1 个字符串的的数量。
初始状态 dp_0,0,0=1，其他值为 0。
我们枚举第 i 个字符，并且通过状态 j 转移到了状态 j'，分为两种情况：
1、cnt_j' = 1，那么可以得到：
dp_i+1,j',1 = dp_i+1,j',1 + dp_i,j,0
2、cnt_j' = 0,那么可以得到：
dp_i+1,j',1 = dp_i+1,j',1 + dp_i,j,1
dp_i+1,j',0 = dp_i+1,j',0 + dp_i,j,0
最后的 \sigma dp_n,i,0 + dp_n,i,1 即是答案。
复杂度为 O(26 × 2n \sigma |si|)。
 */