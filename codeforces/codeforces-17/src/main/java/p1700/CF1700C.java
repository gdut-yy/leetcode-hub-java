package p1700;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1700C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long ans = 0;
        long a0 = a[0];
        for (int i = 1; i < n; i++) {
            int d = a[i] - a[i - 1];
            ans += Math.abs(d);
            if (d < 0) {
                a0 += d;
            }
        }
        ans += Math.abs(a0);
        return String.valueOf(ans);
    }
}
/*
C. Helping the Nature
https://codeforces.com/contest/1700/problem/C

灵茶の试炼 2023-06-14
題目大意：
输入 T(≤2e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
每次操作，你可以执行如下三种中的一种：
1. 把一个前缀的 a[i]-=1
2. 把一个后缀的 a[i]-=1
3. 把所有 a[i]+=1
把所有 a[i] 都变成 0，至少要操作多少次？

https://codeforces.com/problemset/submission/1700/209616776
用差分思考，计算 a 的差分数组 d。注意 d 和 a 是一一映射，a 全为 0 当且仅当 d 全为 0。
操作 1 变成给 d[0]-=1，d[i+1]+=1。特别地，如果 i=n-1 则仅给 d[0]-=1。
操作 2 变成给 d[i]-=1。
操作 3 变成给 d[0]+=1。
根据这些操作，把所有 d[i] 变成 0。
相似题目: A. Extreme Subtraction
https://codeforces.com/contest/1442/problem/A
======

input
4
3
-2 -2 -2
3
10 4 7
4
4 -4 4 -4
5
1 -2 3 -4 5
output
2
13
36
33
 */
