package lq240406;

import java.util.Scanner;

public class LQ240406T4 {
    static int n, q;
    static char[] s;
    static int[][] lrk;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        s = scanner.next().toCharArray();
        lrk = new int[q][3];
        for (int i = 0; i < q; i++) {
            lrk[i][0] = scanner.nextInt();
            lrk[i][1] = scanner.nextInt();
            lrk[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] diff = new int[n + 1];
        for (int[] p : lrk) {
            int i = p[0], j = p[1], k = p[2] % 26;
            diff[i - 1] += k;
            diff[j] -= k;
        }

        char[] ans = new char[n];
        int sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            ans[i] = (char) ((sumD + (s[i] - 'a')) % 26 + 'a');
        }
        return new String(ans);
    }
}
/*
字符迁移【算法赛】

差分数组。
 */