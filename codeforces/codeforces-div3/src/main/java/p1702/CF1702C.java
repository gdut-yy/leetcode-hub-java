package p1702;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1702C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            scanner.nextLine();
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] u = new int[n];
            for (int j = 0; j < n; j++) {
                u[j] = scanner.nextInt();
            }
            int[] a = new int[k];
            int[] b = new int[k];
            for (int j = 0; j < k; j++) {
                a[j] = scanner.nextInt();
                b[j] = scanner.nextInt();
            }

            List<String> res = solve(n, k, u, a, b);
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int n, int k, int[] u, int[] a, int[] b) {
        Map<Integer, LinkedList<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxListMap.computeIfAbsent(u[i], key -> new LinkedList<>()).add(i);
        }

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!idxListMap.containsKey(a[i]) || !idxListMap.containsKey(b[i])) {
                resList.add("NO");
            } else {
                int firstA = idxListMap.get(a[i]).getFirst();
                int lastB = idxListMap.get(b[i]).getLast();
                if (firstA < lastB) {
                    resList.add("YES");
                } else {
                    resList.add("NO");
                }
            }
        }
        return resList;
    }
}
/*
C. Train and Queries
https://codeforces.com/contest/1702/problem/C

题目大意：
给定整数 n、k 和长为 n 的数组 ui，k 行 ai bi，ui 表示火车路线，求每组 ai bi 是否成立

预处理下标数组，比较 ai 第一个下标 i，bi 最后一个下标 j，是否满足 i < j 即可。
======

input
3

6 3
3 7 1 5 1 4
3 5
1 7
3 10

3 3
1 2 1
2 1
1 2
4 5

7 5
2 1 1 1 2 4 4
1 3
1 4
2 1
4 1
1 2

output
YES
NO
NO
YES
YES
NO
NO
YES
YES
NO
YES
 */