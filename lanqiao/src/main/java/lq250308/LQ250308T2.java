package lq250308;

import java.util.Scanner;

public class LQ250308T2 {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;
        int i = 0;
        int mx = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && s[i] == s[st]; i++) {
            }
            if (s[st] == 'a') {
                mx = Math.max(mx, i - st);
            }
        }
        return "a".repeat(mx + 1);
    }
}
/*
祝福语【算法赛】
 */