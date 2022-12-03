package c280;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc280_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        long K = scanner.nextLong();

        long min = 0;
        for (long i = 2; i * i <= K; i++) {
            if (K % i == 0) {
                int cnt = 0;
                while (K % i == 0) {
                    K /= i;
                    cnt++;
                }
                long n = 0;
                while (cnt > 0) {
                    n += i;
                    long x = n;
                    while (x % i == 0) {
                        x /= i;
                        cnt--;
                    }
                }
                min = Math.max(min, n);
            }
        }
        min = Math.max(min, K);
        System.out.println(min);
    }
}
/*
D - Factorial and Multiple
https://atcoder.jp/contests/abc280/tasks/abc280_d

类似分解质因数
https://oi-wiki.org/math/number-theory/pollard-rho/
 */