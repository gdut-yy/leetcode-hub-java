package c279;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc279_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String S = scanner.next();
        int res = 0;
        for (char ch : S.toCharArray()) {
            if (ch == 'w') {
                res += 2;
            } else {
                res += 1;
            }
        }
        System.out.println(res);
    }
}
/*
A - wwwvvvvvv
https://atcoder.jp/contests/abc279/tasks/abc279_a
 */