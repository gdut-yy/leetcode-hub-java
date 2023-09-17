package c309;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Abc309_c {
    static int n, k;
    static int[][] ab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(ab, Comparator.comparingInt(o -> o[0]));

        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + ab[i][1];
        }
        if (preSum[n] <= k) {
            return "1";
        }

        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (preSum[n] - preSum[mid] <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int ans = ab[left - 1][0] + 1;
        return String.valueOf(ans);
    }
}
/*
C - Medicin
https://atcoder.jp/contests/abc309/tasks/abc309_c

题目大意：
于是医生给高桥开了 N 种药。在接下来的 ai 天(包括开处方的那天)，他必须吃 bi 片第 i 种药。他不需要吃其他的药。
让处方日期为第一天。在第一天或之后，他第一天需要服用 K 片或更少药片是什么时候?

前缀和 + 二分答案
======

Input 1
4 8
6 3
2 5
1 9
4 2
Output 1
3

Input 2
4 100
6 3
2 5
1 9
4 2
Output 2
1

Input 3
15 158260522
877914575 2436426
24979445 61648772
623690081 33933447
476190629 62703497
211047202 71407775
628894325 31963982
822804784 50968417
430302156 82631932
161735902 80895728
923078537 7723857
189330739 10286918
802329211 4539679
303238506 17063340
492686568 73361868
125660016 50287940
Output 3
492686569
 */