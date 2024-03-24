package p1426;

import java.util.Scanner;

public class CF1426F {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = ("0" + scanner.next()).toCharArray();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long pw = 1;
        long[][] f = new long[n + 1][3];
        for (int i = 1; i <= n; ++i) {
            if (s[i] == '?') {
                f[i][0] = (3 * f[i - 1][0] % MOD + pw) % MOD;
                f[i][1] = (3 * f[i - 1][1] % MOD + f[i - 1][0]) % MOD;
                f[i][2] = (3 * f[i - 1][2] % MOD + f[i - 1][1]) % MOD;
                pw = pw * 3 % MOD;
            } else {
                f[i][0] = f[i - 1][0];
                f[i][1] = f[i - 1][1];
                f[i][2] = f[i - 1][2];
                if (s[i] == 'a') {
                    f[i][0] = (f[i][0] + pw) % MOD;
                } else {
                    f[i][s[i] - 'a'] = (f[i][s[i] - 'a'] + f[i - 1][s[i] - 'a' - 1]) % MOD;
                }
            }
        }
        return String.valueOf(f[n][2]);
    }
}
/*
F. Number of Subsequences
https://codeforces.com/contest/1426/problem/F

灵茶の试炼 2022-04-19
题目大意：
给定一个长度不超过 2e5 的含有 abc? 四种字符的字符串，每个 ? 必须替换成是 abc 中的一个。（不同位置的 ? 的替换是互相独立的）
设 ? 的个数有 k 个，那么替换后一共有 3^k 个不同的只包含 abc 的字符串。
求这 3^k 个字符串中，子序列 abc 的出现次数之和。（对 1e9+7 取模）

rating 2000
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1426f
https://www.luogu.com.cn/problem/solution/cf1426f
---
https://www.luogu.com.cn/article/fgpxk2s4
非常套路的计数 $\text{DP}$ 题，不过对于一些 $\text{DP}$ 萌新来说确实很有意思。
设 $f[i,0/1/2]$ 表示前 $i$ 个字符构成的分别以 $a,b,c$ 结尾的子序列的个数，那么 $f[n,2]$ 即为答案。
考虑转移。
当 $a_i\neq \text{?}$ 时：
$$
\begin{cases}
f[i,0]=f[i-1,0]+3^{cnt_{i-1}}
\\
f[i,1]=f[i-1,1]+f[i-1,0]
\\
f[i,2]=f[i-1,2]+f[i-1,1]
\end{cases}
$$
当 $a_i= \text{?}$ 时：
$$
\begin{cases}
f[i,0]=f[i-1,0]\times 3+3^{cnt_{i-1}}
\\
f[i,1]=f[i-1,1]\times 3+f[i-1,0]
\\
f[i,2]=f[i-1,2]\times 3+f[i-1,1]
\end{cases}
$$
按上式转移，这题就做完了。
$cnt_{i}$ 表示前 $i$ 个字符中有 $cnt_i$ 个问号。这里解释一下 $3^{cnt_{i-1}}$ 的意义，之前的 $\text{?}$ 会将一个串变为 $3^{cnt_{i-1}}$ 个不同的串，每个串中都含有 $i$ 这个位置的字符 $\text{a}$（无论是从 $\text{?}$ 变换而来还是原先就是 $\text{a}$），所以需要计算 $3^{cnt_{i-1}}$ 次，其他的意义也是差不多的，都是为了统计 $\text{?}$ 对答案的影响。
记得开 $\text{long long}$ ，菜鸡不开 $\text{long long}$ $\text{WA}$ 了好几发，呜呜呜
======

input
6
ac?b?c
output
24

input
7
???????
output
2835

input
9
cccbbbaaa
output
0

input
5
a???c
output
46
 */
