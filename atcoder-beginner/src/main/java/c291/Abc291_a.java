package c291;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc291_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        for (int i = 1; i <= s.length(); i++) {
            char ch = s.charAt(i - 1);
            if (Character.isUpperCase(ch)) {
                System.out.println(i);
                return;
            }
        }
    }
}
/*
A - camel Case
https://atcoder.jp/contests/abc291/tasks/abc291_a
 */