package template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 质数/素数
 */
public class Prime {
    /**
     * 判断 num 是否是质数
     * 时间复杂度 O(√n)
     */
    private static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 埃氏筛
     * 时间复杂度 O(nloglogn)
     * 空间复杂度 O(n)
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                cnt++;
                if (i * i < n) {
                    for (int j = i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return cnt;
    }

    /**
     * 线性筛
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int countPrimes2(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                isPrime[i * primes.get(j)] = false;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
