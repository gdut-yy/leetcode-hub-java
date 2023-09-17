package c278;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc278_e {
    private static int H, W, N, h, w;
    private static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        H = scanner.nextInt();
        W = scanner.nextInt();
        N = scanner.nextInt();
        h = scanner.nextInt();
        w = scanner.nextInt();
        a = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        int k = 0;
        int[] cnt = new int[N + 1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                cnt[a[i][j]]++;
                if (cnt[a[i][j]] == 1) {
                    k++;
                }
            }
        }

        int[] cntAll = cnt.clone();
        int kAll = k;

        int resH = H - h + 1;
        int resW = W - w + 1;
        int[][] res = new int[resH][resW];

        for (int offset = 0; offset < resW; offset++) {
            cnt = cntAll.clone();
            k = kAll;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    int del = a[i][j + offset];
                    cnt[del]--;
                    if (cnt[del] == 0) {
                        k--;
                    }
                }
            }
            res[0][offset] = k;

            for (int i = 1; i < resH; i++) {
                for (int j = 0; j < w; j++) {
                    int add = a[i - 1][j + offset];
                    cnt[add]++;
                    if (cnt[add] == 1) {
                        k++;
                    }

                    int del = a[i + h - 1][j + offset];
                    cnt[del]--;
                    if (cnt[del] == 0) {
                        k--;
                    }
                }
                res[i][offset] = k;
            }
        }

        // int[][] => String[]
        return Arrays.stream(res)
                .map(o -> Arrays.stream(o).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
E - Grid Filling
https://atcoder.jp/contests/abc278/tasks/abc278_e

题目大意：
你有一个网格，从上到下有 H 行，从左到右有 W 列。我们用(i,j)表示从上到下第 i 行和从左到第 j 列的正方形。(i,j)(1≤i≤H,1≤j≤W)有一个整数 i,j 在 1 到 N 之间。
给定整数 h 和 w，对于所有满足 0≤k≤h - h 和 0≤l≤w - w 的对(k,l)，解如下问题:
- 如果你把正方形(i,j)涂黑使得 k<i≤k+h 且 l<j≤l+w，那么在没有涂黑的正方形上有多少不同的整数?
但是，请注意，您实际上并没有将这些正方形涂黑(也就是说，这些问题是独立的)。

二维滑动窗口？
======

Input 1
3 4 5 2 2
2 2 1 1
3 2 5 3
3 4 4 3
Output 1
4 4 3
5 3 4

Input 2
5 6 9 3 4
7 1 5 3 9 5
4 5 4 5 1 2
6 1 6 2 9 7
4 7 1 5 8 8
3 4 3 3 5 3
Output 2
8 8 7
8 9 7
8 9 8

Input 3
9 12 30 4 7
2 2 2 2 2 2 2 2 2 2 2 2
2 2 20 20 2 2 5 9 10 9 9 23
2 29 29 29 29 29 28 28 26 26 26 15
2 29 29 29 29 29 25 25 26 26 26 15
2 29 29 29 29 29 25 25 8 25 15 15
2 18 18 18 18 1 27 27 25 25 16 16
2 19 22 1 1 1 7 3 7 7 7 7
2 19 22 22 6 6 21 21 21 7 7 7
2 19 22 22 22 22 21 21 21 24 24 24
Output 3
21 20 19 20 18 17
20 19 18 19 17 15
21 19 20 19 18 16
21 19 19 18 19 18
20 18 18 18 19 18
18 16 17 18 19 17
 */