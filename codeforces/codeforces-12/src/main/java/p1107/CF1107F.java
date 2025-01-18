package p1107;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF1107F {
    static int n;
    static int[][] a; // a, b, k

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
            a[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static long[][] memo;

    private static String solve() {
        Arrays.sort(a, Comparator.comparingInt(o -> -o[1]));

        memo = new long[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        long ans = 0;
        for (int j = 0; j <= n; j++) {
            ans = Math.max(ans, dfs(n - 1, j));
        }
        return String.valueOf(ans);
    }

    static long dfs(int i, int j) {
        if (i < 0) {
            return 0;
        }
        if (memo[i][j] != -1) return memo[i][j];
        int[] t = a[i];
        long res = dfs(i - 1, j) + Math.max(t[0] - (long) t[1] * t[2], 0);
        if (j > 0) {
            res = Math.max(res, dfs(i - 1, j - 1) + t[0] - t[1] * (j - 1L));
        }
        return memo[i][j] = res;
    }
}
/*
F. Vasya and Endless Credits
https://codeforces.com/contest/1107/problem/F

灵茶の试炼 2024-09-20
题目大意：
输入 n(1≤n≤500) 和 n 个三元组 (ai,bi,ki)，元素范围 [1,1e9]。
银行提供 n 个贷款业务。
第 i 个贷款，可以贷到 ai 元钱，分期 ki 个月，每月底还 bi 元钱（从办理贷款当月开始还）。
只能在月初办理贷款，且每月只能办理一个贷款。
同一个贷款不能重复办理。
张三想在未来某个月的中旬买一辆车，买车的钱全部来自贷款。
输出这辆车的最高价格。
注：张三并不在乎买车后要还银行多少钱。他只是开着车出了国，这样银行就再也找不到他了。

rating 2600
可以用费用流或者 KM 算法做，不过这里只说更快的贪心 + DP 做法。
有两个贪心的想法：
贪心策略一：如果某个贷款的 a - b * k > 0，那么直接白嫖 a - b * k 元钱。注意这只是一个可选项，这样的贷款也可以使用下面的贪心策略二。
贪心策略二：假设我们最终办理了 m 个贷款，那么这 m 个贷款的办理顺序按照 b 从小到大排序，依次办理（每月办理一个）是最优的。特别地，最后办理的贷款，办理完就直接跑路，白嫖 a 元钱。
为了方便计算，按照 b 从大到小排序，也就是把最后办理的贷款排在左边。
问题相当于给你两个序列：
A = [0,1,2,...]，表示需要还钱的月份数。
B = [(a0,b0,k0),(a1,b1,k1),(a2,b2,k2),...]，表示按照 b 从大到小排序后的贷款列表。
我们要从 B 中选一个子序列，和 A 的前缀匹配（类似上周周赛第二题）。
最左边的贷款可以得到 a0 元钱（办理完就跑路），其次的贷款可以得到 a1-b1 元钱，依此类推，第 j 个贷款可以得到 a1-b1*(j-1) 元钱。
定义 f(i,j) 表示从前 i 个贷款中选一个长为 j 的子序列，与上文 A 数组的前缀匹配，所得到的最大收益。
分类讨论：
1. 不选 B[i]，那么 f(i,j) = f(i-1,j)。
2. 选 B[i]，但直接白嫖（贪心策略一），f(i,j) = f(i-1,j) + max(a-b*k,0)。注意 j 是不变的，因为完全可以把这个贷款独立出来办理，躺赚 max(a-b*k,0) 元钱。
3. 选 B[i]，且 j-1 个月之后就跑路（贪心策略二），f(i,j) = f(i-1,j-1) + a-b*(j-1)。注意只有在 j > 0 时才能转移。
三者取最大值。
递归边界：f(-1,j) = 0。
答案：max(f(n-1,0), f(n-1,1), f(n-1,2), ..., f(n-1,n))。
记忆化搜索 https://codeforces.com/contest/1107/submission/281804550
1:1 翻译成递推 https://codeforces.com/contest/1107/submission/281804891
空间压缩 https://codeforces.com/contest/1107/submission/281804982
空间压缩（写法二） https://codeforces.com/contest/1107/submission/281805454
======

Input
4
10 9 2
20 33 1
30 115 1
5 3 2
Output
32

Input
3
40 1 2
1000 1100 5
300 2 1
Output
1337
 */
