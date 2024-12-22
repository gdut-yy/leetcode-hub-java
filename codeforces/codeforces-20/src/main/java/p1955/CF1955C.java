package p1955;

import java.util.Scanner;

public class CF1955C {
    static int n;
    static long k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextLong();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long left = k;
        for (int v : a) {
            left -= v;
        }
        if (left >= 0) return String.valueOf(n);

        int i = 0;
        for (left = (k + 1) / 2; left >= a[i]; i++) {
            left -= a[i];
        }
        int j = n - 1;
        for (left = k / 2; left >= a[j]; j--) {
            left -= a[j];
        }
        return String.valueOf(i + n - 1 - j);
    }
}
/*
C. Inhabitant of the Deep Sea
https://codeforces.com/contest/1955/problem/C

灵茶の试炼 2024-08-26
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) k(1≤k≤1e15) 和长为 n 的数组 a(1≤a[i]≤1e9)。
有 n 个石子堆，每堆的石子个数记录在数组 a 中。
按照如下顺序取石子：
从最左边的有石子的堆中取出一颗石子，然后从最右边的有石子的堆中取出一颗石子，重复上述过程，左右左右取石子。
你至多取出 k 颗石子。
你可以把多少堆石子变成空的？

rating 1300
首先，如果 k >= sum(a)，直接输出 n。
否则，问题相当于从左到右取出 ceil(k/2) 颗石子，从右到左取出 floor(k/2) 颗石子。
写两个 for 循环计算即可。
代码 https://codeforces.com/problemset/submission/1955/277784586
======

Input
6
4 5
1 2 4 3
4 6
1 2 4 3
5 20
2 7 1 8 2
2 2
3 2
2 15
1 5
2 7
5 2
Output
2
3
5
0
2
2
 */
