package c100;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc100_b {
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
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + a[i];
        }
        long ans = (long) 1e18;
        int left = 1, mid = 2, right = 3;
        while (mid < n - 1) {
            long midS = s[mid];
            while (Math.abs(s[left] * 2 - midS) > Math.abs(s[left + 1] * 2 - midS)) {
                left++;
            }
            while (Math.abs(s[right] * 2 - midS - s[n]) > Math.abs(s[right + 1] * 2 - midS - s[n])) {
                right++;
            }
            long a = s[left], b = midS - s[left], c = s[right] - midS, d = s[n] - s[right];
            ans = Math.min(ans, max(a, b, c, d) - min(a, b, c, d));

            mid++;
        }
        return String.valueOf(ans);
    }

    private static long max(long a, long b, long c, long d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    private static long min(long a, long b, long c, long d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
}
/*
D - Equal Cut
https://atcoder.jp/contests/abc102/tasks/arc100_b

灵茶の试炼 2022-12-05
题目大意：
输入 n (4≤n≤1e5) 和一个长为 n 的数组 a (1≤a[i]≤1e9)。
将 a 分割成 4 个非空连续子数组，计算这 4 个子数组的元素和。
你需要最小化这 4 个和中的最大值与最小值的差。
输出这个最小值。

https://atcoder.jp/contests/abc102/submissions/37028653
三指针 left mid right，对应三条分割线。
枚举 mid，那么 left 应当把左边分割的尽量均匀，right 同理。
mid 增大时，left 和 right 都是只增不减的。
这样就可以 O(n) 实现了。
什么叫均匀？如果 left+1 分出的两段的元素和的绝对差比 left 更小，那么 left 就应当右移。
======

Input 1
5
3 2 4 1 2
Output 1
2

Input 2
10
10 71 84 33 6 47 23 25 52 64
Output 2
36

Input 3
7
1 2 3 1000000000 4 5 6
Output 3
999999994
 */