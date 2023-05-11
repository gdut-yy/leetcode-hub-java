package p1822;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1822A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int q = scanner.nextInt();
        while (q-- > 0) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve(n, t, a, b));
        }
    }

    private static String solve(int n, int t, int[] a, int[] b) {
        int maxI = -1;
        int maxB = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] + i <= t) {
                if (maxB < b[i]) {
                    maxB = b[i];
                    maxI = i + 1;
                }
            }
        }
        return String.valueOf(maxI);
    }
}
/*
Codeforces Round 867 (Div. 3)
A. TubeTube Feed
https://codeforces.com/contest/1822/problem/A

题目大意：
蘑菇菲利波夫给自己做了一顿饭，在吃午饭的时候，他决定在 tube 上看一段视频。他午餐时间不能超过 t 秒，所以他找你帮忙选视频。
TubeTube 提要是一个包含 n 个视频的列表，索引从 1 到 n。这段视频持续 ai 秒，娱乐价值 bi。最初，feed 是在第一个视频上打开的，Mushroom 可以在 1 秒内跳转到下一个视频(如果下一个视频存在)。蘑菇可以跳过任何次数的视频(包括零)。
帮助蘑菇选择一个视频，他可以打开并在 t 秒内观看。如果有几个，他想选择最有趣的一个。打印任何合适视频的索引，如果没有则打印 −1。

贪心。
======

input
5
5 9
1 5 7 6 6
3 4 7 1 9
4 4
4 3 3 2
1 2 3 4
5 7
5 5 5 5 5
2 1 3 9 7
4 33
54 71 69 96
42 24 99 1
2 179
55 66
77 88
output
3
2
3
-1
2
 */
