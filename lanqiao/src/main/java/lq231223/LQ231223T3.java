package lq231223;

import java.util.Arrays;
import java.util.Scanner;

public class LQ231223T3 {
    static long n;
    static int m;
    static long[] x, y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        m = scanner.nextInt();
        x = new long[m];
        y = new long[m];
        for (int i = 0; i < m; i++) {
            x[i] = scanner.nextLong();
            y[i] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long minX = Arrays.stream(x).min().orElseThrow();
        long maxX = Arrays.stream(x).max().orElseThrow();
        long minY = Arrays.stream(y).min().orElseThrow();
        long maxY = Arrays.stream(y).max().orElseThrow();

        long dx = maxX - minX + 1;
        long dy = maxY - minY + 1;
        long ans = Math.max(dx, dy);
        return String.valueOf(ans);
    }
}
/*
房顶漏水啦【算法赛】

贪心。
 */