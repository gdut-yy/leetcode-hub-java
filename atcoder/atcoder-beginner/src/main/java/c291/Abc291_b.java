package c291;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc291_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] x = new int[n * 5];
        for (int i = 0; i < n * 5; i++) {
            x[i] = scanner.nextInt();
        }
        Arrays.sort(x);

        long sum = 0L;
        for (int i = n; i < n * 4; i++) {
            sum += x[i];
        }
        double res = sum / 3.0 / n;
        System.out.println(res);
    }
}
/*
B - Trimmed Mean
https://atcoder.jp/contests/abc291/tasks/abc291_b
 */