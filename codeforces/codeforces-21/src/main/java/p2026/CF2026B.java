package p2026;

import java.util.Scanner;

public class CF2026B {
    static int n;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (n == 1) return "1";
        long[] suf = new long[n / 2 + 1];
        for (int i = n - 2; i >= 0; i -= 2) {
            suf[i / 2] = Math.max(suf[i / 2 + 1], a[i + 1] - a[i]);
        }
        if (n % 2 == 0) {
            return String.valueOf(suf[0]);
        }
        long ans = suf[0], pre = 0;
        for (int i = 1; i < n; i += 2) {
            pre = Math.max(pre, a[i] - a[i - 1]);
            ans = Math.min(ans, Math.max(pre, suf[i / 2 + 1]));
        }
        return String.valueOf(ans);
    }
}
/*
B. Black Cells
https://codeforces.com/contest/2026/problem/B

灵茶の试炼 2024-12-02
题目大意：
输入 T(≤500) 表示 T 组数据。所有数据的 n 之和 ≤2000。
每组数据输入 n(1≤n≤2000) 和长为 n 的严格递增数组 a(1≤a[i]<1e18)。
一开始，一维数轴上的所有整点都是白色。
每次操作，你可以选择两个不同的白色整点 x 和 y，满足 |x-y|≤k，然后把这两个白色整点涂黑。注意 x 和 y 不一定要在 a 中。
你需要把在 a 中的整点全部涂黑。此外，最多有一个不在 a 中的整点也可以涂黑。
输出 k 的最小值。
做到 O(n)。

rating 1300
如果 n=1，答案是 1。（注意选的两个整点必须不同）
如果 n 是偶数，那么只能相邻元素两两一对涂黑，取差值的最大值作为答案。
如果 n 是奇数，相当于 a 中有一个元素可以单独涂黑。
枚举这个元素，用前后缀分解计算左右两侧的最大差值。
代码 https://codeforces.com/contest/2026/submission/293741983
代码备份（洛谷）
======

Input
4
2
1 2
1
7
3
2 4 9
5
1 5 8 10 13
Output
1
1
2
3
 */
