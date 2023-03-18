package c285;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc285_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a / 2 == b || b / 2 == a) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }
}
/*
A - Edge Checker 2
https://atcoder.jp/contests/abc285/tasks/abc285_a
 */