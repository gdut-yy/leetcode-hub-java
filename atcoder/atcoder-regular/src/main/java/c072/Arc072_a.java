package c072;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc072_a {
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
        long ans = Math.min(f(1), f(-1));
        return String.valueOf(ans);
    }

    private static long f(int to) {
        long s = 0;
        long res = 0;
        for (int v : a) {
            s += v;
            if (s * to <= 0) {
                res += Math.abs(s - to);
                s = to;
            }
            to *= -1;
        }
        return res;
    }
}
/*
C - Sequence
https://atcoder.jp/contests/arc072/tasks/arc072_a

灵茶の试炼 2022-12-06
题目大意：
输入 n (2≤n≤1e5) 和一个长为 n 的数组 a (-1e9≤a[i]≤1e9)。
每次操作你可以把一个 a[i] 加一或减一。
如果要让 a 的所有相邻前缀和的乘积都小于 0，至少需要操作多少次？

https://atcoder.jp/contests/abc059/submissions/37050266
提示 1：前缀和的符号要么是 -+-+... 要么是 +-+-...
提示 2：如果一个前缀和的符号已经和期望的符号相同，那么就无需修改（因为修改后面的可以达到同样的效果）
因此，枚举前缀和要变成提示 1 中的哪一种，
然后从左到右遍历前缀和，如果符号和期望的不同，就直接改成 1 或者 -1。
代码实现时有一些技巧，可以看看。
======

Input 1
4
1 -3 1 0
Output 1
4

Input 2
5
3 -6 4 -5 7
Output 2
0

Input 3
6
-1 4 3 2 -5 4
Output 3
8
 */