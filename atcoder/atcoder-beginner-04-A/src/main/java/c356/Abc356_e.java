package c356;

import java.util.Scanner;

public class Abc356_e {
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

    private static final int MX = (int) 1e6;

    private static String solve() {
        long[] s = new long[MX + 1];
        for (int v : a) {
            s[v]++;
        }
        for (int i = 2; i <= MX; i++) {
            s[i] += s[i - 1];
        }

        long ans = 0;
        for (int i = 1; i <= MX; i++) {
            long c = s[i] - s[i - 1];
            if (c == 0) continue;
            for (int j = i; j <= MX; j += i) {
                ans += j / i * (s[Math.min(j + i - 1, MX)] - s[j - 1]) * c;
            }
            ans -= c * (c + 1) / 2;
        }
        return String.valueOf(ans);
    }
}
/*
E - Max/Min
https://atcoder.jp/contests/abc356/tasks/abc356_e

灵茶の试炼 2025-01-22
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。下标从 1 开始。
定义 f(i,j) = floor(max(a[i],a[j]) / min(a[i],a[j]))。
输出所有 f(i,j) 之和，其中 1≤i<j≤n。

本质上是从 a 中选两个数来计算，所以 a 中元素顺序不影响答案。
（调和级数）枚举数字 i 以及 i 的倍数 j，那么 [j,j+i-1] 范围内的数，除以 i 下取整都等于 j/i。这些数可以合在一起计算。
为了快速知道范围中的元素个数，可以先统计每个元素的出现次数 cnt，然后计算 cnt 的前缀和。
注意所有等于 i 的数，对答案的正确贡献是 C(cnt[i], 2)，但按照上面的算法会错误地把 cnt[i]^2 加进去，
所以要额外减去 cnt[i]^2 - C(cnt[i], 2) = cnt[i]*(cnt[i]+1)/2。
代码 https://atcoder.jp/contests/abc356/submissions/61661939
======

Input 1
3
3 1 4
Output 1
8

Input 2
6
2 7 1 8 2 8
Output 2
53

Input 3
12
3 31 314 3141 31415 314159 2 27 271 2718 27182 271828
Output 3
592622
 */
