package lq231209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ231209T2 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        // 素数筛
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n + 1; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n + 1; j++) {
                isPrime[i * primes.get(j)] = false;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }

        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + a[i];
        }

        long ans = Long.MIN_VALUE;
        for (Integer span : primes) {
            for (int i = 0; i + span <= n; i++) {
                ans = Math.max(ans, ps[i + span] - ps[i]);
            }
        }
        return String.valueOf(ans);
    }
}
/*
小蓝的金牌梦【算法赛】

素数筛 + 前缀和
 */