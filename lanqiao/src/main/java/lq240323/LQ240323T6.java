package lq240323;

import java.util.Scanner;

public class LQ240323T6 {
    static int n, x;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            x = scanner.nextInt();
            a = new int[n + 5];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] f = new int[n + 5];
        int[] g = new int[n + 5];
        f[1] = a[1];
        g[1] = a[1];
        for (int i = 2; i <= n + 1; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2]) + a[i];
            g[i] = Math.min(g[i - 1], g[i - 2]) + a[i];
        }
        boolean ans = g[n + 1] <= x && x <= f[n + 1];
        return ans ? "Yes" : "No";
    }
}
/*
小蓝的跳跃【算法赛】

中值法求解
我们可以发现，无论哪种走法能够到达终点，我们都可以通过选择一些格子来改变路径的值，例如，对于序列
1 1 -1 1 1，假设我们选择的最大路径是 4，我们可以在路径中再逸择一个-1，从而达到结果为 3 的目的，关键在
于我们如何选择数值才能得到目标值。
事实上，我们只需要求出走出所有格子的最大值和最小值，目标值 x 一定在它们之间。接下来我们分析，为什么
目标值 x 在最大值和最小值之间，我们便一定能够找到一个合适的选择路径。
1、如果目标值 x 比最大值小，那么意味着我们多选了 1，或者少选了-1，少选-1 的情况很简单，如果最大值
路径周围还有未选择的-1，那么我们就可以一起选择。换句话说，如果 x 比最小值大，那么说明我们多选了
-1 或者少选了 1，同样地，我们可以把最小值路径周围的 1 也一起选择。
2、对于最大值路径，如果选择了最后一个数，那么意味着最后一个数为 1，我们可以舍弃它；如果没有选择最后
一个数，那么说明最后一个数为-1，我们就可以选择它。对上述特殊情况推导为一般情况，在最大值路径
中，序列中的所有 1 都必须存在，而只有 1 和-1 交替排列的情况下我们才不能随意舍弃。但这也说明了我们
可以通过选择-1 来减小路径的值，如果相邻位置是 1，我们可以将其舍弃，因为我们不可能使路径的值小于
最小值。
具体解题步骤
1、使用动态规划（dp）求解整个序列的最大值和最小值，需要计算到第 n+1 项，因为跳出序列的情况也要考
虑，例如序列 1 1 1，其最小值为 1.
2、比较目标值是否在最大值和最小值之间即可。
 */