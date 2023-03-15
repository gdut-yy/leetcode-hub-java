package p1741;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1741E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                b[j] = scanner.nextInt();
            }
            System.out.println(solve(n, b));
        }
    }

    private static String solve(int n, int[] b) {
        // f[i] 表示 b[0, i] 可以通过网络发送
        boolean[] f = new boolean[n];

        for (int i = 0; i < n; i++) {
            // 长度在左侧
            if ((i == 0 || f[i - 1]) && i + b[i] < n) {
                f[i + b[i]] = true;
            }
            // 长度在右侧
            if (i == b[i] || i > b[i] && f[i - b[i] - 1]) {
                f[i] = true;
            }
        }
        return f[n - 1] ? "YES" : "NO";
    }
}
/*
E. Sending a Sequence Over the Network
https://codeforces.com/contest/1741/problem/E

题目大意：
给定整数 n 和长度为 n 的数组 b。对于每个线段，它的长度写在它的旁边，或在它的左边或在它的右边。判断 b 是否能通过网络发送。

动态规划。f[i] 表示 b[0, i] 可以通过网络发送，当 f[i-1] = true 时，长度才可在左侧
时间复杂度 O(n)
======

input
7
9
1 1 2 3 1 3 2 2 3
5
12 1 2 7 5
6
5 7 8 9 10 3
4
4 8 6 2
2
3 1
10
4 6 2 1 9 4 9 3 4 2
1
1

output
YES
YES
YES
NO
YES
YES
NO
 */