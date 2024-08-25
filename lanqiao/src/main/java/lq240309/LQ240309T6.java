package lq240309;

import java.util.PriorityQueue;
import java.util.Scanner;

public class LQ240309T6 {
    static int n, m, n1, m1;
    static int[] a, Mx, Mn;
    static long[] t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        n1 = scanner.nextInt();
        m1 = scanner.nextInt();

        a = new int[n * m];
        t = new long[n * m];
        Mx = new int[n * m];
        Mn = new int[n * m];

        for (int i = 0; i < n * m; ++i) {
            t[i] = scanner.nextLong();
            a[i] = (int) t[i];
        }

        if (n1 > m1) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    a[j * n + i] = (int) t[i * m + j];
                }
            }
            int temp = n1;
            n1 = m1;
            m1 = temp;
            temp = n;
            n = m;
            m = temp;
        }

        for (int i = 0; i < n; ++i) {
            t[getidx(i, 0)] = a[getidx(i, 0)];
            for (int j = 1; j < m; ++j) {
                t[getidx(i, j)] = a[getidx(i, j)] + t[getidx(i, j - 1)];
            }
        }

        PriorityQueue<Pair> qx = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.first, p1.first));
        PriorityQueue<Pair> qn = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.first, p1.first));

        for (int i = 0; i < n; ++i) {
            while (!qx.isEmpty()) qx.poll();
            while (!qn.isEmpty()) qn.poll();

            for (int j = 0; j < m1 - 1; ++j) {
                qx.offer(new Pair(a[getidx(i, j)], j));
                qn.offer(new Pair(-a[getidx(i, j)], j));
            }
            for (int j = m1 - 1; j < m; ++j) {
                while (!qx.isEmpty() && qx.peek().second <= j - m1) qx.poll();
                while (!qn.isEmpty() && qn.peek().second <= j - m1) qn.poll();
                qx.offer(new Pair(a[getidx(i, j)], j));
                qn.offer(new Pair(-a[getidx(i, j)], j));
                Mx[getidx(i, j)] = qx.peek().first;
                Mn[getidx(i, j)] = -qn.peek().first;
            }
        }

        long ans = 0;
        for (int i = n1 - 1; i < n; ++i) {
            for (int j = m1 - 1; j < m; ++j) {
                long sum = 0;
                int tx = Integer.MIN_VALUE, tn = Integer.MAX_VALUE;
                for (int k = 0; k < n1; ++k) {
                    tx = Math.max(tx, Mx[getidx(i - k, j)]);
                    tn = Math.min(tn, Mn[getidx(i - k, j)]);
                    if (j == m1 - 1) sum += t[getidx(i - k, j)];
                    else sum += t[getidx(i - k, j)] - t[getidx(i - k, j - m1)];
                }
                ans = Math.max(ans, sum * (tx - tn));
            }
        }
        System.out.println(ans);
    }

    static int getidx(int a, int b) {
        return a * m + b;
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
/*
矩阵X【算法赛】

解题思路
本题考察单调队列，优先队列，思维，二维前缀和。
首先第一个问题是存储问题，由于 n * m ≤ 10^6，但是不知道 n, m 的具体范围，所以，我们可以用一维数组模拟二维，或者二维 vector，这样便就可以解决二维存储问题。
第二个问题，矩阵求和，我们可以用简单的二维前缀和解决这个问题。
第三个问题，求子矩阵的最值，我们有两个解法：
1、我们记录一下每一行的连续 m' 个元素的最值，具体用优先队列，或者单调队列实现吗，然后我们枚举每个子矩阵，并且暴力扫描这个子矩阵的所有行，由于行数可能很大，我们可以换一下行列，因为
min(n',m') ≤ sqrt(10^6), 所以整体的复杂度为 O(nm sqrt(nm)), 四秒可以通过。
2、我们不需要暴力扫描子矩阵的所有行，我们仍然可以通过单调队列完成扫描每一行，然后记录下连续 n' 的最值即可。复杂度为 O(nm）。
---
二维滑动窗口？ Abc278_e
 */