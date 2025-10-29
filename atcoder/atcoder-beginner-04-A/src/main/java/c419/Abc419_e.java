package c419;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Abc419_e {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int M = scanner.nextInt();
        int L = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        long totalFirst = 0;
        for (int i = 0; i < L; i++) {
            totalFirst += A[i];
        }
        long T0 = (-totalFirst) % M;
        if (T0 < 0) {
            T0 += M;
        }

        int nWindows = n - L + 1;
        long[] b = new long[nWindows];
        long currentSum = totalFirst;
        b[0] = (-currentSum) % M;
        if (b[0] < 0) b[0] += M;

        for (int start = 1; start < nWindows; start++) {
            currentSum -= A[start - 1];
            currentSum += A[start + L - 1];
            long val = (-currentSum) % M;
            if (val < 0) val += M;
            b[start] = val;
        }

        long[] cList = new long[nWindows - 1];
        for (int i = 0; i < nWindows - 1; i++) {
            cList[i] = (b[i + 1] - b[i]) % M;
            if (cList[i] < 0) cList[i] += M;
        }

        long[][] costChainList = new long[L][];

        for (int r = 0; r < L; r++) {
            int n_r = ((n - 1 - r) / L) + 1;
            if (n_r <= 1) {
                // Special case: no elements in a_list
                long[] costArr = new long[M];
                for (int x = 0; x < M; x++) {
                    costArr[x] = (long) n_r * x;
                }
                costChainList[r] = costArr;
                continue;
            }

            List<Long> aList = new ArrayList<>();
            long cumShift = 0;
            for (int k = 1; k < n_r; k++) {
                int idx = r + (k - 1) * L;
                if (idx >= cList.length) break;
                cumShift = (cumShift + cList[idx]) % M;
                aList.add(cumShift);
            }

            long C_r = 0;
            for (long a : aList) {
                C_r += a;
            }

            List<Long> thresholds = new ArrayList<>();
            for (long a : aList) {
                thresholds.add(M - a);
            }
            Collections.sort(thresholds);

            int[] fArr = new int[M];
            int j = 0;
            for (int x = 0; x < M; x++) {
                while (j < thresholds.size() && thresholds.get(j) <= x) {
                    j++;
                }
                fArr[x] = j;
            }

            long[] costArr = new long[M];
            for (int x = 0; x < M; x++) {
                costArr[x] = (long) n_r * x + C_r - (long) M * fArr[x];
            }
            costChainList[r] = costArr;
        }

        long INF = (long) 1e18;
        long[] dp = new long[M];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int chainId = 0; chainId < L; chainId++) {
            long[] newDp = new long[M];
            Arrays.fill(newDp, INF);
            long[] costArr = costChainList[chainId];

            for (int s = 0; s < M; s++) {
                if (dp[s] == INF) continue;
                for (int x = 0; x < M; x++) {
                    int sNew = (s + x) % M;
                    long totalCost = dp[s] + costArr[x];
                    if (totalCost < newDp[sNew]) {
                        newDp[sNew] = totalCost;
                    }
                }
            }
            dp = newDp;
        }

        long answer = dp[(int) T0];
        if (answer >= INF) {
            out.println(-1);
        } else {
            out.println(answer);
        }
    }
}
/*
E - Subarray Sum Divisibility
https://atcoder.jp/contests/abc419/tasks/abc419_e

题目大意：
给你一个长度为 N 的整数序列 A = (A1, A2, ..., AN) 。
您的目标是重复执行以下操作，使 A 的每个长度为 L 的连续子数组的和都是 M 的倍数。
- 选择 i 这样的整数 1 <= i <= N ，并将 Ai 的值增加 1 。
求在达到目标之前可能进行的最小运算次数。

https://yuanbao.tencent.com/chat/naQivTmsDa/88c661e4-5515-4517-8dec-e43a54d96e8f
======

Input 1
4 5 3
4 2 1 3
Output 1
4

Input 2
7 10 4
7 0 9 1 6 4 2
Output 2
10
 */
