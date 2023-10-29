package p1881;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1881A {
    static int n, m;
    static String x, s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            x = scanner.next();
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        while (!x.contains(s)) {
            x += x;
            ans++;
            if (!x.contains(s) && x.length() > m * 3) {
                return "-1";
            }
        }
        return String.valueOf(ans);
    }
}
/*
Codeforces Round 903 (Div. 3)
A. Don't Try to Count
https://codeforces.com/contest/1881/problem/A

题目大意：
给定一个长度为 n 的字符串 x 和一个长度为 m (n·m≤100)的字符串 s，由小写拉丁字母组成，可以对字符串 x 进行任意次数的运算。
在一个操作中，您将 x 的当前值附加到字符串 x 的末尾。注意，x 的值在此之后会改变。
例如，如果 x= "aba"，那么应用运算后，x 的变化如下:"aba"→"abaaba"→" abaabababaaba "。
经过多少次操作后，s 将作为子字符串出现在 x 中?字符串的子字符串被定义为该字符串的连续段。

暴力模拟。
======

input
12
1 5
a
aaaaa
5 5
eforc
force
2 5
ab
ababa
3 5
aba
ababa
4 3
babb
bbb
5 1
aaaaa
a
4 2
aabb
ba
2 8
bk
kbkbkbkb
12 2
fjdgmujlcont
tf
2 2
aa
aa
3 5
abb
babba
1 19
m
mmmmmmmmmmmmmmmmmmm
output
3
1
2
-1
1
0
1
3
1
0
2
5
 */
