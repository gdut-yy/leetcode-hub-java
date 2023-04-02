package c153;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arc153_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static final long E12 = (long) 1e12;

    private static String solve(int n, int[] a) {
        long s = 0L;
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = i;
            s += i * a[i];
        }
        if (s == 0) {
            return output(b);
        }
        if (s > 0 == a[0] > 0) {
            b[0] = -s * a[0];
            return output(b);
        }
        if (s > 0 == a[n - 1] < 0) {
            b[n - 1] = -(s - (n - 1L) * a[n - 1]) * a[n - 1];
            return output(b);
        }

        int pre = 0;
        for (int i = 0; i < n; i++) {
            pre += a[i];
            if (pre != 0 && pre > 0 == a[n - 1] > 0) {
                s = 0;
                for (int j = i + 1; j < n; j++) {
                    s += j * a[j];
                }
                for (int j = 0; j < i; j++) {
                    b[j] = j - E12;
                    s += b[j] * a[j];
                }
                b[i] = -s * a[i];
                return output(b);
            }
        }

        int suf = 0;
        for (int i = n - 1; i >= 0; i--) {
            suf += a[i];
            if (suf != 0 && suf > 0 == a[0] > 0) {
                s = 0;
                for (int j = 1; j < i; j++) {
                    s += j * a[j];
                }
                for (int j = i + 1; j < n; j++) {
                    b[j] = E12 - (n - 1 - j);
                    s += b[j] * a[j];
                }
                b[i] = -s * a[i];
                return output(b);
            }
        }

        return "No";
    }

    private static String output(long[] b) {
        return "Yes"
                + System.lineSeparator()
                + Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C - ± Increasing Sequence
https://atcoder.jp/contests/arc153/tasks/arc153_c

灵茶の试炼 2023-02-01
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a，只包含 -1 和 1。
你需要构造一个严格递增数组 b，元素范围在 [-1e12,1e12]，且 sum(a[i]*b[i]) = 0
如果无法构造，输出 No；否则输出 Yes 和数组 b。

https://atcoder.jp/contests/arc153/submissions/38517162
提示 1：b 的首尾元素受到的约束最小，是最灵活的。
提示 2：如果 a 的首尾元素相同，那么无论中间算出的是多少，都可以通过调整 b 的首尾元素让 sum=0。
提示 3：如果 a 的首尾元素不同，基于提示 2，找 a 的一个前缀和，它与 a 的末尾元素的正负号相同；找 a 的一个后缀和，它与 a[0] 的正负号相同。这样的前缀和/后缀和就能作为一个「整体」，达到和提示 2 一样的效果。
如果不存在，则无法构造。
======

Input
5
-1 1 -1 -1 1
Output
Yes
-3 -1 4 5 7

Input
1
-1
Output
Yes
0

Input
2
1 -1
Output
No
 */