package p1580;

import java.util.Arrays;
import java.util.Scanner;

public class CF1580B {
    static int n, m, k, mod;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        mod = scanner.nextInt();
        System.out.println(solve());
    }

    static final int mx = 100;
    static long[] F;
    static long[][] C;
    static long[][][] memo;

    private static String solve() {
        F = new long[mx];
        F[0] = 1;
        for (int i = 1; i < mx; i++) {
            F[i] = F[i - 1] * i % mod;
        }
        C = new long[mx][mx];
        for (int i = 0; i < mx; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % mod;
            }
        }

        memo = new long[m][n + 1][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n + 1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        long ans = dfs(m - 1, n, k);
        return String.valueOf(ans);
    }

    static long dfs(int dep, int size, int need) {
        if (dep < 0) {
            if (need > 0) {
                return 0;
            }
            return F[size]; // 随便排
        }
        if (size == 0) {
            return 1;
        }
        if (memo[dep][size][need] != -1) return memo[dep][size][need];

        int nxt_need = need;
        if (dep == 0) { // 这是我们要找的
            nxt_need--;
        }

        long res = 0;
        for (int leftSz = 0; leftSz < size; leftSz++) {
            for (int leftNeed = Math.max(nxt_need - (size - 1 - leftSz), 0); leftNeed <= Math.min(leftSz, nxt_need); leftNeed++) {
                long leftRes = dfs(dep - 1, leftSz, leftNeed);
                if (leftRes == 0) { // 剪枝，右子树不递归
                    continue;
                }
                long rightRes = dfs(dep - 1, size - 1 - leftSz, nxt_need - leftNeed);
                res = (res + C[size - 1][leftSz] * leftRes % mod * rightRes) % mod;
            }
        }
        return memo[dep][size][need] = res;
    }
}
/*
B. Mathematics Curriculum
https://codeforces.com/contest/1580/problem/B

灵茶の试炼 2025-05-30
题目大意：
输入 n(1≤n≤100) m(1≤m≤n) k(1≤k≤n) mod(1≤mod≤1e9)。
对于数组 A 的所有包含 A[i] 的连续子数组 B，把 max(B) 记录到集合 S 中，如果 |S| = m，也就是恰好有 m 个不同的 max(B)，则称 A[i] 是好数。
输出有多少个 1~n 的排列 A，满足 A 中恰好有 k 个好数。
答案模 mod。

rating 2600
把排列转化成大根笛卡尔树，问题变成：https://oi-wiki.org/ds/cartesian-tree/
在大小为 n 的大根笛卡尔树中，深度为 m-1 的节点恰好有 k 个。
比如根节点的值最大，深度为 0，任意包含根节点的区间最大值都等于根节点的值。
推荐写记忆化搜索，可以剪枝。
定义 dfs(dep, size, need) 表示：
当前距离 m-1 的剩余深度为 dep。
子树大小为 size。
需要在子树中找到 need 个好数（好节点）。
首先，如果 dep = 0，那么把 need 减一。
然后枚举分配给左子树 leftSz 个节点，那么分配给右子树就是 size-1-leftSz 个节点。
内层循环枚举分配给左子树 leftNeed 个好节点，那么分配给右子树 need-leftNeed 个好节点。
从 size-1 个节点中选择 leftSz 个节点的方案数为 C(size-1, leftSz)。注：本题 mod 不一定是质数，逆元不一定存在，用 O(100^2) 的递推预处理组合数。
左子树方案数为 dfs(dep-1, leftSz, leftNeed)。
右子树方案数为 dfs(dep-1, size-1-leftSz, need-leftNeed)。
三者相乘，加到返回值中。
枚举范围：
leftSz 从 0 到 size-1。
因为要保证左右子树的 need <= size，所以 leftNeed 从 max(need-(size-1-leftSz), 0) 到 min(leftSz, need)。
递归边界：
1. 如果 dep < 0，无需继续递归：
1.1. 如果 need > 0，不合法，返回 0；
1.2. 否则 need = 0，这 size 个节点随意排列，有 size! 个方案。注：预处理阶乘。
2. 如果 size = 0，我们找到了一个合法方案，返回 1。
递归入口：
dfs(m-1, n, k)。
重要剪枝：
如果递归左子树的返回值是 0，那么无需递归右子树，因为乘积一定是 0。
时间复杂度是 O(n^2 * m * k^2)，不过由于剪枝、循环长度等因素，常数很小。
代码 https://codeforces.com/contest/1580/submission/321732868
代码备份（洛谷）
======

Input
4 3 2 10007
Output
4

Input
6 4 1 769626776
Output
472

Input
66 11 9 786747482
Output
206331312

Input
99 30 18 650457567
Output
77365367
 */
