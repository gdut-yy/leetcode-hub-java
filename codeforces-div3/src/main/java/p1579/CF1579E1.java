package p1579;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF1579E1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] p = new int[n];
            for (int j = 0; j < n; j++) {
                p[j] = scanner.nextInt();
            }
            System.out.println(solve(n, p));
        }
    }

    private static String solve(int n, int[] p) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i : p) {
            if (deque.isEmpty()) {
                deque.addLast(i);
            } else {
                if (i <= deque.getFirst()) {
                    deque.addFirst(i);
                } else {
                    deque.addLast(i);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : deque) {
            stringBuilder.append(i).append(" ");
        }
        return stringBuilder.toString().stripTrailing();
    }
}
/*
E1. Permutation Minimization by Deque
https://codeforces.com/contest/1579/problem/E1

题目大意：
给出整数 n 和长度为 n 的序列 p。给定双端队列，可头部插入或尾部插入，要求使最后得到的序列字典序最小。

贪心，如果待插入的数小于等于头部元素，头部插入，否则尾部插入。
======

input
5
4
3 1 2 4
3
3 2 1
3
3 1 2
2
1 2
2
2 1

output
1 3 2 4
1 2 3
1 3 2
1 2
1 2
 */