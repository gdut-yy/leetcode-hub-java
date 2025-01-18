package c377;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Abc377_f {
    static long n;
    static int q;
    static Set<Long> horizontal, vertical;
    static Set<Long> diagonal_slash, diagonal_backslash;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        horizontal = new TreeSet<>();
        vertical = new TreeSet<>();
        diagonal_slash = new TreeSet<>();
        diagonal_backslash = new TreeSet<>();
        for (int i = 0; i < q; i++) {
            long x = scanner.nextInt();
            long y = scanner.nextInt();
            horizontal.add(x);
            vertical.add(y);
            diagonal_slash.add(x + y);
            diagonal_backslash.add(unsigned(x - y));
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = (n - horizontal.size()) * (n - vertical.size());

        for (Long d : diagonal_slash) {
            Set<Long> cross_x = new HashSet<>();
            for (Long x : horizontal) {
                if (1 <= unsigned(d - x) && unsigned(d - x) <= n) cross_x.add(x);
            }
            for (Long y : vertical) {
                if (1 <= unsigned(d - y) && unsigned(d - y) <= n) cross_x.add(unsigned(d - y));
            }
            ans -= 2 * Math.min(d, n + 1) - d - 1 - cross_x.size();
        }

        for (Long d : diagonal_backslash) {
            Set<Long> cross_x = new HashSet<>();
            for (Long x : horizontal) {
                if (1 <= unsigned(x - d) && unsigned(x - d) <= n) cross_x.add(x);
            }
            for (Long y : vertical) {
                if (1 <= unsigned(d + y) && unsigned(d + y) <= n) cross_x.add(unsigned(d + y));
            }

            for (Long e : diagonal_slash) {
                if ((d + e) % 2 == 0 && 1 <= unsigned(d + e) / 2 && unsigned(d + e) / 2 <= n
                        && 1 <= unsigned(e - d) / 2 && unsigned(e - d) / 2 <= n) {
                    cross_x.add(unsigned(d + e) / 2);
                }
            }
            ans -= n - Math.min(d, unsigned(-d)) - cross_x.size();
        }

        return String.valueOf(ans);
    }

    static long unsigned(long x) {
        final long unsigned_max = 1L + Integer.MAX_VALUE + 1L + Integer.MAX_VALUE;
        if (x >= 0) return x % unsigned_max;
        return unsigned_max + x;
    }
}
/*
F - Avoid Queen Attack
https://atcoder.jp/contests/abc377/tasks/abc377_f

题目大意：
有一个由 $N^2$ 个正方形组成的网格，网格中有 $N$ 行和 $N$ 列。让 $(i,j)$ 表示从顶端 $(1\leq i\leq N)$ 起的第 $i$ 行和从左侧 $(1\leq j\leq N)$ 起的第 $j$ 列的正方形。
每个方格要么是空的，要么有一个棋子放在上面。网格上有 $M$ 个棋子， $k$ - $(1\leq k\leq M)$ 个棋子被放在 $(a_k,b_k)$ 个方格上。
您想把棋子放在**个空格**上，使它**不能被任何现有棋子吃掉**。
放置在位置 $(i,j)$ 上的棋子可以吃掉满足以下任何条件的棋子：
- 置于行 $i$ 中
- 放在 $j$ 列中
- 放置在 $i+j=a+b$ 所在的任意位置 $(a,b)\ (1\leq a\leq N,1\leq b\leq N)$ 上
- 放置在 $i-j=a-b$ 所在的任意位置 $(a,b)\ (1\leq a\leq N,1\leq b\leq N)$ 上
例如，放在 $(4,4)$ 位置上的棋子可以吃掉下图中蓝色所示位置上的棋子：
您可以将棋子放在几个位置上？

神奇的 unsigned
https://atcoder.jp/contests/abc377/editorial/11247
======

Input 1
8 6
1 4
2 1
3 8
4 5
5 2
8 3
Output 1
2

Input 2
1000000000 1
1 1
Output 2
999999997000000002

Input 3
20 10
1 4
7 11
7 15
8 10
11 6
12 5
13 1
15 2
20 10
20 15
Output 3
77
 */
