package c140;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arc140_c {
    static int n, x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        x = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int m = n / 2;
        if (x == m + 1) {
            int[] p = new int[n];
            p[0] = m + 1;
            for (int i = 2; i < n; i += 2) {
                p[i] = p[i - 2] + 1;
            }
            p[1] = m;
            for (int i = 3; i < n; i += 2) {
                p[i] = p[i - 2] - 1;
            }
            return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        }

        int[] LR = new int[m * 2];
        int v = 1;
        for (int i = 0; i < m * 2; i++) {
            LR[i] = (v == x) ? ++v : v;
            v++;
        }

        int[] p = new int[n];
        p[0] = x;
        if (n % 2 == 1) {
            int p1 = m - 1, p2 = m;
            for (int i = 1; i < n; i += 2) {
                p[i] = LR[p1--];
            }
            for (int i = 2; i < n; i += 2) {
                p[i] = LR[p2++];
            }
        } else {
            // 题解没明确的 N 是偶数的场景
            // P=(X, R1, LM, R2, LM-1..., L1, RM)
            int p2 = (n - 1) / 2;
            int p1 = p2 - 1;
            for (int i = 1; i < n; i += 2) {
                p[i] = LR[p2++];
            }
            for (int i = 2; i < n; i += 2) {
                p[i] = LR[p1--];
            }
        }
        return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C - ABS Permutation (LIS ver.)
https://atcoder.jp/contests/arc140/tasks/arc140_c

灵茶の试炼 2022-12-07
题目大意：
输入 n 和 x (x≤n≤2e5)。
你需要构造一个 1~n 的排列 p，其中第一项为 x。
p 可以生成一个长为 n-1 的数组 a，使得 a[i]=abs(p[i]-p[i+1])。
通过构造合适的 p，最大化 a 的 LIS（最长严格递增子序列）的长度。
输出 p。

https://atcoder.jp/contests/arc140/editorial/3970
为简单起见，我们将考虑 N 是奇数的情况。(当 N 是偶数时，会有细微的差别，但主要思想是一样的。)令 M=⌊N/2⌋。
答案的一个明显的上界是 N−1，只有通过 A=(1,2,...,N−1)才能实现。
从后往前考虑这个 A 的元素，我们可以看到它只有两个对应的 P:
P = (M+1, M, M+2, M−1,...,1,N), (M+1, M+2, M, M+3,...,N,1)。
如果 X=M+1，我们可以输出上述结果之一。
如果 X!=M+1，我们有 N-2 的上界。我们将除 X 以外的元素分成长度为 M 的两个数组 L 和 R，使 L1 < L2 < ... < LM < R1 < R2 < ... < RM。
现在上界由 P=(X, LM, R1, LM−1, R2,..., L1, RM)得到。
======

Input 1
3 2
Output 1
2 1 3

Input 2
3 1
Output 2
1 2 3

6 1
1 4 3 5 2 6
 */