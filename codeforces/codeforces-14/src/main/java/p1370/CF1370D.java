package p1370;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1370D {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    private static boolean checkMid(int mid) {
        return f(0, mid) || f(1, mid);
    }

    private static boolean f(int c, int up) {
        int i = c;
        while (i < n) {
            while (i < n && a[i] > up) {
                i++;
            }
            if (i < n) {
                c++;
                i++;
            }
            if (i < n) {
                c++;
                i++;
            }
        }
        return c >= k;
    }
}
/*
D. Odd-Even Subsequence
https://codeforces.com/contest/1370/problem/D

灵茶の试炼 2023-01-09
题目大意：
输入 n k (2≤k≤n≤2e5) 和长为 n 的数组 a (1≤a[i]≤1e9)。
从 a 中选出一个长为 k 的子序列 s，下标从 1 开始。
定义 x=max(s[1],s[3],s[5],...)，y=max(s[2],s[4],s[6],...)
输出 min(x,y) 的最小值。
注：子序列不一定是连续的。

rating 2000
https://codeforces.com/contest/1370/submission/95403435
提示 1：讨论 min(x, y) 是 x 还是 y，那么问题就变成「最小化最大值」了，二分答案。
提示 2：假设是 x，遍历 a，遇到一个 <= mid 的数，把它当作是属于 x 的，计数器+1；同时后面一个数必须要属于 y，那么随便选（因为只看 x），计数器也+1。如果最后计数器 >= k 那么 check 返回 true，否则返回 false。
假设是 y，那么同理，只不过要从 a 的第二个数开始算（第一个数已经属于 x 了）。
======

input
4 2
1 2 3 4
output
1

input
4 3
1 2 3 4
output
2

input
5 3
5 3 4 2 6
output
2

input
6 4
5 3 50 2 4 5
output
3
 */
