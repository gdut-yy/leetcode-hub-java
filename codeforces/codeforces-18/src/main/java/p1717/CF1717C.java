package p1717;

import java.util.Scanner;

public class CF1717C {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i] || (a[i] < b[i] && b[i] - b[(i + 1) % n] > 1)) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
C. Madoka and Formal Statement
https://codeforces.com/contest/1717/problem/C

灵茶の试炼 2024-01-30
题目大意：
输入 T(≤4e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，长为 n 的数组 b(1≤a[i]≤1e9)。
你可以执行如下操作任意次：
选择一个下标 i，满足 a[i] <= a[(i+1)%n]，然后把 a[i] 增加 1。
能否把 a 变成 b？输出 YES 或 NO。

rating 1300
首先不能有 a[i] > b[i]，因为 a[i] 不能变小。
否则可以按照如下方式操作：
选择满足 a[i]<b[i] 中的最小的 a[i]。
如果 a[i+1]<b[i+1]，由于我们选的是最小的 a[i]，那么必然有 a[i] <= a[i+1]，我们可以操作。
如果 a[i+1]=b[i+1]，由于操作的前提是 a[i]<=a[i+1]=b[i+1]，这意味着 a[i] 在操作后最大是 b[i+1]+1，所以 b[i] 不能超过 b[i+1]+1，满足该条件才能操作。
综上所述，如果存在 a[i]>b[i] or a[i]<b[i] and b[i]>b[(i+1)%n]+1 就输出 NO，否则输出 YES。
https://codeforces.com/contest/1717/submission/243855296
======

input
5
3
1 2 5
1 2 5
2
2 2
1 3
4
3 4 1 2
6 4 2 5
3
2 4 1
4 5 3
5
1 2 3 4 5
6 5 6 7 6
output
YES
NO
NO
NO
YES
 */
