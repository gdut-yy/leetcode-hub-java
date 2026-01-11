package p2121;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2121E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        char[] l = scanner.next().toCharArray();
        char[] r = scanner.next().toCharArray();
        for (int i = 0; i < l.length; i++) {
            if (l[i] == r[i]) continue;
            if (r[i] - l[i] > 1) {
                out.println(i * 2);
                return;
            } else {
                int j = i + 1;
                for (; j < l.length && l[j] == '9' && r[j] == '0'; j++) {
                }
                out.println(i + j);
                return;
            }
        }
        out.println(l.length * 2);
    }
}
/*
E. Sponsor of Your Problems
https://codeforces.com/contest/2121/problem/E

灵茶の试炼 2025-10-21
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 L R(1≤L≤R<1e9)，保证 L 和 R 的十进制长度相同，无前导零。
定义 f(a,b) 为 a 和 b 的十进制表示中，相同位置上数字相同的位数。
例如，f(12,21)=0，f(31,37)=1，f(19891,18981)=2，f(54321,24361)=3。
输出 f(L,x)+f(x,R) 的最小值，其中 x 是 [L,R] 中的整数。

rating 1500
尝试手玩一些数据：
l = 1234
r = 1400
答案是多少？
从百位数开始可以填 3，后面随便填，一定可以不一样，所以答案是 2（千位数必须填 1）。
l = 129989
r = 130000
答案是多少？
299 和 300 这段必须和 l r 其中一个数一样，后面可以填 9，然后就可以随便填。
答案是 1 的长度加上 1299 的长度 = 1 + 4 = 5。
特别地，如果 l = r，那么答案为 len(l) * 2。
否则会进入上面两种情况之一。
时间复杂度：O(log r)，一次遍历。
代码 https://codeforces.com/contest/2121/submission/342876561
代码备份（上面打不开的同学看这个）
======

Input
14
1 1
2 3
4 6
15 16
17 19
199 201
899 999
1990 2001
6309 6409
12345 12501
19987 20093
746814 747932
900990999 900991010
999999999 999999999
Output
2
1
0
3
2
2
1
3
3
4
3
5
12
18
 */
