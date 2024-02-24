package p1396;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1396A {
    static int n;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<String> ans = new ArrayList<>();
        if (n == 1) {
            ans.add("1 1");
            ans.add("" + -a[0]);
            ans.add("1 1");
            ans.add("0");
            ans.add("1 1");
            ans.add("0");
            return String.join(System.lineSeparator(), ans);
        }

        ans.add("1 1");
        ans.add("" + -a[0]);
        a[0] = 0;
        ans.add("2 " + n);
        ans.add(f1());
        ans.add("1 " + n);
        ans.add(f2());
        return String.join(System.lineSeparator(), ans);
    }

    static String f1() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (long v : Arrays.copyOfRange(a, 1, a.length)) {
            sb.append(v * (n - 1)).append(" ");
            a[i++] += v * (n - 1);
        }
        return sb.toString();
    }

    static String f2() {
        StringBuilder sb = new StringBuilder();
        for (long v : a) {
            sb.append(-v).append(" ");
        }
        return sb.toString();
    }
}
/*
A. Multiples of Length
https://codeforces.com/contest/1396/problem/A

灵茶の试炼 2022-04-20
题目大意：
给你一个长度不超过 1e5 的数组（元素范围在 -1e9 ~ 1e9），你要执行恰好三次操作，使得操作结束后数组所有数均为 0。
每次操作你需要选择一个区间（设区间长度为 len），对于区间内的数，加上 len 的任意倍（倍数可正可负可为 0）。注意这对每个数是互相独立的，比如 len=3，那么你可以给区间内的第一个数加 6，第二个数减 9，第三个数加 0。
请你给出任意一个合法方案，可以证明这个问题一定有解。
每个操作输出两行，第一行为区间左右端点（下标从 1 开始），第二行为每个数在该次操作下的变化量（需要能被 len 整除）。

rating 1600
constructive algorithms
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1396a
https://www.luogu.com.cn/problem/solution/cf1396a
由于 x+x*(n-1) = x*n，所以得到如下构造方法：
1、把 a1 加上 -a1
2、把从 2 到 n 的 ai 加上 ai*(n-1)
3、把从 1 到 n 的 ai 加上 -ai
注意特判 n=1 的情况。
======

input
4
1 3 2 4
output
1 1
-1
3 4
4 2
2 4
-3 -6 -6
 */