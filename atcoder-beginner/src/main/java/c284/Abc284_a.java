package c284;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc284_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = scanner.next();
        }
        for (int i = N - 1; i >= 0; i--) {
            System.out.println(S[i]);
        }
    }
}
/*
A - Sequence of Strings
https://atcoder.jp/contests/abc284/tasks/abc284_a
 */