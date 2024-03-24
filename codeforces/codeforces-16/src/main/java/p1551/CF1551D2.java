package p1551;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1551D2 {
    static int n, m, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        char[][] ans = new char[n][m];
        if (n % 2 == 1) {
            k -= m / 2;
            if (k < 0) {
                return "NO";
            }
            for (int j = 1; j < m; j += 2) {
                char c = (char) ('f' ^ (j / 2 % 2));
                ans[n - 1][j - 1] = c;
                ans[n - 1][j] = c;
            }
        } else if (m % 2 == 1) {
            if (k > m / 2 * n) {
                return "NO";
            }
            for (int i = 1; i < n; i += 2) {
                char c = (char) ('f' ^ (i / 2 % 2));
                ans[i - 1][m - 1] = c;
                ans[i][m - 1] = c;
            }
        }
        if (k % 2 == 1) {
            return "NO";
        }

        for (int i = 1; i < n; i += 2) {
            for (int j = 1; j < m; j += 2) {
                if (k > 0) {
                    k -= 2;
                    char c = (char) ('b' ^ (j / 2 % 2));
                    ans[i - 1][j - 1] = c;
                    ans[i - 1][j] = c;
                    ans[i][j - 1] = (char) (c ^ 1);
                    ans[i][j] = (char) (c ^ 1);
                } else {
                    char c = (char) ('d' ^ (i / 2 % 2));
                    ans[i - 1][j - 1] = c;
                    ans[i - 1][j] = (char) (c ^ 1);
                    ans[i][j - 1] = c;
                    ans[i][j] = (char) (c ^ 1);
                }
            }
        }
        return "YES" + System.lineSeparator() +
                Arrays.stream(ans).map(String::new).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
D2. Domino (hard version)
https://codeforces.com/contest/1551/problem/D2

灵茶の试炼 2022-08-29
题目大意：
本题分为简单版本和困难版本，在困难版本中，你需要额外输出具体的方案。
输入 t (≤10) 表示有 t 组数据。
每组数据输入 n (≤100)、m (m≤100) 和 k (0≤k≤n*m/2)，保证 n*m 是偶数。
请你在一个 n 行 m 列的网格中，放置 n*m/2 个 1*2 大小的骨牌，要求恰好有 k 个是横着放的，其余是竖着放的，且恰好铺满这一 n*m 的网格。
如果存在满足要求的铺设方案，输出 YES，否则输出 NO。
对于困难版本，如果答案存在，你需要额外输出 n 个长为 m 的由小写字母组成的字符串，表示你铺设的骨牌（多种方案输出任意一种）。要求：两个相邻的单元格拥有相同的字母，表明这两个单元格由同一个骨牌覆盖。具体输出样例见困难版本题目。

rating 2100
https://codeforces.com/problemset/submission/1551/170038881
提示 1：讨论 n 或 m 的奇偶性。什么情况下输出 NO？
提示 2：标准化，如果 n 和 m 都是偶数，构造起来就会方便不少。
如果 n 是奇数，我们可以先横着摆满最后一排（用字母 fg 交错），如果 k 不足 m/2 输出 NO，否则可以先 k-=m/2；
如果 m 是奇数，我们可以先竖着摆满最后一列（用字母 fg 交错），如果 k 超过 m/2*n 输出 NO。
这样剩余行列数均为偶数，如果 k 是奇数则输出 NO。
然后就可以愉快地构造了。用字母 bc 交错表示横着的，用字母 de 交错表示竖着的。
具体实现技巧见代码。
======

input
8
4 4 2
2 3 0
3 2 3
1 2 0
2 4 2
5 2 2
2 17 16
2 1 1
output
YES
accx
aegx
bega
bdda
YES
aha
aha
YES
zz
aa
zz
NO
YES
aaza
bbza
NO
YES
bbaabbaabbaabbaay
ddccddccddccddccy
NO
 */