package c300;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Abc300_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        long n = scanner.nextLong();
        System.out.println(solve(n));
    }

    private static final int MAX_N = (int) (1e6 + 1);
    private static List<Integer> primes;

    private static String solve(long n) {
        // 300 = 2^2 * 3 * 5^2
        // 预处理 1e6 以内质数
        if (primes == null) {
            primes = new ArrayList<>();
            boolean[] isPrime = new boolean[MAX_N];
            Arrays.fill(isPrime, true);
            for (int i = 2; i < MAX_N; i++) {
                if (isPrime[i]) {
                    primes.add(i);
                }
                for (int j = 0; j < primes.size() && i * primes.get(j) < MAX_N; j++) {
                    isPrime[i * primes.get(j)] = false;
                    if (i % primes.get(j) == 0) {
                        break;
                    }
                }
            }
        }

        int ans = 0;
        int sz = primes.size();
        for (int i = 0; i < sz; i++) {
            long a = primes.get(i);
            for (int j = i + 1; j < sz; j++) {
                long b = primes.get(j);
                if (a * a * b > n) {
                    break;
                }
                long c2 = n / a / a / b;

                int left = 1;
                int right = sz + 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 边界二分 F, F,..., F, [T, T,..., T]
                    // ----------------------^
                    if ((long) primes.get(mid) * primes.get(mid) > c2) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                int cIdx = left - 1;
                if (cIdx <= j) {
                    break;
                }
                ans += cIdx - j;
            }
        }

        return String.valueOf(ans);
    }
}
/*
D - AABCC
https://atcoder.jp/contests/abc300/tasks/abc300_d

题目大意：
有多少个不大于 N 的正整数可以表示为 2 ×b×c 2 有三个质数 a,b, c 使得 a<b<c?

枚举每对 a b，二分找出最大的 c，加法原理累加。
======

Input
1000
Output
3

Input
1000000000000
Output
2817785
 */