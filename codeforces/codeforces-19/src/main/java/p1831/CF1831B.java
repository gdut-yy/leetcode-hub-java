package p1831;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1831B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a, b));
        }
    }

    // https://codeforces.com/contest/1831/submission/207693919
    private static String solve(int n, int[] a, int[] b) {
        int[] ts = new int[n * 2 + 1];
        int lst = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1 && a[i] == a[i + 1]) continue;
            ts[a[i]] = Math.max(ts[a[i]], i - lst);
            lst = i;
            ans = Math.max(ans, ts[a[i]]);
        }
        lst = -1;
        for (int i = 0; i < n; i++) {
            if (i != n - 1 && b[i] == b[i + 1]) continue;
            ans = Math.max(ans, ts[b[i]] + i - lst);
            lst = i;
        }
        return String.valueOf(ans);
    }
}
/*
B. Array merging
https://codeforces.com/contest/1831/problem/B

题目大意：
给定两个数组 a 和 b 长度都是 n。
你将合并这些数组，形成另一个长度为 2⋅n 的数组 c。你必须找到一个子数组的最大长度，这个子数组由所有可以得到的数组 c 中的相等的值组成。
两个数组的合并将产生一个数组 c，该数组依次取任意一个数组的第一个元素(只要该数组是非空的)并删除它。在这一步之后，元素被附加到 c 的后面。我们尽可能地重复这个操作(即至少有一个数组是非空的)。

结论。最长连续相同子数组 必然 分别对应原来数组的 最长连续相同子数组。
======

input
4
1
2
2
3
1 2 3
4 5 6
2
1 2
2 1
5
1 2 2 2 2
2 1 1 1 1
output
2
1
2
5
 */
