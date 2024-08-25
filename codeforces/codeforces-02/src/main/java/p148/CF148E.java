package p148;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF148E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        // 长度不一的二维数组
        int[][] deque = new int[n][];
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            deque[i] = new int[k];
            for (int j = 0; j < k; j++) {
                deque[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(n, m, deque));
    }

    private static String solve(int n, int m, int[][] deques) {
        // 分组背包
        int[] f = new int[m + 1];

        for (int[] deque : deques) {
            int k = deque.length;

            // 前缀和
            int[] preSum = new int[k + 1];
            for (int i = 0; i < k; i++) {
                preSum[i + 1] = preSum[i] + deque[i];
            }

            // max[i] 表示选取 i 个物品的最大价值和
            int[] max = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                // 滑动窗口 [l,r] 段（减去这部分），其中 L=r-l+1 则有 r=L+l-1
                int L = k - i;
                for (int l = 0; l + L <= k; l++) {
                    max[i] = Math.max(max[i], preSum[k] - (preSum[l + L] - preSum[l]));
                }
            }

            for (int i = m; i >= 0; i--) {
                for (int j = 1; j <= k && i - j >= 0; j++) {
                    f[i] = Math.max(f[i], f[i - j] + max[j]);
                }
            }
        }
        return String.valueOf(f[m]);
    }
}
/*
E. Porcelain
https://codeforces.com/contest/148/problem/E

灵茶の试炼 2023-03-07
题目大意：
输入 n(≤100) m(≤1e4) 和 n 个双端队列（dq），对于每个 dq，先输入 k(≤100) 表示 dq 的大小，然后输入 dq 中的 k 个数，范围在 [1,100]。所有 k 之和 ≥m。
你需要从这 n 个 dq 中取出 m 个数，输出这 m 个数的和的最大值。
提示：1e8 可过。

rating 1900
https://codeforces.com/problemset/submission/148/196263614
看成分组背包。
每个 dq 就是一个组，需要计算在这个 dq 中选 x 个数的最大数字和。
这可以用前缀和 + 枚举预处理。
相似题目: 1423. 可获得的最大点数
https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/
2218. 从栈中取出 K 个硬币的最大面值和
https://leetcode.cn/problems/maximum-value-of-k-coins-from-piles/
======

input
2 3
3 3 7 2
3 4 1 5
output
15

input
1 3
4 4 3 1 2
output
9
 */
