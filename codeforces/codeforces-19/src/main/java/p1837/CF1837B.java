package p1837;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1837B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        char[] cs = s.toCharArray();
        int lt = 0, gt = 0;
        char pre = ' ';
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '<') {
                if (pre == '<' || pre == ' ') {
                    lt++;
                } else {
                    lt = 1;
                }
            }
            if (cs[i] == '>') {
                if (pre == '>' || pre == ' ') {
                    gt++;
                } else {
                    gt = 1;
                }
            }
            ans = Math.max(ans, Math.max(lt, gt) + 1);
            pre = cs[i];
        }
        return String.valueOf(ans);
    }
}
/*
B. Comparison String
https://codeforces.com/contest/1837/problem/B

题目大意：
给定一个长度为 n 的字符串 s，其中每个字符是 < 或 >。
由 n+1 个元素组成的数组 a 与字符串 s 兼容，如果从 1 到 n 的每一个 i，字符 si 表示 ai 与 ai+1 比较的结果，即:
- si < 当且仅当 ai<ai+1;
- si > 当且仅当 ai>ai+1。
例如，数组[1,2,5,4,2]与字符串<<>>兼容。还有其他与该字符串兼容的数组，例如[13,37,42,37,13]。
数组的代价是数组中不同元素的数量。例如，[1,2,5,4,2]的代价为 4;[13,37,42,37,13]的代价是 3。
你必须计算与给定字符串 s 兼容的所有数组的最小开销。

求 最长的 递增/递减 段
======

input
4
4
<<>>
4
>><<
5
>>>>>
7
<><><><
output
3
3
6
2

1
5
<<><<
1 2 3 1 2 3

1
7
<><><><
 */
