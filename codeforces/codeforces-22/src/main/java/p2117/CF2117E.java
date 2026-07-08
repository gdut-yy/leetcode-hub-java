package p2117;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2117E {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) a[i][0] = scanner.nextInt();
        for (int i = 0; i < n; i++) a[i][1] = scanner.nextInt();
        int[][] pos = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i][0] == a[i][1]) {
                out.println(i + 1);
                return;
            }
            for (int j = 0; j < 2; j++) {
                int v = a[i][j];
                if (pos[v][j] > 0 || pos[v][j ^ 1] - i > 1) {
                    out.println(i + 1);
                    return;
                }
                if (pos[v][j] == 0) {
                    pos[v][j] = i;
                }
            }
        }
        out.println(0);
    }
}
/*
E. Lost Soul
https://codeforces.com/contest/2117/problem/E

灵茶の试炼 2026-03-11
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和两个长为 n 的数组 a b，元素范围 [1,n]。
首先，你可以执行如下操作至多 1 次：
选择一个下标 i，删除 a[i] 和 b[i]。
然后，你可以执行如下操作任意多次：
选择一个下标 i，把 a[i] 更新为 b[i+1]，或者把 b[i] 更新为 a[i+1]。
最多可以有多少个 j，满足 a[j] == b[j]？

rating 1600
把 a 和 b 排成两排，得到一个 2 行 n 列的矩阵 A。
请读者在纸上画一画，在矩阵 A 上，操作是什么样的。
如果某一列两个数相同（都是 x），那么这两个数可以把左边所有数都变成 x。
这启发我们从右往左思考，只要能让某一列相同，就可以算出答案。
如果遍历到 x = A[i][j] 时，发现 x 在 i 行（同一行）的右侧出现过，那么可以把 A[i^1][j] 也变成 x：
- 如果另一个 x 与 A[i][j] 的列号之差是奇数（比如相邻），那么无需删除元素，即可让 A[i^1][j] 是 x。
- 如果另一个 x 与 A[i][j] 的列号之差是偶数，那么删除 j+1 列，即可让 A[i^1][j] 是 x。
同理，如果遍历到 x = A[i][j] 时，发现 x 在 i^1 行的右侧出现过，且两个数至少间隔一列（下标之差大于 1），那么可以把 A[i^1][j] 也变成 x。
特别地，如果某一列两个数相同，即 A[i][j] = A[i^1][j]，那么 i 及其左侧的列可以都变成同一个数。
如果遍历完了也没遇到上述情况，输出 0。
代码 https://codeforces.com/problemset/submission/2117/365954815
代码备份（上面打不开的同学看这个）
======

Input
10
4
1 3 1 4
4 3 2 2
6
2 1 5 3 6 4
3 2 4 5 1 6
2
1 2
2 1
6
2 5 1 3 6 4
3 5 2 3 4 6
4
1 3 2 2
2 1 3 4
8
3 1 4 6 2 2 5 7
4 2 3 7 1 1 6 5
10
5 1 2 7 3 9 4 10 6 8
6 2 3 6 4 10 5 1 7 9
5
3 2 4 1 5
2 4 5 1 3
7
2 2 6 4 1 3 5
3 1 6 5 1 4 2
5
4 1 3 2 5
3 2 1 5 4
Output
3
3
0
4
3
5
6
4
5
2
 */
