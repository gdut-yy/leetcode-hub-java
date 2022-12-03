package template;

import java.util.ArrayList;
import java.util.List;

/**
 * 分解质因数
 * https://oi-wiki.org/math/number-theory/pollard-rho/
 * CF1744E1
 * Abc280_d
 */
public class Factor {
    /**
     * 分解质因数
     */
    private static List<Long> getFactorPrime(long num) {
        List<Long> resList = new ArrayList<>();
        for (long i = 2; i * i <= num; i++) {
            // 如果 i 能够整除 N，说明 i 为 N 的一个质因子。
            if (num % i == 0) {
                while (num % i == 0) {
                    num /= i;
                }
                resList.add(i);
            }
        }
        // 说明再经过操作之后 N 留下了一个素数
        if (num != 1) {
            resList.add(num);
        }
        return resList;
    }

    /**
     * 因数
     * https://oeis.org/A066150
     */
    private static List<Long> getFactors(long num) {
        List<Long> factors = new ArrayList<>();
        for (long i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                factors.add(num / i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.println(Factor.getFactorPrime(123456789011L));
        System.out.println(Factor.getFactorPrime(720720));

        System.out.println(Factor.getFactors(123456789011L));
        System.out.println(Factor.getFactors(720720));
        // 240
        System.out.println(Factor.getFactors(720720).size());
    }
}

