package lq240531;

import java.math.BigInteger;
import java.util.Scanner;

public class LQ240531T4 {
    static String a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.next();
        b = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        BigInteger ans = new BigInteger(a + b);
        ans = ans.mod(BigInteger.valueOf((long) (1e9 + 7)));
        return ans.toString();
    }
}
/*
字符串加法【算法赛】

BigInteger 库函数。
 */