package p1951;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1951D {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (k != n && k > (n + 1) / 2) {
            out.println("NO");
        } else {
            out.println("YES");
            out.println(2);
            out.println((n - k + 1) + " " + 1);
        }
    }
}
/*
D. Buying Jewels
https://codeforces.com/contest/1951/problem/D

灵茶の试炼 2026-02-12
题目大意：
输入 T(≤1e3) 表示 T 组数据。
每组数据输入 n(1≤n≤1e18) 和 k(1≤k≤1e18)。
Alice 有 n 元钱，想在 Bob 的珠宝店购买珠宝。
珠宝店有若干个展柜。Alice 会先去第 1 个展柜，尽可能多地购买珠宝，然后去第 2 个展柜，依此类推，直到最后一个展柜。
Bob 的珠宝店最多可以放置 60 个展柜（每个展柜有无限数量的珠宝），第 i 个展柜需要设置一个在 [1,1e18] 中的整数价格 p[i]，其中的珠宝价格均为 p[i] 元。
如何设置价格，可以让 Alice 购买的珠宝总数恰好为 k？
如果无法做到，输出 NO。
否则输出 YES，展柜数量，以及每个展柜的珠宝价格。

rating 2000
脑筋急转弯。
先判无解。
k > n 显然无解。
k = n 时有解，设置价格为 1 即可。
k < n 呢？
例如 n=8，k=5，即使按照 2 元 1 个的价格，只能买 4 个。
例如 n=9，k=6，即使按照 2 元 1 个的价格，只能先买 4 个，剩下一个去 1 元展柜买，一共买 5 个。
一般地，如果第一个展柜是 p 元（p >= 2），那么可以买 n/p 个（除法是下取整，下同），剩下 n%p 元，至多再买 n%p 个。
所以至多可以买 n/p + n%p 个（p >= 2）。
设 c = n/p，那么 n%p = n - c * p，所以
n/p + n%p = c + n - c * p = n - c * (p - 1) = n - (n / p) * (p - 1)
p 越小，上式越大。
取 p = 2，我们可以买 n - n / 2 = (n + 1) / 2 个。
所以当 (n+1)/2 < k < n 时，无解。
否则一定有解，构造方案为：
n-k+1, 1
如果 n=k，那么在第一个展柜买 n 个。
否则第一个展柜只能买 1 个，还剩下 k-1 元，去第二个展柜买 k-1 个。
代码 https://codeforces.com/problemset/submission/1951/362339428
代码备份（上面打不开的同学看这个）
======

Input
3
7 3
6 4
255 8
Output
YES
10
2 3 4 5 6 7 8 9 10 11
NO
YES
8
128 64 32 16 8 4 2 1
 */
