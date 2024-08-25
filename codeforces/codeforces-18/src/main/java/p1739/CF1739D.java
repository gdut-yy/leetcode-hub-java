package p1739;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1739D {
    static int n, k;
    //    static int[] p;
    static Map<Integer, List<Integer>> adj;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
//            p = new int[n];
//            for (int i = 0; i < n; i++) {
//                p[i] = scanner.nextInt();
//            }
            adj = new HashMap<>();
            for (int w = 1; w < n; w++) {
                int v = scanner.nextInt() - 1;
                adj.computeIfAbsent(v, key -> new ArrayList<>()).add(w);
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    static int mx, cnt;

    private static boolean checkMid(int mid) {
        mx = mid;
        if (mx == 0) {
            return false;
        }
        cnt = 0;
        f(0, false);
        return cnt <= k;
    }

    private static int f(int v, boolean cut) {
        int h = 0;
        for (Integer w : adj.getOrDefault(v, new ArrayList<>())) {
            h = Math.max(h, f(w, v > 0));
        }
        h++;
        if (cut && h == mx) {
            cnt++;
            return 0;
        }
        return h;
    }
}
/*
D. Reset K Edges
https://codeforces.com/contest/1739/problem/D

灵茶の试炼 2023-01-06
题目大意：
输入 t(≤1e4) 表示 t 组数据，每组数据输入 n k(0≤k<n≤2e5)，有一颗 n 个节点的树，输入 n-1 个数 p[2],p[3],...,p[n]，p[i] 表示点 i 的父节点为 p[i]。
所有数据的 n 之和不超过 2e5。
你可以做如下操作至多 k 次：
断开 p[i] 和 i 之间的边，然后在 1 和 i 之间连边。
输出操作后，这颗树的最小高度。
高度的定义为 1 到最远叶子节点的路径的边数。

rating 1900
https://codeforces.com/contest/1739/submission/188029675
提示 1：由于最终的树越高，操作次数越少，最终的树越矮，操作次数越多，满足单调性，因此可以二分答案。
提示 2：check 需要写一个树形 DP，自底向上计算最长路径长度，达到 mid-1 的时候，切断当前节点和父节点的边，计数器 cnt++，如果最后 cnt≤k 则说明答案不超过 mid。
======

input
5
5 1
1 1 2 2
5 2
1 1 2 2
6 0
1 2 3 4 5
6 1
1 2 3 4 5
4 3
1 1 1
output
2
1
5
3
1
 */
