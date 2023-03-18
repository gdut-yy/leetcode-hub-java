package c290;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc290_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (k == 0) {
                System.out.println(s.substring(0, i) + "x".repeat(n - i));
                return;
            }
            if (chars[i] == 'o') {
                k--;
            }
        }
        System.out.println(s);
    }
}
/*
B - Qual B
https://atcoder.jp/contests/abc290/tasks/abc290_b
 */