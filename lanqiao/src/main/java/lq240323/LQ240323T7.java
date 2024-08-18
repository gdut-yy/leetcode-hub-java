package lq240323;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.LongFunction;

public class LQ240323T7 {
    static long n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            n = scanner.nextLong();
            k = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        // 若 n = p1^c1 * p2^c2 * ... * pt^ct
        // 我们求 f_k(n) = f_k(p1^c1) * ... * f_k(pt^ct)
        long ans = 1;
        Map<Long, Long> primes = new PrimeFactor().build(n);
        for (Map.Entry<Long, Long> entry : primes.entrySet()) {
            long p = entry.getKey(), c = entry.getValue();

            // 我们要求的是 p^0 + p^k + ... + p^vk
            // (p^k)^0 + (p^k)^1 + ... + (p^k)^v
            long v = quickPow(p, k, MOD);
            long cur = 1, tot = 1;
            for (int i = 0; i < c; i++) {
                cur = cur * v % MOD;
                tot += cur;
            }
            ans = ans * tot % MOD;
        }
        return String.valueOf(ans);
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b, long MOD) {
        a %= MOD;
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = cheng(res, a, MOD);
            a = cheng(a, a, MOD);
            b >>= 1;
        }
        return res;
    }

    // 龟速乘
    static long cheng(long a, long b, long MOD) {
        long s = 0;
        while (b != 0) {
            if ((b & 1) != 0) s = (s + a) % MOD;
            a = (a + a) % MOD;
            b >>= 1;
        }
        return s;
    }

    // TLE
//    static Map<Long, Long> prime_factor(long num) {
//        Map<Long, Long> cnt = new HashMap<>();
//        for (long i = 2; i * i <= num; i++) {
//            // 如果 i 能够整除 N，说明 i 为 N 的一个质因子。
//            if (num % i == 0) {
//                int c = 0;
//                while (num % i == 0) {
//                    num /= i;
//                    c++;
//                }
//                cnt.merge(i, (long) c, Long::sum);
//            }
//        }
//        // 说明再经过操作之后 N 留下了一个素数
//        if (num > 1) {
//            cnt.merge(num, 1L, Long::sum);
//        }
//        return cnt;
//    }

    static class PrimeFactor {
        Map<Long, Long> mp;

        Map<Long, Long> build(long n) {
            mp = new HashMap<>();
            init(n, 1);
            return mp;
        }

        void add(long n, long cnt) {
            mp.merge(n, cnt, Long::sum);
        }

        long[] count(long n, long fac) {
            long c = mp.getOrDefault(n, 1L);
            return new long[]{n / fac, c};
        }

        void init(long n, long gain) {
            if (n > 7e5) {
                if (miller_rabin(n)) {
                    add(n, gain);
                } else {
                    long fac = pollard_rho(n);
                    long[] C = count(n, fac);
                    init(fac, C[1] * gain);
                    if (C[0] > 1) init(C[0], gain);
                }
            } else {
                try_divide(n, gain);
            }
        }

        void try_divide(long n, long gian) {
            long i = 2;
            while (i * i <= n) {
                if (n % i == 0) {
                    add(i, gian);
                    n /= i;
                } else {
                    i++;
                }
            }
            if (n > 1) add(n, gian);
        }

//        boolean Miller_Rabin(long p) {  // 判断素数
//            if (p < 2) return false;
//            if (p == 2) return true;
//            if (p == 3) return true;
//            long d = p - 1, r = 0;
//            while ((d & 1) == 0) {
//                ++r;
//                d >>= 1;
//            } // 将d处理为奇数
//            for (long k = 0; k < 10; ++k) {
//                long a = rand() % (p - 2) + 2;
//                long x = quickPow(a, d, p);
//                if (x == 1 || x == p - 1) continue;
//                for (int i = 0; i < r - 1; ++i) {
//                    x = cheng(x, x, p);
//                    if (x == p - 1) break;
//                }
//                if (x != p - 1) return false;
//            }
//            return true;
//        }
//
//
//        long Pollard_Rho(long x) {
//            long s = 0, t = 0;
//            long c = rand() % (x - 1) + 1;
//            int step = 0, goal = 1;
//            long val = 1;
//            for (goal = 1; ; goal *= 2, s = t, val = 1) {  // 倍增优化
//                for (step = 1; step <= goal; ++step) {
//                    t = (cheng(t, t, x) + c) % x;
//                    val = cheng(val, Math.abs(t - s), x);
//                    if ((step % 127) == 0) {
//                        long d = getGCD(val, x);
//                        if (d > 1) return d;
//                    }
//                }
//                long d = getGCD(val, x);
//                if (d > 1) return d;
//            }
//        }

        boolean miller_rabin(long p) {
            if (p <= 4) return p == 2 || p == 3;
            long pow_2 = 0, tmp = p - 1;
            while (tmp % 2 == 0) {
                tmp /= 2;
                pow_2 += 1;
            }
            for (int a : new int[]{2, 3, 5, 7, 11}) {
                long basic = quickPow(a, tmp, p);
                if (basic == 0 || basic == 1 || basic == p - 1) continue;
                for (int i = 1; i < pow_2; i++) {
                    basic = cheng(basic, basic, p);
                    if (basic == 1) return false;
                    if (basic == p - 1) break;
                }
                if (basic != p - 1) return false;
            }
            return true;
        }

        long pollard_rho(long n) {
            long bias = randint(3, n - 1);
            LongFunction<Long> update = i -> (cheng(i, i, n) + bias) % n;
            long x = randint(0, n - 1);
            long y = update.apply(x);
            while (x != y) {
                long factor = getGCD(Math.abs(x - y), n);
                if (factor != 1) return factor;
                x = update.apply(x);
                y = update.apply(update.apply(y));
            }
            return n;
        }

        long getGCD(long num1, long num2) {
            return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
        }

        Random random = new Random();

        long rand() {
            return Math.abs(random.nextLong());
        }

        long randint(long a, long b) {
            long len = b - a + 1;
            return rand() % len + a;
        }
    }
}
/*
赛博奴隶主【算法赛】

Pollard's rho algorithm
@小羊肖恩Yawn_Sean

4
75211667678790878 17835433637912935
42221789871230144 66506029121103377
23131235857152051 15843857531930365
51800094539198636 35409974639166197

64557650
925202269
40018878
719471736
 */