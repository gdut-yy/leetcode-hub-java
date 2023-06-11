package p1833;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1833D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = scanner.nextInt();
            }
            System.out.println(solve(n, p));
        }
    }

    private static String solve(int n, int[] p) {
        int r = 0;

        // 最大数为 n 如果 p[0] == n，那么最大数为 n-1
        int max = p[0] == n ? n - 1 : n;
        for (int i = 1; i < n; i++) {
            // r+1 = max
            if (p[i] == max) {
                r = i - 1;
                break;
            }
        }

        int l = r;
        while (l - 1 >= 0) {
            if (p[0] > p[l - 1]) {
                break;
            } else {
                l--;
            }
        }

        int[] ans = new int[n];
        int id = 0;
        // [r+1,n-1] + [r,l] + [0,l-1]
        for (int i = r + 1; i <= n - 1; i++) ans[id++] = p[i];
        for (int i = r; i >= l; i--) ans[id++] = p[i];
        for (int i = 0; i <= l - 1; i++) ans[id++] = p[i];

        // 特判：最大的数在末尾
        if (r + 1 == n - 1) {
            int[] ans2 = new int[n];
            ans2[0] = max;
            System.arraycopy(p, 0, ans2, 1, n - 1);
            if (check(ans2, ans)) {
                ans = ans2;
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) continue;
            return a[i] > b[i];
        }
        return true;
    }
}
/*
D. Flipper
https://codeforces.com/contest/1833/problem/D

题目大意：
给你一个长度为 n 的排列 p。
排列是由 n 个不同的整数以任意顺序从 1 到 n 组成的数组。例如，{2,3,1,5,4}是一个排列，而{1,2,2}不是(因为 2 出现了两次)，并且{1,3,4}也不是一个排列(因为 n=3，但数组包含 4)。
对于排列 p，您需要应用以下操作正好一次:
- 首先选择一个线段[l,r](1≤l≤r≤n，线段是一个连续的数字序列{pl,pl+1，…，pr−1,pr})并将其反转。反转一个段意味着交换数字对(pl,pr)， (pl+1,pr−1)，…， (pl+i,pr - i)(其中 l+i≤r - i)。
- 然后交换前缀和后缀:[r+1,n]和[1,l−1](注意这些段可能是空的)。
例如，给定 n=5,p={2,3,1,5,4}，如果选择段[l=2,r=3]，在反转段 p={2,1,3,5,4}后，则交换段[4,5]和[1,1]。因此，p={5,4,1,3,2}。可以证明，这是给定排列的最大可能结果。
您需要输出按字典顺序排列的最大排列，该排列可以通过应用所描述的操作获得一次。
如果存在 i(1≤i≤n)使得 aj=bj，且当 1≤j<i 且 ai>bi 时，排列 A 在字典序上大于排列 b。

双指针 + 贪心。
r+1 指向 "最大值"，然后双指针找左端点。
注意特判：最大数在末尾的场景。
======

input
9
5
2 3 1 5 4
9
4 1 6 7 2 8 5 3 9
4
4 3 2 1
2
2 1
6
3 2 4 1 5 6
7
3 2 1 5 7 6 4
10
10 2 5 6 1 9 3 8 4 7
4
4 2 1 3
1
1
output
5 4 1 3 2
9 4 1 6 7 2 8 5 3
3 2 1 4
1 2
6 5 3 2 4 1
7 6 4 5 3 2 1
9 3 8 4 7 1 10 2 5 6
3 4 2 1
1
 */
