package p1790;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1790C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] p = new int[n][n - 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    p[i][j] = scanner.nextInt();
                }
            }
            System.out.println(solve(n, p));
        }
    }

    private static String solve(int n, int[][] p) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = p[i][0];
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }
        int first = -1;
        int sec = -1;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() > 1) {
                first = entry.getKey();
            } else {
                sec = entry.getKey();
            }
        }
        int[] res = new int[n];
        res[0] = first;
        for (int i = 0; i < n; i++) {
            int x = p[i][0];
            if (x == sec) {
                System.arraycopy(p[i], 0, res, 1, n - 1);
                break;
            }
        }
        return Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Premutation
https://codeforces.com/contest/1790/problem/C

题目大意：
给定整数 n 和 n 行，每行 n-1 个数，每行跳过了元素 pi，pi 不重复，不知道它们被写的顺序，要求重建原来的序列

首位必定出现 n-1 次，后面加上一个仅出现 1 次的序列即可。
======

input
5
4
4 2 1
4 2 3
2 1 3
4 1 3
3
2 3
1 3
1 2
5
4 2 1 3
2 1 3 5
4 2 3 5
4 1 3 5
4 2 1 5
4
2 3 4
1 3 4
1 2 3
1 2 4
3
2 1
1 3
2 3

output
4 2 1 3
1 2 3
4 2 1 3 5
1 2 3 4
2 1 3
 */