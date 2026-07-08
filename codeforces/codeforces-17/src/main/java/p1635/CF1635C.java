package p1635;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1635C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (a[n - 2] > a[n - 1]) {
            out.println(-1);
        } else if (a[n - 1] < 0) {
            if (isSorted(a)) {
                out.println(0);
            } else {
                out.println(-1);
            }
        } else {
            out.println(n - 2);
            for (int i = n - 2; i > 0; i--) {
                out.println(i + " " + (i + 1) + " " + n);
            }
        }
    }
    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) return false;
        }
        return true;
    }
}
/*
C. Differential Sorting
https://codeforces.com/contest/1635/problem/C

灵茶の试炼 2026-03-30
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(3≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)，下标从 1 开始。
你可以执行如下操作至多 n 次：
选择三个下标 (i,j,k)，满足 i < j < k，然后把 a[i] 更新为 a[j] - a[k]。要求更新后 |a[i]| <= 1e18。
目标是把 a 变成递增数组（允许相邻元素相等）。
如果无法做到，输出 -1。
否则，先输出操作次数 m，然后输出 m 行，表示每次操作的 i j k，下标从 1 开始。

rating 1200
由于最后两个数无法修改，所以 a[n-1] > a[n] 时无解。
想一想，a[n-2] 怎么改？
想一想，a[n-3] 怎么改？
……
如果 a[n] >= 0，那么操作如下：
从 i=n-2 开始，倒着修改，每次选择 i,i+1,n 这三个下标。
由于 a[i] 在 a[i+1] 的基础上减去了 a[n]，所以从右往左看，a[i] 会越来越小（或者不变）。
由于每次只减少了 a[n]，所以 |a[i]| <= 1e18 满足要求。
如果 a[n] < 0，那么 a[i+1] - a[n] > a[i+1]，所以如果 a 不是有序的，那么无法变成有序的。
代码 https://codeforces.com/problemset/submission/1635/368036358
代码备份（上面打不开的同学看这个）
======

Input
3
5
5 -4 2 -1 2
3
4 3 2
3
-3 -2 -1
Output
2
1 2 3
3 4 5
-1
0
 */
