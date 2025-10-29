package p2126;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF2126D {
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
        int k = scanner.nextInt();
        int[][] a = new int[n][2]; // l, real
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int real = scanner.nextInt();
            a[i][0] = l;
            a[i][1] = real;
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[1]));

        for (int[] t : a) {
            if (t[0] <= k && k < t[1]) {
                k = t[1];
            }
        }
        out.println(k);
    }
}
/*
D. This Is the Last Time
https://codeforces.com/contest/2126/problem/D

灵茶の试炼 2025-08-02
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) k(0≤k≤1e9)，分别表示赌场的个数，你的初始钱数。
然后输入 n 个赌场的信息，每个赌场输入 L R real (0≤L≤real≤R≤1e9)。
对于每个赌场，如果你的钱数 k 在 [L,R] 中，则可以更新 k 为 real。
你可以按任何顺序进入赌场，不需要进入所有的赌场，每个赌场只能进入一次。
输出你最终的最大钱数。

rating 1200
直截了当，按照 real 排序。
如果 k 在 [l,real] 区间中，就立刻更新 k 为 real。
你可能会想，如果我这里不更新 k，后面另一个区间 [l2,real2] 再更新 k 呢？
如果可以这样做，那么 [l2,real2] 必然会包含 real，上面立刻更新的做法仍然是正确的。
代码 https://codeforces.com/contest/2126/submission/330760873
代码备份（Ubuntu Pastebin）
======

Input
5
3 1
2 3 3
1 2 2
3 10 10
1 0
1 2 2
1 2
1 2 2
2 2
1 3 2
2 4 4
2 5
1 10 5
3 6 5
Output
10
0
2
4
5
 */
