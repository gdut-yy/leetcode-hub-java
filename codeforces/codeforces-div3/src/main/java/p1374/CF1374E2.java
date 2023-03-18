package p1374;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1374E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] tab = new int[n][3];
        for (int i = 0; i < n; i++) {
            tab[i][0] = scanner.nextInt();
            tab[i][1] = scanner.nextInt();
            tab[i][2] = scanner.nextInt();
        }
        System.out.println(solve(n, m, k, tab));
    }

    static List<int[]> trash, a, b, both;
    static MaxMinHeap h;

    private static String solve(int n, int m, int k, int[][] tab) {
        trash = new ArrayList<>();
        a = new ArrayList<>();
        b = new ArrayList<>();
        both = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = tab[i][0];
            int x = tab[i][1] << 1 | tab[i][2];

            if (x == 0b00) trash.add(new int[]{t, i + 1});
            else if (x == 0b01) a.add(new int[]{t, i + 1});
            else if (x == 0b10) b.add(new int[]{t, i + 1});
            else if (x == 0b11) both.add(new int[]{t, i + 1});
        }
        if (a.size() > b.size()) {
            List<int[]> tmp = new ArrayList<>(a);
            a = new ArrayList<>(b);
            b = tmp;
        }
        int na = a.size(), nb = both.size();
        if (na + nb < k || nb < k * 2 - m) {
            return "-1";
        }

        a.sort(Comparator.comparingInt(o -> o[0]));
        b.sort(Comparator.comparingInt(o -> o[0]));
        int limitNa = Math.min(m / 2, m - k);
        if (na > limitNa) {
            // a[limitNa:]...
            trash.addAll(a.subList(limitNa, a.size()));
            // b[limitNa:]...
            trash.addAll(b.subList(limitNa, b.size()));
            a = a.subList(0, limitNa);
            b = b.subList(0, limitNa);
            na = limitNa;
        } else {
            // b[na:]...
            trash.addAll(b.subList(na, b.size()));
            b = b.subList(0, na);
        }
        int s = 0;
        for (int i = 0; i < a.size(); i++) {
            s += a.get(i)[0] + b.get(i)[0];
        }

        both.sort(Comparator.comparingInt(o -> o[0]));
        int b0 = Math.max(Math.max(k - na, 0), m - 2 * na - trash.size());
        for (int[] p : both.subList(0, b0)) {
            s += p[0];
        }

        trash.sort(Comparator.comparingInt(o -> o[0]));
        h = new MaxMinHeap();
        MaxMinHeap h0 = new MaxMinHeap();
        for (int[] p : trash.subList(0, m - 2 * na - b0)) {
            h.maxHpAdd(p);
            h0.maxHpAdd(p);
        }
        for (int[] p : trash.subList(m - 2 * na - b0, trash.size())) {
            h.minHpAdd(p);
            h0.minHpAdd(p);
        }
        int s0 = s;
//        tmp := minHp(append([]pair{}, *h.right...))
//        h0 := maxMinHeap{&maxHp{append(h.left.a[:0:0], h.left.a...), h.left.s}, &tmp}

        int ans = s + h.s;
        for (int i = na - 1; i >= k; i--) {
            s -= a.get(i)[0] + b.get(i)[0];
            h.push(a.get(i));
            h.push(b.get(i));
            ans = Math.min(ans, s + h.s);
        }

        if (both.size() > m) {
            both = both.subList(0, m);
        }
        List<int[]> tmp = both.subList(b0, both.size());
        for (int j = 0; j < tmp.size(); j++) {
            s += tmp.get(j)[0];
            int i = Math.min(na, k) - 1 - j;
            if (i >= 0) {
                s -= a.get(i)[0] + b.get(i)[0];
                h.push(a.get(i));
                h.push(b.get(i));
            }
            h.l2r();
            ans = Math.min(ans, s + h.s);
        }
        System.out.println(ans);

        s = s0;
        h = h0;
        if (s + h.s == ans) {
            both = both.subList(0, b0);
            return output();
        }

        for (int i = na - 1; i >= k; i--) {
            s -= a.get(i)[0] + b.get(i)[0];
            h.push(a.get(i));
            h.push(b.get(i));
            if (s + h.s == ans) {
                a = a.subList(0, i);
                b = b.subList(0, i);
                both = both.subList(0, b0);
                return output();
            }
        }

        tmp = both.subList(b0, both.size());
        for (int j = 0; j < tmp.size(); j++) {
            s += tmp.get(j)[0];
            int i = Math.min(na, k) - 1 - j;
            if (i >= 0) {
                s -= a.get(i)[0] + b.get(i)[0];
                h.push(a.get(i));
                h.push(b.get(i));
            }
            h.l2r();
            if (s + h.s == ans) {
                if (i > 0) {
                    a = a.subList(0, i);
                    b = b.subList(0, i);
                } else {
                    a.clear();
                    b.clear();
                }
                both = both.subList(0, b0 + j + 1);
                return output();
            }
        }

        return "NA";
    }

    private static String output() {
        StringBuilder res = new StringBuilder();
        for (int[] p : a) res.append(p[1]).append(" ");
        for (int[] p : b) res.append(p[1]).append(" ");
        for (int[] p : both) res.append(p[1]).append(" ");
        for (int[] p : h.maxHeap) res.append(p[1]).append(" ");
        return res.substring(0, res.length() - 1);
    }

    private static class MaxMinHeap {
        private final PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        private final PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int s = 0;

        void maxHpAdd(int[] v) {
            maxHeap.add(v);
            s += v[0];
        }

        void minHpAdd(int[] v) {
            minHeap.add(v);
        }

        void push(int[] v) {
            minHpAdd(v);
            maxHpAdd(minHeap.remove());
        }

        void l2r() {
            int[] v = maxHeap.remove();
            minHeap.add(v);
            s -= v[0];
        }
    }
}
/*
E2. Reading Books (hard version)
https://codeforces.com/contest/1374/problem/E2

灵茶の试炼 2023-02-14
题目大意：
进阶：需要恰好选 m 本书。
rating2500
======

input
6 3 1
6 0 0
11 1 0
9 0 1
21 1 1
10 1 0
8 0 1
output
24
6 5 1

input
6 3 2
6 0 0
11 1 0
9 0 1
21 1 1
10 1 0
8 0 1
output
39
4 6 5
 */
