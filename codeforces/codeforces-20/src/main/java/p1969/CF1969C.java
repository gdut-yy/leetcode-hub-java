package p1969;

import java.util.Arrays;
import java.util.Scanner;

public class CF1969C {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static long[][] memo;

    private static String solve() {
        memo = new long[n][11];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        long ans = dfs(n - 1, k);
        return String.valueOf(ans);
    }

    static long dfs(int i, int j) {
        if (i < 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        long res = dfs(i - 1, j) + a[i];
        int mn = a[i];
        for (int l = i - 1; l >= Math.max(i - j, 0); l--) {
            mn = Math.min(mn, a[l]);
            int t = i - l;
            res = Math.min(res, dfs(l - 1, j - t) + mn * (t + 1L));
        }
        return memo[i][j] = res;
    }
}
/*
C. Minimizing the Sum
https://codeforces.com/contest/1969/problem/C

灵茶の试炼 2024-09-04
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(1≤n≤3e5) k(0≤k≤10) 和长为 n 的数组 a(1≤a[i]≤1e9)。
如下操作，至多执行 k 次：
选择 a 中两个相邻元素 a[i] 和 a[i+1]，更新 a[i]=a[i+1]，或者更新 a[i+1]=a[i]。
输出 sum(a) 的最小值。
进阶：输出具体操作方案。

rating 1700
类似划分型 DP（见我动态规划题单第六章），定义 dfs(i,j) 表示考虑 a[0]~a[i]，至多操作 j 次时的最小和。
不操作：dfs(i,j) = dfs(i-1,j)
操作，枚举操作次数，或者操作的这一段子数组的左端点 L，那么：
操作了 t=i-L 次，子数组所有元素变成子数组最小值 mn = min(a[L],a[L+1],...,a[i])，得
dfs(i,j) = dfs(L-1,j-t) + mn * (t+1)
这些情况取最小值，即 dfs(i,j)
递归边界：dfs(-1,j)。
答案：dfs(n-1,k)。
记忆化搜索 https://codeforces.com/contest/1969/submission/279447388
1:1 翻译成递推 https://codeforces.com/contest/1969/submission/279447734
======

Input
4
3 1
3 1 2
1 3
5
4 2
2 2 1 3
6 3
4 1 2 2 4 3
Output
4
5
5
10
 */
