package p1142;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1142B {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
        int[] p = new int[n];
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
            if (i > 0) pre[p[i]] = p[i - 1];
        }
        pre[p[0]] = p[n - 1];
        int[][] jumpL = new int[m + 1][18];
        int[] last = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int v = scanner.nextInt();
            jumpL[i][0] = last[pre[v]];
            last[v] = i;
        }
        for (int j = 0; j < 17; j++) {
            for (int i = 0; i < jumpL.length; i++) {
                jumpL[i][j + 1] = jumpL[jumpL[i][j]][j];
            }
        }
        int[] maxL = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            int cur = i;
            for (int s = n - 1; s > 0; s &= s - 1) {
                cur = jumpL[cur][Integer.numberOfTrailingZeros(s)];
            }
            maxL[i] = Math.max(maxL[i - 1], cur);
        }
        char[] ans = new char[q];
        Arrays.fill(ans, '0');
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt(), r = scanner.nextInt();
            if (l <= maxL[r]) ans[i] = '1';
        }
        out.print(new String(ans));
    }
}
/*
B. Lynyrd Skynyrd
https://codeforces.com/contest/1142/problem/B

灵茶の试炼 2026-05-15
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤2e5) q(1≤q≤2e5)，长为 n 的 1~n 的排列 p，长为 m 的数组 a(1≤a[i]≤n)。下标从 1 开始。
然后输入 q 个询问，每个询问输入 L R(1≤L≤R≤m)。
对于每个询问，判断在 a 的子数组 [L,R] 中，是否存在一个长为 n 的子序列 b，满足 b 恰好是 p 的某个循环移位？
如果是，输出 '1'，否则输出 '0'。
注：p 的循环移位是 p[i:] + p[:i]。例如 p=[1,2,3]，那么 [1,2,3], [2,3,1], [3,1,2] 都是 p 的循环移位。

rating 2000
设子序列的最后一个数是 a[i]（i <= R），我们需要计算，从 i 往左跳 n 步的位置是否在 [L,R] 内，即是否 >= L。
往左跳的意思是？且听我说。
对于 p 中的元素 x，设 x 的左侧相邻元素为 pre[x]。
对于 a 中的元素 a[i]，设 pre[a[i]] 最近出现的下标为 j，连一条从 i 到 j 的边。
我们需要求出从 i 往左移动 n 步后的位置。这可以用倍增算法解决。倍增算法原理讲解。
此外，我们还需要求出从任意 <= R 的位置往左跳 n 步后，跳到的位置中的最大值。如果 L <= 这个最大值，那么可以在 [L,R] 中找到满足要求的子序列。
设从 i 往左跳 n 步的位置为 pos[i]，计算 pos 的前缀最大值。
注：本题有线性做法，见洛谷题解。
代码 https://codeforces.com/problemset/submission/1142/374450936
代码备份（上面打不开的同学看这个）
======

Input
3 6 3
2 1 3
1 2 3 1 2 3
1 5
2 6
3 5
Output
110

Input
2 4 3
2 1
1 1 2 2
1 2
2 3
3 4
Output
010
 */
