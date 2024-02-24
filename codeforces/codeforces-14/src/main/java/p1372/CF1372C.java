package p1372;

import java.util.Scanner;

public class CF1372C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        boolean pre = true;
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if ((a[i] == i) != pre) {
                c++;
                pre = !pre;
            }
        }

        if (c == 2) c = 1;
        else if (c > 2) c = 2;
        return String.valueOf(c);
    }
}
/*
C. Omkar and Baseball
https://codeforces.com/contest/1372/problem/C

灵茶の试炼 2022-07-11
题目大意：
【易错题】
输入 t 表示 t 组数据，每组数据输入一个正整数 n(<=2e5) 和一个长为 n 的 1~n 的排列 a。
每次操作，你可以选择 a 的一个子数组，将其错排（错排前后，子数组同一位置上的元素不能相同）。
输出将 a 变为升序，至少需要几次操作。

rating 1500
O(1) 空间复杂度做法：
https://codeforces.com/contest/1372/submission/163625532
答案至多为 2。
证明比较长，见官方题解 https://codeforces.com/blog/entry/79974
输出方案：https://www.codechef.com/submit/DEARRANGE
======

input
2
5
1 2 3 4 5
7
3 2 4 5 1 6 7
output
0
2
 */
