package p1516;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1516C {
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
        int minLb = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int lb = Integer.lowestOneBit(a[i]);
            if (minLb > lb) {
                minLb = lb;
                idx = i;
            }
        }

        int sum = Arrays.stream(a).sum() / minLb;
        if (sum % 2 == 1) {
            return "0";
        }
        // 0-1 背包
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int x : a) {
            x /= minLb;
            for (int j = sum; j >= x; j--) {
                f[j] = f[j] || f[j - x];
            }
        }

        if (f[sum / 2]) {
            return "1" + System.lineSeparator() + (idx + 1);
        }
        return "0";
    }
}
/*
C. Baby Ehab Partitions Again
https://codeforces.com/contest/1516/problem/C

灵茶の试炼 2023-07-12
题目大意：
输入 n(2≤n≤100) 和长为 n 的数组 a(1≤a[i]≤2000)。
你需要删除 a 中的一些数，使 a 无法分成两个元素和相等的子序列。
输出最少要删除多少个数，以及这些数的下标（从 1 开始）。
注：子序列不要求连续。

https://codeforces.com/contest/1516/submission/213269180
分类讨论：
1. 如果 sum(a) 是奇数，显然没法分，无需删除任何数字，输出 0。
2. 如果无法从 a 中选出元素和等于 sum(a)/2 的子序列，那么也没法分，输出 0。这可以用 0-1 背包判断。
3. 否则就可以分，那么要如何删除呢？此时 sum(a) 是偶数，由于偶数 - 奇数 = 奇数，所以减去一个奇数即可。
4. 要是没有奇数呢？此时每个 a[i] 都是偶数，那么把每个 a[i] 都除以 2，是不会影响答案的。反复除以 2 直到 a 中有奇数为止。
代码实现时，无需反复除以 2，而是除以最小的 lowbit(a[i])。如果要删除数字，也是删除 lowbit 最小的数。
======

input
4
6 3 9 12
output
1
2

input
2
1 2
output
0
 */
