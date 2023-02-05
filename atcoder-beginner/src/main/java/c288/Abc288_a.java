package c288;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc288_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        while (n-- > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            System.out.println(a + b);
        }
    }
}
/*
A - Many A+B Problems
https://atcoder.jp/contests/abc288/tasks/abc288_a
 */