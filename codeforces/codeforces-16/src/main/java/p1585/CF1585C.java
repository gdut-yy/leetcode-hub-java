package p1585;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1585C {
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);

        long ans = 0;
        int p = searchInts(a, 0);
        for (int i = 0; i < p; i += k) {
            ans -= a[i];
        }
        for (int i = n - 1; i >= p; i -= k) {
            ans += a[i];
        }
        ans = ans * 2 - Math.max(-a[0], a[n - 1]);
        out.println(ans);
    }

    static int searchInts(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
C. Minimize Distance
https://codeforces.com/contest/1585/problem/C

灵茶の试炼 2025-08-11
题目大意：
输入 T(≤10500) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n k(1≤k≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
一维数轴上有 n 个房子，位置记录在 a 中。
快递站在原点。
你一开始在原点，要给每个房子送快递，每个房子各有一个快递。你每次只能携带至多 k 个快递。
除了最后一次，其余每次送完快递后，都需要返回快递站取件。
输出移动长度的最小值。

rating 1300
注意 a 中元素有正有负。
每趟要么往左，要么往右。同时往左往右会经过原点，可以拆分为往左和往右两趟。
假设最后一趟往右，那么最后一趟应该送多少个快递呢？
越多越好。这样倒数第二个往右的移动的最远距离会更小。
同理，倒数第二往右送的快递越多越好，这样倒数第三往右移动的最远距离会更小。
依此类推。
往左同理。
先假设最后一趟返回原点，然后减去最后一趟的移动距离的最大值。这样代码写起来方便。
把 a 排序，设第一个 >= 0 的下标为 p。
从 n-1 循环到 p，步长为 -k。
累加经过的元素和，乘以 2。
从 0 循环到 p-1，步长为 k。
累加经过的元素和的相反数，乘以 2。
这样算出了最后一趟返回原点时的移动距离和。
然后减去 max(-a[0],a[n-1])，表示最后一趟不返回原点，最后一趟往左/往右取最大值。
代码 https://codeforces.com/contest/1585/submission/332981171
代码备份（Ubuntu Pastebin）
======

Input
4
5 1
1 2 3 4 5
9 3
-5 -10 -15 6 5 8 3 7 4
5 3
2 2 3 3 3
4 2
1000000000 1000000000 1000000000 1000000000
Output
25
41
7
3000000000
 */
