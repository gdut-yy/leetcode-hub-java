package p1825;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1825C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }
            System.out.println(solve(n, m, x));
        }
    }

    // https://codeforces.com/contest/1824/submission/205083763
    private static String solve(int n, int m, int[] x) {
        Set<Integer> set = new HashSet<>();
        int cnt1 = 0, cnt2 = 0;
        for (int xi : x) {
            if (xi == -1) cnt1++;
            else if (xi == -2) cnt2++;
            else set.add(xi);
        }

        int sz = set.size();
        int[] a = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(a);

        int ans = 0;
        ans = Math.max(ans, cnt1 + sz);
        ans = Math.max(ans, cnt2 + sz);
        ans = Math.min(ans, m);

        for (int i = 0; i < sz; i++) {
            int l = Math.min(a[i] - 1, i + cnt1);
            int r = Math.min(m - a[i], sz - 1 - i + cnt2);
            ans = Math.max(ans, l + 1 + r);
        }
        return String.valueOf(ans);
    }
}
/*
C. LuoTianyi and the Show
https://codeforces.com/contest/1825/problem/C

题目大意：
有 n 人参加了一个关于 VOCALOID 的节目。他们将坐在从左到右编号为 1 到 m 的一排座位上。
人们来了，按顺序坐下。每个人占据座位的方式有三种:
1. 坐在最左边已经坐着的人的左边，或者如果 1 号座位被占用了，那么就离开演出。如果目前没有人坐，请坐在 m 座。
2. 坐在已经坐下的最右边的人右边的座位上，或者如果座位 m 被占用了，那么就离开演出。如果没有人坐，请坐在 1 号座位上。
3. 坐在第 xi 号座位上。如果这个座位有人坐，请退场。
现在你想知道一个座位的最大人数是多少，如果你可以让人们以任何顺序进入演出?
---
如果 xi=-1，则第 i 个人坐第一种方式就坐。
如果 xi=-2，则第 i 个人以第二种方式就坐。
如果 xi>0，则第 i 个人以第三种方式就座，即他想坐在数字 xi 的座位上，如果这个座位有人，他就离开。

枚举
======

input
10
3 10
5 5 5
4 6
1 -2 -2 1
5 7
-1 -1 4 -2 -2
6 7
5 -2 -2 -2 -2 -2
6 6
-1 1 4 5 -1 4
6 8
-1 -1 -1 3 -1 -2
6 7
5 -1 -2 -2 -2 -2
3 1
-2 -2 1
2 5
5 -2
1 2
-1
output
1
3
5
6
5
5
5
1
2
1
 */
