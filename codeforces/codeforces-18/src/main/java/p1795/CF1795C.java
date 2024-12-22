package p1795;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1795C {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + b[i];
        }

        long[] ans = new long[n];
        long[] d = new long[n + 1];
        long[] ex = new long[n + 1];
        long sd = 0;
        for (int i = 0; i < n; i++) {
            int j = searchInts(s, s[i] + a[i] + 1) - 1;
            d[i]++;
            d[j]--;
            sd += d[i];
            ex[j] += a[i] - (s[j] - s[i]);
            ans[i] = sd * (s[i + 1] - s[i]) + ex[i];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static int searchInts(long[] a, long key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
C. Tea Tasting
https://codeforces.com/contest/1795/problem/C

灵茶の试炼 2024-10-15
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5)，长为 n 的数组 a(1≤a[i]≤1e9)，长为 n 的数组 b(1≤b[i]≤1e9)。
有 n 杯茶，第 i 杯有 a[i] 毫升。
有 n 位品茶师，第 i 位一次可以喝 b[i] 毫升茶。
下标从 1 开始。
品茶流程有 n 轮。
第一轮，第 i 位品茶师喝第 i 杯茶。i>=1。
第二轮，第 i 位品茶师喝第 i-1 杯茶。i>=2。第 1 位品茶师什么也不做。
第三轮，第 i 位品茶师喝第 i-2 杯茶。i>=3。第 1,2 位品茶师什么也不做。
依此类推。
输出每位品茶师喝茶的总量。

rating 1500
人喝茶，茶被人喝。
反向思维，考虑一杯茶被哪些人喝。
用前缀和+二分+差分数组解决。
对于 a[i]，我们有 s[j] - s[i] <= a[i]。
在前缀和数组 s 中，二分最后一个 <= s[i] + a[i] 的位置 j。
那么 [i,j) 中的人都满满地喝了一口，用差分数组维护。
注意，第 j 个人可以喝剩下的 a[i] - (s[j] - s[i])，单独记录到数组 ex[j] 中。
代码 https://codeforces.com/problemset/submission/1795/285270973
======

Input
4
3
10 20 15
9 8 6
1
5
7
4
13 8 5 4
3 4 2 1
3
1000000000 1000000000 1000000000
1 1 1000000000
Output
9 9 12
5
3 8 6 4
1 2 2999999997
 */
