package p2145;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF2145C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        String s = scanner.next();

        int cnt_a = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') cnt_a++;
        }
        int d = cnt_a * 2 - n;
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int ans = n;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char b = s.charAt(i);
            sum += 1 - (b - 'a') * 2;
            pos.put(sum, i);
            if (pos.containsKey(sum - d)) {
                ans = Math.min(ans, i - pos.get(sum - d));
            }
        }

        if (ans == n) {
            ans = -1;
        }
        out.println(ans);
    }
}
/*
C. Monocarp's String
https://codeforces.com/contest/2145/problem/C

灵茶の试炼 2025-11-03
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和一个长为 n 的字符串，只包含 'a' 和 'b'。
从 s 中删除一个连续子串 t（可以为空），使得剩余字符串的 'a' 和 'b' 的个数相等。
输出 t 的最短长度。
如果必须把整个 s 删除，输出 -1。
进阶：如果 s 包含前三种字母呢？

rating 1300
设 d = s.count('a') - s.count('b')。
我们要找一个最短子串，满足子串中的 a 的个数 - b 的个数 = d。
和 LC525. 连续数组 一样，把 a 看成 1，b 看成 -1。
问题就是找一个和为 d 的最短子数组。
做法同 LC560. 和为 K 的子数组。
用 map 或者数组记录上一个前缀和的位置。
进阶问题类似 LC3714. 最长的平衡子串 II。
代码 https://codeforces.com/problemset/submission/2145/347092413
代码备份（上面打不开的同学看这个）
======

Input
5
5
bbbab
6
bbaaba
4
aaaa
12
aabbaaabbaab
5
aabaa
Output
3
0
-1
2
-1
 */
