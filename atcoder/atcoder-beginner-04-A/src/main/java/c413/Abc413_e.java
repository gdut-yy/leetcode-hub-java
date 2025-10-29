package c413;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc413_e {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] p = new int[1 << n];
        for (int i = 0; i < p.length; i++) {
            p[i] = scanner.nextInt();
        }

        List<Integer> ans = fun(p, 0, 1 << n);
        out.println(String.join(" ", ans.stream().map(String::valueOf).toArray(String[]::new)));
    }

    static List<Integer> fun(int[] p, int l, int r) {
        if (r - l == 1) return new ArrayList<>(List.of(p[l]));
        int mid = (l + r) / 2;
        List<Integer> a = fun(p, l, mid);
        List<Integer> b = fun(p, mid, r);
        if (a.get(0) > b.get(0)) {
            b.addAll(a);
            return b;
        }
        a.addAll(b);
        return a;
    }
}
/*
E - Reverse 2^i
https://atcoder.jp/contests/abc413/tasks/abc413_e

题目大意：
给你一个 (1,2,3,...,2^{N}) 的排列组合 P=(P_0,P_1,...,P_{2^{N}-1}) 。
您可以执行以下任意次数（可能为零）的操作：
- 选择满足 0 <= a * 2^{b} < (a+1) * 2^{b} <=> 2^{N} 的非负整数 a,b ，并反转 P_{a * 2^{b}}, P_{a * 2^{b}+1},...,P_{(a+1) * 2^{b}-1} 。
这里，反转 P_{a * 2^{b}}, P_{a * 2^{b}+1},...,P_{(a+1) * 2^{b}-1} 意味着同时用 P_{(a+1) * 2^{b}-1}, P_{(a+1) * 2^{b}-2},...,P_{a * 2^{b}} 替换 P_{a * 2^{b}}, P_{a * 2^{b}+1},...,P_{(a+1) * 2^{b}-1} 。
求重复上述操作可以得到的词性最小的排列组合 P 。
给你 T 个测试案例，请找出每个案例的答案。

https://atcoder.jp/contests/abc413/editorial/13406
======

Input 1
4
1
1 2
2
1 3 4 2
2
2 3 4 1
3
8 3 4 2 1 5 7 6
Output 1
1 2
1 3 2 4
1 4 2 3
1 5 6 7 2 4 3 8
 */
