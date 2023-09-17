package c301;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc301_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(solve(s, t));
    }

    private static String solve(String s, String t) {
        int[] cntArr = new int[26];

        int at1 = 0, at2 = 0;
        for (char ch : s.toCharArray()) {
            if (ch != '@') {
                cntArr[ch - 'a']++;
            } else {
                at1++;
            }
        }
        for (char ch : t.toCharArray()) {
            if (ch != '@') {
                cntArr[ch - 'a']--;
            } else {
                at2++;
            }
        }

        int lt0 = 0, gt0 = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (cntArr[ch - 'a'] != 0) {
                if (!isAtcoder(ch)) {
                    return "No";
                }
            }
            if (cntArr[ch - 'a'] > 0) {
                gt0 += cntArr[ch - 'a'];
            } else if (cntArr[ch - 'a'] < 0) {
                lt0 += cntArr[ch - 'a'];
            }
        }
        return lt0 <= at1 && gt0 <= at2 ? "Yes" : "No";
    }

    // ch 为 a t c o d e r 之一
    private static boolean isAtcoder(char ch) {
        return "atcoder".indexOf(ch) != -1;
    }
}
/*
C - AtCoder Cards
https://atcoder.jp/contests/abc301/tasks/abc301_c

题目大意：
单人纸牌游戏在 AtCoder 公司很受欢迎。游戏中的每张卡片上都写着一个小写的英文字母或符号 @。每种类型都有足够数量的卡片。游戏是这样的。
1.将相同数量的卡片排成两排。
2.将每一张带有 @ 的卡片替换为以下卡片之一:a, t, c, o, d, e, r。
3.如果两排牌重合，你就赢了。否则，你就输了。
要赢得这个游戏，你要做以下的作弊。
在步骤 1 之后，无论何时都可以自由地重新排列一行中的卡片。
给定两个字符串 S 和 T，表示步骤 1 之后的两行。确定是否有可能在允许作弊的情况下获胜。

先分别统计两个字符串的 @ 数量，相同字符先抵消（第 1 个字符串 减去 第 2 个字符串）。
再统计各字符大于 0，小于 0 的总量。大于 0 部分需要消耗 at2，小于 0 部分需要消耗 at1。
======

Input 1
ch@ku@ai
choku@@i
Output 1
Yes

Input 2
ch@kud@i
akidu@ho
Output 2
Yes

Input 3
aoki
@ok@
Output 3
No

Input 4
aa
bb
Output 4
No
 */