package lq240713;

import java.util.Scanner;

public class LQ240713T8 {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (m > 20) return String.valueOf(m);

        for (int k = m; k <= 2000; k++) {
            long ans = 1;
            for (int i = 0; i < m; i++) {
                ans = ans * (k - i);
                if (ans >= (long) n * m) {
                    return String.valueOf(k);
                }
            }
        }
        return "-1";
    }
}
/*
涂涂画画【算法赛】

n \cdot n \le \frac{k!}{(k-m)!}
由于 nm <= 10^18，当 m 大于 20 时，上述不等式一定成立，因此答案一定为 m。当 m 小于 20 时，可以在 2000 以内枚举 k 来找到满足不等式的最小 k。
 */