package p1238;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1238E {
    static int n, m;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.next();
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;

    private static String solve() {
        int[][] cnt = new int[m][m];
        for (int i = 1; i < n; i++) {
            int x = s.charAt(i - 1) - 'a';
            int y = s.charAt(i) - 'a';
            if (x != y) {
                cnt[x][y]++;
                cnt[y][x]++;
            }
        }

        int[] f = new int[1 << m];
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int s = 0; s < 1 << m; s++) {
            int i = Integer.bitCount(s);
            // for cus, lb := len(f)-1^s, 0; cus > 0; cus ^= lb {
            for (int cus = f.length - 1 ^ s, lb = 0; cus > 0; cus ^= lb) {
                lb = cus & -cus;
                int ns = s | lb;
                int p = Integer.numberOfTrailingZeros(lb);
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    if ((s >> j & 1) == 1) {
                        sum += cnt[p][j] * i;
                    } else {
                        sum -= cnt[p][j] * i;
                    }
                }
                f[ns] = Math.min(f[ns], f[s] + sum);
            }
        }
        return String.valueOf(f[(1 << m) - 1]);
    }
}
/*
E. Keyboard Purchase
https://codeforces.com/contest/1238/problem/E

灵茶の试炼 2023-07-14
题目大意：
输入 n(1≤n≤1e5) m(1≤m≤20) 和长为 n 的字符串 s，由前 m 个小写字母组成。
你需要构造一个长为 m 的小写字母排列，例如 m=3 时的 bac，把这个排列当成一个只有一排的键盘。
在只用一根手指的情况下，用这个键盘打出 s。
问：构造一个怎样的键盘，可以使手指的移动距离之和最小？输出这个最小值。

1879. 两个数组最小的异或值之和
不了解排列型状压的，推荐先做这题。
统计字符串中相邻字母对的个数，记作 cnt。
用状态 s 表示前面填了 |s| 个字母的键盘，这里 |s| 表示 s 中二进制 1 的个数
假设当前填字母 c，那么 c 的位置 pos[c]=|s|。
对于前面已经填的字母 x，贡献为 cnt[c][x] * (pos[c] - pos[x])，
对于后面没有填的字母 y，贡献为 cnt[c][y] * (pos[y] - pos[c])。
把 cnt[c][x] * pos[c] 单独分离出来，这样每个字母怎么填，就不需要知道前后字母的【具体位置】了。
总贡献 cost(c) = sum(cnt[c][x] * pos[c] for x in s) - sum(cnt[c][y] * pos[c] for y not in s)
定义 f[s] 表示状态 s 的 cost 之和的最小值，有
f[s|c] = min(f[s] + cost(c) for c not in s)
初始值 f[0] = 0，答案为 f[-1]。
https://codeforces.com/problemset/submission/1238/213707044
优化：比上面快 3~4 倍（只需要计算 sum(cnt[c][x])，sum(cnt[c][y]) 可以由 sum(cnt[c]) - sum(cnt[c][x]) 得到，而 sum(cnt[c]) 可以提前预处理出来。）
https://codeforces.com/contest/1238/submission/213707877
也可以进一步预处理 sum(cnt[c][x])，但是还没上面跑的快。
https://codeforces.com/contest/1238/submission/213708185
======

input
6 3
aacabc
output
5

input
6 4
aaaaaa
output
0

input
15 4
abacabadabacaba
output
16
 */
