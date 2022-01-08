package template;

import java.math.BigInteger;

/**
 * 排列组合
 * <p>
 * Arrangement / Permutation 排列
 * A(n, m) = n! / (n-m)! （n 为下标）
 * <p>
 * Combination 组合
 * C(n, m) = n! / m!(n-m)! （n 为下标）
 */
public class Arrangement {
    private long arrangement(int n, int m) {
        return factorial(n).divide(factorial(n - m)).longValue();
    }

    private long combination(int n, int m) {
        m = Math.min(n - m, m);
        return factorial(n).divide(factorial(m)).divide(factorial(n - m)).longValue();
    }

    // factorial(n) = n!
    private BigInteger factorial(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = n; i >= 1; i--) {
            res = res.multiply(new BigInteger(String.valueOf(i)));
        }
        return res;
    }

    public static void main(String[] args) {
        Arrangement arrangement = new Arrangement();
        System.out.println(arrangement.arrangement(10, 10));
        System.out.println(arrangement.arrangement(8, 8));
        System.out.println(arrangement.combination(13, 4));
        System.out.println(arrangement.combination(9, 4));
    }
}
