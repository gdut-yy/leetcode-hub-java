package p1857;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1857F {
    static int n;
    static int[] a;
    static int q;
    static long[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            q = scanner.nextInt();
            xy = new long[q][2];
            for (int i = 0; i < q; i++) {
                xy[i][0] = scanner.nextLong();
                xy[i][1] = scanner.nextLong();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Map<Long, Integer> cntMap = new HashMap<>();
        for (long x : a) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }

        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            long x = xy[i][0], y = xy[i][1];

            long delta = x * x - 4 * y;
            if (delta < 0) continue;
            long sqrt = (long) Math.sqrt(delta);
            long ai = (x + sqrt) / 2;
            long aj = (x - sqrt) / 2;
            if (ai + aj == x && ai * aj == y) {
                if (ai != aj) {
                    long c1 = cntMap.getOrDefault(ai, 0);
                    long c2 = cntMap.getOrDefault(aj, 0);
                    ans[i] = c1 * c2;
                } else {
                    long c = cntMap.getOrDefault(ai, 0);
                    ans[i] = c * (c - 1) / 2;
                }
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
F. Sum and Product
https://codeforces.com/contest/1857/problem/F

灵茶の试炼 2025-11-11
题目大意：
你有一个长度为 n 的数组。
你的任务是回答 q 个问题:给定 x,y，找出 i 和 j(1≤i<j≤n)同时 ai+aj=x 和 ai·aj=y 的对 i 和 j 的个数。
也就是说，对于数组[1,3,2]，要求 x=3,y=2，答案是 1:
- i=1, j=2 失败是因为 1+3=4 而不是 3，同样 1·3=3 而不是 2;
- i=1, j=3 同时满足两个条件;
- i=2, j=3 失败了因为 3+2=5 而不是 3，还有 3·2=6 而不是 2;

数学。一元二次方程求根。
(x-aj)*aj = y
aj^2 - aj * x + y =0
---
x^2 - ax + b = 0
x ± sqrt(x^2 - 4y) / 2
======

input
3
3
1 3 2
4
3 2
5 6
3 1
5 5
4
1 1 1 1
1
2 1
6
1 4 -2 3 3 3
3
2 -8
-1 -2
7 12
output
1 1 0 0
6
1 1 3
 */
