package c403;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc403_d {
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

    static final int INF = (int) 1e9;

    private static void solve() {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        if (d == 0) {
            d = INF;
        }
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            g.computeIfAbsent(v % d, k -> new ArrayList<>()).add(v);
        }
        if (d == INF) {
            out.println(n - g.size());
            return;
        }
        int ans = n;
        for (List<Integer> a : g.values()) {
            Collections.sort(a);
            int f0 = 0, f1 = 0;
            int cnt = 0;
            for (int i = 0; i < a.size(); i++) {
                int v = a.get(i);
                cnt++;
                if (i == a.size() - 1 || a.get(i + 1) - v == d) {
                    int tmp = f1;
                    f1 = Math.max(f1, f0 + cnt);
                    f0 = tmp;
                    cnt = 0;
                } else if (a.get(i + 1) > v) {
                    ans -= Math.max(f1, f0 + cnt);
                    f0 = 0;
                    f1 = 0;
                    cnt = 0;
                }
            }
            ans -= f1;
        }
        out.println(ans);
    }
}
/*
D - Forbidden Difference
https://atcoder.jp/contests/abc403/tasks/abc403_d

灵茶の试炼 2026-05-26
题目大意：
输入 n(1≤n≤2e5) d(0≤d≤1e6) 和长为 n 的数组 a(0≤a[i]≤1e6)。
从 a 中移除尽量少的数，使得 a 中任意两数的绝对差都不等于 d。
输出最少要移除多少个数。

rating
d=1 怎么做？
这题是 LC740. 删除并获得点数。
两数之差为 d 的必要条件是两数模 d 同余。
按照模 d 分组。
同一组内的数，统计元素出现次数，变成 LC198. 打家劫舍。
比如 d=2，某一组的数为 [2,2,4,8,8,8]，相当于频率数组 [2,1,0,3]。
可以写分组循环，也可以直接一次遍历，具体看我代码。
用 n 减去最多保留的元素个数。
注意特判 d=0 的情况，答案为 n - 不同元素个数。
代码 https://atcoder.jp/contests/abc403/submissions/75781658
======

Input 1
5 2
3 1 4 1 5
Output 1
1

Input 2
4 3
1 6 1 8
Output 2
0

Input 3
10 3
1 6 2 10 2 3 2 10 6 4
Output 3
2
 */

