package p1690;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1690C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] s = new int[n];
            int[] f = new int[n];
            for (int j = 0; j < n; j++) {
                s[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                f[j] = scanner.nextInt();
            }
            System.out.println(solve(n, s, f));
        }
    }

    private static String solve(int n, int[] s, int[] f) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0) {
                res[i] = String.valueOf(f[i] - Math.max(f[i - 1], s[i]));
            } else {
                res[i] = String.valueOf(f[i] - s[i]);
            }
        }
        return String.join(" ", res);
    }
}
/*
C. Restoring the Duration of Tasks
https://codeforces.com/contest/1690/problem/C

题目大意：
给定整数 n 和长度为 n 的数组 s，数组 f，第 i 个任务开始时间 si，结束时间 fi。当新任务在前一个任务完成前，将新任务放在队列末尾。求每个任务 di（持续时间）。

贪心。结果即为 fi - Math.max(si, fi-1)
======

input
4
3
0 3 7
2 10 11
2
10 15
11 16
9
12 16 90 195 1456 1569 3001 5237 19275
13 199 200 260 9100 10000 10914 91066 5735533
1
0
1000000000

output
2 7 1
1 1
1 183 1 60 7644 900 914 80152 5644467
1000000000
 */