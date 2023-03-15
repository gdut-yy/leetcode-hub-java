package p1624;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CF1624C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        // 贪心。先排序，小的数机会小，优先处理
        Arrays.sort(a);

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int ai : a) {
            queue.add(ai);
        }
        BitSet bitSet = new BitSet(n + 1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                if (cur < 1) {
                    continue;
                }
                if (cur <= n && !bitSet.get(cur)) {
                    bitSet.set(cur);
                } else {
                    queue.add(cur / 2);
                }
            }
        }
        return bitSet.cardinality() == n ? "YES" : "NO";
    }
}
/*
C. Division by Two and Permutation
https://codeforces.com/contest/1624/problem/C

题目大意：
给出整数 n 和长度为 n 的数组 a，规定一次操作可用 ⌊ai/2⌋ 替换掉 ai，可以操作若干次，问能否使数组 a 包含 1 到 n.

贪心。排序后 BFS，小的数机会小，优先处理。
======

input
6
4
1 8 25 2
2
1 1
9
9 8 3 4 2 7 1 5 6
3
8 2 1
4
24 7 16 7
5
22 6 22 4 22

output
YES
NO
YES
NO
NO
YES
 */