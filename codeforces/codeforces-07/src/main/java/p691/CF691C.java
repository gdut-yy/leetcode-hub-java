package p691;

import java.util.Scanner;

public class CF691C {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        if (!s.contains(".")) {
            // 标准化：补上小数点
            s += ".";
        }
        // 标准化：去掉前后缀的 0
        s = trim0();
        int i = s.indexOf(".");

        // e := i - IndexAny(s, "123456789") // 计算指数
        int e = 0;
        for (; e < s.length(); e++) {
            if ('1' <= s.charAt(e) && s.charAt(e) <= '9') {
                e = i - e;
                break;
            }
        }
        if (e > 0) {
            e--;
        }

        // 去掉小数点，再次去掉前后缀的 0，得到小数部分
        s = s.substring(0, i) + s.substring(i + 1);
        s = trim0();
        if (s.length() > 1) {
            s = s.charAt(0) + "." + s.substring(1);
        }
        if (e != 0) {
            s += "E" + e;
        }
        return s;
    }

    static String trim0() {
        int i = 0, j = s.length() - 1;
        while (s.charAt(i) == '0') i++;
        while (s.charAt(j) == '0') j--;
        return s.substring(i, j + 1);
    }

    // Time limit exceeded on test 38
    static String trim0_tle() {
        s = s.replaceAll("^0+", "");
        s = s.replaceAll("0+$", "");
        return s;
    }
}
/*
C. Exponential notation
https://codeforces.com/contest/691/problem/C

灵茶の试炼 2022-08-25
题目大意：
上场周赛出了一道【易错题】（周赛第二题），所以今天我也找了一道【易错题】，带大家针对训练一下。
应该指的是 第 307 场周赛 2022-08-21，10:30
2384. 最大回文数字
https://leetcode.cn/problems/largest-palindromic-number/
---
输入一个长度不超过 1e6 的字符串 x，表示一个大于 0 的小数（可能有前导零）。
输出 x 的科学计数法表示（格式为 aEb），要求：
1、1≤a<10，如果 a 是整数，不要输出小数点。
2、b 必须是整数，如果 b=0，那么你只需要输出 a。

rating 1800
https://codeforces.com/contest/691/submission/169524952
实现技巧：标准化，去掉前缀和后缀的 0，如果没有小数点在末尾加上小数点。
见代码注释。没有感情，全是技巧。
======

input
16
output
1.6E1

input
01.23400
output
1.234

input
.100
output
1E-1

input
100.
output
1E2
 */
