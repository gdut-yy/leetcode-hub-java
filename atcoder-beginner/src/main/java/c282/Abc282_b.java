package c282;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc282_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = scanner.next();
        }

        int[] mask = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (S[i].charAt(j) == 'o') {
                    mask[i] |= 1 << j;
                }
            }
        }
        int cnt = 0;
        int target = (1 << M) - 1;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((mask[i] | mask[j]) == target) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
/*
B - Let's Get a Perfect Score
https://atcoder.jp/contests/abc282/tasks/abc282_b
 */