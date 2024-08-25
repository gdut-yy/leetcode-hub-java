package lq240810;

import java.util.Scanner;

public class LQ240810T3 {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            s = scanner.next().toCharArray();
            t = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] cnt = new int[26];
        int n = s.length;
        for (int i = 0; i < n; i++) {
            cnt[s[i] - 'a']++;
            cnt[t[i] - 'a']--;
        }

        // 正数，负数
        int pos = 0, neg = 0;
        for (int c : cnt) {
            if (c >= 0) pos += c;
            else neg -= c;
        }
        return Math.min(pos, neg) <= 1 ? "YES" : "NO";
    }
}
/*
织女的考验【算法赛】
 */