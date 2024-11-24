package p1706;

import java.util.Scanner;

public class CF1706C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (n % 2 > 0) {
            long ans = 0;
            for (int i = 1; i < n; i += 2) {
                ans += Math.max(Math.max(a[i - 1], a[i + 1]) - a[i] + 1, 0);
            }
            return String.valueOf(ans);
        }
        long suf = 0;
        for (int i = n - 2; i > 0; i -= 2) {
            suf += Math.max(Math.max(a[i - 1], a[i + 1]) - a[i] + 1, 0);
        }
        long ans = suf;
        long pre = 0;
        for (int i = 1; i < n - 2; i += 2) {
            suf -= Math.max(Math.max(a[i], a[i + 2]) - a[i + 1] + 1, 0);
            pre += Math.max(Math.max(a[i - 1], a[i + 1]) - a[i] + 1, 0);
            ans = Math.min(ans, pre + suf);
        }
        return String.valueOf(ans);
    }
}
/*
C. Qpwoeirut And The City
https://codeforces.com/contest/1706/problem/C

灵茶の试炼 2024-02-13
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(3≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，下标从 0 开始。
每次操作，你可以把 a 中的一个数增加一。
你需要让尽量多的下标在 [1,n-2] 中的数，满足 a[i] > a[i-1] 且 a[i] > a[i+1]。
首先，你需要最大化满足上述要求的数的个数；其次，你需要最小化操作次数。
输出最小操作次数。

rating 1400
如果 n 是奇数，那么方案是唯一的，把所有下标为奇数的数，增加到 max(a[i-1],a[i+1])+1（如果已经 >= 这个数就不用增加）。
如果 n 是偶数，我们可以用前后缀分解，分成两个长为奇数的段，解决方法同上。
https://codeforces.com/contest/1706/submission/244821028
======

input
6
3
2 1 2
5
1 2 1 4 3
6
3 1 4 5 5 2
8
4 2 1 3 5 3 6 1
6
1 10 1 1 10 1
8
1 10 11 1 10 11 10 1
output
2
0
3
3
0
4
 */
