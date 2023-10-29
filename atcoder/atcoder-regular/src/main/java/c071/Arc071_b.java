package c071;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc071_b {
    static int n, m;
    static int[] x, y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        y = new int[m];
        for (int i = 0; i < m; i++) {
            y[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long sx = 0, sy = 0;
        for (int i = 0; i < n; i++) {
            sx += (i * 2L - n + 1) * x[i];
        }
        for (int i = 0; i < m; i++) {
            sy += (i * 2L - m + 1) * y[i];
        }
        long ans = sx % MOD * (sy % MOD) % MOD;
        return String.valueOf(ans);
    }
}
/*
D - ###
https://atcoder.jp/contests/arc071/tasks/arc071_b

灵茶の试炼 2023-09-21
题目大意：
输入 n m(2≤n,m≤2e5)，长为 n 的严格递增数组 x(-1e9≤x[i]≤1e9)，长为 m 的严格递增数组 y(-1e9≤y[i]≤1e9)。
从 x 中选两个数，组成直线 X=x[i1], X=x[i2]，其中 i1<i2。
从 y 中选两个数，组成直线 Y=y[j1], Y=y[j2]，其中 j1<j2。
这四条直线包围的区域是一个矩形。
计算所有矩形的面积之和。模 1e9+7。

提示 1：手玩下 n=3, m=3 的情况（图形是一个田字）。把公式列出来。
矩形面积 = 长*宽，在 n=3, m=3 的情况下，可以有 3 种长，3 种宽。
所有矩形面积 = 长1*宽1 + 长1*宽2 + 长1*宽3 + 长2*宽1 + 长2*宽2 + 长2*宽3 + 长3*宽1 + 长3*宽2 + 长3*宽3
= (长1 + 长2 + 长3) * (宽1 + 宽2 + 宽3)
所以，长和宽可以分别计算。
对于 x，问题变成：所有 x[j]-x[i] 的和 (i<j)。
提示 2：贡献法，考虑 x[i] 在和式中的贡献是多少？
即：有多少个 +x[i]？有多少个 -x[i]？
解答：（i 从 0 开始）有 i 个 +x[i]，有 n-1-i 个 -x[i]。
所以 x[i] 在和式中的贡献为 2*i-n+1。
这样，我们就得到了一个 O(n+m) 的算法。
https://atcoder.jp/contests/abc058/submissions/45464458
======

Input 1
3 3
1 3 4
1 3 6
Output 1
60

Input 2
6 5
-790013317 -192321079 95834122 418379342 586260100 802780784
-253230108 193944314 363756450 712662868 735867677
Output 2
835067060
 */