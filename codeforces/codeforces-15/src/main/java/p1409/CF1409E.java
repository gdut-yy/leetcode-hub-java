package p1409;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1409E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                y[i] = scanner.nextInt();
            }
            System.out.println(solve(n, k, x, y));
        }
    }

    private static String solve(int n, int k, int[] x, int[] y) {
        Arrays.sort(x);
        int[] pre = new int[n + 1];
        int ans = 0, left = 0;
        for (int right = 0; right < n; right++) {
            while (x[right] - x[left] > k) {
                left++;
            }
            ans = Math.max(ans, right - left + 1 + pre[left]);
            pre[right + 1] = Math.max(pre[right], right - left + 1);
        }
        return String.valueOf(ans);
    }
}
/*
E. Two Platforms
https://codeforces.com/contest/1409/problem/E

灵茶の试炼 2023-01-17
题目大意：
输入 t(≤2e4) 表示 t 组数据，每组数据输入 n(≤2e5) k(≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9) 和数组 b。所有数据的 n 之和不超过 2e5。
把 a[i] 标记到数轴上，问两条长为 k 的线段，最多可以覆盖多少 a[i]（线段端点可以覆盖 a[i]）。
注意：数组 b 是没用的，但是你要读入它。
扩展：有 m 条线段：2209. 用地毯覆盖后的最少白色砖块
https://leetcode.cn/problems/minimum-white-tiles-after-covering-with-carpets/

rating 1800
https://codeforces.com/contest/1409/submission/189420578
先排序。
如果只有一个线段，那就是双指针问题。
两个线段的话，第二个线段用双指针，顺带加上 left 之前的最大覆盖数，则需要额外维护一个覆盖数的前缀最大值。
具体来说，pre[i] 记录以 i-1 结尾的单个线段的最大覆盖数，那么有
ans = max(ans, right-left+1+pre[left])
pre[right+1] = max(pre[right], right-left+1)
这里 left 和 right 是双指针里面的变量。
相似题目: 2555. 两个线段获得的最多奖品
https://leetcode.cn/problems/maximize-win-from-two-segments/
C. George and Job
https://codeforces.com/contest/467/problem/C
======

input
4
7 1
1 5 2 3 1 5 4
1 3 6 7 2 5 4
1 1
1000000000
1000000000
5 10
10 7 5 15 8
20 199 192 219 1904
10 10
15 19 8 17 20 10 9 2 10 19
12 13 6 17 1 14 7 9 19 3
output
6
1
5
10
 */

