package lq240713;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LQ240713T3 {
    static int n;
    static char[] s;
    static int m;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        m = scanner.nextInt();
        lr = new int[m][2];
        for (int i = 0; i < m; i++) {
            lr[i][0] = scanner.nextInt() - 1;
            lr[i][1] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] ps = new int[n + 1];
        for (int i = 1; i < n; i++) {
            boolean b = s[i - 1] == '1' && s[i] == '0';
            ps[i] = ps[i - 1] + (b ? 1 : 0);
        }
        ps[n] = ps[n - 1];

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = lr[i][0], r = lr[i][1];
            ans[i] = ps[r] - ps[l];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
帕鲁服务器崩坏【算法赛】

前缀和。
 */