package p1648;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1648A {
    static int n, m;
    static int[][] c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        c = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    static final int MAX_N = (int) (1e5 + 5);
    static long ans;

    private static String solve() {
        List<Integer>[] posI = new ArrayList[MAX_N];
        List<Integer>[] posJ = new ArrayList[MAX_N];
        Arrays.setAll(posI, e -> new ArrayList<>());
        Arrays.setAll(posJ, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                posI[c[i][j]].add(i);
                posJ[c[i][j]].add(j);
            }
        }
        ans = 0;
        for (int i = 0; i < MAX_N; i++) {
            f(posI[i]);
            posJ[i].sort(null);
            f(posJ[i]);
        }
        return String.valueOf(ans);
    }

    static void f(List<Integer> p) {
        long sj = 0;
        for (int i = 0; i < p.size(); i++) {
            long j = p.get(i);
            ans += i * j - sj;
            sj += j;
        }
    }
}
/*
A. Weird Sum
https://codeforces.com/contest/1648/problem/A

灵茶の试炼 2023-11-13
题目大意：
输入 n m (1≤n*m≤1e5) 和 n 行 m 列的矩阵 a，元素范围 [1,1e5]。
对于矩阵中的所有相同元素对，即满足 a[x1][y1] = a[x2][y2] 的元素对 (a[x1][y1], a[x2][y2])，把 abs(x1-x2) + abs(y1-y2) 加到答案中。
注意 (a,b) 和 (b,a) 只算一次。
输出答案。

rating 1400
提示 1：横纵坐标是互相独立的。
提示 2：贡献法，对于同一个元素，考虑它的所有纵坐标组成的数组 p，对于 p[i] 来说，它左边有 i 个数，距离之和就是
 (p[i]-p[0]) + (p[i]-p[1]) + ... + (p[i]-p[i-1])
= i*p[i] - (p[0]+p[1]+...+p[i-1])
所以排序后，遍历的同时维护前缀和即可。
https://codeforces.com/problemset/submission/1648/231922783
======

input
2 3
1 2 3
3 2 1
output
7

input
3 4
1 1 2 2
2 1 1 2
2 2 1 1
output
76

input
4 4
1 1 2 3
2 1 1 2
3 1 2 1
1 1 2 1
output
129
 */
