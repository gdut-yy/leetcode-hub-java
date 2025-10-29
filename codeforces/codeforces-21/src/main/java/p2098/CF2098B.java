package p2098;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF2098B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        int m = n - k;
        int ans = a[k + m / 2] - a[(m - 1) / 2] + 1;
        out.println(ans);
    }
}
/*
B. Sasha and the Apartment Purchase
https://codeforces.com/contest/2098/problem/B

灵茶の试炼 2025-07-01
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) k(0≤k<n) 和长为 n 的数组 a(1≤a[i]≤1e9)。
一条街道（坐标轴）上有 n 个酒吧，第 i 个酒吧的位置为 a[i]。
你可以移除至多 k 个酒吧。
这条街道的房子整齐排列，位置为 1,2,3,...,1e9。
定义 f(x) 表示位置为 x 的房子到所有剩余酒吧的距离之和。
对于位置为 i 的房子，如果存在一种移除酒吧的方案，可以让 f(i) = min(f(x))，则称 i 为好房子。
输出好房子的个数。

rating 1400
根据 中位数贪心及其证明：
删除前 k 个酒吧，剩余酒吧的中位数（如果剩余酒吧是偶数取中间右边）是最大值。
删除后 k 个酒吧，剩余酒吧的中位数（如果剩余酒吧是偶数取中间左边）是最小值。
答案为最大值 - 最小值 + 1。
代码 https://codeforces.com/contest/2098/submission/326466497
代码备份（Ubuntu Pastebin）
======

Input
4
4 0
1 2 3 4
5 2
7 6 6 7 1
3 1
6 7 9
6 2
5 1 9 10 13 2
Output
2
2
4
9
 */
