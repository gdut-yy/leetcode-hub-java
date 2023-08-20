package p1850;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1850D {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(a);

        int cnt = 1, max = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] <= k) {
                cnt++;
            } else {
                cnt = 1;
            }
            max = Math.max(max, cnt);
        }
        return String.valueOf(n - max);
    }
}
/*
D. Balanced Round
https://codeforces.com/contest/1850/problem/D

题目大意：
你是一轮 Codeforces 的发起人，准备了 n 个你要设置的问题，问题 i 有困难 ai。您将执行以下过程:
- 从列表中删除一些(可能为零)问题;
- 按照你希望的顺序重新排列剩下的问题。
当且仅当任意两个连续问题的绝对难度差不超过 k(小于或等于 k)时，一局被认为是平衡的。
你需要解决的问题的最少数量是多少才能使问题的安排达到平衡?

贪心，求最长区间。
======

input
7
5 1
1 2 4 5 6
1 2
10
8 3
17 3 1 20 12 5 17 12
4 2
2 4 6 8
5 3
2 3 19 10 8
3 4
1 10 5
8 1
8 3 1 4 5 10 7 3
output
2
0
5
0
3
1
4
 */
