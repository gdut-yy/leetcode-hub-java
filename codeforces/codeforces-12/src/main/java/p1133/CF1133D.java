package p1133;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1133D {
    static int n;
    static int[] a, b;

    record vec(int x, int y) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

    private static String solve() {
        int ans = 0, c0 = 0;
        Map<vec, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = a[i], y = b[i];
            if (x == 0) {
                if (y == 0) {
                    c0++;
                }
                continue;
            }
            int g = (int) getGCD(x, y);
            vec v = new vec(x / g, y / g);
            int cntV = cnt.merge(v, 1, Integer::sum);
            ans = Math.max(ans, cntV);
        }
        ans += c0;
        return String.valueOf(ans);
    }

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
D. Zero Quantity Maximization
https://codeforces.com/contest/1133/problem/D

灵茶の试炼 2025-05-27
题目大意：
输入 n(1≤n≤2e5) 和两个长为 n 的数组 a b，元素范围 [-1e9,1e9]。
选择一个实数 d，计算数组 c，其中 c[i] = d * a[i] + b[i]。
问：c 中最多有多少个元素等于 0？

rating 1500
分类讨论：
如果 a[i]=0，那么必须 b[i]=0 才行。这种情况与 d 无关，单独统计。
如果 a[i]≠0，那么设 g=gcd(a[i],b[i])，统计 pair (a[i]/g,b[i]/g) 的个数。
注意不能用浮点数，会有精度误差。
C++ 可以用 long double。
代码 https://codeforces.com/contest/1133/submission/320853550
代码备份（洛谷）
======

Input
5
1 2 3 4 5
2 4 7 11 3
Output
2

Input
3
13 37 39
1 2 3
Output
2

Input
4
0 0 0 0
1 2 3 4
Output
0

Input
3
1 2 -1
-6 -12 6
Output
3
 */
