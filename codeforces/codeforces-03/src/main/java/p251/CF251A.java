package p251;

import java.util.Scanner;

public class CF251A {
    static int n, d;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        d = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        int l = 0, r = 0;
        while (r < n) {
            while (a[r] - a[l] > d) {
                l++;
            }
            ans += (long) (r - l) * (r - l - 1) / 2;
            r++;
        }
        return String.valueOf(ans);
    }
}
/*
A. Points on Line
https://codeforces.com/contest/251/problem/A

灵茶の试炼 2024-05-13
题目大意：
输入 n(1≤n≤1e5) d(1≤d≤1e9) 和长为 n 的严格递增数组 a(-1e9≤a[i]≤1e9)。
输出有多少个三元组 (i,j,k) 满足 i<j<k 且 a[k]-a[i]<=d。

rating 1300
同向双指针。
枚举 a[k]，只要 a[k]-a[i]>d 就增加 i。
对于 i 和 j 来说，有 C(k-i,2) 种选法，加入答案。
https://codeforces.com/contest/251/submission/260246422
======

Input
4 3
1 2 3 4
Output
4

Input
4 2
-3 -2 -1 0
Output
2

Input
5 19
1 10 20 30 50
Output
1
 */
