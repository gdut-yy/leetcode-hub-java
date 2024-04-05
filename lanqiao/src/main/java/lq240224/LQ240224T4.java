package lq240224;

import java.util.Scanner;

public class LQ240224T4 {
    static long x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (x % 8 != 0 || x == 0) {
            return "No";
        }
        // 8 = 3^2 - 1^2
        // 16 = 5^2 - 3^2
        // 24 = 7^2 - 5^2
        x /= 8;
        x = x * 2 - 1;
        return "Yes" + System.lineSeparator()
                + x + " " + (x + 2);
    }
}
/*
你不干？有的是帕鲁干！【算法赛】

结论题。
两个连续正奇数的平方之差是 8 的倍数。注意特判 0。
 */