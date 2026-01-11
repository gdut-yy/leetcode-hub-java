package p2161;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF2161D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        List<Integer>[] pos = new ArrayList[n + 1];
        Arrays.setAll(pos, e -> new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            pos[v].add(i);
        }

        int[] f = new int[n + 1];
        int mx = 0;

        for (int x = 1; x <= n; x++) {
            List<Integer> p = pos[x - 1];
            List<Integer> q = pos[x];
            int sufMax = 0;
            int j = p.size() - 1;

            for (int i = q.size() - 1; i >= 0; i--) {
                while (j >= 0 && p.get(j) > q.get(i)) {
                    sufMax = Math.max(sufMax, f[p.get(j)]);
                    j--;
                }
                sufMax++;
                f[q.get(i)] = Math.max(sufMax, mx + (q.size() - i));
            }

            for (int idx : p) {
                mx = Math.max(mx, f[idx]);
            }
        }

        int maxF = Arrays.stream(f).max().orElseThrow();
        out.println(n - maxF);
    }
}
/*
D. Locked Out
https://codeforces.com/contest/2161/problem/D

灵茶の试炼 2025-11-20
题目大意：
输入 T(≤6e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(1≤n≤3e5) 和长为 n 的数组 a(1≤a[i]≤n)。
删除 a 中的一些元素，得到数组 b。
要求 b 满足：不存在 i < j 且 b[j] - b[i] = 1 的下标对 (i, j)。
最少要删多少个数？

rating 2100
https://www.luogu.com.cn/article/dvt8t11y
======

Input
6
1
1
5
1 2 3 4 5
5
5 4 3 2 1
5
5 5 5 4 4
7
1 7 1 2 5 7 1
6
1 2 5 6 5 5
Output
0
2
0
0
1
2
 */
