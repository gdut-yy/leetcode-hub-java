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
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                maxHeap.add(new int[]{a[i], i + 1});
            }
        }

        List<String> resList = new ArrayList<>();
        while (maxHeap.size() > 1) {
            int[] top1 = maxHeap.remove();
            int[] top2 = maxHeap.remove();
            resList.add(top1[1] + " " + top2[1]);
            if (top1[0] - 1 > 0) {
                top1[0]--;
                maxHeap.add(top1);
            }
            if (top2[0] - 1 > 0) {
                top2[0]--;
                maxHeap.add(top2);
            }
        }
        return resList;
    }
}
/*
D. Productive Meeting
https://codeforces.com/contest/1579/problem/D

题目大意：
给出整数 n 和长度为 n 的数组 a。任何两个人可退一步单独交谈，求最多谈话总次数。

贪心，优先序列。
======

input
8
2
2 3
3
1 2 3
4
1 2 3 4
3
0 0 2
2
6 2
3
0 0 2
5
8 2 0 1 1
5
0 1 0 0 6

output
2
1 2
1 2
3
1 3
2 3
2 3
5
1 3
2 4
2 4
3 4
3 4
0
2
1 2
1 2
0
4
1 2
1 5
1 4
1 2
1
5 2
 */