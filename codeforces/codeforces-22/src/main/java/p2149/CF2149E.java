package p2149;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF2149E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int n, k, L, R;
    static int[] a;

    private static void solve() {
        n = scanner.nextInt();
        k = scanner.nextInt();
        L = scanner.nextInt();
        R = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long ans = f(k) - f(k - 1);
        out.println(ans);
    }

    static long f(int mx) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            cnt.merge(v, 1, Integer::sum);

            while (cnt.size() > mx) {
                int w = a[l];
                cnt.put(w, cnt.get(w) - 1);
                if (cnt.get(w) == 0) {
                    cnt.remove(w);
                }
                l++;
            }

            int windowSize = i - l + 1;
            int validLength = Math.max(Math.min(windowSize, R) - L + 1, 0);
            res += validLength;
        }
        return res;
    }
}
/*
E. Hidden Knowledge of the Ancients
https://codeforces.com/contest/2149/problem/E

灵茶の试炼 2025-11-04
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n k(1≤k≤n≤2e5) L R(1≤L≤R≤n) 和长为 n 的数组 a(1≤a[i]≤1e9)。
输出 a 有多少个连续子数组 b，满足 b 的长度在 [L,R] 中，且 b 恰好有 k 个不同元素。

rating 1500
本题是恰好型滑动窗口（见我的 滑动窗口题单）。
定义 f(k) 为至多有 k 个不同元素的子数组个数。（定义成至少也可以，做法类似）
那么答案就是 f(k) - f(k-1)。
当右端点在 i 时，设 left 是最小的满足要求的左端点。
那么子数组长度最大为 min(i-left+1, R)，最小为 L。
所以有 min(i-left+1,R) - L + 1 个右端点为 i 的子数组。
但这不能是负数，所以有 max(min(i-left+1,R) - L + 1, 0) 个右端点为 i 的子数组。
C++ 选手注意 LL。
代码 https://codeforces.com/contest/2149/submission/347037731
代码备份（上面打不开的同学看这个）
======

Input
5
1 1 1 1
5
5 2 2 3
1 2 1 3 2
6 3 1 6
1 2 3 1 2 3
4 1 1 2
7 7 7 7
7 3 2 4
1 2 1 2 3 2 1
Output
1
5
10
7
5
 */
