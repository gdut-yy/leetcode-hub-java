package p1980;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1980E {
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

    static int n, m;

    static int compare(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);
        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) return a[i] - b[i];
        }
        return a.length - b.length;
    }

    static int[][][] readMatrix() {
        int[][] rows = new int[n][m];
        int[][] cols = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rows[i][j] = scanner.nextInt();
                cols[j][i] = rows[i][j];
            }
        }
        for (int i = 0; i < n; i++) Arrays.sort(rows[i]);
        for (int j = 0; j < m; j++) Arrays.sort(cols[j]);
        Arrays.sort(rows, (a, b) -> compare(a, b));
        Arrays.sort(cols, (a, b) -> compare(a, b));
        return new int[][][]{rows, cols};
    }

    private static void solve() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[][][] m1 = readMatrix();
        int[][][] m2 = readMatrix();
        for (int i = 0; i < n; i++) {
            if (!Arrays.equals(m1[0][i], m2[0][i])) {
                out.println("NO");
                return;
            }
        }
        for (int j = 0; j < m; j++) {
            if (!Arrays.equals(m1[1][j], m2[1][j])) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }
}
/*
E. Permutation of Rows and Columns
https://codeforces.com/contest/1980/problem/E

灵茶の试炼 2026-02-11
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n*m 之和 ≤2e5。
每组数据输入 n m (1≤n*m≤2e5) 和两个 n 行 m 列的矩阵，分别记作 a 和 b，元素范围 [1,nm]。
保证矩阵 a 是一个排列，即 [1,nm] 中的每个整数恰好出现一次。
保证矩阵 b 是一个排列，即 [1,nm] 中的每个整数恰好出现一次。
每次操作，你可以：
交换 a 中的任意两行，或者，交换 a 中的任意两列。
能否通过若干次操作，把 a 变成 b？
输出 YES 或 NO。

rating 1600
（结论好猜，如何证明？）
操作不会改变什么？
列与列的交换不会改变每一行的元素（元素集合不变）。
行与行的交换不会改变每一列的元素（元素集合不变）。
所以矩阵 a 要能变成矩阵 b，必要条件是两个矩阵有相同的行集合，有相同的列集合，意思是：
(a 的每一行排序，再把 a 的所有行按照字典序排序) == (b 的每一行排序，再把 b 的所有行按照字典序排序)
(a 的每一列排序，再把 a 的所有列按照字典序排序) == (b 的每一列排序，再把 b 的所有列按照字典序排序)
下面说明这也是充分的。意思是，如果操作后，a 的每一行的元素集合与 b 的相等，每一列的元素集合与 b 的相等，那么 a == b 一定成立。
你可能会问：我们只保证了集合相等，万一元素顺序不一样呢？
比如交换后，a 和 b 第一行的元素集合都是 {1,5,9}，第三列的元素集合都是 {1,3,6}。
由于只有元素 1 同时属于第一行和第三列，所以操作后，a[1][3] == b[1][3]。
（不可能出现第一行是 5,1,9，第三列是 3,1,6 的情况，第一行第三列那个数不能又是 9 又是 3）
一般地，在矩阵元素互不相同的前提下，恰好有一个数既属于第 i 行，又属于第 j 列。
如果操作后，a 和 b 的第 i 行的元素集合相等，第 j 列的元素集合相等，那么行列元素集合的交集也相等。在矩阵元素互不相同的前提下，交集的大小恰好是 1。
交集元素即第 i 行第 j 列的元素，这意味着操作后，a[i][j] == b[i][j]，所以 a == b。
代码 https://codeforces.com/problemset/submission/1980/362197890
代码备份（上面打不开的同学看这个）
======

Input
7
1 1
1
1
2 2
1 2
3 4
4 3
2 1
2 2
1 2
3 4
4 3
1 2
3 4
1 5 9 6
12 10 4 8
7 11 3 2
1 5 9 6
12 10 4 8
7 11 3 2
3 3
1 5 9
6 4 2
3 8 7
9 5 1
2 4 6
7 8 3
2 3
1 2 6
5 4 3
6 1 2
3 4 5
1 5
5 1 2 3 4
4 2 5 1 3
Output
YES
YES
NO
YES
YES
NO
YES
 */
