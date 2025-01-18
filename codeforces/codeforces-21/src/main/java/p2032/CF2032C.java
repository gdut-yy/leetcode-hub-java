package p2032;

import java.util.Arrays;
import java.util.Scanner;

public class CF2032C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(a);
        int ans = n - 2;
        int j = 0;
        for (int i = 2; i < n; i++) {
            while (a[j] + a[j + 1] <= a[i]) {
                j++;
            }
            ans = Math.min(ans, n - 1 - i + j);
        }
        return String.valueOf(ans);
    }
}
/*
C. Trinity
https://codeforces.com/contest/2032/problem/C

灵茶の试炼 2024-11-25
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(3≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你可以执行如下操作任意次：
选择 a 中的两个数 a[i] 和 a[j]，把 a[i] 改成 a[j]。
你需要把 a 变成好数组，即任意三个不同下标，对应的元素可以组成一个三角形（两边之和大于第三边）。
输出最小操作次数。

rating 1400
把小的数变成大的？还是把大的数变成小的？还是混合策略？
考虑枚举。
把 a 从小到大排序。
枚举最终数组中的最大值为 a[i]，那么 > a[i] 的都要修改，如果 a[j]+a[j+1] <= a[i]，那么 a[0] ~ a[j] 也要修改。
枚举 a[i]，用双指针计算 j 的最大值。
代码 https://codeforces.com/contest/2032/submission/292259905
代码备份（洛谷）
======

Input
4
7
1 2 3 4 5 6 7
3
1 3 2
3
4 5 3
15
9 3 8 1 6 5 3 8 2 1 4 2 9 4 7
Output
3
1
0
8
 */
