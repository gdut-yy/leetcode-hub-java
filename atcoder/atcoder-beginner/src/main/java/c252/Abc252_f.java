package c252;

import java.nio.charset.StandardCharsets;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Abc252_f {
    static int n;
    static long l;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        l = scanner.nextLong();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long v : a) {
            l -= v;
            minHeap.add(v);
        }
        if (l > 0) {
            minHeap.add(l);
        }

        while (minHeap.size() > 1) {
            Long pop1 = minHeap.remove();
            Long pop2 = minHeap.remove();
            pop2 += pop1;
            ans += pop2;
            minHeap.add(pop2);
        }
        return String.valueOf(ans);
    }
}
/*
F - Bread
https://atcoder.jp/contests/abc252/tasks/abc252_f

灵茶の试炼 2022-10-28
题目大意：
输入 n (2≤n≤2e5) 和 L(≤1e15)，长为 n 的数组 a (1≤a[i]≤1e9, sum(a)≤L)。
有一根长为 L 的面包，需要分给 n 个小孩，每个小孩需要长度恰好为 a[i] 的面包。
对于任意一根长为 k 的面包，你可以切成两段，要求每段长度都为整数，切的花费为 k。
输出最小花费。

https://atcoder.jp/contests/abc252/submissions/36006064
逆向思维，把分割看成合并。这样就转换成经典的 Huffman 问题，用最小堆实现。
如果 sum(a) < L，可以把多余的面包额外当成一个新的小孩需要的。
======

Input 1
5 7
1 2 1 2 1
Output 1
16

Input 2
3 1000000000000000
1000000000 1000000000 1000000000
Output 2
1000005000000000
 */