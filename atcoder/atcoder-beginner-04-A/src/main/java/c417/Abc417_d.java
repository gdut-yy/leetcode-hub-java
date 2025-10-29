package c417;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc417_d {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int BOUND_M = 2000;

    private static void solve() {
        int n = scanner.nextInt();
        List<int[]> gifts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            gifts.add(new int[]{p, a, b});
        }

        int[] S = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            S[i] = S[i - 1] + gifts.get(i - 1)[2];
        }

        int[][] dp = new int[n + 1][BOUND_M + 1];
        for (int y = 0; y <= BOUND_M; y++) {
            dp[n][y] = y;
        }

        for (int t = n - 1; t >= 0; t--) {
            int[] gift = gifts.get(t);
            int P = gift[0], A = gift[1], B = gift[2];
            for (int y = 0; y <= BOUND_M; y++) {
                int newMood;
                if (y <= P) {
                    newMood = y + A;
                } else {
                    if (y < B) {
                        newMood = 0;
                    } else {
                        newMood = y - B;
                    }
                }
                if (newMood < 0) newMood = 0;

                if (newMood <= BOUND_M) {
                    dp[t][y] = dp[t + 1][newMood];
                } else {
                    dp[t][y] = falling(newMood, t + 1, n, S, dp);
                }
            }
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            if (x <= BOUND_M) {
                out.println(dp[0][x]);
            } else {
                out.println(falling(x, 0, n, S, dp));
            }
        }
    }

    private static int falling(int y1, int start, int n, int[] S, int[][] dp) {
        if (start >= n) {
            return y1;
        }
        int base = S[start];
        int totalSegmentSum = S[n] - base;
        int target = y1 - BOUND_M + base;

        if (totalSegmentSum < y1 - BOUND_M) {
            return (y1 < totalSegmentSum) ? 0 : y1 - totalSegmentSum;
        }

        int low = start + 1;
        int high = n;
        int jIdx = high + 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (S[mid] >= target) {
                jIdx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (jIdx > n) {
            return (y1 < totalSegmentSum) ? 0 : y1 - totalSegmentSum;
        } else {
            int k = jIdx - start;
            int T_seg = S[jIdx] - base;
            int newMood = (y1 < T_seg) ? 0 : y1 - T_seg;
            int nextStart = start + k;
            if (nextStart >= n) {
                return newMood;
            } else {
                return dp[nextStart][newMood];
            }
        }
    }
}
/*
D - Takahashi's Expectation
https://atcoder.jp/contests/abc417/tasks/abc417_d

题目大意：
高桥将收到 N 件礼物。
他有一个名为心情的参数，是一个非负整数，每次收到礼物时，他的心情都会发生变化。每件礼物都有三个参数：价值 P 、心情上升 A 、心情下降 B ，根据这些参数，他的心情会发生如下变化：
- 当收到的礼物的值 P 大于或等于他的心情时，他对礼物感到高兴，心情增加 A 。
- 当收到的礼物的价值 P 小于他的心情时，他对礼物感到失望，心情会降低 B 。但是，如果他的心情原本小于 B ，则会变成 0 。
他收到的 i (1 <= i <= N) 份礼物的价值为 Pi ，心情增加 Ai ，心情减少 Bi 。
你有 Q 个问题，请回答所有问题。在第 i (1 <= i <= Q) 题中，你得到了一个非负整数 Xi ，请回答下面的问题：
> 当高桥的心情最初为 Xi 时，求他收到所有 N 礼物后的心情。

https://yuanbao.tencent.com/chat/naQivTmsDa/32627442-8563-4304-b6a4-bc5fbd6c8d72
======

Input 1
4
3 1 4
1 5 9
2 6 5
3 5 8
11
0
1
2
3
4
5
6
7
8
9
10
Output 1
6
0
0
0
5
6
0
0
0
0
0

Input 2
3
500 500 500
500 500 500
500 500 500
1
1000000000
Output 2
999998500

Input 3
20
124 370 105
280 200 420
425 204 302
435 141 334
212 287 231
262 410 481
227 388 466
222 314 366
307 205 401
226 460 452
336 291 119
302 104 432
478 348 292
246 337 403
102 404 371
368 399 417
291 416 351
236 263 231
170 415 482
101 339 184
20
1162
1394
1695
2501
3008
3298
4053
4093
4330
5199
5302
5869
5875
6332
6567
7483
7562
7725
9723
9845
Output 3
339
339
339
339
339
339
339
339
339
339
339
339
339
389
339
643
722
885
2883
3005
 */
