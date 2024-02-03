package lq231209;

import java.math.BigInteger;
import java.util.Scanner;

public class LQ231209T5 {
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

    private static String wa() {
        // 爆 long
        long s = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i] * s;
            s += a[i];
        }
        return String.valueOf(ans);
    }

    private static String solve() {
        BigInteger s = BigInteger.ZERO;
        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            ans = ans.add(BigInteger.valueOf(a[i]).multiply(s));
            s = s.add(BigInteger.valueOf(a[i]));
        }
        return ans.toString();
    }
}
/*
合并石子加强版【算法赛】

诈骗题。
\sum_{i=1}^{n} a_i \times s_{i-1}
 */