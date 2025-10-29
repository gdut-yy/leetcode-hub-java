package c418;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc418_d {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        String s = scanner.next();

        long[] cnt = {1, 0}; // 使用long防止整数溢出
        int state = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                state = 1 - state; // 切换状态
            }
            cnt[state]++; // 更新对应状态的计数
        }

        // 计算组合数C(cnt[0],2) + C(cnt[1],2)
        long totalPairs = cnt[0] * (cnt[0] - 1) / 2 + cnt[1] * (cnt[1] - 1) / 2;
        out.println(totalPairs);
    }
}
/*
D - XNOR Operation
https://atcoder.jp/contests/abc418/tasks/abc418_d

题目大意：
> 本问题是问题 G 的子问题。
由`0`和`1`组成的非空字符串 S 满足以下条件时，称为优美字符串：
- （条件）你可以执行以下一系列操作，直到 S 的长度变为 1 ，并使 S 中唯一剩下的字符是 `1`。
  1.选择满足 1 <= i <= |S| - 1 的任意整数 i 。
  2.定义整数 x 如下：
    - 若 S_i = `0` 和 S_{i+1} = 0`，则 x = 1
    - 若 S_i = `0` 和 S_{i+1} = 1`，则 x = 0
    - 若 S_i = `1` 和 S_{i+1} = 0`，则 x = 0
    - 若 S_i = `1` 和 S_{i+1} = 1`，则 x = 1
  3.删除 S_i 和 S_{i+1} ，并插入与 x 相对应的数字。
    例如，如果 S= 10101"，而您选择了 i=2 ，则操作后的字符串为 "1001"。
给您一个长度为 N 的字符串 T ，由 `0` 和 `1` 组成。
请找出有多少个美丽的字符串是 T 的子串。即使两个子串是相同的字符串，如果它们取自不同的位置，也要分别计算。
- 1 <= N <= 2e5
- N 是整数。
- T 是长度为 N 的字符串，由 `0` 和 `1` 组成。

https://yuanbao.tencent.com/chat/naQivTmsDa/217c75a7-140f-43c9-805a-4a29e0292a29
======

Input 1
3
110
Output 1
3

Input 2
4
0000
Output 2
4

Input 3
30
011011100101110111100010011010
Output 3
225
 */
