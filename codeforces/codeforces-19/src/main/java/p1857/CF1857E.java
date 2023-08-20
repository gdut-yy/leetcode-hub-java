package p1857;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1857E {
    static int n;
    static int[] x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> x[o]));

        long s = 0;
        for (int i = 0; i < n; i++) {
            s += x[ids[i]] - x[ids[0]] + 1;
        }

        long[] ans = new long[n];
        ans[ids[0]] = s;
        for (int i = 1; i < n; i++) {
            long delta = x[ids[i]] - x[ids[i - 1]];
            s -= (n - 1 - i) * delta;
            s += (i - 1) * delta;
            ans[ids[i]] = s;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E. Power of Points
https://codeforces.com/contest/1857/problem/E

题目大意：
给定 n 个点，坐标为 x1,...,xn，它们位于数轴上。
对于某些整数 s，我们构造分段[s,x1]， [s,x2],...,[s,xn]。注意，如果 xi<s，则段看起来像[xi,s]。段[a,b]覆盖所有整数点 a,a+1,a+2,...,b。
我们将点 p 的幂定义为与坐标 p 相交的线段的个数，记为 fp。
你的任务是计算每个 s∈{x1,...,xn}，即从 1 到 10^9 的所有整数点的 fp 之和。
例如，如果初始坐标为[1,2,5,7,1]，我们选择 s=5，则段将为:[1,5]，[2,5]，[5,5]，[5,7]，[1,5]。这些点的幂是:f1=2 f2=3 f3=3 f4=3 f5=5 f6=1 f7=1 f8=0 ... f10^9=0。它们的和是 2+3+3+3+5+1+1=18。

递推。
相似题目: 2615. 等值距离和
https://leetcode.cn/problems/sum-of-distances/
======

input
3
3
1 4 3
5
1 2 5 7 1
4
1 10 100 1000
output
8 7 6
16 15 18 24 16
1111 1093 1093 2893
 */
