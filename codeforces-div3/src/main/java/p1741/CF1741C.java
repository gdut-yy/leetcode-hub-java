package p1741;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1741C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static Map<Long, Integer> hashMap;
    private static long sum;

    private static String solve(int n, int[] a) {
        // preSum => idx
        hashMap = new HashMap<>();
        hashMap.put(0L, 0);
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + a[i];
            hashMap.put(preSum[i + 1], i + 1);
        }

        long min = n;
        sum = preSum[n];
        for (int i = 0; i < n; i++) {
            if (sum % preSum[i + 1] == 0) {
                long thickness = getThickness(preSum[i + 1]);
                if (thickness != -1) {
                    min = Math.min(min, thickness);
                }
            }
        }
        return String.valueOf(min);
    }

    private static long getThickness(long partSum) {
        long thickness = 0;
        for (long i = partSum; i <= sum; i += partSum) {
            if (!hashMap.containsKey(i)) {
                // 不成立返回 -1
                return -1;
            } else {
                int cur = hashMap.get(i) - hashMap.get(i - partSum);
                thickness = Math.max(thickness, cur);
            }
        }
        return thickness;
    }
}
/*
C. Minimize the Thickness
https://codeforces.com/contest/1741/problem/C

题目大意：
给定整数 n 和长为 n 的数组 a。将 a 分成若干段，使每个元素恰好在一个段中并且所有段的元素之和是相等的。厚度定义为最长段的长度。求出 a 所有可能分段的最小厚度。

前缀和。2000 * 10^6 居然会爆 int ?!
======

input
4
6
55 45 30 30 40 100
4
10 23 7 13
5
10 55 35 30 65
6
4 1 1 1 1 4

output
3
4
2
3
 */