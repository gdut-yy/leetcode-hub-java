package p1077;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1077C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long sum = 0;
        long mx = 0, mx2 = 0, mxI = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (a[i] > mx) {
                mx2 = mx;
                mx = a[i];
                mxI = i;
            } else if (a[i] > mx2) {
                mx2 = a[i];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == mxI && sum - a[i] == mx2 * 2 || i != mxI && sum - a[i] == mx * 2) {
                ans.add(i + 1);
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Good Array
https://codeforces.com/contest/1077/problem/C

灵茶の试炼 2024-06-17
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。
对于数组 b，如果 b 中存在一个数 x，使得 x = b 中其余元素之和，则称 b 为「好数组」。
如果删除 a[i] 可以使剩余元素组成好数组，则称 i 为「好下标」。
输出 a 的好下标的个数，以及所有好下标（任意顺序）。注意下标从 1 开始。

rating 1300
好数组的某个数 x = 其余元素的和
那么 x 必须是好数组的最大值（如果 x 不是最大值，那么其余元素的和包含最大值，比 x 还要大）
所以好数组必须满足：最大值 = 好数组的元素和 - 最大值，即最大值 * 2 = 好数组的元素和。
维护 a 的最大值 mx、次大值 mx2、最大值的下标。
如果删除的不是最大值，那么需要满足 sum(a) - a[i] == mx * 2。
如果删除的是最大值，那么需要满足 sum(a) - a[i] == mx2 * 2。
https://codeforces.com/problemset/submission/1077/264844875
======

Input
5
2 5 1 2 2
Output
3
4 1 5
Input
4
8 3 5 2
Output
2
1 4
Input
5
2 1 2 4 3
Output
0

 */
