package c305;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Abc305_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        int[][] lr = new int[q][2];
        for (int i = 0; i < q; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, a, q, lr));
    }

    private static String solve(int n, int[] a, int q, int[][] lr) {
        // 离散化 begin
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n / 2; i++) {
            int l = a[i * 2 - 1];
            int r = a[i * 2];
            set.add(l);
            set.add(r);
        }
        for (int i = 0; i < q; i++) {
            int l = lr[i][0];
            int r = lr[i][1];
            set.add(l);
            set.add(r);
        }
        int sz = set.size();
        int[] xArr = new int[sz];
        int id = 0;
        for (Integer x : set) {
            xArr[id++] = x;
        }
        Arrays.sort(xArr);
        // 离散化 end

        int[] ori = new int[sz];
        for (int i = 1; i <= n / 2; i++) {
            int l = a[i * 2 - 1];
            int r = a[i * 2];
            for (int j = getId(xArr, l); j < getId(xArr, r); j++) {
                ori[j] = xArr[j + 1] - xArr[j];
            }
        }
        // 前缀和
        int[] preSum = new int[sz + 1];
        for (int i = 0; i < sz; i++) {
            preSum[i + 1] = preSum[i] + ori[i];
        }
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = lr[i][0];
            int r = lr[i][1];
            ans[i] = preSum[getId(xArr, r)] - preSum[getId(xArr, l)];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static int getId(int[] xArr, int x) {
        return Arrays.binarySearch(xArr, x);
    }
}
/*
D - Sleep Log
https://atcoder.jp/contests/abc305/tasks/abc305_d

题目大意：
高桥有睡眠记录。日志表示为奇数长度序列 A=(a1(=0),a2,...,AN)，其中奇数元素表示他起床的次数，偶数元素表示他上床睡觉的次数。更正式地说，在开始记录睡眠日志后，他进行了以下睡眠会话。
- 对于每一个整数 i，使 1≤i≤(n−1)/2，他在睡眠日志开始后正好 A[2i] 分钟入睡，在睡眠日志开始后正好 A[2i+1] 分钟醒来。
- 他没有在任何其他时间入睡或醒来。
回答以下问题。对于第 i 个问题，给你一对整数(li,ri)满足 0≤li≤ri≤N。
从开始记录睡眠日志的第 li 分钟到第 ri 分钟这段时间里，Takahashi 睡着的总分钟数是多少?

上来先 动态开点线段树，然后 TLE 了；
改成 离散化+前缀和 就 AC 了；
======

Input 1
7
0 240 720 1320 1440 1800 2160
3
480 1920
720 1200
0 2160
Output 1
480
0
960

Input 2
21
0 20 62 192 284 310 323 324 352 374 409 452 486 512 523 594 677 814 838 946 1000
10
77 721
255 541
478 970
369 466
343 541
42 165
16 618
222 592
730 983
338 747
Output 2
296
150
150
49
89
20
279
183
61
177
 */