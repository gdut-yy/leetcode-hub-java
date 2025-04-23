package c215;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Abc215_f {
    static int n;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        int left = 0;
        int right = a[n - 1][0] - a[0][0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    static boolean checkMid(int low) {
        low++;
        int mn = (int) 1e9, mx = 0;
        int l = 0;
        for (int[] p : a) {
            while (a[l][0] <= p[0] - low) {
                mn = Math.min(mn, a[l][1]);
                mx = Math.max(mx, a[l][1]);
                l++;
            }
            if (p[1] - mn >= low || mx - p[1] >= low) {
                return false;
            }
        }
        return true;
    }
}
/*
F - Dist Max 2
https://atcoder.jp/contests/abc215/tasks/abc215_f

灵茶の试炼 2025-02-13
题目大意：
输入 n(2≤n≤2e5) 和 n 个二维坐标点，范围 [0,1e9]。保证所有点互不相同。
定义两点 (xi,yi) 和 (xj,yj) 的距离为 min(|xi-xj|,|yi-yj|)。
输出两点之间的最大距离。

最大化最小值，二分答案。
先按照横坐标排序。
二分答案 mid。
枚举右边的 x，维护左边横坐标 <= x - mid 的点，我们只需要知道其中的最小 y 和最大 y。这可以写一个双指针。
判断是否满足右边的 y 和左边的最小 y（或者最大 y）的差 >= mid。
代码 https://atcoder.jp/contests/abc215/submissions/62429359
======

Input 1
3
0 3
3 1
4 10
Output 1
4

Input 2
4
0 1
0 4
0 10
0 6
Output 2
0

Input 3
8
897 729
802 969
765 184
992 887
1 104
521 641
220 909
380 378
Output 3
801
 */
