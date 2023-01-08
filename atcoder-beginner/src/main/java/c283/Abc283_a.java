package c283;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc283_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int res = (int) Math.pow(A, B);
        System.out.println(res);
    }
}
/*
A - Power
https://atcoder.jp/contests/abc283/tasks/abc283_a
 */