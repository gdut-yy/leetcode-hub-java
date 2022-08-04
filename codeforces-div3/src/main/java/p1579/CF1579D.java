package p1579;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1579D {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            List<String> res = solve(n, a);
            System.out.println(res.size());
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int n, int[] a) {
        // [val, idx]
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                priorityQueue.add(new int[]{a[i], i + 1});
            }
        }

        List<String> resList = new ArrayList<>();
        while (priorityQueue.size() > 1) {
            int[] top1 = priorityQueue.remove();
            int[] top2 = priorityQueue.remove();
            resList.add(top1[1] + " " + top2[1]);
            if (top1[0] - 1 > 0) {
                top1[0]--;
                priorityQueue.add(top1);
            }
            if (top2[0] - 1 > 0) {
                top2[0]--;
                priorityQueue.add(top2);
            }
        }
        return resList;
    }
}
/*
D. Productive Meeting
https://codeforces.com/contest/1579/problem/D

题目大意：
给出字符串 s。s 只包含 'A','B','C' 三种字符，每次操作可去除 1个'A'和 1个'B'，或去除 1个'B'和 1个'C'，问最后能否成为空串。

统计字符频次，判断 'B'的频次是否等于 'A','C'频次之和即可。
======
 */