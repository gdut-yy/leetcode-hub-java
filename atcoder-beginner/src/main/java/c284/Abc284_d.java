package c284;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc284_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long N = scanner.nextLong();
            long p = -1;
            long q = -1;
            for (long i = 2; i * i * i <= N; i++) {
                if (N % i == 0) {
                    // i * j == N
                    long j = N / i;
                    if (j % i == 0) {
                        p = i;
                        q = j / i;
                    } else {
                        q = i;
                        p = (long) Math.sqrt(j);
                    }
                    break;
                }
            }
            System.out.println(p + " " + q);
        }
    }
}
/*
D - Happy New Year 2023
https://atcoder.jp/contests/abc284/tasks/abc284_d

质因数分解
时间复杂度 O(3√n)
 */