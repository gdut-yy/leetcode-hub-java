package c276;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc276_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int gcd = A[0];
        for (int x : A) {
            gcd = getGCD(gcd, x);
        }

        int res = 0;
        for (int x : A) {
            // 倍数
            int multiple = x / gcd;
            int cnt = count(multiple);
            if (cnt >= 0) {
                res += cnt;
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(res);
    }

    private static int count(int num) {
        int res = 0;
        while (num % 2 == 0) {
            num /= 2;
            res++;
        }
        while (num % 3 == 0) {
            num /= 3;
            res++;
        }
        return num == 1 ? res : -1;
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
D - Divide by 2 or 3
https://atcoder.jp/contests/abc276/tasks/abc276_d
 */