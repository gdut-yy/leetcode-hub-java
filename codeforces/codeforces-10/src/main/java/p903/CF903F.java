package p903;

import java.util.Scanner;

public class CF903F {
    static int n;
    static int[] a;
    static char[][] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[4];
        s = new char[4][];
        for (int i = 0; i < 4; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            s[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    static int[][][][][] memo;

    private static String solve() {
        memo = new int[n][4][1 << 4][1 << 4][1 << 4];
        int ans = dfs(n - 1, 0, 0, 0, 0);
        return String.valueOf(ans);
    }

    static int dfs(int j, int i, int cur, int pre, int pre2) {
        if (j < 0) {
            if (pre > 0 || pre2 > 0) {
                return a[3];
            }
            return 0;
        }
        if (i > 3) {
            if (pre2 > 0) {
                return dfs(j - 2, 0, 0, 0, 0) + a[3];
            }
            return dfs(j - 1, 0, 0, cur, pre);
        }
        if (memo[j][i][cur][pre][pre2] > 0) return memo[j][i][cur][pre][pre2] - 1;
        int res = dfs(j, i + 1, cur << 1 | (s[i][j] >> 2 & 1 ^ 1), pre, pre2);
        res = Math.min(res, dfs(j, i + 1, cur << 1, pre, pre2) + a[0]);
        res = Math.min(res, dfs(j, i + 2, cur << Math.min(4 - i, 2), pre & ~(3 << Math.max(2 - i, 0)), pre2) + a[1]);
        res = Math.min(res, dfs(j, i + 3, cur << Math.min(4 - i, 3), pre & ~(7 << Math.max(1 - i, 0)), pre2 & ~(7 << Math.max(1 - i, 0))) + a[2]);
        memo[j][i][cur][pre][pre2] = res + 1;
        return res;
    }
}
/*
F. Clear The Matrix
https://codeforces.com/contest/903/problem/F

灵茶の试炼 2024-11-15
题目大意：
输入 n(4≤n≤1000) 和长为 4 的数组 a(1≤a[i]≤1000)，以及一个 4 行 n 列的字符矩阵，只包含 '*' 和 '.'。
把一个 i*i 的子矩阵全部改成 '.' 的花费为 a[i]（i 从 1 开始）。
输出把矩阵字符全部变成 '.' 的最小总花费。

rating 2200
状压 DP。
我的建议是一个格子一个格子地计算，思维量会小很多。
把每列的 * 和 . 压缩成一个 0~15 的二进制数。
从右往左递归，需要知道：
当前在第 j 列、第 i 行，
第 j 列的二进制数 cur，
第 j+1 列的二进制数 pre，
第 j+2 列的二进制数 pre2。
定义 dfs(j,i,cur,pre,pre2) 表示在此状态下的最小花费。
注意 cur 会随着 i 的递归不断变化。
有四种情况（下标均从 0 开始）：
1. 什么也不做，直接递归到 dfs(j,i+1,cur<<1|s[i][j],pre,pre2)，其中 s[i][j] 为 1（对应 '*'）或者 0（对应 '.'）。
2. 使用 1x1：dfs(j,i+1,cur<<1,pre,pre2) + a[0]。
3. 使用 2x2，改第 i 和 i+1 行：dfs(j,i+2,cur<<min(4-i,2),pre&~mask2,pre2) + a[1]。其中 mask2=3<<max(2-i,0)，表示把第 i 和 i+1 行的字符改成 '.'。注意这里的 min 和 max 是因为当 i=3 的时候只能改第 i 和 i-1 行。
4. 使用 3x3，改第 i、i+1 和 i+2 行：dfs(j,i+3,cur<<min(4-i,3),pre&~mask3,pre2&~mask3) + a[2]。其中 mask3=7<<max(1-i, 0)。注意这里的 min 和 max 是因为当 i=2,3 的时候只能改第 i、i-1 和 i-2 行。
四种情况取最小值，得到 dfs(j,i,cur,pre,pre2)。
如果递归到 i>3 的情况（表示第 j 列考虑完毕）：
1. 如果 pre2 > 0，那么只能使用 4x4 覆盖掉，返回 dfs(j-2,0,0,0,0) + a[3]。
2. 否则 pre2 = 0，那么返回 dfs(j-1,0,0,cur,pre)。
递归边界（j < 0）：
1. 如果 pre > 0 或者 pre2 > 0，那么只能使用 4x4 覆盖掉，返回 a[3]。
2. 否则，返回 0。
递归入口：
dfs(n-1,0,0,0,0)。
注：代码直接用 0 表示没有记忆化（而不是用 -1）。为此需要在记忆化的时候 +1，以保证记录的数据是正数。取值的时候 -1 复原。
这一技巧对于 Java 选手也适用。
代码 https://codeforces.com/contest/903/submission/291446529
代码备份（洛谷）
======

Input
4
1 10 8 20
***.
***.
***.
...*
Output
9

Input
7
2 1 8 2
.***...
.***..*
.***...
....*..
Output
3

Input
4
10 10 1 10
***.
*..*
*..*
.***
Output
2
 */