package p1921;

import java.util.Arrays;
import java.util.Scanner;

public class CF1921D {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
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
    }

    private static String solve() {
        Arrays.sort(a);
        reverseSort(b);
        int i = 0, j = n - 1, p = 0, q = m - 1;
        long ans = 0;
        while (i <= j) {
            if (Math.abs(a[i] - b[p]) >= Math.abs(a[j] - b[q])) {
                ans += Math.abs(a[i] - b[p]);
                i++;
                p++;
            } else {
                ans += Math.abs(a[j] - b[q]);
                j--;
                q--;
            }
        }
        return String.valueOf(ans);
    }

    // 由大到小排序
    private static void reverseSort(int[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
D. Very Different Array
https://codeforces.com/contest/1921/problem/D

灵茶の试炼 2025-11-24
题目大意：
Petya 有一个 n 个整数的数组 ai。他的兄弟 Vasya 很嫉妒，决定自己做一个 n 个整数的数组。
为了做到这一点，他找到了 m 个整数 bi (m≥n)，现在他想从中选择 n 个整数，并将它们按一定的顺序排列，得到一个长度为 n 的数组 ci。
为了避免与他的兄弟相似，Vasya 想让他的阵列与 Petya 的阵列尽可能不同。具体来说，他希望总差 D=∑ni=1|ai−ci|尽可能大。
帮助 Vasya 找到他能得到的最大差值 D。

排序 + 双指针
======

input
9
4 6
6 1 2 4
3 5 1 7 2 3
3 4
1 1 1
1 1 1 1
5 5
1 2 3 4 5
1 2 3 4 5
2 6
5 8
8 7 5 8 2 10
2 2
4 1
9 6
4 6
8 10 6 4
3 10 6 1 8 9
3 5
6 5 2
1 7 9 7 2
5 5
9 10 6 3 7
5 9 2 3 9
1 6
3
2 7 10 1 1 5
output
16
0
12
11
10
23
15
25
7
 */