package didi;

import java.io.PrintWriter;
import java.util.Scanner;

public class DDBook24 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] v = new int[n];

        long total = 0;
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
            total += v[i];
        }

        // 保持原样，即选择全部点，对应 d = 1
        long ans = total;

        // d = n / K，K 是保留后的正多边形边数
        // K >= 3，所以 d <= n / 3，且 d 必须整除 n
        for (int d = 1; d <= n / 3; d++) {
            if (n % d != 0) continue;

            long[] sums = new long[d];
            for (int i = 0; i < n; i++) {
                sums[i % d] += v[i];
            }

            for (long s : sums) {
                ans = Math.max(ans, s);
            }
        }

        out.println(ans);
    }
}
/*
几何选择
https://leetcode.cn/leetbook/read/didiglobal2/e785dt/

有一个魔法阵的形状是由 n 个阵基组成的正 n 边形。
“真正强大的魔法都是返璞归真的!”一位大魔导师这样说。
魔法学院的同学们开始改进魔法阵，他们从书上了解到，所有魔法阵的形状都是正 K 边形，K 为大于等于三的正整数。一个魔法阵的威力等于构成魔法阵的阵基威力之和。
因此他们可以通过去掉一些阵基，改变魔法阵使得法阵的威力更大，但是因为他们只是学生，并不能移动阵基。如现在的魔法阵是正六边形
1 5 2 -3 3 -3 选择第 1，3，5 号阵基构成正三角形法阵的威力变为 6 是最好的，显然不能选择 1，2，5 号阵基，因为这并不是一个正 k 边形。
现在给出你原来阵基的威力大小，请你求出魔法阵的最大的威力，如果去掉一部分阵基并不能增强法阵威力，也可以保持原样。
格式：
输入：
- 输入第一行仅包含一个正整数 n，表示原有魔法阵阵基的数量。
- 输入第二行包含 n 个整数，第 i 个整数表示第 i 个阵基的威力 v[i] 。
输出：
- 输出仅包含一个整数，即魔法阵最大的威力。
示例：
输入：
     6
     1 5 2 -3 3 -3
输出：6
提示：
3 <= n <= 20000
-10000 <= v[i] <= 10000
 */
