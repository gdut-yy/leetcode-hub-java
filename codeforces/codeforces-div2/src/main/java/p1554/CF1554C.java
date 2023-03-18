package p1554;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1554C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(solve(n, m));
        }
    }

    private static String solve(int n, int m) {
        m++;
        int ans = 0;
        for (int i = 29; i >= 0; i--) {
            int x = n >> i & 1;
            int y = m >> i & 1;
            if (x > 0 && y == 0) {
                break;
            }
            if (x == 0 && y > 0) {
                ans |= 1 << i;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Mikasa
https://codeforces.com/contest/1554/problem/C

灵茶の试炼 2023-03-02
题目大意：
输入 t(≤3e4) 表示 t 组数据，每组数据输入两个整数 n 和 m，均在 [0,1e9] 范围内。
定义数组 a = [n xor 0, n xor 1, n xor 2, ..., n xor m]。
输出不在 a 中的最小非负整数。

https://codeforces.com/contest/1554/submission/164112524
提示 1：把答案记作 mex，把所有 a[i] 和 mex 都异或上 n，
那么 n xor mex 不能在 [0,1,2,...,m] 中，也就是 n xor mex >= m+1。
提示 2：从高到低考虑 mex 的每一位。
提示 3：如果 n 这一位是 0，m+1 这一位是 1，那么 mex 这一位一定要是 1。
如果 n 这一位是 1，m+1 这一位是 0，那么 mex 这一位可以是 0，此时 n xor mex 是 1，已经大于 m+1 了，退出循环。其余情况 mex 可以是 0，但是不能退出循环。
相似题目: C - Max MEX
https://atcoder.jp/contests/abc290/tasks/abc290_c
2003. 每棵子树内缺失的最小基因值
https://leetcode.cn/problems/smallest-missing-genetic-value-in-each-subtree/
======

input
5
3 5
4 6
3 2
69 696
123456 654321
output
4
3
0
640
530866
 */

