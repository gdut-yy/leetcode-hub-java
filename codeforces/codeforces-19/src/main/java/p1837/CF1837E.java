package p1837;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1837E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static final int MOD = 998244353;

    // https://codeforces.com/contest/1837/submission/207213651
    private static String solve(int n, int[] a) {
        for (int i = 0; i < 1 << n; i++) {
            if (~a[i] != 0) {
                a[i]--;
            }
        }
        return String.valueOf(f(a, n));
    }

    private static long f(int[] a, int n) {
        if (n == 0) return 1;
        long ans = 1, cnt = 0;
        for (int i = 0; i < 1 << n; i += 2) {
            if ((~a[i] != 0 && ~a[i + 1] != 0)) {
                if (a[i] < 1 << n - 1 == a[i + 1] < 1 << n - 1) return 0;
            }
            if (a[i] >= 1 << n - 1 || a[i + 1] >= 1 << n - 1) continue;
            if (a[i] == -1 && a[i + 1] == -1) ans = ans * 2 % MOD;
            if (a[i] == -1 || a[i + 1] == -1) ans = ans * ++cnt % MOD;
        }
        int[] b = new int[1 << n];
        int id = 0;
        for (int i = 0; i < 1 << n; i += 2) {
            if (~a[i] != 0 && a[i] < 1 << n - 1) {
                b[id++] = a[i];
            } else if (~a[i + 1] != 0 && a[i + 1] < 1 << n - 1) {
                b[id++] = a[i + 1];
            } else {
                b[id++] = -1;
            }
        }
        return ans * f(b, n - 1) % MOD;
    }
}
/*
E. Playoff Fixing
https://codeforces.com/contest/1837/problem/E

题目大意：
2^k 支队伍参加了一场季后赛。各队按人数递减的顺序编号，从 1 到 2000。1 队最强，2^k 队最弱。人数少的球队总是击败人数多的球队。
首先，在一个叫做播种的过程中，各队按一定顺序排列。每支球队都被分配了一个独特的值，从 1 到 2^k，称为种子，代表其在季后赛中的起始位置。
比赛包括 2^k−1 的比赛。他们的比赛方式如下:队伍分成两组:1 号种子队对阵 2 号种子队，3 号种子队对阵 4 号种子队(完全按照这个顺序)，以此类推(因此，在那个阶段进行 2^k−1 场比赛)。当一个队输了一场比赛，它就被淘汰了。
在那之后，只剩下 2^k−1 个队伍。如果只剩下一支队伍，则宣布其为冠军;否则，进行 2^k−2 场比赛:在第一场比赛中，“1 号种子对 2 号种子”的胜者对阵“3 号种子对 4 号种子”的胜者，然后是“5 号种子对 6 号种子”的胜者对阵“7 号种子对 8 号种子”的胜者，以此类推。这个过程不断重复，直到只剩下一个团队。
比赛结束后，球队将根据他们被淘汰时的比赛阶段分配名额。特别是:
- 比赛的获胜者将获得第 1 名;
- 在决赛中被淘汰的球队获得第 2 名;
- 在半决赛中被淘汰的两支球队获得第 3 名;
- 所有在四分之一决赛中被淘汰的球队获得第 5 名;
- 所有在 1/8 决赛中被淘汰的球队获得第 9 个席位，以此类推。
既然我们建立了规则，我们就来做一点操纵。我们特别希望:
- 第 1 队(不是种子号队)将进行第 1 场比赛;
- 第 2 队参加第二场比赛;
- 第 3 队和第 4 队参加第 3 场比赛;
- 从 5 到 8 的队伍参加 5 场比赛，以此类推。
例如，这张图描述了 k=3 时锦标赛可能进行的一种方式，以及球队的最终位置:
一些种子已经留给了一些球队(显然，我们不是唯一操纵比赛的球队)。我们必须用剩下的队伍来填补剩下的种子，以达到预期的排位。有多少种方法?由于该值可能很大，所以对 998244353 取模打印它。
---
1. 并列的队伍，其中没有分配 seed 的，要怎么分配 seed（全排列）。
2. 决赛的 team 1 和 team 2 要在不同的半区，如果都没有分配 seed，那么有 2 种分配方案，但这 2 种只能表示上下半区，并没有确定具体的 seed（准确地说确定的是 seed 的最高位）。假设 team 1 在上半区，team 2 在下半区。然后考虑半决赛，如果 team 1~4 都没有分配 seed，那么分配方式就是 1_ + 2_ 或 _1 + 2_ 或 1_ + _2 或 _1 + _2 这 4 种（下划线填 3 或 4）注意 team 3 和 team 4 是并列的，它们的顺序在要点 1 中考虑了。1/4 决赛也是类似的，考虑 1234 这四个队的顺序，5~8 由于是并列的，它们的顺序在要点 1 中考虑了。

组合计数
======

input
2
1 2 3 4
output
0

input
2
1 3 4 2
output
1

input
1
-1 -1
output
2

input
2
-1 -1 -1 -1
output
16

input
3
-1 -1 -1 -1 2 -1 -1 -1
output
768

input
0
1
output
1
 */
