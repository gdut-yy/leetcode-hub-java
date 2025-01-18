package p1700;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CF1700E {
    static int n, m;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    record pair(int i, int j) {
    }

    private static final int[][] DIRECTIONS5 = {{0, 0}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static String solve() {
        List<pair> badPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!ok(i, j)) {
                    badPos.add(new pair(i, j));
                }
            }
        }
        if (badPos.isEmpty()) return "0";

        Set<pair> ans = new HashSet<>();
        // 除了交换 (bi,bj)，也可以通过交换 (bi,bj) 的邻居，使 (bi,bj) 变成一个好格子
        // 只需检查至多 5 个位置，因为 (bi,bj) 必须变成好格子
        int bi = badPos.getFirst().i;
        int bj = badPos.getFirst().j;
        for (int[] d : DIRECTIONS5) {
            int pi = bi + d[0];
            int pj = bj + d[1];
            if (pi < 0 || pi == n || pj < 0 || pj == m) continue;
            for (int i = 0; i < n; i++) {
                next:
                for (int j = 0; j < m; j++) {
                    swap(pi, pj, i, j);
                    // 交换离坏格子很远的点，必然是无效交换，所以先检查是否有坏格子仍然是坏格子
                    for (pair q : badPos) {
                        if (!ok(q.i, q.j)) {
                            swap(pi, pj, i, j);
                            continue next;
                        }
                    }
                    // 有效交换！进一步检查受到影响的 10 个点是否正常
                    if (ok2(pi, pj) && ok2(i, j)) {
                        // 注意去重
                        pair new_pair = new pair(Math.min(pi * m + pj, i * m + j), Math.max(pi * m + pj, i * m + j));
                        ans.add(new_pair);
                    }
                    swap(pi, pj, i, j);
                }
            }
        }
        if (!ans.isEmpty()) {
            return "1 " + ans.size();
        }
        return "2";
    }

    static void swap(int pi, int pj, int i, int j) {
        // 交换其他所有点
        int tmp = a[pi][pj];
        a[pi][pj] = a[i][j];
        a[i][j] = tmp;
    }

    // 好格子：自己是 1，或者存在一个小于自己的邻居
    static boolean ok(int i, int j) {
        return a[i][j] == 1 ||
                j > 0 && a[i][j - 1] < a[i][j] ||
                j + 1 < m && a[i][j + 1] < a[i][j] ||
                i > 0 && a[i - 1][j] < a[i][j] ||
                i + 1 < n && a[i + 1][j] < a[i][j];
    }

    // 判断 (i,j)，以及 (i,j) 的邻居，是否都是好格子
    static boolean ok2(int i, int j) {
        return ok(i, j) &&
                (j == 0 || ok(i, j - 1)) &&
                (j + 1 == m || ok(i, j + 1)) &&
                (i == 0 || ok(i - 1, j)) &&
                (i + 1 == n || ok(i + 1, j));
    }
}
/*
E. Serega the Pirate
https://codeforces.com/contest/1700/problem/E

灵茶の试炼 2024-10-18
题目大意：
输入 n m(1≤n*m≤4e5) 和 n 行 m 列的网格图，元素范围 [1,n*m]。保证范围中的每个数都恰好出现一次。
你从值为 1 的格子出发。每一步，只能走上下左右相邻的格子。
你可以重复访问同一个格子。
目标：访问所有格子，并满足，如果 x < y，那么访问元素值 x 的时间必须早于访问元素值 y 的时间。
你可以通过交换两个任意位置的格子（无需相邻）来实现目标。
输出最小交换次数，具体如下：
如果不用交换，输出 0。
如果至少要交换 2 次，输出 2。
如果只需交换 1 次，输出 1，以及方案数。

rating 2600
https://www.luogu.com.cn/article/hphgs19a
======

Input
3 3
2 1 3
6 7 4
9 8 5
Output
0

Input
2 3
1 6 4
3 2 5
Output
1 3

Input
1 6
1 6 5 4 3 2
Output
2
 */
