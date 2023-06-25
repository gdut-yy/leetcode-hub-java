package p1843;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1843C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            System.out.println(solve(n));
        }
    }

    private static String solve(long n) {
        long ans = 0;
        while (n > 0) {
            ans += n;
            n /= 2;
        }
        return String.valueOf(ans);
    }
}
/*
C. Sum in Binary Tree
https://codeforces.com/contest/1843/problem/C

题目大意：
万雅真的很喜欢数学。有一天，当他在解决另一个数学问题时，他想到了一个有趣的树。这棵树是这样构建的。
最初，树只有一个编号为 1 的顶点——树的根。然后，Vanya 给它加上两个孩子，分别给他们分配连续的数字- 2 和 3。
之后，他将按照顶点数量的递增顺序添加子顶点，从 2 开始，为它们的子顶点分配最小未使用的索引。因此，Vanya 将拥有一个无限树，其根位于顶点 1，其中每个顶点将恰好有两个子顶点，并且顶点数将按层顺序排列。
Vanya 想知道从 1 号顶点到 n 号顶点的路径上的顶点数之和等于多少。因为 Vanya 不喜欢数数，所以他让你帮他找出这个数字。

递归。
======

input
6
3
10
37
1
10000000000000000
15
output
4
18
71
1
19999999999999980
26
 */
