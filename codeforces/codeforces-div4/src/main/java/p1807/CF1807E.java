package p1807;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1807E {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            long ans = solve(n, a);
            System.out.printf("! %d%n", ans);
        }
    }

    private static int solve(int n, int[] a) {
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + a[i];
        }

        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(preSum, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left + 1;
    }

    // preSum[mid+1] < actual
    static boolean checkMid(int[] preSum, int mid) {
        long expected = preSum[mid + 1];
        long actual = ask(mid + 1);
        return actual > expected;
    }

    private static long ask(int r) {
        StringBuilder ask = new StringBuilder("?");
        ask.append(" ").append(r);
        for (int i = 1; i <= r; i++) {
            ask.append(" ").append(i);
        }
        System.out.println(ask);
        return scanner.nextLong();
    }
}
/*
E. Interview
https://codeforces.com/contest/1807/problem/E

交互题。
这是一个互动的问题。如果您不确定交互问题是如何工作的，那么建议您阅读参与者指南。
在考试的最后阶段之前，主任进行了一次面试。他给了刚一堆石头，第 i 堆有 ai 块石头。
每个石头都是一样的，重 1 克，除了一个特殊的石头，它是未知堆的一部分，重 2 克。

二分查找。主要难点在于处理交互数据。
相似题目: E. Guess the Cycle Size
https://codeforces.com/contest/1729/problem/E
======

input
2
5
1 2 3 4 5

11

6

3

7
1 2 3 5 3 4 2

12

6
output
? 4 1 2 3 4

? 2 2 3

? 1 2

! 2

? 4 2 3 5 6

? 2 1 4

! 7


2
5
1 2 3 4 5
 */
