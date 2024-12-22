package p898;

import java.util.Arrays;
import java.util.Scanner;

public class CF898D {
    static int n, m, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);

        int cnt = 0, ans = 0;
        int l = 0, r = 0;
        while (r < n) {
            cnt++; // 移入窗口
            while (a[r] - a[l] >= m) {
                if (a[l] > 0) cnt--; // 移出窗口
                l++;
            }
            if (cnt == k) {
                a[r] = 0; // 删除
                cnt--;
                ans++;
            }
            r++;
        }
        return String.valueOf(ans);
    }
}
/*
D. Alarm Clock
https://codeforces.com/contest/898/problem/D

灵茶の试炼 2024-06-05
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤1e6) k(1≤k≤n) 和长为 n 的数组 a(1≤a[i]≤1e6)。
数轴上有 n 个点，要求任意长为 m-1 的闭区间不能包含 >= k 个点。
问：至少要去掉多少个点？
注：闭区间 [L,R] 的长度为 R-L。

rating 1600
https://www.luogu.com.cn/article/6z3t7ne6
======

Input
3 3 2
3 5 1
Output
1

Input
5 10 3
12 8 18 25 1
Output
0

Input
7 7 2
7 3 4 1 6 5 2
Output
6

Input
2 2 2
1 3
Output
0
 */
