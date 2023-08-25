package p746;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF746D {
    static int n, k, a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        String cg = "G", cb = "B";
        if (a < b) {
            // a, b, cg, cb = b, a, cb, cg
            int tmp = a;
            a = b;
            b = tmp;

            String tmps = cg;
            cg = cb;
            cb = tmps;
        }
        b++;
        if ((a - 1) / b >= k) {
            return "NO";
        } else {
            String base = cb + cg.repeat(a / b);
            return base.repeat(b - a % b).substring(1) + (base + cg).repeat(a % b);
        }
    }
}
/*
D. Green and Black Tea
https://codeforces.com/contest/746/problem/D

灵茶の试炼 2023-07-25
题目大意：
输入 n k(1≤k≤n≤1e5) a b(0≤a,b≤n 且 a+b=n)。
构造一个长为 n 的字符串，包含 a 个 'G' 和 b 个 'B'，且不能有长度超过 k 的连续相同字母。
如果无法构造，输出 NO，否则输出任意一个符合要求的字符串。

https://codeforces.com/contest/746/submission/215370490
假设 a>=b，那么可以用 b 个 'B' 当作分割线，尽量均分 a 个 'G'。（把 a 个 'G' 均分成 b+1 段。）
如果发现任意一段连续 'G' 长度超过 k，就输出 NO。
其余实现技巧见代码。
======

input
5 1 3 2
output
GBGBG

input
7 2 2 5
output
BBGBGBB

input
4 3 4 0
output
NO
 */
