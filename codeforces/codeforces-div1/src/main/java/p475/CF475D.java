package p475;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF475D {
    static int n;
    static int[] a;
    static int q;
    static int[] x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        q = scanner.nextInt();
        x = new int[q];
        for (int i = 0; i < q; i++) {
            x[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, Long> cnt = new HashMap<>();
        // v,l,r
        List<int[]> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = a[i];
            for (int[] p : b) {
                p[0] = getGCD(p[0], x);
            }
            b.add(new int[]{x, i, i + 1});
            int k = 0;
            for (int j = 1; j < b.size(); j++) {
                int[] q = b.get(j);
                if (b.get(k)[0] == q[0]) {
                    b.get(k)[2] = q[2];
                } else {
                    k++;
                    b.set(k, q);
                }
            }
            // b = b[:k+1]
            b.subList(k + 1, b.size()).clear();
            for (int[] p : b) {
                cnt.put(p[0], cnt.getOrDefault(p[0], 0L) + p[2] - p[1]);
            }
        }

        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            ans[i] = cnt.getOrDefault(x[i], 0L);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
D. CGCDSSQ
https://codeforces.com/contest/475/problem/D

题目大意：
给定一个整数序列 a1,...,an 和 q 查询 x1,...,xq 在上面。对于每个查询 xi，您必须计算(l, r)对的数量，使 1≤l≤r≤n 并且 gcd(al,al+1,...,ar) = xi。
Gcd (v1,v2,...,vn)是 v1,v2,...,vn的最大公约数。它等于一个最大的正整数，它能整除所有的 vi。

rating 2000
子数组 LCM/GCD/OR/AND 模板
https://codeforces.com/contest/475/submission/109997345
======

input
3
2 6 3
5
1
2
3
4
6
output
1
2
2
0
1

input
7
10 20 3 15 1000 60 16
10
1
2
3
4
5
6
10
20
60
1000
output
14
0
2
2
2
0
2
2
1
1
 */
