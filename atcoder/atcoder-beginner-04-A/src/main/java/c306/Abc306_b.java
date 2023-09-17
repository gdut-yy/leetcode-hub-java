package c306;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc306_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] a = new int[64];
        for (int i = 0; i < 64; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(a));
    }

    private static String solve(int[] a) {
        long ans = 0;
        for (int i = 0; i < 63; i++) {
            ans += (long) a[i] << i;
        }
        // 2^63 爆 long
        if (a[63] == 1) {
            return String.valueOf(new BigInteger("9223372036854775808").add(new BigInteger(String.valueOf(ans))));
        }
        return String.valueOf(ans);
    }
}
/*
B - Base 2
https://atcoder.jp/contests/abc306/tasks/abc306_b

题目大意：
给定一个序列 a =(a0, a1,...,a63)，长度为 64，由 0 和 1 组成。
找到 A0·2^0 + A1·2^1 + ... + A63·2^63

1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1
9223372036854775807 * 2

9,223,372,036,854,775,808
======

Input 1
1 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
Output 1
13

Input 2
1 0 1 0 1 0 0 0 0 1 0 0 1 1 0 1 1 1 1 0 0 0 1 0 0 1 1 1 1 1 1 0 0 0 0 1 0 1 0 1 0 1 1 1 1 0 0 1 1 0 0 0 0 1 0 1 0 1 0 1 0 0 0 0
Output 2
766067858140017173
 */