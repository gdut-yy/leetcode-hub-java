package p582;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF582B {
    static int n, t;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        t = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer> f = new ArrayList<>();
        int d = 0;
        for (int i = 0; i <= n && t > 0; i++) {
            int m = f.size();
            for (int x : a) {
                int j = searchInts(f, x + 1);
                if (j < f.size()) f.set(j, x);
                else f.add(x);
            }
            d = f.size() - m;
            t--;
        }
        int ans = f.size() + t * d;
        return String.valueOf(ans);
    }

    static int searchInts(List<Integer> a, int key) {
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
B. Once Again...
https://codeforces.com/contest/582/problem/B

灵茶の试炼 2024-07-11
题目大意：
输入 n(1≤n≤100) t(1≤t≤1e7) 和长为 n 的数组 a(1≤a[i]≤300)。
把 t 个一样的数组 a 拼接在一起，得到长为 t×n 的数组 b，满足 b[i] = b[i+n]。
输出 b 的最长非降子序列（LIS）的长度。注意这里的 LIS 是非降的，允许元素相等。

rating 1900
贪心+二分求 LIS
如果 t <= n，那么直接求长为 tn 的数组的 LIS。也就是对数组 a 循环 t 次。
如果 t > n，只需要循环 n 次。
设最后一轮循环（第 n 轮循环）二分的数组 f 的长度增加了 d，那么有如下结论：
接下来的 t-n 轮循环是不需要跑的，保证每轮循环 f 数组的长度都会增加 d。
例如 a=[2,3,1]，前三轮循环，找到的 LIS 为
[2,3]
[1,2,3]
[1,1,2,3]
后面每轮循环都只会让 f 的长度增加 1。
相当于每多一轮循环，中间就插入了一个 1。
代码 https://codeforces.com/problemset/submission/582/269741056
======

Input
4 3
3 1 4 2
Output
5
 */