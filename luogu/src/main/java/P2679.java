import java.util.Scanner;

public class P2679 {
    static int n, m, K;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        K = scanner.nextInt();
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static final int mod = (int) (1e9 + 7);

    private static String solve() {
        long[][][][] f = new long[2][n + 1][m + 1][2];
        for (int i = 0; i <= n; i++) {
            f[0][i][0][0] = 1;
            f[0][i][0][1] = 1;
        }
        for (int k = 0; k < K; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    long res = 0;
                    if (s[i] == t[j]) {
                        res += f[k % 2][i][j][0]; // f(k-1, i-1, j-1, 0)
                        res += f[(k + 1) % 2][i][j][1]; // f(k, i-1, j-1, 1)
                        res %= mod;
                    }
                    f[(k + 1) % 2][i + 1][j + 1][1] = res;

                    long res2 = f[(k + 1) % 2][i][j + 1][0]; // f(k, i-1, j, 0)
                    if (s[i] == t[j]) {
                        res2 = (res2 + res) % mod;
                    }
                    f[(k + 1) % 2][i + 1][j + 1][0] = res2;
                }
            }
            for (int i = 0; i <= n; i++) {
                f[0][i][0][0] = 0;
                f[0][i][0][1] = 0;
            }
        }
        return String.valueOf(f[K % 2][n][m][0]);
    }
}
/*
P2679 [NOIP2015 提高组] 子串
https://www.luogu.com.cn/problem/P2679

灵茶の试炼 2023-11-30
题目大意：
输入 n(1≤n≤1000) m k(1≤k≤m≤200) 和长为 n 的字符串 s，长为 m 的字符串 t，只包含小写英文字母。
你需要从 s 中取出 k 个互不重叠的非空连续子串，然后把这 k 个子串按照其在 s 中的出现顺序依次连接起来，得到一个新的字符串。
输出有多少种方案可以使得这个新串与 t 相等。
答案模 1e9+7。
注意：子串相同但取出的位置不同，也认为是不同的方案。

一、优化前
本题属于划分型 DP，定义 dfs(k,i,j) 表示从 s 的前 i 个字母中取出 k 个子串，拼接得到 t 的前 j 个字母的方案数。
不选 s[i]：
dfs(k,i-1,j)
选 s[i]（注意前提是从 s 取出的这个子串和 t 中对应子串是一样的，即 s[i]=t[j], s[i-1]=t[j-1], ...）
子串长度=1：dfs(k-1,i-1,j-1)
子串长度=2：dfs(k-1,i-2,j-2)
子串长度=3：dfs(k-1,i-3,j-3)
...
这样做时间是 O(knm^2)，无法接受。
---
二、优化
注意到当 s[i]=t[j] 时，我们可以继续比较 s[i-1] 和 t[j-1]，向左寻找更长的子串。
但在 dfs(*,i-1,j-1) 中，我们也会比较 s[i-1] 和 t[j-1]，也会继续向左寻找更长的子串。
这样就重复计算了。
不妨添加一个维度，用状态机 DP 思考。
定义 dfs(k,i,j,on) 表示从 s 的前 i 个字母中取出 k 个子串，得到 t 的前 j 个字母的方案数。
on=0 表示尚未开始匹配（此时开始匹配，那么当前字母是子串的末尾字母）。
on=1 表示已经开始匹配（当前字母不是子串的末尾字母）。
对于 on=0：
不选 s[i]：dfs(k,i-1,j,0)
如果 s[i]=t[j]，那么有两种情况：
选 s[i] 并且子串长度恰好为 1：dfs(k-1,i-1,j-1,0)
选 s[i] 并且子串长度超过 1：dfs(k,i-1,j-1,1) 注意这里没有减小 k，等到匹配完了再减小。
这两个选的情况，可以合并成 dfs(k,i,j,1)，所以有
dfs(k,i,j,0) = dfs(k,i-1,j,0) + dfs(k,i,j,1)
对于 on=1：
如果 s[i]!=t[j]：直接返回 0。
否则：
在这里结束：dfs(k-1,i-1,j-1,0)
继续向左匹配：dfs(k,i-1,j-1,1)
所以在 s[i]=t[j] 时，有
dfs(k,i,j,1) = dfs(k-1,i-1,j-1,0) + dfs(k,i-1,j-1,1)
时间空间都是 O(knm)。
记忆化搜索可以直接拿到 90 分。少的那 10 分是因为这题卡内存，或者说空间复杂度需要是 O(nm)。
要想拿到 100 分，需要翻译成递推，然后把第一个维度优化一下（用两个数组滚动）。
https://www.luogu.com/paste/xrvnxad4
注：也可以用前缀和优化，但我感觉状态机 DP 更好想。
======

输入 #1
6 3 1
aabaab
aab
输出 #1
2
输入 #2
6 3 2
aabaab
aab
输出 #2
7
输入 #3
6 3 3
aabaab
aab
输出 #3
7
 */