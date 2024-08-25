package p1374;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CF1374E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] tab = new int[n][3];
        for (int i = 0; i < n; i++) {
            tab[i][0] = scanner.nextInt();
            tab[i][1] = scanner.nextInt();
            tab[i][2] = scanner.nextInt();
        }
        System.out.println(solve(n, k, tab));
    }

    private static String solve(int n, int k, int[][] tab) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> both = new ArrayList<>();
        for (int[] t : tab) {
            int t0 = t[0];
            int x = t[1] << 1 | t[2];

            if (x == 0b01) a.add(t0);
            else if (x == 0b10) b.add(t0);
            else if (x == 0b11) both.add(t0);
        }
        if (a.size() > b.size()) {
            List<Integer> tmp = new ArrayList<>(a);
            a = new ArrayList<>(b);
            b = tmp;
        }
        int na = a.size(), nb = both.size();
        if (na + nb < k) {
            return "-1";
        }

        Collections.sort(a);
        Collections.sort(b);
        if (na > k) {
            a = a.subList(0, k);
            na = k;
        }
        for (int i = 0; i < na; i++) {
            a.set(i, a.get(i) + b.get(i));
        }

        Collections.sort(both);
        if (nb > k) {
            both = both.subList(0, k);
            nb = k;
        }

        int s = 0;
        for (int v : both) {
            s += v;
        }
        for (int i = 0; i < k - nb; i++) {
            s += a.get(i);
        }

        int ans = s;
        // for i, v := range a[k-nb:] {}
        List<Integer> tmp = a.subList(k - nb, na);
        for (int i = 0; i < tmp.size(); i++) {
            s += tmp.get(i) - both.get(nb - 1 - i);
            ans = Math.min(ans, s);
        }
        return String.valueOf(ans);
    }
}
/*
E1. Reading Books (easy version)
https://codeforces.com/contest/1374/problem/E1

灵茶の试炼 2023-02-14
题目大意：
输入 n k (1≤k≤n≤2e5)，表示有 n 本书，然后输入 n 行，每行输入 t(1≤t≤1e4) a b，其中 a=0/1 表示 A 不喜欢/喜欢这本书，b=0/1 表示 B 不喜欢/喜欢这本书。
你需要选择一些书，使得其中至少有 k 本是 A 喜欢的，至少有 k 本是 B 喜欢的。
如果无法满足输出 -1，否则输出所选书的 t 之和的最小值。
进阶：如果要选恰好 m 本书呢？

rating 1600
https://codeforces.com/contest/1374/submission/193557671
提示：枚举有 x 本书是两个人都喜欢的。
剩下的就是选 k-x 本只有 A 喜欢的，k-x 本只有 B 喜欢的。
排序后用双指针加速计算。
进阶：https://codeforces.com/contest/1374/submission/193671570
======

input
8 4
7 1 1
2 1 1
4 0 1
8 1 1
1 0 1
1 1 1
1 0 1
3 0 0
output
18

input
5 2
6 0 0
9 0 0
1 0 1
2 1 1
5 1 0
output
8

input
5 3
3 0 0
2 1 0
3 1 0
5 0 1
3 0 1
output
-1
 */
