package p1344;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1344A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        boolean[] has = new boolean[n];
        for (int i = 0; i < n; i++) {
            int v = ((a[i] + i) % n + n) % n;
            if (has[v]) {
                return "NO";
            }
            has[v] = true;
        }
        return "YES";
    }
}
/*
A. Hilbert's Hotel
https://codeforces.com/contest/1344/problem/A

灵茶の试炼 2023-04-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
如果对于任意两个不同的整数 k1 和 k2，都满足 a[k1 mod n] + k1 ≠ a[k2 mod n] + k2，则输出 YES，否则输出 NO。
注意对于负数 k，k mod n 的结果也在 [0,n-1] 内。

https://codeforces.com/contest/1344/submission/202560069
考虑什么时候输出 NO。
设 k1 = p1*n + i, k2 = p2*n + j
则有 a[i] + (p1*n + i) = a[j] + (p2*n + j)
变形得 (a[i] + i) - (a[j] + j) = (p2-p1) * n
由于 p2-p1 可以随意取，所以变成 a[i] + i 和 a[j] + j 模 n 同余。
所以问题变成 a 中是否有相同的 (a[i]+i) % n，用 bool 数组记录即可。
注意取模为负数时要调整到非负数。
======

input
6
1
14
2
1 -1
4
5 5 5 1
3
3 2 1
2
0 1
5
-239 -2 -100 -3 -11
output
YES
YES
YES
NO
NO
YES
 */
