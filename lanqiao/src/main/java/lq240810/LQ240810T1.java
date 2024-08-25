package lq240810;

import java.util.Scanner;

public class LQ240810T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve());
    }

    private static String solve() {
        int ans = (365 + (7 - 1)) / 7;
        return String.valueOf(ans);
    }
}
/*
喜鹊罢工【算法赛】
 */