package p777;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF777D {
    static int n;
    static String[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        for (int i = n - 2; i >= 0; i--) {
            String t0 = s[i];
            String t1 = s[i + 1];
            int l = Math.min(t0.length(), t1.length());
            if (t0.substring(0, l).equals(t1.substring(0, l))) {
                s[i] = t0.substring(0, l);
                continue;
            }
            for (int j = 1; j < l; j++) {
                if (t0.charAt(j) < t1.charAt(j)) {
                    break;
                } else if (t0.charAt(j) > t1.charAt(j)) {
                    s[i] = s[i].substring(0, j);
                    break;
                }
            }
        }
        return String.join(System.lineSeparator(), s);
    }
}
/*
D. Cloud of Hashtags
https://codeforces.com/contest/777/problem/D

灵茶の试炼 2023-01-13
题目大意：
输入 n(≤5e5) 和长为 n 的字符串数组 a，每个字符串都以 # 开头，所有字符串的长度之和不超过 5e5。
你可以把字符串的任意后缀去掉。
输出使得 a 变为字典序升序，至少需要去掉多少字符。

https://codeforces.com/contest/777/submission/171012642
提示 1：贪心，从后往前枚举，每个字符串要保留尽可能多的字符。
提示 2：由于字典序的传递性，只需要比较相邻的字符串。
======

input
3
#book
#bigtown
#big
output
#b
#big
#big

input
3
#book
#cool
#cold
output
#book
#co
#cold

input
4
#car
#cart
#art
#at
output
#
#
#art
#at

input
3
#apple
#apple
#fruit
output
#apple
#apple
#fruit
 */
