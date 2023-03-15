package p1729;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1729E {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        long ans = solve();
        System.out.printf("! %d%n", ans);
    }

    private static long solve() {
        for (int i = 2; i <= 26; i++) {
            long x = ask(1, i);
            long y = ask(i, 1);
            if (x == -1) {
                return i - 1;
            }
            if (x != y) {
                return x + y;
            }
        }
        return -1;
    }

    private static long ask(int a, int b) {
        System.out.printf("? %d %d%n", a, b);
        return scanner.nextLong();
    }
}
/*
E. Guess the Cycle Size
https://codeforces.com/contest/1729/problem/E

题目大意：
交互题。隐藏 n 个顶点的循环图(3 ≤ n ≤ 10^18)。循环图是由 n 个顶点构成一个循环的无向图。每个顶点都属于循环，即循环的长度(其中边的数量)正好是 n。
循环中顶点的顺序是任意的。通过 "? a b" 查询，返回从顶点 a 到顶点 b 的两条路径的随机长度，如果 max(a,b)>n 则输出 -1。
要求不超过 50 次的查询猜出隐藏图（数量 n）中的顶点数量。

参考官方 Tutorial
其思想是：我们将输出形式为 (1,n) 和 (n,1) 的查询，从 2 逐渐增加 n。如果我们第一次得到查询 −1 的答案，那么图的大小正好是 n−1。
否则，让第一个查询的答案是 x，第二个查询的答案是 y。
1/2 概率 x≠y。在本例中，我们可以输出答案：x+y，因为从顶点1到n总共有两条不同的路径，我们识别了它们。因此，路径的总长度将是循环图的大小。
1/2 概率 x=y。在这种情况下，我们必须继续这个算法。我们最多可以尝试 25 次。
让我们计算找到正确图大小的概率:p=1−(1/2)^25。也就是说，我们“幸运”的一次测试的概率p≈0.99999997。但我们应该在 50 次测试中有"幸运"我们得到:P = p(50)≈0.99999851。
======

input

1

2

-1

output
? 1 2

? 1 3

? 1 4

! 3
 */