package p1889;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1889A {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        String s = scanner.next();
        int cnt0 = 0;
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == '0') cnt0++;
        }
        if (cnt0 * 2 != n) {
            out.println(-1);
            return;
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = n - 1;
        while (!s.isEmpty()) {
            if (s.charAt(0) != s.charAt(s.length() - 1)) {
                s = s.substring(1, s.length() - 1);
                j--;
            } else if (s.charAt(0) == '0') {
                s = s.substring(1) + "0";
                j++;
                ans.add(j);
            } else {
                s = "1" + s.substring(0, s.length() - 1);
                j++;
                ans.add(i);
            }
            i++;
        }
        out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < ans.size(); k++) {
            if (k > 0) sb.append(' ');
            sb.append(ans.get(k));
        }
        out.println(sb);
    }
}
/*
A. Qingshan Loves Strings 2
https://codeforces.com/contest/1889/problem/A

灵茶の试炼 2026-03-02
题目大意：
输入 T(≤100) 表示 T 组数据。
每组数据输入 n(1≤n≤100) 和长为 n 的 01 字符串 s。
你可以执行如下操作至多 300 次：
把 "01" 插入 s 中的任意位置。
设最终字符串为 t，目标是让 t[i] != t[|t|-i+1]，即中心对称位置上的字符都不同。
如果无法做到，输出 -1。
否则输出两行：第一行是操作次数，第二行是每次操作的插入位置 x。
其中 x=0 表示插在字符串的最前面，x=1 表示插在第一个字符的后面，依此类推。

rating 1300
操作不会改变什么？
什么情况下无解？
对于合法字符串 t，由于 t[i] != t[|t|-i+1]，即对称位置一定是 0 和 1，所以 t 中的 0 和 1 的个数必须相同。
由于插入 01 后，0 和 1 的个数之差不变，所以初始字符串 s 的 0 和 1 的个数必须相同，否则无解。
如果初始字符串 s 的 0 和 1 的个数相同，那么一定有解，操作方案如下：
如果 s[1] != s[n]，那么问题变成 2 到 n-1 的子问题（长为 n-2 的子问题）。
否则如果 s[1] = s[n] = 0，在最左边插入 01 仍然会导致首尾相同，所以只能在最右边插入 01，然后去掉首尾字符，继续循环。该操作本质是把 s 开头的 0 移到了末尾（循环移位）。
否则如果 s[1] = s[n] = 1，在最右边插入 01 仍然会导致首尾相同，所以只能在最左边插入 01，然后去掉首尾字符，继续循环。该操作本质是把 s 末尾的 1 移到了开头（循环移位）。
在 s 有不同字符的情况下，一定会在若干次移位后，出现首尾字符不同的情况，此时问题变成了长为 n-2 的子问题。
这可以用反证法证明：移位后的首尾字母，在移位之前是相邻的。如果首尾字母总是相同，说明相邻字符都相同，即整个 s 只有一种字符，矛盾。
注：在思考算法题/数学题时，“找不变量”是一个无处不在的主题，见 3b1b 视频。https://www.bilibili.com/video/BV164411k7e3/
代码 https://codeforces.com/problemset/submission/1889/364293500
代码备份（上面打不开的同学看这个）
======

Input
6
2
01
3
000
4
1111
6
001110
10
0111001100
3
001
Output
0

-1
-1
2
6 7
1
10
-1
 */
