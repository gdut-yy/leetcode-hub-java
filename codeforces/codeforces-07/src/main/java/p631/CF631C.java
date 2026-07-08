package p631;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF631C {
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

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        int[][] st = new int[m + 1][2];
        int sz = 0;
        for (int i = 0; i < m; i++) {
            int tp = scanner.nextInt(), r = scanner.nextInt();
            while (sz > 0 && st[sz - 1][1] <= r) sz--;
            if (sz == 0 || st[sz - 1][0] != tp) {
                st[sz][0] = tp;
                st[sz][1] = r;
                sz++;
            }
        }
        st[sz][0] = 0;
        st[sz][1] = 0;
        sz++;
        int br = st[0][1];
        int[] b = new int[br];
        for (int i = 0; i < br; i++) b[i] = a[i];
        Arrays.sort(b);
        int lo = 0, hi = br - 1;
        for (int i = 0; i < sz - 1; i++) {
            int tp = st[i][0], r = st[i][1], l = st[i + 1][1];
            int k = r - l;
            if (tp == 1) {
                for (int j = 0; j < k; j++) a[l + j] = b[hi - k + 1 + j];
                hi -= k;
            } else {
                for (int j = 0; j < k; j++) a[l + j] = b[lo + k - 1 - j];
                lo += k;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(a[i]);
        }
        out.println(sb);
    }
}
/*
C. Report
https://codeforces.com/contest/631/problem/C

灵茶の试炼 2026-01-21
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
然后输入 m 个操作，每个操作输入两个数 t(1≤t≤2) 和 r(1≤r≤n)。
按照输入顺序，依次处理这 m 个操作：
如果 t=1，把 a 的前 r 个数从小到大排序。
如果 t=2，把 a 的前 r 个数从大到小排序。
输出最终的 a。

rating 1700
观察一
如果先给前 3 个数排序，再给前 5 个数排序，那么无论前 3 个数怎么排（升序/降序），最终顺序来自「给前 5 个数排序」这个操作。
所以「给前 3 个数排序」不影响结果，直接忽略。
观察二
如果先给前 5 个数从小到大排序，再给前 3 个数从小到大排序，那么后者不影响结果（前 3 个数已经有序了），直接忽略。
及时去掉无用数据，这启发我们用单调栈维护。
最终得到一个 r 严格递减的序列，且相邻操作的顺序（升序/降序）不同。
然后模拟：
比如第一个操作给前 5 个数从小到大排序，第二个操作给前 3 个数从大到小排序，那么答案的第 4,5 个数就确定了，把排序后的第 4,5 小填入答案。
比如第一个操作给前 5 个数从大到小排序，第二个操作给前 3 个数从小到大排序，那么答案的第 4,5 个数就确定了，把排序后的第 2,1 小填入答案。
依此类推，可以用双指针（或者切片）实现上述过程。
代码 https://codeforces.com/contest/631/submission/345980261
代码备份（上面打不开的同学看这个）
======

Input
3 1
1 2 3
2 2
Output
2 1 3

Input
4 2
1 2 4 3
2 3
1 2
Output
2 4 1 3
 */
