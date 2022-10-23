package p1579;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1579G {
    public static void main(String[] args) throws IOException {
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

    private static String solve(int n, int[] a) {
        // 答案显然不会超过最大 operate[i] 的 2 倍
        int max = Arrays.stream(a).max().orElseThrow() * 2 + 1;

        // f[i][j] 表示前 i 个数，最右端点纵坐标与折线图最低端点纵坐标差值为 j 时，折线图最大最小值差值的最小值
        int[][] f = new int[n + 1][max];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            for (int j = 0; j < max; j++) {
                if (f[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (j + x < max) {
                    f[i + 1][j + x] = Math.min(f[i + 1][j + x], Math.max(f[i][j], j + x));
                }
                if (j >= x) {
                    f[i + 1][j - x] = Math.min(f[i + 1][j - x], f[i][j]);
                } else {
                    f[i + 1][0] = Math.min(f[i + 1][0], f[i][j] - j + x);
                }
            }
        }
        return String.valueOf(Arrays.stream(f[n]).min().orElseThrow());
    }
}
/*
G. Minimal Coverage
https://codeforces.com/contest/1579/problem/G
 */