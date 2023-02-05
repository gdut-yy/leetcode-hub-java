package c285;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc285_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        String S = " " + scanner.next();

        // S1 ~ S6
        char[] chars = S.toCharArray();
        for (int i = 1; i < N; i++) {
            int l = 0;
            for (; l + i <= N; l++) {
                if (chars[l] == chars[l + i]) {
                    break;
                }
            }
            System.out.println(l - 1);
        }
    }
}
/*
B - Longest Uncommon Prefix
https://atcoder.jp/contests/abc285/tasks/abc285_b
 */