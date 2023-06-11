package p1156;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1156B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);

        // 感觉 StringBuilder 优于 List<Character>
        StringBuilder odds = new StringBuilder();
        StringBuilder evens = new StringBuilder();
        for (char ch : cs) {
            if ((ch & 1) == 1) {
                odds.append(ch);
            } else {
                evens.append(ch);
            }
        }

        int oddLen = odds.length();
        int evenLen = evens.length();
        if (oddLen == 0) {
            return evens.toString();
        } else if (evenLen == 0) {
            return odds.toString();
        } else if (Math.abs(odds.charAt(oddLen - 1) - evens.charAt(0)) != 1) {
            return odds.toString() + evens;
        } else if (Math.abs(evens.charAt(evenLen - 1) - odds.charAt(0)) != 1) {
            return evens.toString() + odds;
        } else {
            return "No answer";
        }
    }
}
/*
B. Ugly Pairs
https://codeforces.com/contest/1156/problem/B

灵茶の试炼 2023-03-14
题目大意：
输入 t(≤100) 表示 t 组数据。每组数据输入一个长度不超过 100 的字符串 s，只包含小写字母。
你需要重排 s 中的字母（或者保持 s 不变），使得 abs(s[i]-s[i+1]) != 1，即任意相邻字母在字母表中不相邻。
输出任意一个符合要求的结果，如果不存在，输出 No answer。

https://codeforces.com/contest/1156/submission/197311349
提示 1：想想 s 中没有重复字母要怎么做。
提示 2：s 排序后，按照 ASCII 码的奇偶性分组，设为 x 和 y。
提示 3：看看 x+y 或者 y+x 行不行，如果这样都不行就无解。比如 acb，bac 等。
======

input
4
abcd
gg
codeforces
abaca
output
cadb
gg
codfoerces
No answer
 */
