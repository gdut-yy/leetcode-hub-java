package c282;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc282_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        boolean inBlock = false;
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '"') {
                inBlock = !inBlock;
            }
            if (cs[i] == ',' && !inBlock) {
                cs[i] = '.';
            }
        }
        return new String(cs);
    }
}
/*
C - String Delimiter
https://atcoder.jp/contests/abc282/tasks/abc282_c

题目大意：
给定一个长度为 N 的字符串 S，由小写英文字母，，和"组成。可以保证 S 包含偶数个“。
设 2K 为 s 中“”的个数，对于每一个 i=1,2，…，K，从(2i−1)-th”到(2i)-th”的字符被称为被包围。
您的任务是将 S 中非封闭字符 ',' 替换为 '.' 并打印结果字符串。

======

Input 1
8
"a,b"c,d
Output 1
"a,b"c.d

Input 2
5
,,,,,
Output 2
.....

Input 3
20
a,"t,"c,"o,"d,"e,"r,
Output 3
a."t,"c."o,"d."e,"r.
 */