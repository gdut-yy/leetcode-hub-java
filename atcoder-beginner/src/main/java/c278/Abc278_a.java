package c278;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc278_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int cnt = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = K; i < N; i++) {
            cnt++;
            stringBuilder.append(A[i]).append(" ");
        }
        for (int i = 0; i < N - cnt; i++) {
            stringBuilder.append(0).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
/*
A - Shift
https://atcoder.jp/contests/abc278/tasks/abc278_a
 */