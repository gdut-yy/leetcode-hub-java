package p1920;

import java.util.Arrays;
import java.util.Scanner;

public class CF1920E {
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static final int MOD = 998244353;
    static int[][] memo;

    private static String solve() {
        memo = new int[n + 1][k];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }

        long ans = 0;
        for (int j = 0; j < k; j++) {
            ans += dfs(n, j);
        }
        return String.valueOf(ans % MOD);
    }

    static int dfs(int i, int j) {
        if (i == 0) return 1;
        if (memo[i][j] != -1) return memo[i][j];
        long res = 0;
        for (int x = 0; x + j < k && (x + 1) * (j + 1) <= i; x++) {
            res += dfs(i - (x + 1) * (j + 1), x);
        }
        return memo[i][j] = (int) (res % MOD);
    }
}
/*
E. Counting Binary Strings
https://codeforces.com/contest/1920/problem/E

灵茶の试炼 2024-09-12
题目大意：
输入 T(≤2500) 表示 T 组数据。所有数据的 n 之和 ≤2500。
每组数据输入 n 和 k (1≤k≤n≤2500)。
定义【好字符串】为恰好包含一个 1 的 01 字符串。
输出有多少个 01 字符串满足：恰好包含 n 个好子串，且每个好子串的长度都 <= k。
答案模 998244353。

rating 2100
注意题目的约束在子串上，对原串并没有【直接】的约束。
如何计算好子串的个数？
例如子串 001000，其对答案的贡献为好子串左端点的个数 * 好子串右端点的个数 = (2+1)*(3+1) = 12，也就是有 12 个好子串恰好包含一个 1。
这启发我们围绕 0 的个数设计状态。
注意我们并不需要知道原串的长度，也不需要知道 0 和 1 的具体位置。只需要知道 0 的个数。
把 1 视作分割线，把字符串 s 分成若干段 0。
注意对于 s=1001 这种首尾有 1 的字符串，为了能计算贡献，要将 s 视作有三段 0，长度分别为 0,2,0。
假如最后两段 0 的个数分别是 2 和 3（上面 001000 的例子），那么问题变成：
恰好包含 n-12 个好子串，且右边一段 0 的个数是 2 的情况下，字符串的个数。
继续思考，假设当前这段 0 的个数为 4（字符串的末尾是 00001001000），这会贡献 (4+1)*(2+1) = 15 个好子串，接下来要解决的问题为：
恰好包含 n-27 个好子串，且右边一段 0 的个数是 4 的情况下，字符串的个数。
一般地，定义 f(i,j) 表示恰好包含 i 个好子串，且右边一段 0 的个数是 j 的情况下，字符串的个数。
枚举当前这段 0 的个数 x，递归到 f(i-(x+1)*(j+1), x)。
x 需要满足 x >= 0 且 x+j < k（因为中间还有个 1）且 (x+1)*(j+1) <= i。
注意枚举 x 的次数为 O(i/j)，根据调和级数，时间复杂度为 O(nklogn)。
递归边界：f(0,j)=1。
答案：f(n,0)+f(n,1)+...+f(n,k-1)。
记忆化搜索 https://codeforces.com/problemset/submission/1920/280515581
1:1 翻译成递推 https://codeforces.com/problemset/submission/1920/280515765
======

Input
6
1 1
3 2
4 2
5 4
6 2
2450 2391
Output
1
3
5
12
9
259280854
 */
