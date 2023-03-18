package c277;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc277_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (P[i] == X) {
                System.out.println(i + 1);
            }
        }
    }
}
/*
A - ^{-1}
https://atcoder.jp/contests/abc277/tasks/abc277_a
 */