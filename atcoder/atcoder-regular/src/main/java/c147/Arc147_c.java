package c147;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Arc147_c {
    static int n;
    static Integer[] l, r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        l = new Integer[n];
        r = new Integer[n];
        for (int i = 0; i < n; i++) {
            l[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(l, Comparator.reverseOrder());
        Arrays.sort(r);
        long ans = 0;
        for (int i = 0; l[i] > r[i]; i++) {
            ans += (n - 1 - i * 2L) * (l[i] - r[i]);
        }
        return String.valueOf(ans);
    }
}
/*
C - Min Diff Sum
https://atcoder.jp/contests/arc147/tasks/arc147_c

灵茶の试炼 2023-10-19
题目大意：
输入 n(2≤n≤3e5)，然后输入 n 行，每行两个数，表示一个闭区间的左右端点 L[i] 和 R[i]，数值范围在 [1,1e7] 内。
你需要从每个闭区间内，各选择一个整数。这 n 个数组成了数组 x。
设 s 为所有 abs(x[j] - x[i]) 的和，其中 i < j。
相当于把 x 中的所有数放在一条数轴上，计算所有点对的距离之和。
输出 s 的最小值。

https://www.luogu.com.cn/blog/endlesscheng/solution-at-arc147-c
======

Input 1
3
1 3
2 4
5 6
Output 1
4

Input 2
3
1 1
1 1
1 1
Output 2
0

Input 3
6
1 5
2 4
1 1
4 4
3 6
3 3
Output 3
15
 */