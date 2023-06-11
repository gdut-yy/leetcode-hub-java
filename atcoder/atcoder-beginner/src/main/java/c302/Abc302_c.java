package c302;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc302_c {
    private static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = scanner.next();
        }
        System.out.println(solve(ss));
    }

    private static boolean ans;

    private static String solve(String[] ss) {
        ans = false;
        dfs(ss, 0);
        return ans ? "Yes" : "No";
    }

    private static void dfs(String[] ss, int curI) {
        if (curI == n) {
            if (check(ss)) {
                ans = true;
                return;
            }
        }
        for (int i = curI; i < n; i++) {
            swap(ss, curI, i);
            dfs(ss, curI + 1);
            swap(ss, curI, i);
        }
    }

    private static void swap(String[] ss, int i, int j) {
        String tmp = ss[i];
        ss[i] = ss[j];
        ss[j] = tmp;
    }

    // 判断序列 ss 是否满足要求
    private static boolean check(String[] ss) {
        for (int i = 1; i < n; i++) {
            if (!check(ss[i - 1], ss[i])) {
                return false;
            }
        }
        return true;
    }

    // 判断字符串 s t 是否只差一个字符
    private static boolean check(String s, String t) {
        int c = 0;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                c++;
            }
        }
        return c <= 1;
    }
}
/*
C - Almost Equal
https://atcoder.jp/contests/abc302/tasks/abc302_c

题目大意：
给定 N 个字符串 s1, s2,..., sn，每个字符串长度为 M，由小写英文字母组成。这里，si 是两两不同的。
确定是否可以重新排列这些字符串以获得字符串 t1, t2,..., tn 的新序列，从而:
对于所有整数 i，使得 1≤i≤N - 1，可以将 Ti 的一个字符改为另一个小写英文字母，使其等于 Ti+1。
2≤N≤8
1≤M≤5

DFS 暴搜。
相似题目: 46. 全排列
https://leetcode.cn/problems/permutations/
======

Input 1
4 4
bbed
abcd
abed
fbed
Output 1
Yes

Input 2
2 5
abcde
abced
Output 2
No

Input 3
8 4
fast
face
cast
race
fact
rice
nice
case
Output 3
Yes
 */