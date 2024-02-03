package lq231223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ231223T2 {
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

    static final int MAX_N = (int) (1e5 + 5);
    static List<Integer> primes;

    static {
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

    private static String solve() {
        long ans = 0;
        for (int v : a) {
            int i = lowerBound(primes, v);
            int res = primes.get(i) - v;
            if (i > 0) {
                res = Math.min(res, v - primes.get(i - 1));
            }
            ans += res;
        }
        return String.valueOf(ans);
    }

    static int lowerBound(List<Integer> a, long key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
质数王国【算法赛】

素数筛 + 二分
 */