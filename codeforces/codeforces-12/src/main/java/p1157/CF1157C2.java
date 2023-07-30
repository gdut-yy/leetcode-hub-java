package p1157;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1157C2 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        StringBuilder ans = new StringBuilder();

        int l = 0, r = n - 1;
        int pre = 0;
        while (l <= r && (a[l] > pre || a[r] > pre)) {
            boolean isR = a[l] <= pre || a[r] > pre && a[r] < a[l];
            // 至多发生一次
            if (a[l] == a[r]) {
                int l0 = l + 1;
                while (l0 < r && a[l0] > a[l0 - 1]) {
                    l0++;
                }
                int r0 = r - 1;
                while (r0 > l && a[r0] > a[r0 + 1]) {
                    r0--;
                }
                isR = r - r0 > l0 - l;
            }
            if (isR) {
                ans.append('R');
                pre = a[r];
                r--;
            } else {
                ans.append('L');
                pre = a[l];
                l++;
            }
        }
        return ans.length() + System.lineSeparator() + ans;
    }
}
/*
C2. Increasing Subsequence (hard version)
https://codeforces.com/contest/1157/problem/C2

灵茶の试炼 2023-07-05
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的双端队列 a(1≤a[i]≤2e5)。
每次操作，弹出 a 的队首或队尾。
从第二次操作开始，弹出的数字必须严格大于上一次弹出的数字。
输出最多可以弹出多少个数字，以及操作序列（队首为 L，队尾为 R）。

https://codeforces.com/problemset/submission/1157/212155329
贪心模拟即可。
哪边小选哪边（但必须大于上一个数）。
如果两边一样，那么后续操作要么都选左，要么都选右，暴力比较选哪边更优（有更长的严格递增）。
注意【一样】的情况，在整个模拟过程中，至多发生一次（因为必须严格递增）。
======

input
5
1 2 4 3 2
output
4
LRRR

input
7
1 3 5 6 5 4 2
output
6
LRLRRR

input
3
2 2 2
output
1
R

input
4
1 2 4 3
output
4
LLRR
 */
