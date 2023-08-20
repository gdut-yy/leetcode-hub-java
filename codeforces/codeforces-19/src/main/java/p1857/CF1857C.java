package p1857;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1857C {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = n * (n - 1) / 2;
            a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(a);
        int delta = n;
        int[] b = new int[n];
        int id = 0;
        for (int i = 0; i < m && delta > 0; i += delta) {
            b[id++] = a[i];
            delta--;
        }
        b[id] = b[id - 1];
        return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Assembly via Minimums
https://codeforces.com/contest/1857/problem/C

题目大意：
Sasha 有一个包含 n 个正整数的数组 a。他觉得很无聊，对于所有 i j (i<j)，他写下了 ai 和 aj 的最小值。他得到了一个大小为 n·(n−1)/2 的新数组 b。
例如,如果 a = [2,3,5,1],他会写 [min(2,3),min(2,5),min(2,1),min(3,5),min(3,1),min(5,1) ] = [2,2,1,3,1,1]。
然后，他随机洗牌数组 b 的所有元素。
不幸的是，他忘记了数组 a，你的任务是恢复任何可能的数组 a，从这些数组 a 中可以得到数组 b。
数组 a 的元素应该在[−10^9,10^9]的范围内。

贪心。举例：
5
3 0 0 -2 0 -2 0 0 -2 -2
---
4 个 -2
5 个 0（等于 3 个 0 + 2 个 0）
1 个 3
======

input
5
3
1 3 1
2
10
4
7 5 3 5 3 3
5
2 2 2 2 2 2 2 2 2 2
5
3 0 0 -2 0 -2 0 0 -2 -2
output
1 3 3
10 10
7 5 3 12
2 2 2 2 2
0 -2 0 3 5
 */
