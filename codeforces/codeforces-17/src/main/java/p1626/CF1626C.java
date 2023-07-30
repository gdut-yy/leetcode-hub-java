package p1626;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1626C {
    static int n;
    static int[] h, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = scanner.nextInt();
            }
            k = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    // https://codeforces.com/contest/1626/submission/211306494
    private static String solve() {
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = h[i] - k[i] + 1;
            a[i][1] = h[i];
        }

        long ans = 0;
        int r0 = a[n - 1][1], minL = a[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            int l = a[i][0], r = a[i][1];
            if (r < minL) {
                long sz = r0 - minL + 1;
                ans += (sz + 1) * sz / 2;
                r0 = r;
            }
            minL = Math.min(minL, l);
        }
        long sz = r0 - minL + 1;
        ans += (sz + 1) * sz / 2;
        return String.valueOf(ans);
    }
}
/*
C. Monsters And Spells
https://codeforces.com/contest/1626/problem/C

灵茶の试炼 2023-06-28
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e4。
每组数据输入 n(1≤n≤100) 和长为 n 的严格递增数组 k，长为 n 的数组 h (1≤h[i]≤k[i]≤1e9)。
你在玩一个打怪游戏。有 n 只怪物，第 i 只会在第 k[i] 秒出现，血量为 h[i]。
你有一个引导类法术，你引导的时间越长，伤害越高，消耗的魔法值也越高。
具体来说，开始引导的第 1 秒，伤害为 1，消耗 1；第 2 秒，伤害为 2，消耗 2；第 i 秒，伤害为 i，消耗 i。
例如，伤害达到 3，要消耗 1+2+3=6 的魔法值。
你可以随时停止引导（停止后伤害为 0），或者重新引导（从 1 开始）。
游戏从第 1 秒开始。在第 k[i] 秒，法术伤害至少要是 h[i]。
要击败所有怪物，消耗的魔法值之和至少是多少？

把每个怪物需要的法术时间范围算出来，即 [k[i]-h[i]+1, k[i]]
那么问题和 56. 合并区间 是一样的，对于互相重叠的区间，法术必须一直持续。不重叠的区间就没必要持续了。
倒序合并区间可以做到 O(n)。
正序 O(nlogn) https://codeforces.com/contest/1626/submission/211306027
倒序 O(n) https://codeforces.com/contest/1626/submission/211306494
======

input
3
1
6
4
2
4 5
2 2
3
5 7 9
2 1 2
output
10
6
7
 */
