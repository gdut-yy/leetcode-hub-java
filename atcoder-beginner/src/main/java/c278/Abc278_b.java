package c278;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc278_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int H = scanner.nextInt();
        int M = scanner.nextInt();

        int t = H * 60 + M;
        for (int i = t; i < t + 1440; i++) {
            int time = i % 1440;
            String hStr = "00" + (time / 60);
            String mStr = "00" + (time % 60);

            int a = hStr.charAt(hStr.length() - 2) - '0';
            int b = hStr.charAt(hStr.length() - 1) - '0';
            int c = mStr.charAt(mStr.length() - 2) - '0';
            int d = mStr.charAt(mStr.length() - 1) - '0';

            int newH = a * 10 + c;
            int newM = b * 10 + d;
            if (newH * 60 + newM < 1440 && newM < 60) {
                System.out.println((a * 10 + b) + " " + (c * 10 + d));
                return;
            }
        }
    }
}
/*
B - Misjudge the Time
https://atcoder.jp/contests/abc278/tasks/abc278_b
 */