package c169;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc169_e {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);
        Arrays.sort(b);
        int min = a[n / 2], max = b[n / 2];
        if ((n & 1) == 0) {
            min += a[n / 2 - 1];
            max += b[n / 2 - 1];
        }
        int ans = max - min + 1;
        return String.valueOf(ans);
    }
}
/*
E - Count Median
https://atcoder.jp/contests/abc169/tasks/abc169_e

灵茶の试炼 2022-10-26
题目大意：
输入 n (2≤n≤2e5) 和 n 个区间的左右端点，区间范围在 [1,1e9]。
每个区间内选一个整数，然后计算这 n 个整数的中位数。你能得到多少个不同的中位数？
注：偶数长度的中位数是中间两个数的平均值（没有下取整）。

https://atcoder.jp/contests/abc169/submissions/35971735
上下界思想，计算中位数的最小值和最大值，然后范围内的都可以取到。
由于偶数长度的中位数会存在小数点后为 0.5 的情况，所以答案是可以 *2 的。具体见代码。
======

Input 1
2
1 2
2 3
Output 1
3

Input 2
3
100 100
10 10000
1 1000000000
Output 2
9991
 */