package p1901;

import java.util.Arrays;
import java.util.Scanner;

public class CF1901C {
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
        int mn = Arrays.stream(a).min().orElseThrow();
        int mx = Arrays.stream(a).max().orElseThrow();
        if (mn == mx) return "0";

        int u = (1 << bitsLen(mx)) - 1;
        int x = u - mx;
        int ans = 1 + bitsLen((u / 2) ^ ((mn + x) / 2));
        StringBuilder output = new StringBuilder();
        output.append(ans);
        if (ans <= n) {
            output.append(System.lineSeparator()).append(x).append(" ").append("0 ".repeat(ans - 1));
        }
        return output.toString();
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        if (x == 0) return 0;
        return Long.toBinaryString(x).length();
    }
}
/*
C. Add, Divide and Floor
https://codeforces.com/contest/1901/problem/C

灵茶の试炼 2024-07-23
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
每次操作，你可以选一个在 [0,1e18] 中的整数 x，然后把每个 a[i] 都更新成 floor((a[i] + x) / 2)。
至少操作多少次，可以使所有 a[i] 都相同？
输出最小操作次数。
如果操作次数 <= n，额外输出每次操作选的 x。

rating 1400
https://www.luogu.com.cn/article/5ofuodod
======

Input
4
1
10
2
4 6
6
2 1 2 1 2 1
2
0 32
Output
0
2
2 5
1
1
6
 */
