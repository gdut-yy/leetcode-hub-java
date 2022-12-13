package c281;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc281_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String S = scanner.next();
        System.out.println(solve(S));
    }

    private static String solve(String s) {
        if (s.length() != 8) {
            return "No";
        }
        if (!Character.isUpperCase(s.charAt(0)) || !Character.isUpperCase(s.charAt(7))) {
            return "No";
        }
        for (int i = 1; i < 7; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return "No";
            }
        }
        int n = Integer.parseInt(s.substring(1, 7));
        if (n < 100000 || n > 999999) {
            return "No";
        }
        return "Yes";
    }
}
/*
B - Sandwich Number
https://atcoder.jp/contests/abc281/tasks/abc281_b
 */