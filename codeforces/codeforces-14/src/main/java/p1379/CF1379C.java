package p1379;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1379C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] ab = new int[m][2];
            for (int i = 0; i < m; i++) {
                ab[i][0] = scanner.nextInt();
                ab[i][1] = scanner.nextInt();
            }
            System.out.println(solve(n, m, ab));
        }
    }

    private static String solve(int N, int m, int[][] ab) {
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = ab[i][0];
        }
        Arrays.sort(a);
        Arrays.sort(ab, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o2[0], o1[0]);
            }
            return Integer.compare(o2[1], o1[1]);
        });

        long ans = 0;
        int i = m - 1;
        long sumA = 0;
        for (int[] x : ab) {
            // 双指针
            while (N > 0 && i >= 0 && a[i] >= x[1]) {
                sumA += a[i];
                N--;
                i--;
            }
            int n = N;
            long s = sumA;
            if (n > 0) {
                if (x[0] < x[1]) {
                    s += x[0];
                    n--;
                }
                s += (long) n * x[1];
            }
            if (s > ans) {
                ans = s;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Choosing flowers
https://codeforces.com/contest/1379/problem/C

灵茶の试炼 2023-03-10
题目大意：
输入 t(≤1e4) 表示 t 组数据。所有数据的 m 之和 ≤1e5。
每组数据输入 n(≤1e9) m(≤1e5) 表示有 m 种物品，每种物品有无限个，你需要选择 n 个。
然后输入 m 行，每行两个数字 a[i] 和 b[i]，范围在 [0,1e9]。
如果第 i 种物品选 x 个（x>0），收益为 a[i]+(x-1)*b[i]。
输出最大收益。

rating 2000
https://codeforces.com/contest/1379/submission/87405052
提示 1：至多有一个物品要选超过 1 个。（反证法：如果有两个，只选 b 更大的那个更优）
提示 2：枚举第 i 个物品选了超过 1 个，那么比 b[i] 大的物品必须选 1 个。
提示 3：对 a 排序，然后二分或者双指针。
======

input
2
4 3
5 0
1 4
2 2

5 3
5 2
4 2
3 1
output
14
16
 */
