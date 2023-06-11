package p1800;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1800C2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = scanner.nextInt();
            }
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, int[] s) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        long res = 0L;
        for (int i = 0; i < n; i++) {
            if (s[i] > 0) {
                maxHeap.add(s[i]);
            } else if (s[i] == 0) {
                if (!maxHeap.isEmpty()) {
                    res += maxHeap.remove();
                }
            }
        }
        return String.valueOf(res);
    }
}
/*
C2. Powering the Hero (hard version)
https://codeforces.com/contest/1800/problem/C2

题目大意：
给定整数 n 和长度为 n 的数组 s。s[i] = 0 的为英雄牌，s[i] > 0 的为奖励卡，可以加到英雄牌上，然后英雄加到你的军队中，求军队的最大总力量。

贪心。优先队列。遇到英雄牌时，选当前最大的奖励卡加上。
======

input
5
5
3 3 3 0 0
6
0 3 3 0 0 3
7
1 2 3 0 4 5 0
7
1 2 5 0 4 3 0
5
3 1 0 0 4

output
6
6
8
9
4
 */