package p1690;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class CF1690G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            scanner.nextLine();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int[] k = new int[m];
            int[] d = new int[m];
            for (int j = 0; j < m; j++) {
                k[j] = scanner.nextInt();
                d[j] = scanner.nextInt();
            }
            System.out.println(solve(n, m, a, k, d));
        }
    }

    private static String solve(int n, int m, int[] a, int[] k, int[] d) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (treeSet.isEmpty() || a[i] < a[treeSet.last()]) {
                treeSet.add(i);
            }
        }

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int ki = k[i];
            int di = d[i];
            ki -= 1;
            a[ki] -= di;

            Integer pre = treeSet.lower(ki);
            if (pre == null || a[ki] < a[pre]) {
                treeSet.add(ki);
                for (Integer suf = treeSet.higher(ki); suf != null && a[suf] >= a[ki]; suf = treeSet.higher(ki)) {
                    treeSet.remove(suf);
                }
            }
            resList.add(String.valueOf(treeSet.size()));
        }
        return String.join(" ", resList);
    }
}
/*
G. Count the Trains
https://codeforces.com/contest/1690/problem/G

题目大意：
给定整数 n,m 和 n 个整数 a, ai 表示带有数字 i 的车厢速度为 ai，车厢的速度不能超过前面的车厢。m 行，每行两个整数 k 和 d，代表 ak 下降 d 速度。
求每次降速后，火车的列数。

单调集合，二分替换。
======

input
3

4 2
6 2 3 7
3 2
4 7

5 4
10 13 5 2 6
2 4
5 2
1 5
3 2

13 4
769 514 336 173 181 373 519 338 985 709 729 702 168
12 581
6 222
7 233
5 117

output
3 4
4 4 2 3
5 6 6 5
 */