package p1921;

import java.util.Scanner;

public class CF1921C {
    static int n, f, a, b;
    static int[] m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            f = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            m = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                m[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long tot = 0;
        for (int i = 1; i <= n; i++) {
            long cost = (long) (m[i] - m[i - 1]) * a;
            tot += Math.min(cost, b);
        }
        return tot < f ? "YES" : "NO";
    }
}
/*
C. Sending Messages
https://codeforces.com/contest/1921/problem/C

题目大意：
斯捷潘是一个非常忙碌的人。今天他需要在时刻 m1,m2，…mn (mi<mi+1)发送 n 条消息。不幸的是，到 0 点的时候，他的手机只剩下 f 单位的电量了。此时，手机处于开机状态。
手机每开机一个单位的时间就会损失 a 单位的电量。而且，在任何时候，Stepan 都可以关闭手机，稍后再打开。这个动作每次消耗 b 单位能量。考虑一下打开和关闭是即时的，这样你就可以在 x 时刻打开它，同时发送消息，反之亦然，在 x 时刻发送消息，同时关闭手机。
如果在任何一点电荷水平降至 0(变为 ≤0)，则在该时刻不可能发送消息。
由于所有的信息对 Stepan 来说都非常重要，他想知道他是否可以在不给手机充电的情况下发送所有的信息。

贪心。
======

input
6
1 3 1 5
3
7 21 1 3
4 6 10 13 17 20 26
5 10 1 2
1 2 3 4 5
1 1000000000 1000000000 1000000000
1000000000
3 11 9 6
6 8 10
12 621526648 2585904 3566299
51789 61859 71998 73401 247675 298086 606959 663464 735972 806043 806459 919683
output
NO
YES
YES
NO
NO
YES
 */
