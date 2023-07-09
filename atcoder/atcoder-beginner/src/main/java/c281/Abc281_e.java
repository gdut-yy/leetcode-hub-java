package c281;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Abc281_e {
    static int n, m, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] ans = new long[n - m + 1];

        // 前k小的和 等价于 总和减去前m-k大的和
        MultiSets multiSets = new MultiSets(m, m - k);
        for (int i = 0; i < m; i++) {
            multiSets.add(a[i]);
        }
        ans[0] = multiSets.tot - multiSets.sumX;

        for (int i = m; i < n; i++) {
            multiSets.add(a[i]);
            multiSets.del(a[i - m]);

            ans[i - m + 1] = multiSets.tot - multiSets.sumX;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static class MultiSets {
        int n, k;
        TreeMap<Integer, Integer> xMap, yMap;
        int xsz, ysz;
        long sumX, tot;

        // n:窗口大小, k:第 k 大
        public MultiSets(int n, int k) {
            this.n = n;
            this.k = k;
            this.xMap = new TreeMap<>();
            this.yMap = new TreeMap<>();
            this.xsz = 0;
            this.ysz = 0;
            sumX = 0;
        }

        private void add(int v) {
            yInsertV(v);
            balance();
            tot += v;
        }

        private void del(int v) {
            if (xMap.containsKey(v)) {
                xEraseV(v);
            } else {
                yEraseV(v);
            }
            balance();
            tot -= v;
        }

        private void balance() {
            if (xsz + ysz < n) return;
            while (xsz < k) {
                int iy = yMap.lastKey();
                yEraseV(iy);
                xInsertV(iy);
            }
            if (xsz == 0 || ysz == 0) return;
            while (true) {
                int ix = xMap.firstKey();
                int iy = yMap.lastKey();
                if (ix >= iy) break;
                xEraseV(ix);
                yEraseV(iy);
                xInsertV(iy);
                yInsertV(ix);
            }
        }

        private void xInsertV(int v) {
            xMap.put(v, xMap.getOrDefault(v, 0) + 1);
            xsz++;
            sumX += v;
        }

        private void yInsertV(int v) {
            yMap.put(v, yMap.getOrDefault(v, 0) + 1);
            ysz++;
        }

        private void xEraseV(int v) {
            xMap.put(v, xMap.getOrDefault(v, 0) - 1);
            if (xMap.get(v) == 0) xMap.remove(v);
            xsz--;
            sumX -= v;
        }

        private void yEraseV(int v) {
            yMap.put(v, yMap.getOrDefault(v, 0) - 1);
            if (yMap.get(v) == 0) yMap.remove(v);
            ysz--;
        }
    }
}
/*
E - Least Elements
https://atcoder.jp/contests/abc281/tasks/abc281_e

题目大意：
给定长度为 N 的整数序列 A=(A1,...,AN)，以及整数 M 和 K。
对于每一个 i = 1,...,N−M+1，求解如下独立问题。
求 M 个整数 A[i],A[i+1],...,A[i+M-1] 的排序表中前 K 个值的和，按升序排列。

双堆 + 滑动窗口
相似題目: D - 3N Numbers
https://atcoder.jp/contests/arc074/tasks/arc074_b
E - Best Performances
https://atcoder.jp/contests/abc306/tasks/abc306_e
======

Input 1
6 4 3
3 1 4 1 5 9
Output 1
5 6 10

Input 2
10 6 3
12 2 17 11 19 8 4 3 6 20
Output 2
21 14 15 13 13
 */