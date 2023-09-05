package c162;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc162_f {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] f = new long[n + 1];
        long s = a[0];
        for (int i = 2; i <= n; i++) {
            int v = a[i - 1];
            if ((i & 1) == 0) {
                f[i] = Math.max(f[i - 2] + v, s);
            } else {
                s += v;
                f[i] = Math.max(f[i - 2] + v, f[i - 1]);
            }
        }
        return String.valueOf(f[n]);
    }
}
/*
F - Select Half
https://atcoder.jp/contests/abc162/tasks/abc162_f

灵茶の试炼 2022-11-08
题目大意：
本题是力扣 198. 打家劫舍 的变形题。
输入 n (2≤n≤2e5) 和长为 n 的数组 a (-1e9≤a[i]≤1e9)。
数组 a 就是 198 题的房屋存放金额。
在本题中，你必须恰好偷 floor(n/2) 个房子。
输出你能偷窃到的最高金额。
你能做到 O(1) 空间吗？

https://atcoder.jp/contests/abc162/submissions/36315908
定义 f[i] 表示从前 i 个数中选 floor(i/2) 个数的最大收益。
下面讨论的下标从 1 开始。
f[0]=f[1]=0。
对于 i≥2，
如果选，那么 f[i] = f[i-2] + a[i]。
如果不选：
- 如果 i 为偶数，那么前面的选法是固定的，也就是所有奇数下标的和，记作 s。
- 如果 i 为奇数，那么需要选 (i-1)/2 个数，在不选的情况下，相当于从前 i-1 个数中选 (i-1)/2 个数，这恰好是 f[i-1]。
选或不选取 max。
答案为 f[n]。
======

Input 1
6
1 2 3 4 5 6
Output 1
12

Input 2
5
-1000 -100 -10 0 10
Output 2
0

Input 3
10
1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000
Output 3
5000000000

Input 4
27
18 -28 18 28 -45 90 -45 23 -53 60 28 -74 -71 35 -26 -62 49 -77 57 24 -70 -93 69 -99 59 57 -49
Output 4
295
 */