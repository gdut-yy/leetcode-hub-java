package p899;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF899E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int[] a;
    static int[] pre;
    static int[] nxt;
    static int[] sz;

    private static void solve() {
        int n = scanner.nextInt();
        a = new int[n];
        pre = new int[n];
        nxt = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i - 1;
            nxt[i] = i + 1;
            sz[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                merge(i - 1, i);
            }
        }

        PriorityQueue<MaxHeap> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (sz[i] > 0) {
                pq.add(new MaxHeap(sz[i], i));
            }
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            MaxHeap p = pq.poll();
            int i = p.i;
            if (sz[i] != p.sz) continue;
            sz[i] = 0;
            int l = pre[i];
            int r = nxt[i];
            del(i);
            if (l >= 0 && r < n && a[l] == a[r]) {
                merge(l, r);
                pq.add(new MaxHeap(sz[r], r));
            }
            ans++;
        }
        out.println(ans);
    }

    static void del(int i) {
        int l = pre[i];
        int r = nxt[i];
        if (l >= 0) {
            nxt[l] = r;
        }
        if (r < pre.length) {
            pre[r] = l;
        }
    }

    static void merge(int from, int to) {
        sz[to] += sz[from];
        sz[from] = 0;
        del(from);
    }

    static class MaxHeap implements Comparable<MaxHeap> {
        int sz, i;

        MaxHeap(int sz, int i) {
            this.sz = sz;
            this.i = i;
        }

        @Override
        public int compareTo(MaxHeap other) {
            if (this.sz != other.sz) {
                return Integer.compare(other.sz, this.sz); // max heap
            }
            return Integer.compare(this.i, other.i); // smaller index first
        }
    }
}
/*
E. Segments Removal
https://codeforces.com/contest/899/problem/E

灵茶の试炼 2026-01-01
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
a[i] 表示第 i 个数的颜色。
每次操作，从 a 中移除最长的同色段（多个最长取最左边的）。
例如 [13,13,7,7,7,2,2,2] -> [13,13,2,2,2]。
操作直到 a 为空。
输出操作次数。

rating 2000
模拟题。
1. 我们需要知道当前哪一段最长（同长度取下标小的）。
这可以用堆（懒删除堆）维护 pair{长度，位置}。
懒删除堆的意思是，如果出堆的长度与实际长度不匹配，那么这个 pair 是垃圾数据，忽略。
2. 我们需要知道上一段未被删除的位置，以及下一段未被删除的位置。如果这两段颜色相同，那么可以合并，长度相加。
这可以用（数组模拟的）双向链表维护。
注意同一段颜色只需保留最右边的位置（长度信息记录在此），其余位置全部删除。删除后，可以方便求出上一段未被删除的位置，以及下一段未被删除的位置。
代码 https://codeforces.com/problemset/submission/899/355965529
代码备份（上面打不开的同学看这个）
======

Input
4
2 5 5 2
Output
2

Input
5
6 3 4 1 5
Output
5

Input
8
4 4 4 2 2 100 100 100
Output
3

Input
6
10 10 50 10 50 50
Output
4
 */
