package p1822;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1822G1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static final int MAX_N = (int) 1e6;

    private static String solve(int n, int[] a) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int ai : a) {
            cntMap.put(ai, cntMap.getOrDefault(ai, 0) + 1);
        }

        long res = 0L;
        // b = 1
        for (Integer c : cntMap.values()) {
            res += c * (c - 1L) * (c - 2);
        }
        // b >= 2
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int num = entry.getKey();
            int val = entry.getValue();
            for (int p = 2; num * p * p <= MAX_N; p++) {
                if (cntMap.containsKey(num * p) && cntMap.containsKey(num * p * p)) {
                    res += (long) val * cntMap.get(num * p) * cntMap.get(num * p * p);
                }
            }
        }
        return String.valueOf(res);
    }
}
/*
G1. Magic Triples (Easy Version)
https://codeforces.com/contest/1822/problem/G1

题目大意：
这是这个问题的简单版本。唯一不同的是，在这个版本中，ai≤106。
对于给定的 n 个整数序列 a，一个三元组(i,j,k)被称为 magic，如果:
- 1≤i, j, k≤n。
- i j k 是两两不同的。
存在正整数 b 使得 ai·b=aj 且 aj·b=ak。
Kolya 收到了一个整数序列 a 作为礼物，现在想要为它计算魔法三元组的数量。帮他完成这个任务!
注意，整数 i, j 和 k 的顺序没有限制。
======

input
7
5
1 7 7 2 7
3
6 2 18
9
1 2 3 4 5 6 7 8 9
4
1000 993 986 179
7
1 10 100 1000 10000 100000 1000000
8
1 1 2 2 4 4 8 8
9
1 1 1 2 2 2 4 4 4
output
6
1
3
0
9
16
45
 */
