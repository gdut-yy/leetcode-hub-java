package c280;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc280_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String S = scanner.next();
        String T = scanner.next();

        int len = S.length();
        int res = T.length();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) != T.charAt(i)) {
                res = i + 1;
                break;
            }
        }
        System.out.println(res);
    }
}
/*
C - Extra Character
https://atcoder.jp/contests/abc280/tasks/abc280_c

枚举
 */