package lq231014;

import java.util.Scanner;

public class LQ231014T2 {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        while (q-- > 0) {
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int id = 1;
        for (char c : s) {
            if (c == 'R') id = id * 2 + 1;
            else id *= 2;
        }
        int ans = id - (1 << s.length) + 1;
        return String.valueOf(ans);
    }
}
/*
数树数【算法赛】

找规律。
 */