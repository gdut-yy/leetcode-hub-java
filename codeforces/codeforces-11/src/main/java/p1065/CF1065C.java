package p1065;

import java.util.Arrays;
import java.util.Scanner;

public class CF1065C {
    static int n, k;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        reverseSort(a);
        long s = 0;
        long ans = 0;
        for (int i = 1; i < n; i++) {
            long d = a[i - 1] - a[i];
            if (s + d * i < k) {
                s += d * i;
                continue;
            }
            d -= (k - s) / i;
            ans += 1 + d / (k / i);
            s = d % (k / i) * i;
        }
        if (s > 0) {
            ans++;
        }
        return String.valueOf(ans);
    }

    static void reverseSort(long[] a) {
        Arrays.sort(a);
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            long tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
    }
}
/*
C. Make It Equal
https://codeforces.com/contest/1065/problem/C

灵茶の试炼 2024-04-17
题目大意：
输入 n(1≤n≤2e5) k(n≤k≤1e9) 和长为 n 的数组 a(1≤a[i]≤2e5)。
每次操作，你可以选择一个整数 x，把所有大于 x 的 a[i] 都减小至 x，花费为减少量之和，要求单次操作的花费不能超过 k。
要使所有 a[i] 都一样，最少要操作多少次？
进阶：做到 O(nlogn)，即复杂度和 max(a) 无关。如果数组 a 是有序的，可以做到 O(n)。

rating 1600
O(nlogn) 做法。
最终要减小到 min(a)。
以下讨论，下标从 0 开始。
把 a 从大到小排序，设相邻两数的高度之差为 d = a[i-1] - a[i]。关于高度见原题图片。
把前面 0~i-1 这 i 个已经减小到 a[i-1] 的数都减小到 a[i]，需要额外花费 d * i 的代价。
设当前累计代价为 s，如果 s + d * i < k，那么直接把 s 增加 d * i，继续循环。
如果 s + d * i > k，就要好好讨论了。
首先，有 (k-s) / i 的高度是可以和前面的代价一并计算的，花费 1 次操作，然后把 d 减少 (k-s) / i。
剩下的 d，每次操作，都可以把 d 减少 k / i，至少要操作 d / (k / i) 次，才能让剩余的 d * i < k。
还剩下 d % (k / i) 的高度，把 d % (k / i) * i 作为 s，继续循环。
循环结束后，如果 s > 0，则需要额外一次操作。
https://codeforces.com/contest/1065/submission/254233276
======

Input
5 5
3 1 2 2 4
Output
2

Input
4 5
2 3 4 5
Output
2
 */
