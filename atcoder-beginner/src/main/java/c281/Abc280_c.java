package c281;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc280_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        long T = scanner.nextLong();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }

        long sum = Arrays.stream(A).sum();
        T %= sum;
        long s = 0L;
        for (int i = 0; i < N; i++) {
            if (s + A[i] <= T) {
                s += A[i];
            } else {
                System.out.println((i + 1) + " " + (T - s));
                return;
            }
        }
    }
}
/*
C - Circular Playlist
https://atcoder.jp/contests/abc281/tasks/abc281_c

先对和取模
 */