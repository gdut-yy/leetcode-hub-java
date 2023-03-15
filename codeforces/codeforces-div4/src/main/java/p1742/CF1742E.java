package p1742;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1742E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int[] k = new int[q];
            for (int j = 0; j < q; j++) {
                k[j] = scanner.nextInt();
            }
            System.out.println(solve(n, q, a, k));
        }
    }

    private static String solve(int n, int q, int[] a, int[] k) {
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + a[i];
        }

        int[] aMax = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
            aMax[i] = max;
        }

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int ki = k[i];

            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (aMax[mid] > ki) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            resList.add(String.valueOf(preSum[left]));
        }
        return String.join(" ", resList);
    }
}
/*
E. Scuza
https://codeforces.com/contest/1742/problem/E

题目大意：
给定整数 n 和长为 n 的数组 a，q 个询问。如果 Timur 的腿至少有 aj 长，他只能爬第 j 级台阶。打印出 Timur 爬台阶时可能达到的最大高度。

二分查找出能到达的最后一个台阶，返回其前缀和即可。
时间复杂度 O(qlogn)
======

input
3
4 5
1 2 1 5
1 2 4 9 10
2 2
1 1
0 1
3 1
1000000000 1000000000 1000000000
1000000000

output
1 4 4 9 9
0 2
3000000000
 */