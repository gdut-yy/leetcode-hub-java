package c430;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc430_c {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
        String s = scanner.next();
        int[] cnt = new int[2];
        int l1 = 0, l2 = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
            while (cnt[0] >= a) {
                if (s.charAt(l1) == 'a') {
                    cnt[0]--;
                }
                l1++;
            }
            while (cnt[1] >= b) {
                if (s.charAt(l2) == 'b') {
                    cnt[1]--;
                }
                l2++;
            }
            ans += Math.max(l1 - l2, 0);
        }
        out.println(ans);
    }
}
/*
C - Truck Driver
https://atcoder.jp/contests/abc430/tasks/abc430_c

灵茶の试炼 2026-06-29
题目大意：
输入 n(1≤n≤3e5) a(1≤a≤n) b(1≤b≤n) 和长为 n 的字符串 s，只包含 'a' 和 'b'。
输出 s 有多少个子串 t，满足 t 至少有 a 个 'a'，至多有 b-1 个 'b'。

rating
三指针滑动窗口。
一个指针 left1 维护 [0, left1 - 1] 是满足 'a' 个数 >= a 的子串左端点范围。
一个指针 left2 维护 [left2, i] 是满足 'b' 个数 < b 的子串左端点范围。
这两个区间的交集为 [left2, left1 - 1]。
所以对于一个固定的子串右端点 i，满足要求的子串左端点个数为交集区间的长度，即 max(left1 - left2, 0)。
代码 https://atcoder.jp/contests/abc430/submissions/77040168
======

Input 1
11 4 2
abbaaabaaba
Output 1
3

Input 2
13 1 2
bbbbbbbbbbbbb
Output 2
0
 */
