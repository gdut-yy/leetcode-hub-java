package p1541;

import java.util.Scanner;

public class CF1541B {
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
        int[] idx = new int[n * 2 + 1];
        int ans = 0;
        for (int j = 1; j <= n; j++) {
            int aj = a[j - 1];
            for (int ai = 1; ai * aj < j * 2; ai++) {
                int i = idx[ai];
                if (i > 0 && ai * aj == i + j) {
                    ans++;
                }
            }
            idx[aj] = j;
        }
        return String.valueOf(ans);
    }
}
/*
B. Pleasant Pairs
https://codeforces.com/contest/1541/problem/B

灵茶の试炼 2024-02-27
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤2n)，数组元素互不相同。
输出有多少对 (i,j) 满足 i<j 且 a[i]*a[j]=i+j。

rating 1200
从小到大枚举 j，然后寻找符合要求的 i。
由于 i<j，所以 a[i]*a[j] = i+j < 2j，我们可以直接暴力枚举 a[i]=1,2,3,4,...,(2j-1)/a[j]，去看 j 左边是否有枚举的 a[i]，
如果有，再判断 a[i]*a[j]=i+j 是否成立，成立就把答案加一。
由于数组元素互不相同，根据调和级数公式，暴力枚举的复杂度是 O(nlogn)。
https://codeforces.com/contest/1541/submission/246092627
======

input
3
2
3 1
3
6 1 5
5
3 1 5 9 2
output
1
1
3
 */
