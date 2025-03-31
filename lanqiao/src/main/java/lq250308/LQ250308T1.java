package lq250308;

import java.util.Scanner;

public class LQ250308T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        for (int i = 1; i <= 2025; i++) {
            if (i % 3 == 0 || i % 8 == 0 || i % 38 == 0) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
38-红包【算法赛】
 */