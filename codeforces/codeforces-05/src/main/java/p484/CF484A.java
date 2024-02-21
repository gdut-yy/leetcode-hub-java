package p484;

import java.util.Scanner;

public class CF484A {
    static long L, R;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            L = scanner.nextLong();
            R = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        // 把最低的 0 改成 1
        while ((L | (L + 1)) <= R) {
            L |= L + 1;
        }
        return String.valueOf(L);
    }
}
/*
A. Bits
https://codeforces.com/contest/484/problem/A

灵茶の试炼 2022-09-05
题目大意：
输入 t (t≤1e4) 表示 t 组数据，每组数据输入两个数 L 和 R (0≤L≤R≤1e18)。
对每组数据，输出在区间 [L,R] 内的二进制中的 1 的个数最多的那个数字，如果有多个这样的数字，输出最小的。
思考：如果让你找的是 0 的个数最多的那个数字呢？（前导零不计）

rating 1700
https://codeforces.com/problemset/submission/484/170918872
提示 1：由于要 ≥L，可以尝试从 L 出发，把 L 的二进制中的 0 改成 1，使得修改之后 L≤R。
提示 2：贪心：从最低位的 0 开始修改，这样才能修改尽可能多的 0 为 1。
相比枚举 0 的位置，有一种更巧妙的位运算技巧，见代码。
思考题解答：方法类似，从 R 出发把 1 改成 0。
======

input
3
1 2
2 4
1 10
output
1
3
7
 */
