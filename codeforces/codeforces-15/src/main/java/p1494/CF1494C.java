package p1494;

import java.util.Arrays;
import java.util.Scanner;

public class CF1494C {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int x = searchInts(a, 0);
        int y = searchInts(b, 0);
        int ans = f(Arrays.copyOfRange(a, x, a.length), Arrays.copyOfRange(b, y, b.length));

        // 负数变正数且递增，方便复用 f
        for (int i = 0; i < (x + 1) / 2; i++) {
            int new_ai = -a[x - 1 - i];
            int new_x1i = -a[i];

            a[i] = new_ai;
            a[x - 1 - i] = new_x1i;
        }
        for (int i = 0; i < (y + 1) / 2; i++) {
            int new_bi = -b[y - 1 - i];
            int new_y1i = -b[i];

            b[i] = new_bi;
            b[y - 1 - i] = new_y1i;
        }
        ans += f(Arrays.copyOfRange(a, 0, x), Arrays.copyOfRange(b, 0, y));
        return String.valueOf(ans);
    }

    static int f(int[] a, int[] b) {
        int same = 0, i = 0, n = a.length;
        for (int v : b) {
            while (i < n && a[i] < v) {
                i++;
            }
            if (i < n && a[i] == v) {
                same++;
                i++;
            }
        }

        int res = same;
        i = 0;
        int left = 0;
        for (int right = 0; right < b.length; right++) {
            int v = b[right];
            while (i < n && a[i] < v) {
                i++;
            }
            if (i < n && a[i] == v) {
                same--;
                i++;
            }

            // b[left] 到 b[right] 的特殊位置无法被 i 个连续箱子覆盖
            while (left <= right && v - b[left] + 1 > i) {
                left++;
            }
            res = Math.max(res, right - left + 1 + same);
        }
        return res;
    }

    static int searchInts(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
C. 1D Sokoban
https://codeforces.com/contest/1494/problem/C

灵茶の试炼 2022-09-13
题目大意：
输入 t (≤1000) 表示 t 组数据，每组数据输入 n (≤2e5) m (≤2e5)，长为 n 的严格递增数组 a (-1e9≤a[i]≤1e9) 和长为 m 的严格递增数组 b (-1e9≤b[i]≤1e9)。a 和 b 中均不包含 0。所有数据的 n 之和、m 之和均不超过 2e5。
你在玩一个一维推箱子的游戏，你的初始位置为 0，箱子的位置由数组 a 表示，特殊位置由数组 b 表示。
你可以同时推动多个相邻的箱子。
你不能穿过箱子。
你不能拉箱子。
对于每组数据，输出最多可以让多少个箱子在特殊位置上。
注意可能有的箱子一开始就在特殊位置上。
你能做到线性时间复杂度，且除去输入的空间为常数吗？

rating 1900
三指针做法：https://codeforces.com/contest/1494/submission/171998732
二分做法：https://codeforces.com/contest/1494/submission/109374034
提示 1：正负分开考虑。
提示 2：以正数为例，枚举每个特殊位置，把连续箱子中最右的那个箱子推到这个位置上，能有多少个箱子在特殊位置上？
======

input
5
5 6
-1 1 5 11 15
-4 -3 -2 6 7 15
2 2
-1 1
-1000000000 1000000000
2 2
-1000000000 1000000000
-1 1
3 5
-1 1 2
-2 -1 1 2 5
2 1
1 2
10
output
4
2
0
3
1
 */
