package c310;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc310_e {
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        int zeros = 0, ones = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ans += zeros + ones;
                pre = zeros + ones;
                zeros++;
            } else {
                ans += i + 1 - pre;
                pre = i + 1 - pre;
                ones++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
E - NAND repeatedly
https://atcoder.jp/contests/abc310/tasks/abc310_e

题目大意：
给定一个长度为 N 的字符串 S，由 0 和 1 组成。它描述了一个长度为 N 的序列 a =(a1,a2,...,a1)。若 S(1≤i≤N)的第 i 个字符为 0，则 A i =0;如果是 1，那么 A i =1。
---
f(1,1)=0=0
f(1,2)=0⊼0=1
f(1,3)=(0⊼0)⊼1=0
f(1,4)=((0⊼0)⊼1)⊼1=1
f(1,5)=(((0⊼0)⊼1)⊼1)⊼0=1
f(2,2)=0=0
f(2,3)=0⊼1=1
f(2,4)=(0⊼1)⊼1=0
f(2,5)=((0⊼1)⊼1)⊼0=1
f(3,3)=1=1
f(3,4)=1⊼1=0
f(3,5)=(1⊼1)⊼0=1
f(4,4)=1=1
f(4,5)=1⊼0=1
f(5,5)=0=0
---
f(1,5)=(((0⊼0)⊼1)⊼1)⊼0=1
f(2,5)=((0⊼1)⊼1)⊼0=1
f(3,5)=(1⊼1)⊼0=1
f(4,5)=1⊼0=1
f(5,5)=0=0
---
f(1,4)=((0⊼0)⊼1)⊼1=1
f(2,4)=(0⊼1)⊼1=0
f(3,4)=1⊼1=0
f(4,4)=1=1
---
f(1,3)=(0⊼0)⊼1=0
f(2,3)=0⊼1=1
f(3,3)=1=1
---
f(1,2)=0⊼0=1
f(2,2)=0=0
---
f(1,1)=0=0

与非的性质
0⊼0=1,0⊼1=1,1⊼0=1,1⊼1=0.
相似题目: LCP 81. 与非的谜题
https://leetcode.cn/problems/ryfUiz/
======

Input 1
5
00110
Output 1
9

Input 2
30
101010000100101011010011000010
Output 2
326
 */