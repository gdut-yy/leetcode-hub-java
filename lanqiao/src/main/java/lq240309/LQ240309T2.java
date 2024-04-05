package lq240309;

import java.util.Scanner;

public class LQ240309T2 {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static int[] MP = {
            0b0111111, // 0
            0b0000110, // 1
            0b1011011, // 2
            0b1001111, // 3
            0b1100110, // 4
            0b1101101, // 5
            0b1111101, // 6
            0b0000111, // 7
            0b1111111, // 8
            0b1101111, // 9
            //6543210
    };

    private static String solve() {
        int n = s.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = MP[s[i] - '0'];
            int b = MP[t[i] - '0'];
            ans += Integer.bitCount((a | b) - (a & b));
        }
        return String.valueOf(ans);
    }
}
/*
霓虹【算法赛】

二进制压缩
 */