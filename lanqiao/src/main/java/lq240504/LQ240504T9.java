package lq240504;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import static java.math.RoundingMode.FLOOR;

public class LQ240504T9 {
    static String l, r; // 1e28

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        l = scanner.next();
        r = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = f(new BigDecimal(r)) - f(new BigDecimal(l).subtract(BigDecimal.ONE));
        return String.valueOf(ans);
    }

    static Set<Pair> pairs;
    static int v1 = 22472; // 8 * 53 * 53 = 22472
    static int mod1 = v1 / 2;
    static long v2 = 1000003 * 9;

    static {
        pairs = new HashSet<>();

        List<Integer>[] tmp1 = new ArrayList[v1];
        Arrays.setAll(tmp1, e -> new ArrayList<>());
        for (int i = 0; i < mod1; i++) {
            tmp1[i * i % v1].add(i);
        }

        for (int i = 0; i < mod1 + 1; i++) {
            // if tmp1[i] and tmp1[-i]:
            int i1 = Math.floorMod(-i, v1);

            if (!tmp1[i].isEmpty() && !tmp1[i1].isEmpty()) {
                for (Integer x : tmp1[i]) {
                    for (Integer y : tmp1[i1]) {
                        if (x <= y) pairs.add(new Pair(y, x));
                        if (y <= x) pairs.add(new Pair(x, y));
                    }
                }
            }
        }
    }

    static long f(BigDecimal big_x) {
        // x //= v2 ** 2
//        x = Math.floorDiv(x, v2 * v2);
        BigDecimal big_v2 = BigDecimal.valueOf(v2);
        long x = big_x.divide(big_v2.multiply(big_v2), 0, FLOOR).longValue();

        long cnt = 0;
        for (Pair p : pairs) {
            long a = p.x, b = p.y;
            long res = 0;
            long ca = a;
            while (ca * ca + b * b <= x) {
                res += Math.floorDiv(isqrt(x - ca * ca) - b, mod1) + 1;
                ca += mod1;
            }
            if (a != b) res *= 2;
            cnt += res;
        }
        return cnt;
    }

    static long isqrt(long x) {
        return (long) Math.sqrt(x);
    }

    static class Pair {
        long x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
/*
Yaya 与数数【算法赛】

预处理，考虑每一个质数对应的 p^k
0,1,...,p^k-1 中所有数的平方 mod p^k 的结果进行计算
可以用哈希表找到所有的匹配位置
@小羊肖恩Yawn_Sean

毒瘤题，Java 要用到 BigDecimal
 */