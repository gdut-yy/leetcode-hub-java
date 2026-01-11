package p1926;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1926E {
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

        for (int i = 0; ; i++) {
            int m = ((n >> i) + 1) / 2;
            if (k <= m) {
                out.println((k * 2 - 1) << i);
                break;
            }
            k -= m;
        }
    }
}
/*
E. Vlad and an Odd Ordering
https://codeforces.com/contest/1926/problem/E

灵茶の试炼 2025-11-18
题目大意：
输入 T(≤5e4) 表示 T 组数据。
每组数据输入 n k(1≤k≤n≤1e9)。
一开始，有一个长为 n 的数组 a = [1,2,...,n] 和一个空数组 b = []。
首先取出 a 中的奇数，从小到大添加到 b 的末尾。
然后取出 a 中剩余的是奇数*2 的数，从小到大添加到 b 的末尾。
然后取出 a 中剩余的是奇数*3 的数，从小到大添加到 b 的末尾。
然后取出 a 中剩余的是奇数*4 的数，从小到大添加到 b 的末尾。
依此类推，直到 a 为空。
例如 n = 7 时，b = [1,3,5,7] + [2,6] + [] + [4] = [1,3,5,7,2,6,4]。
b 的下标从 1 开始。
输出 b[k]。

rating 1500
第一轮，我们取出 a 的所有奇数，剩下的元素是什么？
剩下的是偶数。
把偶数都除以 2，得到 1,2,3,...,n/2，这是一个规模更小的子问题。n' = n/2。
所以可以用递归（或者迭代）解决。
设奇数个数 m = ceil(n'/2)。
如果 k <= m，那么答案 = 第 k 个奇数 << 迭代次数 = (2k-1) << 迭代次数。
否则把 k 减少 m，继续迭代。
代码 https://codeforces.com/problemset/submission/1926/347093115
代码备份（上面打不开的同学看这个）
======

Input
11
7 1
7 2
7 3
7 4
7 5
7 6
7 7
1 1
34 14
84 19
1000000000 1000000000
Output
1
3
5
7
2
6
4
1
27
37
536870912
 */
