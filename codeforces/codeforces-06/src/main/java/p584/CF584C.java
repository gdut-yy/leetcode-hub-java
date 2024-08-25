package p584;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF584C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        String s1 = scanner.next();
        String s2 = scanner.next();
        System.out.println(solve(n, t, s1, s2));
    }

    private static String solve(int n, int t, String s1, String s2) {
        // d = f(s1,s2)
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                d++;
            }
        }

        // 此时 f(s1,s3) == f(s2,s3) == d
        char[] s3 = new char[n];
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                s3[i] = s1.charAt(i);
            } else {
                s3[i] = unlikeAB(s1.charAt(i), s2.charAt(i));
            }
        }

        // 需要调整到 k = 0
        int k = (d - t) * 2;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                // 整少了
                if (k < 0) {
                    s3[i] = unlikeAB(s1.charAt(i), s2.charAt(i));
                    k += 2;
                }
            } else {
                // 整多了，每个要改两个 s3[i]，一个等于 s1[i]，一个等于 s2[i]
                if (k > 0) {
                    s3[i] = ((k & 1) == 1) ? s1.charAt(i) : s2.charAt(i);
                    k--;
                }
            }
        }

        return k == 0 ? new String(s3) : "-1";
    }

    private static char unlikeAB(char a, char b) {
        for (char ch = 'a'; ; ch++) {
            if (ch != a && ch != b) {
                return ch;
            }
        }
    }
}
/*
C. Marina and Vasya
https://codeforces.com/contest/584/problem/C

灵茶の试炼 2023-02-22
题目大意：
给定整数 n, t 和长度为 n 的字符串 s1, s2
定义 f(a,b) 表示 a[i] != b[i] 的下标数量。
构造一个长为 n 由小写字母组成的 s3，使得 f(s1,s3) == f(s2,s3) == t
如果无法构造出，输出 -1

rating 1700
constructive algorithms
https://codeforces.com/contest/584/submission/194532015
先算出 f(s1,s2)，记作 d。
把 s3 初始化成：如果 s1[i]=s2[i]，则 s3[i] = s1[i]，否则 s3[i] 是一个和 s1[i] 和 s2[i] 都不一样的字母。
如果 d<t，说明还需要整点不一样的，从 s1[i]=s2[i] 里面找。
如果 d>t，说明整多了，从 s1[i]!=s2[i] 里面恢复，每个 d 要改两个 s3[i]，一个等于 s1[i]，一个等于 s2[j]
======

input
3 2
abc
xyc
output
ayd

input
1 0
c
b
output
-1
 */
