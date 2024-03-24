package c007;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Agc007_b {
    static int n;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[p[i] - 1] = n * p[i] + i;
        }
        int[] b = new int[n];
        b[0] = n * n;
        for (int i = 1; i < n; i++) {
            b[i] = b[i - 1] - n;
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")) + System.lineSeparator()
                + Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B - Construct Sequences
https://atcoder.jp/contests/agc007/tasks/agc007_b

灵茶の试炼 2022-06-10
题目大意：
输入 n(<=20000) 和一个 1~n 的排列 p。
请你构造两个长度为 n 的数组 a 和 b，满足：
1. 元素值在 [1,1e9]
2. a 严格单调递增
3. b 严格单调递减
4. a[p[i]]+b[p[i]] 严格单调递增，即 a[p[0]]+b[p[0]] < a[p[1]]+b[p[1]] < ...
输出任意符合上述要求的 a 和 b。

https://atcoder.jp/contests/agc007/submissions/32349215
我的思考过程：
假设 a[p[i]]+b[p[i]] 是 1 2 3 ...
再假设 b 是 -1 -2 -3 ... (最后再加个偏移量调整到 [1,1e9])
但是这样算的话，左边的样例算出来 a=[4,3,5] 了，而且也不太好调整。
不妨将 b 扩大 10 倍，即 -10 -20 -30，这样 a=[13,21,32]，看上去不错哦。
一般地，将 b 扩大 n 倍就能适用于一般情况了。
因此可以得到如下构造方案：
a[p[i]] = n*p[i] + i
b[i] = n*(n-i)
---
最坏情况下，max(a[n-1], b[0]) 的最小值可以是多少？
======

Input 1
2
1 2
Output 1
1 4
5 4

Input 2
3
3 2 1
Output 2
1 2 3
5 3 1

Input 3
3
2 3 1
Output 3
5 10 100
100 10 1
 */