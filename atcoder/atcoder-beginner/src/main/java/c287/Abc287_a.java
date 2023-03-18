package c287;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc287_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int cntFor = 0;
        int cntAgainst = 0;
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (s.equals("For")) {
                cntFor++;
            } else {
                cntAgainst++;
            }
        }
        System.out.println(cntFor > cntAgainst ? "Yes" : "No");
    }
}
/*
A - Majority
https://atcoder.jp/contests/abc287/tasks/abc287_a
 */