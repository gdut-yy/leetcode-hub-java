package p702;

import java.util.Scanner;

public class CF702C {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        long pre = (long) -1e18;
        int i = 0;
        for (int j = 0; j < m; j++) {
            long v = b[j];
            for (; i < n && a[i] <= v; i++) {
                ans = Math.max(ans, Math.min(a[i] - pre, v - a[i]));
            }
            pre = v;
        }
        if (i < n) {
            ans = Math.max(ans, a[n - 1] - pre);
        }
        return String.valueOf(ans);
    }
}
/*
C. Cellular Network
https://codeforces.com/contest/702/problem/C

灵茶の试炼 2023-12-19
题目大意：
输入 n m(1≤n,m≤1e5) 和长分别为 n 和 m 的非递减数组 a 和 b，元素范围在 [-1e9,1e9]。
在一维数轴上，数组 a 表示每个城市的位置，数组 b 表示每座信号塔的位置。
问：信号塔发射信号的半径至少是多少，才能使所有城市都被信号覆盖？

rating 1500
对每个城市，找左右离它最近的信号塔，算出距离，所有距离的最大值即为答案。
可以用双指针模拟，时间复杂度 O(n+m)。
https://codeforces.com/contest/702/submission/236844605
======

input
3 2
-2 2 4
-3 0
output
4

input
5 3
1 5 10 14 17
4 11 15
output
3
 */
