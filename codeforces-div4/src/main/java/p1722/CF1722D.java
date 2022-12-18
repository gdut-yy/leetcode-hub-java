package p1722;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1722D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n - 1 - i;

            if (s.charAt(i) == 'L') {
                sum += left;
                if (right > left) {
                    maxHeap.add(right - left);
                }
            } else {
                sum += right;
                if (left > right) {
                    maxHeap.add(left - right);
                }
            }
        }

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!maxHeap.isEmpty()) {
                sum += maxHeap.remove();
            }
            resList.add(String.valueOf(sum));
        }
        return String.join(" ", resList);
    }
}
/*
D. Line
https://codeforces.com/contest/1722/problem/D

题目大意：
给定整数 n 和长为 n 的字符串 s，仅包含 L/R，对于从 1 到 n 的每一个 k ，如果你能改变最多 k 个人的方向，返回这条线的最大值。

贪心，优先队列，优先取改变后增加大的。
======

input
6
3
LLR
5
LRRLL
1
L
12
LRRRLLLRLLRL
10
LLLLLRRRRR
9
LRLRLRLRL

output
3 5 5
16 16 16 16 16
0
86 95 98 101 102 102 102 102 102 102 102 102
29 38 45 52 57 62 65 68 69 70
44 50 54 56 56 56 56 56 56
 */