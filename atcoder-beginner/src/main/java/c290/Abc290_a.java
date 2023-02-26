package c290;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc290_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int bi = scanner.nextInt();
            sum += a[bi - 1];
        }
        System.out.println(sum);
    }
}
/*
A - Contest Result
https://atcoder.jp/contests/abc290/tasks/abc290_a
 */