package p543;

import java.util.Arrays;
import java.util.Scanner;

public class CF543C {
    static int n, m;
    static char[][] a;
    static int[][] cost;
    static int[] rowCost;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new char[n][];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        cost = new int[n][m];
        rowCost = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cost[i][j] = scanner.nextInt();
            }
            rowCost[i] = Arrays.stream(cost[i]).min().orElseThrow();
        }
        System.out.println(solve());
    }

    static class pair {
        int t, cost;

        public pair(int t, int cost) {
            this.t = t;
            this.cost = cost;
        }
    }

    private static final int INF = (int) 1e9;

    private static String solve() {
        pair[][] colCost = new pair[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.setAll(colCost[i], e -> new pair(0, 0));
        }

        for (int i = 0; i < n; i++) {
            char[] s = a[i];
            for (int j = 0; j < s.length; j++) {
                int mx = 0;
                for (int k = 0; k < n; k++) {
                    char[] t = a[k];
                    if (t[j] == s[j]) {
                        colCost[i][j].t |= 1 << k;
                        colCost[i][j].cost += cost[k][j];
                        mx = Math.max(mx, cost[k][j]);
                    }
                }
                colCost[i][j].cost -= mx;
            }
        }

        int u = 1 << n;
        int[] f = new int[u];
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int s = 0; s < u - 1; s++) {
            int fs = f[s];
            int i = Integer.numberOfTrailingZeros(~s);
            f[s | (1 << i)] = Math.min(f[s | (1 << i)], fs + rowCost[i]);
            for (pair p : colCost[i]) {
                f[s | p.t] = Math.min(f[s | p.t], fs + p.cost);
            }
        }
        return String.valueOf(f[u - 1]);
    }
}
/*
C. Remembering Strings
https://codeforces.com/contest/543/problem/C

灵茶の试炼 2025-05-02
题目大意：
输入 n m(1≤n,m≤20) 和长为 n 的字符串数组 s，长度均为 m，只包含小写英文字母。
输入 n 行 m 列的矩阵 cost，元素范围 [0,1e6]。
对于字符串 s[i] 来说，如果存在一个 j，满足 s[i][j] 与第 j 列的其他字母都不一样，那么称 s[i] 是容易记忆的。
你可以修改 s[i][j] 为任意小写英文字母，花费为 cost[i][j]。
把这 n 个字符串都变成容易记忆的，最小总花费是多少？

rating 2500
由于 n <= 20 < 26，我们总是可以把 s[i][j] 改成不在第 j 列中的字母，使 s[i] 是容易记忆的。
对于 s[i]，有两种改法，使 s[i] 是容易记忆的：
1. 横着看。单改 s[i] 中的某个字母，便可使 s[i] 是容易记忆的。那么贪心地，选择这一行最小的花费，记作 rowCost[i]。
2. 竖着看。对于 s[i][j]，第 j 列的所有与 s[i][j] 相同的字母，可以改成互不相同的。设第 j 列中的与 s[i][j] 相同的字符串的下标集合为 T（包含 i），那么贪心地，选择 T 中的最大花费不改，其余的随便改。这样 T 中的所有字符串都是容易记忆的。花费为 T 的所有花费之和，减去其中的最大花费，结果记作 colCost[i][j]。
定义 f[S] 表示把下标集合 S 中的字符串都变成容易记忆的，需要的最小花费。
选择 S 中的最小下标 i，把 s[i]（横着或者竖着）改成容易记忆的。为什么只需选择最小下标？比如有三个字符串，无论我们按照什么顺序处理，都是一样的，那么不妨人为规定一个顺序，即优先处理下标最小的字符串。
横：用 f[S]+rowCost[i]，去更新 f[S|1<<i] 的最小值。（刷表法）
竖：枚举改第 j 列，用 f[S]+colCost[i][j]，去更新 f[S|T] 的最小值。
初始值 f[0] = 0，其余 inf。
答案为 f[U]，其中 U 是 0~n-1 的全集。
代码 https://codeforces.com/problemset/submission/543/317521335
代码备份（洛谷）
======

Input
4 5
abcde
abcde
abcde
abcde
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
Output
3

Input
4 3
abc
aba
adc
ada
10 10 10
10 1 10
10 10 10
10 1 10
Output
2

Input
3 3
abc
ada
ssa
1 1 1
1 1 1
1 1 1
Output
0
 */
