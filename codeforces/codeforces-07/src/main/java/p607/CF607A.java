package p607;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF607A {
    static int n;
    static int[][] pk;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        pk = new int[n][2];
        for (int i = 0; i < n; i++) {
            pk[i][0] = scanner.nextInt();
            pk[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(pk, Comparator.comparingInt(o -> o[0]));

        int ans = 0;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = pk.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (checkMid(pk[i], mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            int j = left;
            f[i] = j - 1 >= 0 ? f[j - 1] + 1 : 1;
            ans = Math.max(ans, f[i]);
        }
        return String.valueOf(n - ans);
    }

    static boolean checkMid(int[] p, int j) {
        return pk[j][0] >= p[0] - p[1];
    }
}
/*
A. Chain Reaction
https://codeforces.com/contest/607/problem/A

灵茶の试炼 2024-01-17
题目大意：
输入 n(1≤n≤1e5)，表示有 n 座激光塔。
然后输入 n 行，每行两个数 p[i](0≤p[i]≤1e6) 和 k[i](1≤k[i]≤1e6)，表示第 i 座激光塔的位置和威力。保证所有激光塔的位置互不相同。
游戏规则：
按照 pos[i] 从大到小依次激活激光塔，当一座激光塔被激活时，它会摧毁它左侧所有满足 p[i]-p[j] <= k[i] 的激光塔 j。
被摧毁的激光塔无法被激活。
在游戏开始前，你可以在最右边的激光塔的右侧，再添加一座激光塔，位置和威力由你决定。
你希望被摧毁的激光塔的数量尽量少。
输出这个最小值。

rating 1600
先按照 p[i] 排序。
问题相当于，我们可以自由决定从哪座激光塔开始游戏。枚举第一座被激活的激光塔。
假设从第 i 座激光塔开始游戏。
它能摧毁哪些激光塔，可以用二分查找快速地计算出来。
设 j 是最左边的被摧毁的激光塔。
那么问题变成：从第 j-1 座激光塔开始游戏，最少可以摧毁多少座激光塔。
这是一个和原问题相似的子问题，这意味着我们可以用 DP 解决。
用记忆化搜索或者递推实现都可以。
为了计算方便，也可以改为计算最多保留多少座激光塔。最后输出 n-最多保留。
https://codeforces.com/contest/607/submission/241948037
======

input
4
1 9
3 1
6 1
7 4
output
1

input
7
1 1
2 1
3 1
4 1
5 1
6 1
7 1
output
3
 */
