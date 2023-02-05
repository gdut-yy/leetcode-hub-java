package c288;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc288_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        Arrays.sort(s, 0, k);
        for (int i = 0; i < k; i++) {
            System.out.println(s[i]);
        }
    }
}
/*
B - Qualification Contest
https://atcoder.jp/contests/abc288/tasks/abc288_b
 */