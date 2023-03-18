package c293;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc293_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();

        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i * 2 + 1 < n; i++) {
            char tmp = cs[i * 2];
            cs[i * 2] = cs[i * 2 + 1];
            cs[i * 2 + 1] = tmp;
        }
        System.out.println(new String(cs));
    }
}
/*
A - Swap Odd and Even
https://atcoder.jp/contests/abc293/tasks/abc293_a

 */