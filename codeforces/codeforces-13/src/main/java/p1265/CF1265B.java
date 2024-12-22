package p1265;

import java.util.Arrays;
import java.util.Scanner;

public class CF1265B {
    static int n;
    static int[] pos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            pos = new int[n];
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt();
                pos[v - 1] = i;
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int mn = n, mx = -1;
        char[] ans = new char[n];
        Arrays.fill(ans, '0');
        for (int i = 0; i < n; i++) {
            int p = pos[i];
            mn = Math.min(mn, p);
            mx = Math.max(mx, p);
            if (mx - mn == i) {
                ans[i] = '1';
            }
        }
        return new String(ans);
    }
}
/*
B. Beautiful Numbers
https://codeforces.com/contest/1265/problem/B

灵茶の试炼 2024-10-28
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和一个 1~n 的排列 p。
对于每个长度 L=1,2,3,...,n，判断 p 是否存在一个长为 L 的连续子数组，包含 1~L 所有数字。
输出一个长为 n 的 01 字符串，依次表示 L=1,2,3,...,n 的答案，其中 0 表示 false，1 表示 true。

rating 1300
预处理每个元素的下标。
然后枚举元素 i=1,2,3,...，同时维护对应下标的最小值 mn 和最大值 mx。
如果发现 mx-mn+1=i，说明从下标 mn 到下标 mx 恰好包含了排列的前 i 个数。
代码中的元素改成从 0 开始了，判断条件变成 mx-mn=i。
代码 https://codeforces.com/contest/1265/submission/286624374
代码备份（洛谷）
======

Input
3
6
4 5 1 3 2 6
5
5 3 1 2 4
4
1 4 3 2
Output
101011
11111
1001
 */
