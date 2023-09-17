package c295;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc295_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        long res = 0L;
        int sumMod2Mask = 0;
        int[] cnt = new int[1 << 10];
        cnt[0] = 1;
        for (char c : s.toCharArray()) {
            int num = c - '0';
            sumMod2Mask ^= 1 << num;
            res += cnt[sumMod2Mask];
            cnt[sumMod2Mask]++;
        }
        return String.valueOf(res);
    }
}
/*
D - Three Days Ago
https://atcoder.jp/contests/abc295/tasks/abc295_d

题目大意：
字符串 20230322 可以被重新排列为 02320232，这是 0232 的两次重复。
类似地，当一个由数字组成的字符串可以被重新排列成(或已经是)某个字符串的重复两次时，我们说它是快乐的。
给你一个由数字组成的字符串 S。求满足下列所有条件的整数(l,r)对的个数。

异或相当于模 2 下的加法
相似题目: 2588. 统计美丽子数组数目
https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/
======

Input
20230322
Output
4

Input
0112223333444445555556666666777777778888888889999999999
Output
185

Input
3141592653589793238462643383279502884197169399375105820974944
Output
9
 */