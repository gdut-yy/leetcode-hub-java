package c285;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc285_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String S = scanner.next();
        int len = S.length();
        long res = 0;
        long a = 1;
        for (int i = len - 1; i >= 0; i--) {
            res += (S.charAt(i) - 'A' + 1) * a;
            a *= 26;
        }
        System.out.println(res);
    }
}
/*
C - abc285_brutmhyhiizp
https://atcoder.jp/contests/abc285/tasks/abc285_c
 */