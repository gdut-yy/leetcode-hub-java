package p2065;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF2065C2 {
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
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = scanner.nextInt();
        Arrays.sort(b);

        int pre = (int) -1e9;
        for (int v : a) {
            int j = searchInts(b, pre + v);
            if (j < m) {
                int mn = b[j] - v;
                if (v >= pre) {
                    mn = Math.min(mn, v);
                }
                v = mn;
            } else if (v < pre) {
                out.println("NO");
                return;
            }
            pre = v;
        }
        out.println("YES");
    }

    private static int searchInts(int[] a, int key) {
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
C2. Skibidus and Fanum Tax (hard version)
https://codeforces.com/contest/2065/problem/C2

灵茶の试炼 2025-07-21
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) m(1≤m≤2e5)，长为 n 的数组 a(1≤a[i]≤1e9)，长为 m 的数组 b(1≤b[i]≤1e9)。
对于每个 a[i]，你可以把 a[i] 改成 b[j] - a[i]（b[j] 可以自由选择），也可以让 a[i] 保持不变。
对于每个 a[i]，至多修改一次。
能否让 a 变成非递减数组？（a[i] <= a[i+1]）
输出 YES 或 NO。

rating 1300
贪心地，每次选最小的 b[j]，满足 b[j] - a[i] >= a[i-1]。
如果不存在这样的 b[j]，那么 a[i] 只能不变。
否则 a[i] 要么变成 b[j] - a[i]，要么不变。
如果不变更优，即 a[i] <= b[j]-a[i] 且 a[i] >= a[i-1]，那么不变。
为了快速计算每次选的 b[j]，把 b 排序后二分。
代码 https://codeforces.com/contest/2065/submission/329573998
代码备份（Ubuntu Pastebin）
======

Input
5
1 3
5
9 1 1000000000
3 2
1 4 3
3 4
4 3
2 4 6 5
6 1 8
5 2
6 4 5 4 5
4 1000
3 1
9 8 7
8
Output
YES
NO
YES
NO
YES
 */
