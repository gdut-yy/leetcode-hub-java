package c283;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc283_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int op = scanner.nextInt();
            if (op == 1) {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                A[k - 1] = x;
            } else {
                int k = scanner.nextInt();
                System.out.println(A[k - 1]);
            }
        }
    }
}
/*
B - First Query Problem
https://atcoder.jp/contests/abc283/tasks/abc283_b
 */