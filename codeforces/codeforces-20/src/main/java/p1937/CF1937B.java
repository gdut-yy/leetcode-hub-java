package p1937;

import java.util.Scanner;

public class CF1937B {
    static int n;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            t = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int i = 1;
        while (i < n && s[i] <= t[i - 1]) {
            i++;
        }
        int j = i - 1;
        while (j > 0 && s[j] == t[j - 1]) {
            j--;
        }

        return new String(s).substring(0, i) + new String(t).substring(i - 1)
                + System.lineSeparator() + (i - j);
    }
}
/*
B. Binary Path
https://codeforces.com/contest/1937/problem/B

灵茶の试炼 2024-08-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和一个 2 行 n 列的网格图，格子值只有 0 和 1。
你从矩阵左上角出发，走到右下角。
你只能向右/向下走。
把经过的格子值按顺序记录下来，得到一个长为 n+1 的 01 字符串。
输出字典序最小的 01 字符串，以及有多少种走法可以得到该字符串。
如果改成 n 行 m 列要怎么做？
https://ac.nowcoder.com/acm/contest/76652/B
如果是一般图要怎么做？（字典序最小最短路）
I 题 https://codeforces.com/gym/101309

rating 1300
提示 1：
如果 s[i] > t[i-1]，那么一定要往下走，且由于之后只能向右走，后面的字符串是固定的。
在此之前可以一直向右走。
所以最小字典序为 s[:i]+t[i-1:]。
提示 2：
在一定要向下走的位置（记作 i）之前，有多少个位置可以「提前向下走」，而不改变最小字典序？
提示 3：
从 j=i-1 开始倒着遍历，只要 s[j] = t[j-1] 就继续循环。
循环结束时，一共有 i-j 个可以向下走而不改变最小字典序的位置。
代码 https://codeforces.com/problemset/submission/1937/276511896
======

Input
3
2
00
00
4
1101
1100
8
00100111
11101101
Output
000
2
11000
1
001001101
4
 */
