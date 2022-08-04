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
给出字符串 s。s 只包含 'A','B','C' 三种字符，每次操作可去除 1个'A'和 1个'B'，或去除 1个'B'和 1个'C'，问最后能否成为空串。

统计字符频次，判断 'B'的频次是否等于 'A','C'频次之和即可。
======
 */