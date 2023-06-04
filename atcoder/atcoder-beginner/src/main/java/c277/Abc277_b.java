package c277;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc277_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = scanner.next();
        }
        System.out.println(solve(n, ss));
    }

    private static String solve(int n, String[] ss) {
        Set<String> set = new HashSet<>();
        for (String s : ss) {
            char c1 = s.charAt(0);
            if (c1 != 'H' && c1 != 'D' && c1 != 'C' && c1 != 'S') {
                return "No";
            }
            char c2 = s.charAt(1);
            if (c2 != 'A' && c2 != '2' && c2 != '3' && c2 != '4' && c2 != '5'
                    && c2 != '6' && c2 != '7' && c2 != '8' && c2 != '9'
                    && c2 != 'T' && c2 != 'J' && c2 != 'Q' && c2 != 'K') {
                return "No";
            }
            set.add(s);
        }
        if (set.size() != n) {
            return "No";
        }
        return "Yes";
    }
}
/*
B - Playing Cards Validation
https://atcoder.jp/contests/abc277/tasks/abc277_b

题目大意：
给定 N 个字符串，每个字符串的长度为 2，由大写英文字母和数字组成。第 i 个字符串是 si。
判断以下三个条件是否都满足。
- 对于每个字符串，第一个字符是 H、D、C 和 S 中的一个。
- 对于每个字符串，第二个字符是 A、2、3、4、5、6、7、8、9、T、J、Q、K 中的一个。
所有的字符串都是两两不同的。也就是说，如果 i != j，那么 Si != Sj。

模拟。
======

Input 1
4
H3
DA
D3
SK
Output 1
Yes

Input 2
5
H3
DA
CK
H3
S7
Output 2
No

Input 3
4
3H
AD
3D
KS
Output 3
No

Input 4
5
00
AA
XX
YY
ZZ
Output 4
No
 */