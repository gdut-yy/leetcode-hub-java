package p1822;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1822C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        long res = n * (n + 2L) + 2;
        return String.valueOf(res);
    }
}
/*
C. Bun Lover
https://codeforces.com/contest/1822/problem/C

题目大意：
特玛喜欢肉桂卷——用肉桂和巧克力做成的“蜗牛”形状的面包。
肉桂卷有不同的大小，从上面看是方形的。巧克力卷最美味的部分是巧克力，它以螺旋状的形式在肉桂卷上倒在薄薄的一层，围绕着小圆面包，如下图所示:
对于尺寸为 n 的肉桂卷，正方形外侧的长度为 n，中间最短的垂直巧克力段的长度为 1。
正式来说，圆面包由两个螺旋形的面团组成，中间用巧克力隔开。一个 n+1 号的肉桂卷是由一个 n 号的肉桂卷，将每一个面团螺旋包裹在肉桂卷上再包裹一层。
重要的是，尺寸为 n 的肉桂卷以一种独特的方式定义。
特玛对 n 号肉桂卷里有多少巧克力感兴趣。由于天玛早已停止购买小肉桂卷，因此保证 n≥4。
通过计算巧克力层的总长度来回答这个不明显的问题。

找规律。答案为 n·(n+2) + 2
======

input
4
4
5
6
179179179
output
26
37
50
32105178545472401
 */
