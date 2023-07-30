package c312;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc312_d {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        int n = s.length;
        long[][] f = new long[n + 1][n + 1];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i] != ')') {
                    f[i + 1][j + 1] += f[i][j];
                    f[i + 1][j + 1] %= MOD;
                }
                if (j != 0 && s[i] != '(') {
                    f[i + 1][j - 1] += f[i][j];
                    f[i + 1][j - 1] %= MOD;
                }
            }
        }
        return String.valueOf(f[n][0]);
    }
}
/*
D - Count Bracket Sequences
https://atcoder.jp/contests/abc312/tasks/abc312_d

题目大意：
你会得到一个由(，)和?组成的非空字符串 S。
有两个 x 的方式来获得一个新的字符串通过替换每个?在 S with (and)中，x 是出现的次数?其中，求出产生圆括号字符串的方法的个数，取 998244353 的模。
如果满足下列条件之一，则称字符串为括号字符串。
- 它是一个空字符串。
- 对于某个括号字符串 a，它是(，a, and)的连接。
- 对于一些非空括号字符串 a 和 B，它是 a 和 B 的连接。

https://atcoder.jp/contests/abc312/editorial/6864
设 dp(i,j) 为替换每次出现的 ? 在前 i 个字符中使用 [ 或 ]，使得在所有 k≤i 的前 k 个字符中 [ 出现的次数多于 ]，
并且(在前 i 个字符中 [ 的个数)−(在前 i 个字符中 ] 的个数)=j。我们想要的是 dp(N,0)
我们描述了 DP(动态规划)的转换。如果每个 ? 将前(i−1)个字符中的 [ 和 ] 替换为 [ 和 ]，
并且(前(i−1)个字符中的 [ 的数目)-(前(i−1)个字符中的 ] 的数目)=j，那么(前 i 个字符中的 [ 的数目)-(前 i 个字符中的 ] 的数目)变成 j+1 如果 Si = [， j−1 如果 Si = ]， j+1 和 j−1 如果 Si = ? 分别用 [ 和 ] 代替。
因此，过渡如下:如果 Si = [，则将 dpi,j 加到 dpi+1,j+1;如果 Si = ]，则将其加到 dp i+1,j−1; 如果 Si = ?，那么将它加到 dpi+1,j+1 和 dp i+1,j+1。
由于 DP 中有 O(n^2) 个状态，而每个状态的迁移花费为 O(1)，因此问题在总共 O(n^2) 个时间内得到了解决。
======

Input 1
(???(?
Output 1
2

Input 2
)))))
Output 2
0

Input 3
??????????????(????????(??????)?????????(?(??)
Output 3
603032273
 */