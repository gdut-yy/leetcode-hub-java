package p1400;

import java.util.Scanner;

public class CF1400D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        long[] cnt = new long[n + 1];
        cnt[a[0]]++;
        for (int j = 1; j < n - 2; j++) {
            int v = a[j];
            long c = cnt[a[j + 1]];
            for (int i = j + 2; i < n; i++) {
                int w = a[i];

                if (w == v) {
                    ans += c;
                }
                c += cnt[w];
            }
            cnt[v]++;
        }
        return String.valueOf(ans);
    }
}
/*
D. Zigzags
https://codeforces.com/contest/1400/problem/D

灵茶の试炼 2022-09-09
题目大意：
输入 t (≤100) 表示 t 组数据，每组数据输入 n (4≤n≤3000) 和一个长为 n 的数组 a (1≤a[i]≤n)，下标从 1 开始。所有数据的 n 之和 ≤3000。
对每组数据，输出满足 1≤i<j<k<l≤n 且 a[i]=a[k] 且 a[j]=a[l] 的四元组 (i,j,k,l) 的数量。
相似题目 https://codeforces.com/contest/1677/problem/A

rating 1900
https://codeforces.com/contest/1400/submission/171470018
提示 1：枚举 j 和 l。
提示 2：枚举 j 的同时，统计下标小于 j 的每个元素的出现次数 cnt[x]。
提示 3：遍历 l，累加 j 和 l 之间的 cnt[x]，记作 c，当 a[j] = a[l] 时，累加 c 到答案上。
注意用 64 位整数。
======

input
2
5
2 2 2 2 2
6
1 3 3 1 2 3
output
5
2
 */
