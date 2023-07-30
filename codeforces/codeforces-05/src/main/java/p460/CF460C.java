package p460;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF460C {
    static int n, m, w;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        w = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int left = 0;
        int right = (int) (1e9 + m);
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    private static boolean checkMid(int low) {
        low++;
        int cnt = 0;
        int[] diff = new int[n];
        int sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            if (sumD + a[i] < low) {
                int d = low - sumD - a[i];
                cnt += d;
                if (cnt > m) return true;
                sumD += d;
                if (i + w < n) {
                    diff[i + w] -= d;
                }
            }
        }
        return false;
    }
}
/*
C. Present
https://codeforces.com/contest/460/problem/C

灵茶の试炼 2023-06-07
題目大意：
输入 n m w (1≤w≤n≤1e5) (1≤m≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你需要操作 m 次，每次操作可以选一个长为 w 的连续子数组，把数组内的元素都加一。
输出 min(a) 的最大值。

https://codeforces.com/contest/460/submission/208655653
二分答案 low。
用差分数组维护区间加。
相似题目: 2528. 最大化城市的最小供电站数目
https://leetcode.cn/problems/maximize-the-minimum-powered-city/
======

input
6 2 3
2 2 2 2 1 1
output
2

input
2 5 1
5 8
output
9
 */
