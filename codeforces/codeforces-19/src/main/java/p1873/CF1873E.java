package p1873;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1873E {
    static int n, x;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            x = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static long[] preSum;

    private static String solve() {
        Arrays.sort(a);

        // 前缀和
        preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + a[i];
        }

        int left = 1;
        int right = (int) (2e9 + 5);
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left - 1);
    }

    private static boolean checkMid(int mid) {
        int j = searchInts(a, mid);
        return x >= (long) mid * j - preSum[j];
    }

    private static int searchInts(int[] a, int key) {
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
E. Building an Aquarium
https://codeforces.com/contest/1873/problem/E

题目大意：
你喜欢鱼，所以你决定建一个水族馆。你有一块由 n 根柱子组成的珊瑚，第 i 根柱子有 ai 单位高。之后，你将在珊瑚周围建造一个水箱，如下所示:
- 选取一个整数 h≥1 -水箱高度。在水箱的两侧筑高为 h 的墙。
- 然后，将水箱装满水，使每根柱子的高度为 h，除非珊瑚高于 h;那么不应该向这个柱中添加水。
例如，如果 a=[3,1,2,4,6,2,5]，高度 h=4，那么最终将使用总共 w=8 单位的水，如下所示。
你最多可以使用 x 单位的水来填满水箱，但你要建造尽可能大的水箱。h 的最大值是多少?

二分答案。注意上界不止 1e9
======

input
5
7 9
3 1 2 4 6 2 5
3 10
1 1 1
4 1
1 4 3 4
6 1984
2 6 5 9 1 8
1 1000000000
1
output
4
4
2
335
1000000001

1
1 1000000000
1000000000
 */
