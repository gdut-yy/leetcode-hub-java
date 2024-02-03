package lq231125;

import java.util.Scanner;

public class LQ231125T3 {
    static long n;
    static int q;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        q = scanner.nextInt();
        a = new long[q];
        for (int i = 0; i < q; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    private static String solve() {
        String[] ans = new String[q];
        for (int i = 0; i < q; i++) {
            long s = a[i];
            if (s == 0) {
                ans[i] = "1 1";
            } else if (s == 1) {
                ans[i] = "1 2";
            } else {
                long row = (s - 2) / 3 + 1;
                long offset = row - 1;
                long col = (s - 2) % 3 + offset;
                ans[i] = (row + 1) + " " + (col + 1);
            }
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
压缩矩阵【算法赛】

找规律。
 */