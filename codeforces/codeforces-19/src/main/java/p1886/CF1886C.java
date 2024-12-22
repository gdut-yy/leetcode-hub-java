package p1886;

import java.util.Scanner;

public class CF1886C {
    static String s;
    static long pos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next();
            pos = scanner.nextLong();
            System.out.print(solve());
        }
    }

    private static char solve() {
        pos--;
        long n = s.length();
        if (pos < n) {
            return s.charAt((int) pos);
        }
        long m = n * 2 + 1;
        long k = (long) ((m - Math.sqrt(m * m - pos * 8)) / 2);
        pos -= ((n * 2 - k + 1) * k / 2);
        StringBuilder st = new StringBuilder();
        s += "0";
        for (int i = 0; ; i++) {
            while (!st.isEmpty() && s.charAt(i) < st.charAt(st.length() - 1)) {
                st.deleteCharAt(st.length() - 1);
                k--;
                if (k == 0) {
                    if (pos < st.length()) {
                        return st.charAt((int) pos);
                    }
                    return s.charAt((int) (i + pos - st.length()));
                }
            }
            st.append(s.charAt(i));
        }
    }
}
/*
C. Decreasing String
https://codeforces.com/contest/1886/problem/C

灵茶の试炼 2023-12-13
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的字符串长度之和 ≤1e6。
每组数据输入长度 ≤1e6 的字符串 s1（只包含小写字母）和下标 pos(1≤pos≤n*(n+1)/2, n=len(s))。
从 s1 去掉一个字母，得到的字典序最小的字符串，记作 s2。
从 s2 去掉一个字母，得到的字典序最小的字符串，记作 s3。
依此类推，直到剩下一个字母，此时的字符串记作 sn。
输出 s1+s2+...+sn 的第 pos 个字母。
你只需要输出一行，这一行的第 i 个字母对应第 i 组数据的答案。请勿添加空格。

rating 1600
首先把 pos 出现在哪个 s[k] 算出来，可以用循环，也可以解一元二次不等式。
然后用单调栈模拟即可，每次遇到比栈顶小的字母就把栈顶出栈。
不了解单调栈套路的话可以先做 316. 去除重复字母
https://codeforces.com/contest/1886/submission/235784116
======

input
3
cab
6
abcd
9
x
1
output
abx
 */
