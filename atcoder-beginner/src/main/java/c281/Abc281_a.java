package c281;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc281_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        for (int i = N; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
/*
A - Count Down
https://atcoder.jp/contests/abc281/tasks/abc281_a
 */