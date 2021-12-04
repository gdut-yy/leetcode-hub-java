package template;

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
        return factorial(n) / factorial(n - m);
    }

    private long combination(int n, int m) {
        m = Math.min(n - m, m);
        return factorial(n) / factorial(m) / factorial(n - m);
    }

    // res = n!
    private long factorial(int n) {
        long res = 1;
        while (n > 1) {
            res *= n;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        Arrangement arrangement = new Arrangement();
        System.out.println(arrangement.arrangement(10, 10));
        System.out.println(arrangement.arrangement(8, 8));
        System.out.println(arrangement.combination(10, 8));
        System.out.println(arrangement.combination(8, 8));
    }
}
