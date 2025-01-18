package c359;

import java.util.Arrays;
import java.util.Scanner;

public class Abc359_d {
    static int n, k;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;
    static boolean[] pal;
    static int mask;
    static long[][] memo;

    private static String solve() {
        pal = new boolean[1 << k];
        o:
        for (int i = 0; i < pal.length; i++) {
            for (int j = 0; j < k / 2; j++) {
                if ((i >> j & 1) != (i >> (k - 1 - j) & 1)) {
                    continue o;
                }
            }
            pal[i] = true;
        }

        mask = (1 << (k - 1)) - 1;
        memo = new long[n][1 << k];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return String.valueOf(dfs(n - 1, 0));
    }

    static long dfs(int i, int j) {
        if (i < 0) {
            return 1;
        }
        if (memo[i][j] != -1) return memo[i][j];
        long res = 0;
        for (int b = 0; b < 2; b++) {
            if (s[i] != '?' && (s[i] & 1) != b) {
                continue;
            }
            int t = j << 1 | b;
            if (i > n - k || !pal[t]) {
                res += dfs(i - 1, t & mask);
            }
        }
        return memo[i][j] = res % MOD;
    }
}
/*
D - Avoid K Palindrome
https://atcoder.jp/contests/abc359/tasks/abc359_d

灵茶の试炼 2024-08-06
题目大意：
输入 n k(2≤k≤n≤1000 且 k≤10) 和长为 n 的字符串 s，只包含 A,B,? 三种字符。
如果一个字符串不包含长度恰好为 k 的回文子串，我们称其为合法字符串。
把 s 中的所有 ? 替换成 A 或 B，可以得到 2^q 个不同的字符串，其中 q 是 s 中的 ? 的个数。
输出这 2^q 个字符串中的合法字符串个数，模 998244353。

把 AB 信息用二进制压缩表示。
下面的写法中，二进制高位对应的字母在 s 中更靠右的位置，二进制低位对应的字母在 s 中更靠左的位置。
从右往左递归。
定义 dfs(i,j)，其中 i 右边的 k-1 个字母的二进制为 j，计算替换 s[0] 到 s[i] 中的 ?，能得到多少个合法子串。
枚举 b=0,1（如果 s[i]!=? 则 b=s[i]&1）。
把 b 和 j 拼起来，即 t = j<<1 | b，如果 i>n-k，或者得到的二进制数 t 不是回文的，那么就递归到 dfs(i-1, t&mask)，其中 mask = (1 << (k-1)) - 1，用来去掉二进制的最高位。
递归边界：dfs(-1,j)=1，表示找到了一个合法字符串。
递归入口：dfs(n-1,0)。
记忆化搜索 https://atcoder.jp/contests/abc359/submissions/56382758
1:1 翻译成递推 https://atcoder.jp/contests/abc359/submissions/56382174
======

Input 1
7 4
AB?A?BA
Output 1
1

Input 2
40 7
????????????????????????????????????????
Output 2
116295436

Input 3
15 5
ABABA??????????
Output 3
0
 */