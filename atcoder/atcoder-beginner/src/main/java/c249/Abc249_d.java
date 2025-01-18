package c249;

import java.util.Scanner;

public class Abc249_d {
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

    static final int mx = (int) 2e5;

    private static String solve() {
        long[] cnt = new long[mx + 1];
        for (int v : a) {
            cnt[v]++;
        }
        long ans = 0;
        for (int i = 1; i <= mx; i++) {
            for (int j = 1; i * j <= mx; j++) {
                ans += cnt[i] * cnt[j] * cnt[i * j];
            }
        }
        return String.valueOf(ans);
    }
}
/*
D - Index Trio
https://atcoder.jp/contests/abc249/tasks/abc249_d

灵茶の试炼 2024-08-05
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤2e5)。
问：有多少个下标三元组 (i,j,k) 满足 a[i]*a[j]=a[k]？
注意 i,j,k 之间没有大小约束。

枚举值域。
统计每个数的出现次数到 cnt 数组中。
枚举 x 和 y，根据乘法原理，有 cnt[x]*cnt[y]*cnt[x*y] 个三元组是满足要求的，加到答案中。
时间复杂度 O(U/1+U/2+U/3+...+U/U) = O(UlogU)，其中 U=max(a)=2e5。
代码 https://atcoder.jp/contests/abc249/submissions/46156403
======

Input 1
3
6 2 3
Output 1
2

Input 2
1
2
Output 2
0

Input 3
10
1 3 2 4 6 8 2 2 3 7
Output 3
62
 */