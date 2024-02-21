package p573;

import java.util.Arrays;
import java.util.Scanner;

public class CF573B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        for (int i = 1; i <= n; i++) {
            a[i] = Math.min(a[i], a[i - 1] + 1);
        }
        for (int i = n; i >= 1; i--) {
            a[i] = Math.min(a[i], a[i + 1] + 1);
        }
        int ans = Arrays.stream(a).max().orElseThrow();
        return String.valueOf(ans);
    }
}
/*
B. Bear and Blocks
https://codeforces.com/contest/573/problem/B

灵茶の试炼 2022-07-18
题目大意：
输入 n(1<=n<=1e5) 和一个长为 n 的数组 h(1<=h[i]<=1e9)。
给你 n 个积木塔，这些积木塔竖着并列摆放在地板上，均由相同的积木组成，第 i 个积木塔包含 h[i] 个积木。
如果一个积木，其上下左右都是积木或地板，那么它叫做内部积木，否则叫做外部积木。
每一时刻，你可以消除所有的外部积木。
输出消除所有积木所需的时间。

rating 1600
https://codeforces.com/problemset/submission/573/164666280
提示 1-1：把关注点放在每列积木被清除的时刻上。答案为所有积木列被清除时刻的最大值。
提示 1-2：递推。
提示 2-1：如果在某个时刻第 i-1 列或第 i+1 列积木被清除了，那么下一时刻第 i 列积木就被清除了。另外，一列积木被清除的时间不会超过这列积木的高度。
提示 2-2：从左到右更新一遍，从右到左更新一遍。
======

input
6
2 1 4 6 2 2
output
3

input
7
3 3 3 1 3 3 3
output
2
 */
