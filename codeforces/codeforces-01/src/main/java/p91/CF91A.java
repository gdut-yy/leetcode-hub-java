package p91;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF91A {
    static String s1, s2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s1 = scanner.next();
        s2 = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s1.length();

        // 子序列自动机
        int[] pos = new int[26];
        Arrays.fill(pos, n);
        int[][] nxt = new int[n][26];
        for (int k = 0; k < 2; k++) {
            for (int i = n - 1; i >= 0; i--) {
//                nxt[i] = pos.clone();
                System.arraycopy(pos, 0, nxt[i], 0, 26);
                pos[s1.charAt(i) - 'a'] = i;
            }
        }

        int ans = 1;
        int i = 0, j = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            j = 1;
        }
        for (; j < s2.length(); j++) {
            int i2 = nxt[i][s2.charAt(j) - 'a'];
            if (i2 == n) {
                return "-1";
            }
            if (i2 <= i) {
                ans++;
            }
            i = i2;
        }

        return String.valueOf(ans);
    }
}
/*
A. Newspaper Headline
https://codeforces.com/contest/91/problem/A

灵茶の试炼 2023-06-06
題目大意：
输入长度不超过 1e4 的字符串 s1 和长度不超过 1e6 的字符串 s2，都只包含小写字母。
设字符串 t = s1 * x 表示由 s1 重复 x 次的字符串，比如 "abc" * 3 = "abcabcabc"。
输出使 s2 是 t 的子序列的 x 的最小值。如果无法做到输出 -1。
注：子序列不一定是连续的。

rating 1500
https://codeforces.com/contest/91/submission/208158075
子序列自动机。
用 nxt[i][c] 表示 s1[i] 右侧最近字母 c 的下标，如果没有就从头再找。
nxt[i][c] 可以倒着遍历 s1 预处理出来（遍历两遍）。
然后就可以贪心匹配 s2 了，一旦发现下一个字母的位置 <= 当前位置，说明要多绕一圈，答案加一。
相似题目见右。
$727. 最小窗口子序列
https://leetcode.cn/problems/minimum-window-subsequence/
792. 匹配子序列的单词数
https://leetcode.cn/problems/number-of-matching-subsequences/
2014. 重复 K 次的最长子序列
https://leetcode.cn/problems/longest-subsequence-repeated-k-times/
======

input
abc
xyz
output
-1

input
abcd
dabc
output
2
 */
