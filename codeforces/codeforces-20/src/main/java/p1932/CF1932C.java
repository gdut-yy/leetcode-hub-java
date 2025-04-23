package p1932;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1932C {
    static int n, m;
    static int[] a;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Integer> b = new ArrayList<>();
        int i = 0, j = n - 1;
        for (char c : s) {
            if (c == 'L') b.add(a[i++]);
            else b.add(a[j--]);
        }

        int[] ans = new int[n];
        int res = 1;
        for (int qi = n - 1; qi >= 0; qi--) {
            res = res * b.get(qi) % m;
            ans[qi] = res;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. LR-remainders
https://codeforces.com/contest/1932/problem/C

灵茶の试炼 2025-01-28
题目大意：
给定一个长度为 n 的数组 a，一个正整数 m，以及一串长度为 n 的命令。每个命令都是字符“L”或字符“R”。
按照在字符串 s 中写入的顺序处理所有 n 个命令。命令的处理方法如下:
- 首先，输出数组 a 中所有元素的乘积除以 m 的余数。
- 然后，如果命令为“L”，则从数组 a 中移除最左边的元素，如果命令为“R”，则从数组 a 中移除最右边的元素。
注意，在每次移动之后，数组 a 的长度减少 1，并且在处理完所有命令后，它将为空。
编写一个程序，按照字符串 s 中的顺序(从左到右)处理所有命令。

逆向处理
======

Input
4
4 6
3 1 4 2
LRRL
5 1
1 1 1 1 1
LLLLL
6 8
1 2 3 4 5 6
RLLLRR
1 10000
10000
R
Output
0 2 4 1
0 0 0 0 0
0 0 0 4 4 4
0
 */
