package c280;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc280_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = scanner.nextInt();
        }

        long[] A = new long[N];
        A[0] = S[0];
        for (int i = 1; i < N; i++) {
            A[i] = S[i] - S[i - 1];
        }
        String res = Arrays.stream(A).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(res);
    }
}
/*
B - Inverse Prefix Sum
https://atcoder.jp/contests/abc280/tasks/abc280_b

前缀和逆运算 - 差分
 */