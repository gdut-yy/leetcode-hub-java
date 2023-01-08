package c283;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc283_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String S = scanner.next();

        int cnt = 0;
        while (S.length() > 0) {
            if (S.endsWith("00")) {
                S = S.substring(0, S.length() - 2);
            } else {
                S = S.substring(0, S.length() - 1);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
/*
C - Cash Register
https://atcoder.jp/contests/abc283/tasks/abc283_c
 */