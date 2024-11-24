package p1354;

import java.util.Scanner;

public class CF1354B {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int n = s.length;
        int[] cnt = new int[3];
        int l = 0, r = 0;
        int ans = n + 1;
        while (r < n) {
            cnt[s[r] - '1']++;

            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                ans = Math.min(ans, r - l + 1);
                cnt[s[l] - '1']--;
                l++;
            }
            r++;
        }
        if (ans == n + 1) ans = 0;
        return String.valueOf(ans);
    }
}
/*
B. Ternary String
https://codeforces.com/contest/1354/problem/B

灵茶の试炼 2024-05-20
题目大意：
输入 T(≤2e4) 表示 T 组数据。所有数据的字符串长度之和 ≤2e5。
每组数据输入一个长度 ≤2e5 的字符串 s，只包含数字 '1' '2' '3'。
输出 s 中的最短子串的长度，该子串必须包含所有 '1' '2' '3' 三种字符。
如果没有这样的子串，输出 0。

rating 1200
不定长滑窗，求最短。
用一个长为 3 的 cnt 数组维护子串内的 1 2 3 的个数。
如果三个数的 cnt 都大于 0，就更新答案的最小值，移动左端点。
https://codeforces.com/problemset/submission/1354/261329180
更多滑窗题目可以看我的题单
======

Input
7
123
12222133333332
112233
332211
12121212
333333
31121
Output
3
3
4
4
0
0
4
 */
