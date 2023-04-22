package p1661;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1661C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = scanner.nextInt();
            }
            System.out.println(solve(n, h));
        }
    }

    private static String solve(int n, int[] h) {
        int max = Arrays.stream(h).max().orElseThrow();
        return String.valueOf(Math.min(f(h, max), f(h, max + 1)));
    }

    private static long f(int[] h, int t) {
        long c1 = 0L, c2 = 0L;
        for (int hi : h) {
            hi = t - hi;
            c1 += hi % 2;
            c2 += hi / 2;
        }
        if (c1 > c2) {
            return c1 * 2 - 1;
        }
        if (c1 == c2) {
            return c1 * 2;
        }
        c2 = (c2 - c1) * 2;
        return c1 * 2 + (c2 / 3 * 2 + c2 % 3);
    }
}
/*
C. Water the Trees
https://codeforces.com/contest/1661/problem/C

灵茶の试炼 2023-01-24
题目大意：
输入 t(≤2e4) 表示 t 组数据，每组数据输入 n(≤3e5) 和长为 n 的数组 h(1≤h[i]≤1e9)，表示 n 棵树的高度。所有数据的 n 之和不超过 3e5。
在第 1,3,5,... 天，你可以把一棵树的高度+1，或者不做任何事。
在第 2,4,6,... 天，你可以把一棵树的高度+2，或者不做任何事。
要使所有树的高度一样，至少要多少天？

https://codeforces.com/contest/1661/submission/190218911
提示 1：最终高度只能是 max(h) 和 max(h)+1，更高的高度只会比这两个的天数多。
提示 2：为什么可以是 max(h)+1？因为两个 1 可以当成 2，而 2 无法当作 1。
例如 h=[1,1,1,1,1,1,2]，max(h) 需要 11 天，而 max(h)+1 需要 9 天。
提示 3：贪心，或者二分答案。二分答案的 check 是需要补奇数的树必须用个+1，其他的随意，所以先用 +1，然后看剩下的能否补到所有高度都一样。
贪心的做法是分类讨论，记 c1 表示需要补奇数高度的树的个数，c2 为每棵树需要补充的高度除以 2 下取整之和：
- 如果 c1>c2，那么需要 c1*2-1 天。
- 如果 c1=c2，那么需要 c2*2 天。
- 如果 c1<c2，例如 12_2_2_2 这种，可以把空出的前两个 1 补到最后一个 2 上，这样只需要 6 天。
总的来说需要研究 _2_2_2... 这种需要多少天，你可以手玩下推出这个长度在模 3=0/1/2 时有不同的结果。
设 d = (c2-c1)*2，那么前面的 1212... 需要 c1*2 天，后面的 _2_2_2... 需要 d/3*2+d%3 天。
======

input
3
3
1 2 4
5
4 4 3 5 5
7
2 5 4 8 3 7 4
output
4
3
16
 */
