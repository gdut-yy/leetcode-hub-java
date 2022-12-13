package c281;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc281_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int D = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // f[i][j][k] 表示 A[0, i] 取 j 个数 % D 为 k 的最大和
        long[][][] f = new long[N + 1][K + 1][D];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                Arrays.fill(f[i][j], -1L);
            }
        }
        f[0][0][0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K + 1; j++) {
                for (int k = 0; k < D; k++) {
                    if (f[i][j][k] == -1) {
                        continue;
                    }
                    f[i + 1][j][k] = Math.max(f[i + 1][j][k], f[i][j][k]);

                    // transition when a_i is chosen
                    if (j != K) {
                        f[i + 1][j + 1][(k + A[i]) % D] = Math.max(f[i + 1][j + 1][(k + A[i]) % D], f[i][j][k] + A[i]);
                    }
                }
            }
        }
        System.out.println(f[N][K][0]);
    }
}
/*
D - Max Multiple
https://atcoder.jp/contests/abc281/tasks/abc281_d

求能整除 D 的最大子序列和，长度为 K。
动态规划
 */