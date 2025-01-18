package p1584;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1584F {
    static int n;
    static char[] s;
    static List<Integer>[][] pos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            pos = new ArrayList[123][10];
            for (int i = 0; i < pos.length; i++) {
                for (int j = 0; j < pos[i].length; j++) {
                    pos[i][j] = new ArrayList<>();
                }
            }
            for (int i = 0; i < n; i++) {
                pos[0][i].add(-1); // 假定在 LCS 前面还有个字符 '\0'，下标为 -1
                s = scanner.next().toCharArray();
                for (int j = 0; j < s.length; j++) {
                    int b = s[j];
                    pos[b][i].add(j); // 记录字母 b 在字符串 s[i] 中的出现位置 j
                }
            }
            System.out.println(solve());
        }
    }

    static int[][] memo;
    static pair[][] from;

    static class pair {
        int mask;
        char c;
    }

    private static String solve() {
        memo = new int[1 << n][123];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(memo[i], -1);
        }
        from = new pair[1 << n][123];
        int ans = dfs(0, (char) 0) - 1;

        StringBuilder lcs = new StringBuilder();
        for (pair p = from[0][0]; p.c > 0; p = from[p.mask][p.c]) {
            lcs.append(p.c);
        }
        return ans + System.lineSeparator() + lcs;
    }

    static int dfs(int mask, char c) {
        if (memo[mask][c] != -1) return memo[mask][c];
        int res = 0;
        pair frm = new pair();
        // 枚举 LCS 的下一个字母 ch
        // 要求：ch 在所有字符串中的下标 > c 在对应字符串中的下标
        // 如果有两个 ch 都满足要求，优先取左边的，对应下面代码中的 p[0] > cur
        for (char ch = 'A'; ch <= 'z'; ) {
            int mask2 = 0;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                List<Integer> p = pos[ch][i];
                if (p.isEmpty()) {
                    // goto nxt
                    flag = true;
                    break;
                }
                int cur = pos[c][i].get(mask >> i & 1); // 当前字母 c 的下标
                // p[0] 或者 p[1] 是下一个字母 ch 的下标
                if (p.get(0) > cur) {
                    // 0
                } else if (p.size() > 1 && p.get(1) > cur) {
                    mask2 |= 1 << i;
                } else {
                    // goto nxt
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                int r = dfs(mask2, ch);
                if (r > res) {
                    res = r;
                    frm.mask = mask2; // 记录转移来源
                    frm.c = ch;
                }
            }
//            nxt:
            if (ch == 'Z') {
                ch = 'a';
            } else {
                ch++;
            }
        }
        from[mask][c] = frm;
        res++;
        return memo[mask][c] = res;
    }
}
/*
F. Strange LCS
https://codeforces.com/contest/1584/problem/F

灵茶の试炼 2024-06-14
题目大意：
输入 T(≤5) 表示 T 组数据。
每组数据输入 n(2≤n≤10) 和 n 个字符串，只包含大写和小写英文字母，且对于每个字符串，每个字母最多出现两次。
计算这 n 个字符串的最长公共子序列（LCS）。
输出 LCS 的长度和任意 LCS。

rating 2600
我的题解 https://www.luogu.com.cn/article/0tweenji
记忆化搜索（93ms） https://codeforces.com/contest/1584/submission/264727384
======

Input
4
2
ABC
CBA
2
bacab
defed
3
abcde
aBcDe
ace
2
codeforces
technocup
Output
1
A
0

3
ace
3
coc
 */
