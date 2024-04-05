package lq240127;

import java.util.Scanner;

public class LQ240127T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve());
    }

    private static String solve() {
        int ans = Integer.bitCount(2024);
        return String.valueOf(ans);
    }
}
/*
美丽的2024【算法赛】
 */