package c165;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc165_f {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        g = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g.computeIfAbsent(v, key -> new ArrayList<>()).add(w);
            g.computeIfAbsent(w, key -> new ArrayList<>()).add(v);
        }
        System.out.println(solve());
    }

    static Map<Integer, List<Integer>> g;
    static List<Integer> dp;
    static int[] ans;

    private static String solve() {
        dp = new ArrayList<>();
        ans = new int[n];

        f(0, -1);
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static void f(int v, int fa) {
        int i = searchInts(dp, a[v]);
        if (i < dp.size()) {
            int old = dp.get(i);
            dp.set(i, a[v]);
            ans[v] = dp.size();
            for (Integer w : g.getOrDefault(v, new ArrayList<>())) {
                if (w != fa) {
                    f(w, v);
                }
            }
            dp.set(i, old);
        } else {
            dp.add(a[v]);
            ans[v] = dp.size();
            for (Integer w : g.getOrDefault(v, new ArrayList<>())) {
                if (w != fa) {
                    f(w, v);
                }
            }
            dp.remove(dp.size() - 1);
        }
    }

    private static int searchInts(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
F - LIS on Tree
https://atcoder.jp/contests/abc165/tasks/abc165_f

灵茶の试炼 2022-10-31
题目大意：
输入 n (2≤n≤2e5) 和长为 n 的数组 a (1≤a[i]≤1e9)，表示每个节点的点权。
然后输入一棵树的 n-1 条边（节点编号从 1 开始）。
输出 n 个数，第 i 个数为从节点 1 到节点 i 的路径上点权的 LIS 长度。
注：LIS 指最长严格递增子序列。

https://atcoder.jp/contests/abc165/submissions/12963027
DFS 这棵树，把路径看成序列，用 O(nlogn) 的做法求 LIS。
回溯的时候注意还原现场。
======

Input 1
10
1 2 5 3 4 6 7 3 2 4
1 2
2 3
3 4
4 5
3 6
6 7
1 8
8 9
9 10
Output 1
1
2
3
3
4
4
5
2
2
3
 */