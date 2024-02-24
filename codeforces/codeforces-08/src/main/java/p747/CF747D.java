package p747;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF747D {
    static int n, k;
    static int[] t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer> gap = new ArrayList<>();
        int cnt = (int) -1e9;
        int ans = 0;
        boolean pre = true;
        for (int v : t) {
            boolean s = v >= 0;
            if (s != pre) {
                ans++;
                if (s) {
                    cnt = 0;
                } else if (cnt > 0) {
                    gap.add(cnt);
                }
            }
            if (s) {
                cnt++;
            } else if (--k < 0) {
                return "-1";
            }
            pre = s;
        }

        gap.sort(null);
        for (Integer v : gap) {
            if (k < v) break;
            k -= v;
            ans -= 2;
        }
        if (0 < cnt && cnt <= k) {
            ans--;
        }
        return String.valueOf(ans);
    }
}
/*
D. Winter Is Coming
https://codeforces.com/contest/747/problem/D

灵茶の试炼 2022-05-20
题目大意：
给你 n(<=2e5) 个数表示每天的温度 t[i] (-20<=t[i]<=20)，到达目的地需要 n 天。
你有两个轮胎，雪地胎和普通胎。
雪地胎可以在任何温度行驶，但只能用 k(<=n) 天。（不一定要连续使用 k 天）
普通胎只能在温度不为负的时候行驶，使用天数无限制。
你一开始用的是普通胎。在每天开始可以选择更换为另一种轮胎。
问这 n 天需要最少换几次轮胎？若无法做到则输出 -1。

rating 1800
https://codeforces.com/contest/747/submission/157761183
贪心。
先把负数覆盖了，然后不断找中间最短非负数的连续段合并，每次合并可以减少两次更换次数。
注意末尾非负连续段，这里覆盖了可以再减少一次更换次数。
======

input
4 3
-5 20 -3 0
output
2

input
4 2
-5 20 -3 0
output
4

input
10 6
2 -5 1 3 0 0 -4 -3 1 0
output
3
 */
