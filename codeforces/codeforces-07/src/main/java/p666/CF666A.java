package p666;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF666A {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    static boolean[][] vis;
    static Map<String, Boolean> ans;

    private static String solve() {
        int n = s.length();
        vis = new boolean[n][4];
        ans = new HashMap<>();
        dfs(n - 1, "");

        List<String> suf = new ArrayList<>(ans.keySet());
        suf.sort(null);
        return suf.size() + System.lineSeparator()
                + String.join(System.lineSeparator(), suf);
    }

    static void dfs(int i, String pre) {
        if (i < 6 || vis[i][pre.length()]) {
            return;
        }
        vis[i][pre.length()] = true;
        String suf = s.substring(i - 1, i + 1);
        if (!suf.equals(pre)) {
            ans.put(suf, true);
            dfs(i - 2, suf);
        }
        suf = s.substring(i - 2, i + 1);
        if (i > 6 && !suf.equals(pre)) {
            ans.put(suf, true);
            dfs(i - 3, suf);
        }
    }
}
/*
A. Reberland Linguistics
https://codeforces.com/contest/666/problem/A

灵茶の试炼 2024-11-20
题目大意：
输入长度在 [5,1e4] 的字符串 s，只包含小写英文字母。
s 是以如下方式生成的：
首先，找一个长度 >= 5 的词根。
然后在这个词根的右边，添加若干长为 2 或 3 的后缀。
要求：不能连续添加两个相同的后缀。
输出所有可能的后缀有多少个，以及按字典序升序输出所有可能的后缀。

rating 1800
写一个带 vis 的 DFS。
参数为剩余字符串的最后一个字母的下标 i，以及上一个（右边）后缀 pre。
从 i=n-1，pre="" 开始倒着递归。
如果 i<6 或者 vis[i][len(pre)]=true，则直接返回。
否则标记 vis[i][len(pre)]=true，然后枚举长为 2 和 3 的后缀，继续递归。
递归过程中收集答案。
代码 https://codeforces.com/problemset/submission/666/291515024
代码备份（洛谷）
======

Input
abacabaca
Output
3
aca
ba
ca

Input
abaca
Output
0
 */
