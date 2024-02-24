package p1537;

import java.util.Scanner;

public class CF1537E2 {
    static int n, k;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int sz = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) > s.charAt(i % sz)) {
                break;
            }
            if (s.charAt(i) < s.charAt(i % sz)) {
                sz = i + 1;
            }
        }
        String repeat = s.substring(0, sz).repeat(k / sz + 1);
        return repeat.substring(0, k);
    }
}
/*
https://codeforces.com/contest/1537/problem/E2

灵茶の试炼 2022-08-30
题目大意：
本题分为简单版本和困难版本，在困难版本中，n 和 k 不超过 5e5。
输入 n (≤5000) 和 k (≤5000)，以及一个长为 n 的字符串 s，由小写字母组成。
有如下两种操作，每种操作你都可以执行任意多次：
1. 删除 s 的最后一个字符；
2. 将 s 复制一份拼在后面，即 s = s + s。
输出你能得到的所有长为 k 的字符串中，字典序最小的字符串。

rating 2200
https://codeforces.com/problemset/submission/1537/170118286
提示 1：操作的本质是，答案一定由 s 的某些前缀组成。
提示 2：进一步地，应当选择（在重复自身后）字典序最小的前缀，在此基础上组成答案。
例如 "dbca" > "dbcada"，因为重复后 "dbcadb..." > "dbcada..."
暴力比较所有前缀，可以解决简单版本。
困难版本见群友 @meyi 的题解，非常标准的证明：
https://www.luogu.com.cn/blog/zankizero/ti-xie-cf1537e2-erase-and-extend-hard-version
======

input
8 16
dbcadabc
output
dbcadabcdbcadabc

input
4 5
abcd
output
aaaaa
 */
