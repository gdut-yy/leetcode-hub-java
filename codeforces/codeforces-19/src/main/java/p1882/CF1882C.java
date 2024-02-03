package p1882;

import java.util.Scanner;

public class CF1882C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long[] pre = new long[n + 5];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1];
            if (i % 2 == 1 && a[i] >= 0) {
                pre[i] += a[i];
            }
        }
        long[] suf = new long[n + 5];
        for (int i = n; i >= 1; i--) {
            suf[i] = suf[i + 1];
            if (a[i] >= 0) {
                suf[i] += a[i];
            }
        }

        long ans = 0;
        for (int i = 2; i <= n; i += 2) {
            ans = Math.max(ans, suf[i + 1] + pre[i - 1]);
        }
        for (int i = 1; i <= n; i += 2) {
            ans = Math.max(ans, a[i] + suf[i + 1] + pre[i - 1]);
        }
        return String.valueOf(ans);
    }
}
/*
C. Card Game
https://codeforces.com/contest/1882/problem/C

题目大意：
一副牌中有 n 张牌。最初，ai 被写在第 i 张卡片上——从上面开始的第 i 张。写在卡片上的值不会改变。
你将玩一个游戏。一开始你的分数是 0。在每个回合中，您可以执行以下操作之一:
- 选择一个奇数†正整数 i，它不大于牌组中剩下的牌数。把第 i 张牌从牌顶移开，把写在牌上的数字加到你的分数上。剩下的卡片将从顶部开始重新排序。
- 选择一个偶数‡正整数 i，它不大于牌组中剩下的牌数。将第 i 张牌从牌顶移开。剩下的卡片将从顶部开始重新排序。
- 结束游戏。你可以随时结束游戏，你不需要从最初的牌组中移除所有的牌。
游戏结束时你能得到的最高分是多少?
†一个整数 i 是奇数，如果存在一个整数 k 使得 i=2k+1。
‡若存在整数 k 使 i=2k，则整数 i 为偶数。

只有奇数的牌才会得分
---
结论：删除一个偶数位 i，那么它后续的所有非负数，都可以在不牺牲其他负数牌的情况下，全部拿到手。
证明：对于 a[k]>=0 且 k>i 的元素，如果 k 是奇数位，那么显然，它可以直接被吸收； 如果 k 是偶数位，那么，我们删除位 i 之后，它就变成了奇数位，可以被吸收。
类似的，我们可以得到以下结论。
删除一个奇数位 i，那么它后续的所有非负数，都可以在不牺牲其他负数牌的情况下，全部拿到手。
维护下后缀和即可。
我们枚举所有删除的元素的情况。算出最优值即可。
注意，对于前面 i-1 个元素，奇数位中为非负数可以直接白嫖，维护下前缀和即可。
======

input
4
4
-4 1 -3 5
4
1 -2 3 -4
3
-1 3 -5
1
-1
output
5
4
2
0
 */
