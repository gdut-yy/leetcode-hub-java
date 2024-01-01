package p1678;

import java.util.Scanner;

public class CF1678B2 {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0, seg = 0;
        char pre = ' ';
        for (int i = 0; i < n; i += 2) {
            if (s[i] != s[i + 1]) {
                ans++;
            } else if (s[i] != pre) {
                seg++;
                pre = s[i];
            }
        }
        return ans + " " + (Math.max(seg, 1));
    }
}
/*
B2. Tokitsukaze and Good 01-String (hard version)
https://codeforces.com/contest/1678/problem/B2

灵茶の试炼 2023-10-12
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 长为 n 的字符串 s，只包含 0 和 1。
你需要修改 s 中的一些字符（只能修改成 0 或 1），使得把 s 按照【连续相同字符】分割后，每一段的长度均为偶数。
例如 11001111 分割成 11 00 1111，长度都是偶数。
输出两个数：
1. 最少要修改多少个字符。
2. 在修改次数最少的前提下，最少可以分割成多少段。
2023.10.28 押题成功！
https://leetcode.cn/problems/minimum-number-of-changes-to-make-binary-string-beautiful/

例如 s=111000，我们可以两个两个一对：11 10 00，只要有一对的字符是不同的，那么必然要修改一次。
并且我们至少会得到两段连续相等子串。
又例如 s=111001，两个两个一对：11 10 01，最少改两次，把 0 都改成 1 更好，因为改完后只有一段了。
如何判断至少要多少段？如果 s[i]=s[i+1] 并且 s[i] 和上一段的字符是不同的，那么就一定要新增一段。
https://codeforces.com/contest/1678/submission/227695878
======

input
5
10
1110011000
8
11001111
2
00
2
11
6
100110
output
3 2
0 3
0 1
0 1
3 1
 */
