package p1849;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1849C {
    static int n, m;
    static char[] s;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            s = scanner.next().toCharArray();

            lr = new int[m][2];
            for (int i = 0; i < m; i++) {
                lr[i][0] = scanner.nextInt();
                lr[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] lf = new int[n];
        int[] rg = new int[n];
        lf[0] = -1;
        for (int i = 0; i < n; ++i) {
            if (i > 0) lf[i] = lf[i - 1];
            if (s[i] == '0') lf[i] = i;
        }
        rg[n - 1] = n;
        for (int i = n - 1; i >= 0; --i) {
            if (i + 1 < n) rg[i] = rg[i + 1];
            if (s[i] == '1') rg[i] = i;
        }

        Set<Long> st = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int l = lr[i][0] - 1, r = lr[i][1] - 1;
            int ll = rg[l], rr = lf[r];
            if (ll > rr) {
                st.add(-1L);
            } else {
                st.add((long) ll << 32 | rr);
            }
        }
        return String.valueOf(st.size());
    }
}
/*
C. Binary String ing
https://codeforces.com/contest/1849/problem/C

灵茶の试炼 2024-01-03
题目大意：
给定一个由 n 个字符 0 和/或 1 组成的字符串 s。
你把这个字符串复制 m 个，让第 i 个副本是字符串 ti。然后对每个副本只执行一个操作:对于第 i 个副本，对它的子字符串[li;ri]排序(从第 i 个字符到第 ri 个字符的子字符串，包括两个端点)。注意，每个操作只影响一个副本，并且每个副本只受一个操作的影响。
你的任务是计算 t1,t2,...,tm 中不同字符串的个数。注意，只有在操作后至少有一个副本保持不变时，才应该计算初始字符串 s。

前后缀分解？如果去重？字符串哈希？
---
https://codeforces.com/blog/entry/118752
我们可以看到，每个修改后的副本仅由两个整数 lb 和 rb 决定——字符被更改的第一个位置和最后一个位置。如果我们能找到每个副本的这样的数字，不同的配对的数量将是问题的答案。
设 lfi 为最近的字符 0 在位置 i 或其左边的位置，rgi 为最近的字符 1 在位置 i 或其右边的位置。
如果字符串 s 的第一个字符为 1，则 lf0=−1，否则 lf0=0。如果字符串 s 的最后一个字符为 0，则 rgn−1=n，否则 rgn−1=n−1。
可以使用简单的动态规划计算值 lf 和 rg, lf 从左到右计算，rg -从右到左计算。那么我们需要的数字 lb 和 rb 分别等于 rgl 和 lfr。如果 rgl>lfr，那么改变的段是简并的(这意味着字符串根本没有改变)。我们可以为这种类型的字符串定义一些特殊的片段，例如(−1，−1)。否则，字符串的段(rgl,lfr)将改变。
时间复杂度:0 (nlogn)。
======

input
3
6 5
101100
1 2
1 3
2 4
5 5
1 6
6 4
100111
2 2
1 4
1 3
1 2
1 1
0
1 1
output
3
3
1
 */
