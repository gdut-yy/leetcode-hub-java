package lq231014;

import java.util.Scanner;

public class LQ231014T5 {
    static int n;
    static String s;
    static char[] t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(t[i])) t[i] = Character.toLowerCase(t[i]);
            else t[i] = Character.toUpperCase(t[i]);
        }

        char[] txt = (s + s).toCharArray();
        char[] pat = t;
        int[] pi = prefix_function(pat);

        int ans = n;
        for (int i = 0, j = 0; i < txt.length; i++) {
            while (j > 0 && txt[i] != pat[j]) j = pi[j - 1];
            if (txt[i] == pat[j]) j++;
            if (j == n) {
                ans = Math.min(ans, Math.min(i - n + 1, n * 2 - i - 1));
                j = pi[j - 1];
            }
        }
        return ans == n ? "No" : "Yes" + System.lineSeparator() + ans;
    }

    private static int[] prefix_function(char[] s) {
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) j = pi[j - 1];
            if (s[i] == s[j]) j++;
            pi[i] = j;
        }
        return pi;
    }
}
/*
契合匹配【算法赛】

KMP
 */