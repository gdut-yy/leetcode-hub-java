package c371;

import java.util.Scanner;

public class Abc371_e {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long sumG = 0;
        long ans = 0;
        int[] last = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = a[i - 1];
            sumG += i - last[v];
            ans += sumG;
            last[v] = i;
        }
        return String.valueOf(ans);
    }
}
/*
E - I Hate Sigma Problems
https://atcoder.jp/contests/abc371/tasks/abc371_e

灵茶の试炼 2025-02-25
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
定义 f(i,j) 为连续子数组 a[i]~a[j] 中的不同元素个数。
输出所有 f(i,j) 之和，其中 i<=j。

本题是 LC2262. 字符串的总引力，做法见我题解。
代码 https://atcoder.jp/contests/abc371/submissions/62942398
======

Input 1
3
1 2 2
Output 1
8

Input 2
9
5 4 2 2 3 2 4 4 1
Output 2
111
 */
