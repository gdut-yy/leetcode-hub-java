package c136;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc136_d {
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

    private static final int MAX_N = (int) 1e6;

    private static String solve() {
        long[] f = new long[MAX_N];
        for (int v : a) {
            f[v]++;
        }
        // 注意循环顺序，需要保证先计算完 f[i-p10]，再计算 f[i]
        for (int p10 = 1; p10 < MAX_N; p10 *= 10) {
            for (int i = 0; i < MAX_N; i++) {
                if (i / p10 % 10 > 0) {
                    f[i] += f[i - p10];
                }
            }
        }
        long ans = 0;
        next:
        for (int x : a) {
            ans += f[MAX_N - 1 - x];
            while (x > 0) {
                if (x % 10 > 4) {
                    continue next;
                }
                x /= 10;
            }
            // 多统计了 x+x 的情况
            ans--;
        }
        return String.valueOf(ans / 2);
    }
}
/*
D - Without Carry
https://atcoder.jp/contests/arc136/tasks/arc136_d

灵茶の试炼 2023-09-15
题目大意：
输入 n(2≤n≤1e6) 和长为 n 的数组 a(0≤a[i]<1e6)。
输出满足【十进制加法 a[i]+a[j] 的每个数位都没有产生进位】的下标对 (i,j) 个数，其中 i<j。

举例，如果一个数和 666 相加不进位，那么与 665 相加也不会进位。
定义 y 是 x 的「十进制子集」，当且仅当 y 的所有数位都小于等于 x 对应的数位。例如 666,566,656,665,123,66 都是 666 的十进制子集。
定义 f[i] 表示 i 的十进制子集的个数。
为什么要这样定义？对于 a[i] 来说，999999-a[i] 的任意十进制子集与 a[i] 相加都不会进位，所以 f[999999-a[i]] 就是与 a[i] 相加不进位的数字个数。
枚举 i 的第 j 个数位，如果这个数位大于 0，那么
f[i] += f[i-pow(10,j)]
初始值：f[x] = x 在数组 a 中的出现次数。
然后遍历 a[i]，把 f[999999-a[i]] 加到答案中。
如果 a[i]+a[i] 没有进位，那么我们多统计了一个答案，ans--。
最后把答案除以 2，因为 (a[i],a[j]) 和 (a[j],a[i]) 我们都统计了一次。
https://atcoder.jp/contests/arc136/submissions/45039336
注：如果你之前学过二进制的 SOS DP，对于想出本题做法有帮助。
本题相当于是十进制的 SOS DP。
https://codeforces.com/blog/entry/45223
======

Input 1
4
4 8 12 90
Output 1
3

Input 2
20
313923 246114 271842 371982 284858 10674 532090 593483 185123 364245 665161 241644 604914 645577 410849 387586 732231 952593 249651 36908
Output 2
6

Input 3
5
1 1 1 1 1
Output 3
10
 */