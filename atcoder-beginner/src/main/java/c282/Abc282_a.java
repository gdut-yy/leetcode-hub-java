package c282;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc282_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stringBuilder.append((char) ('A' + i));
        }
        System.out.println(stringBuilder.toString());
    }
}
/*
A - Generalized ABC
https://atcoder.jp/contests/abc282/tasks/abc282_a
 */