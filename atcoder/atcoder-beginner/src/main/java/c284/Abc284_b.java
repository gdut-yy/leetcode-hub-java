package c284;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc284_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (A[i] % 2 == 1) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
/*
B - Multi Test Cases
https://atcoder.jp/contests/abc284/tasks/abc284_b
 */