package nc65507;

import java.util.Scanner;

public class NC65507C {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int cntDigit = 0;
        int cntLowercase = 0;
        int cntUppercase = 0;
        int cntCode = 0;
        for (char c : s) {
            if (Character.isDigit(c)) cntDigit++;
            else if (Character.isLowerCase(c)) cntLowercase++;
            else if (Character.isUpperCase(c)) cntUppercase++;
            else cntCode++;
        }

        long ans = 0;
        for (char c : s) {
            if (Character.isDigit(c)) {
                if (cntDigit > 1) {
                    ans += 10 + 26 + 26 + 4 - 1;
                } else {
                    ans += 10 - 1;
                }
            } else if (Character.isLowerCase(c)) {
                if (cntLowercase > 1) {
                    ans += 10 + 26 + 26 + 4 - 1;
                } else {
                    ans += 26 - 1;
                }
            } else if (Character.isUpperCase(c)) {
                if (cntUppercase > 1) {
                    ans += 10 + 26 + 26 + 4 - 1;
                } else {
                    ans += 26 - 1;
                }
            } else {
                if (cntCode > 1) {
                    ans += 10 + 26 + 26 + 4 - 1;
                } else {
                    ans += 4 - 1;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
小红的密码修改
https://ac.nowcoder.com/acm/contest/65507/C

题目描述
已知合法的密码有以下要求：
1. 长度在 8 到 16 之间。
2. 必须包含大写字母、小写字母、数字、特殊符号这四种字符。其中特殊符号只能是英文逗号、英文句号、英文问号和英文感叹号这四种。
小红准备修改她目前的密码，但她最多只会修改一个字符，因为修改多了小红就容易忘记她的密码。修改后需要满足是合法的密码。
小红想知道，她一共有多少种修改的方式？共有 t 次询问。
输入描述:
第一行输入一个正整数 t，代表询问的次数。
接下来的 t 行，每行输入一个字符串。保证输入的字符串是一个合法的密码。
1≤t≤10^5
输出描述:
输出 t 行，每行输出一个整数，代表修改的方案数。

加法原理
======

示例1
输入
1
12345aB.
输出
378
 */