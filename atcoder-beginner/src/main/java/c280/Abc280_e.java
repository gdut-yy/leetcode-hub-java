package c280;

public class Abc280_e {
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        // 281/100 (mod 998244353) = 229596204
        System.out.println(281 * inv(100, MOD) % MOD);
    }

    private static long inv(long a, long mod) {
        return quickPow(a, mod - 2, mod);
    }

    private static long quickPow(long a, long b, long mod) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
/*
E - Critical Hit
https://atcoder.jp/contests/abc280/tasks/abc280_e
 */