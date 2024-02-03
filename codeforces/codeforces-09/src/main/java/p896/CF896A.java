package p896;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF896A {
    static int n;
    static long k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        StringBuilder ans = new StringBuilder();
        while (q-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextLong();
            ans.append(f());
        }
        System.out.println(ans);
    }

    static final String S = "What are you doing at the end of the world? Are you busy? Will you save us?";
    static final String P0 = "What are you doing while sending \"";
    static final String P1 = "\"? Are you busy? Will you send \"";
    static final String P2 = "\"?";
    static long L0 = P0.length();
    static long L1 = P1.length();
    static long L2 = P2.length();
    static List<Long> sz;

    static {
        sz = new ArrayList<>();
        sz.add((long) S.length());
        while (sz.get(sz.size() - 1) < 1e18) {
            long v = sz.get(sz.size() - 1) * 2 + L0 + L1 + L2;
            sz.add(v);
        }
    }

    static char f() {
        k--;
        while (true) {
            if (n < sz.size() && k >= sz.get(n)) return '.';
            if (n == 0) return S.charAt((int) k);
            if (k < L0) return P0.charAt((int) k);
            k -= L0;
            n--;
            if (n >= sz.size() || k < sz.get(n)) continue;
            k -= sz.get(n);
            if (k < L1) return P1.charAt((int) k);
            k -= L1;
            if (k < sz.get(n)) continue;
            k -= sz.get(n);
            return P2.charAt((int) k);
        }
    }
}
/*
A. Nephren gives a riddle
https://codeforces.com/contest/896/problem/A

灵茶の试炼 2022-09-08
题目大意：
用编程语言声明字符串序列 f（\" 表示字符串中的引号）：
f[0] = "What are you doing at the end of the world? Are you busy? Will you save us?"
f[i] = "What are you doing while sending " + f[i-1] + "? Are you busy? Will you send " + f[i-1] + "?"
输入 t (≤10) 表示 t 组数据，每组数据输入 n (0≤n≤1e5) 和 k (1≤k≤1e18)。
对每组数据，输出 f[n][k-1]，如果 f[n] 的长度不足 k，则输出一个英文句点 '.'。
题目背景：《末日三问》

rating 1700
https://codeforces.com/contest/896/submission/171298801
提示 1：写一个递归 or 迭代。  F(n,k)
提示 2：预处理 f[i] 的长度。
不需要太多（指 1e18）。
我用的迭代写法，递归写法见右 @L.K
======

input
3
1 1
1 2
1 111111111111
output
Wh.

input
5
0 69
1 194
1 139
0 47
1 66
output
abdef

input
10
4 1825
3 75
3 530
4 1829
4 1651
3 187
4 584
4 255
4 774
2 474
output
Areyoubusy
 */
