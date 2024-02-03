package lq231209;

import java.util.Arrays;
import java.util.Scanner;

public class LQ231209T3 {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        char[] cs = new char[n];
        Arrays.fill(cs, '0');
        for (int i = 0; i < n; i++) {
            if (m > 0) {
                int add = Math.min(9, m);
                cs[i] = (char) (cs[i] + add);
                m -= add;
            }
        }
        return new String(cs);
    }
}
/*
构造数字【算法赛】

贪心。
 */