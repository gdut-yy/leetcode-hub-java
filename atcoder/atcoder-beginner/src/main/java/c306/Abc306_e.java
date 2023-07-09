package c306;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Abc306_e {
    static int n, k, q;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        q = scanner.nextInt();
        xy = new int[q][2];
        for (int i = 0; i < q; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    // https://atcoder.jp/contests/abc306/editorial/6612
    private static String solve() {
        MultiSets multiSets = new MultiSets(n, k);
        for (int i = 0; i < n; i++) {
            multiSets.add(0);
        }

        long[] ans = new long[q];
        int[] a = new int[n];
        for (int i = 0; i < q; i++) {
            int x = xy[i][0] - 1;
            int y = xy[i][1];

            multiSets.add(y);
            multiSets.del(a[x]);
            a[x] = y;

            ans[i] = multiSets.sumX;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    // 多重集
    private static class MultiSets {
        int n, k;
        TreeMap<Integer, Integer> xMap, yMap;
        int xsz, ysz;
        long sumX;

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
        }

        private void del(int v) {
            if (xMap.containsKey(v)) {
                xEraseV(v);
            } else {
                yEraseV(v);
            }
            balance();
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
E - Best Performances
https://atcoder.jp/contests/abc306/tasks/abc306_e

题目大意：
我们有一个长度为 N 的序列 a =(a1,a2,...,an)一开始，所有项都是 0。
使用输入中给定的整数 K，定义函数 f(a) 如下:
- 设 B 为 A 降序排序得到的序列(使其非单调递增)。
- 然后，设 f(A)= b1 + b2 + ... + bk。
我们考虑在这个序列上应用 Q 更新。
对 i=1,2,..,Q 的序列 A 按此顺序应用以下操作，并在每次更新后在该点打印值 f(A)。
- 把 axi 变成 yi。
---
In this input, N=4 and K=2. Q=10 updates are applied.
The 1-st update makes A=(5,0,0,0). Now, f(A)=5.
The 2-nd update makes A=(5,1,0,0). Now, f(A)=6.
The 3-rd update makes A=(5,1,3,0). Now, f(A)=8.
The 4-th update makes A=(5,1,3,2). Now, f(A)=8.
The 5-th update makes A=(5,10,3,2). Now, f(A)=15.
The 6-th update makes A=(0,10,3,2). Now, f(A)=13.
The 7-th update makes A=(0,10,3,0). Now, f(A)=13.
The 8-th update makes A=(0,10,1,0). Now, f(A)=11.
The 9-th update makes A=(0,0,1,0). Now, f(A)=1.
The 10-th update makes A=(0,0,0,0). Now, f(A)=0.

双平衡树
相似题目: E - Least Elements
https://atcoder.jp/contests/abc281/tasks/abc281_e
2653. 滑动子数组的美丽值
https://leetcode.cn/problems/sliding-subarray-beauty/
======

Input 1
4 2 10
1 5
2 1
3 3
4 2
2 10
1 0
4 0
3 1
2 0
3 0
Output 1
5
6
8
8
15
13
13
11
1
0
 */