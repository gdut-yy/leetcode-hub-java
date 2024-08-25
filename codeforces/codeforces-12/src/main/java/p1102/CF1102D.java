package p1102;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1102D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        // c0, c1, c2
        int[] cntArr = new int[3];
        Arrays.fill(cntArr, -n / 3);
        char[] cs = s.toCharArray();
        for (char ch : cs) {
            cntArr[ch - '0']++;
        }

        for (int i = 0; i < n; i++) {
            int b = cs[i] - '0';
            if (b > 0 && cntArr[b] > 0) {
                if (cntArr[0] < 0) {
                    cs[i] = '0';
                    cntArr[0]++;
                    cntArr[b]--;
                } else if (cntArr[1] < 0) {
                    cs[i] = '1';
                    cntArr[1]++;
                    cntArr[b]--;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int b = cs[i] - '0';
            if (cntArr[b] > 0) {
                if (cntArr[2] < 0) {
                    cs[i] = '2';
                    cntArr[2]++;
                    cntArr[b]--;
                } else if (cntArr[1] < 0) {
                    cs[i] = '1';
                    cntArr[1]++;
                    cntArr[b]--;
                }
            }
        }

        return new String(cs);
    }
}
/*
D. Balanced Ternary String
https://codeforces.com/contest/1102/problem/D

灵茶の试炼 2023-05-29
题目大意：
输入 n(3≤n≤3e5 且 n=3k) 和长为 n 的字符串 s，只包含 012。
你需要修改 s 中的字符，使得 012 的数量都等于 n/3。
修改次数应当尽量少。
输出修改后的字典序最小的字符串。

rating 1500
https://codeforces.com/contest/1102/submission/207636737
为了最小化修改次数，只需要修改出现次数 > n/3 的。
从左往右，大的改成小的，例如 2->0
从右往左，小的改成大的，例如 1->2
======

input
3
121
output
021

input
6
000000
output
001122

input
6
211200
output
211200

input
6
120110
output
120120
 */
