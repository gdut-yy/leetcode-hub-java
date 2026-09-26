import java.io.PrintWriter;
import java.util.Scanner;

public class espressif01 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        // 吃掉第一行剩余内容，再读取第二行的数字串
        scanner.nextLine();
        String digits = scanner.nextLine();

        // 从高位到低位逐位取模：rem = (rem * n + digit) % m
        long remainder = 0;
        for (int i = 0; i < digits.length(); i++) {
            int d = digitValue(digits.charAt(i));
            // 非法字符或超出该进制的数码，数字到此结束
            if (d < 0 || d >= n) {
                break;
            }
            remainder = (remainder * n + d) % m;
        }
        out.println(remainder);
    }

    private static int digitValue(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        return -1;
    }
}
/*
大数求余
https://leetcode.cn/leetbook/read/espressif/5wim2t/

求一个 n (1 < n <= 36)进制正整数除以 m (1 < m <= 36) 的余数。
输入描述:
每组输入包括2行。
第1行只包含2个整数n，m，其中n表示被除数的进制数，m表示除数（十进制）。
第2行，包含一个整数，该整数由连续进制字符(‘0’-‘9’, ‘a’-‘z’，其中‘a’表示10，’z’表示35)组成，若发现非法字符(比如空格等，在10进制下，’a’-‘z’也属于非法字符，以此类推)，表示整数结束。若未找到有效字符，则认为该数字为0.
输出描述:
输出只有一行，只有一个整数，表示余数，以10进制表示。
备注:
示例1
输入
11 10
123abc
输出
6
 */
