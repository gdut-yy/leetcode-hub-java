package p1872;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1872B {
    static int n;
    static int[][] ds;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            ds = new int[n][2];
            for (int i = 0; i < n; i++) {
                ds[i][0] = scanner.nextInt();
                ds[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static final int INF = 1000;

    private static String solve() {
        int left = 1;
        int right = INF;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left - 1);
    }

    private static boolean checkMid(int k) {
        int[] a = new int[INF];
        Arrays.fill(a, INF);
        for (int[] d : ds) {
            if (d[0] <= k) {
                a[d[0]] = Math.min(a[d[0]], d[0] - 1 + d[1]);
            }
        }
        int t = k - 1;
        for (int i = k; i >= 1; i--) {
            if (a[i] <= t) {
                return false;
            }
            t++;
        }
        return true;
    }
}
/*
B. The Corridor or There and Back Again
https://codeforces.com/contest/1872/problem/B

题目大意：
你在一条无限向右延伸的走廊里，被分成正方形的房间。从 1 号房间开始，到 k 号房间，然后再回到 1 号房间。你可以选择 k 的值。移动到相邻的房间需要 1 秒。
此外，走廊里有 n 个陷阱:第 i 个陷阱位于房间 di，在你进入房间 di 后 si 秒就会被激活。一旦陷阱被激活，你就不能带着这个陷阱进入或离开房间。
确定 k 的最大值，使您能够从房间 1 移动到房间 k，然后安全返回房间 1。
例如，如果 n=1,d1=2,s1=2，您可以进入房间 k=2 并安全返回(陷阱将在 1+s1=1+2=3 的时刻激活，它不能阻止您返回)。但是，如果您试图到达房间 k=3，陷阱将在 1+s1=1+2=3 的时刻激活，阻止您返回(您将在第 3 秒返回的途中尝试进入房间 2，但激活的陷阱将阻止您)。k 的任何更大的值也是不可行的。因此，答案是 k=2。

二分答案
======

input
7
1
2 2
3
2 8
4 3
5 2
1
200 200
4
1 20
5 9
3 179
100 1
2
10 1
1 18
2
1 1
1 2
3
1 3
1 1
1 3
output
2
5
299
9
9
1
1
 */

