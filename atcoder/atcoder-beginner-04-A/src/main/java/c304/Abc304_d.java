package c304;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc304_d {
    static int w, h, n, A, B;
    static int[][] pq;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        w = scanner.nextInt();
        h = scanner.nextInt();
        n = scanner.nextInt();
        pq = new int[n][2];
        for (int i = 0; i < n; i++) {
            pq[i][0] = scanner.nextInt();
            pq[i][1] = scanner.nextInt();
        }
        A = scanner.nextInt();
        a = new int[A];
        for (int i = 0; i < A; i++) {
            a[i] = scanner.nextInt();
        }
        B = scanner.nextInt();
        b = new int[B];
        for (int i = 0; i < B; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<String, Integer> cntMap = new HashMap<>();
        for (int[] p : pq) {
            int x = binarySearch(a, p[0]);
            int y = binarySearch(b, p[1]);
            String key = x + ":" + y;
            cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        }

        int min = 0, max = 0;
        // 如果写成 cntMap.size() < (A + 1) * (B + 1) 会爆 int...
        if (cntMap.size() == (A + 1L) * (B + 1)) {
            min = cntMap.values().stream().mapToInt(Integer::intValue).min().orElseThrow();
        }
        max = cntMap.values().stream().mapToInt(Integer::intValue).max().orElseThrow();
        return min + " " + max;
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
D - A Piece of Cake
https://atcoder.jp/contests/abc304/tasks/abc304_d

题目大意：
在 x 平面上有一个长方形的蛋糕和一些草莓。饼的矩形面积为{(x,y):0≤x≤W,0≤y≤H}。
蛋糕上有 N 个草莓，当 i=1,2,...,N 时，第 i 个草莓的坐标是(pi, qi)。没有两个草莓有相同的坐标。
高桥将用刀将蛋糕切成几块，如下所示。
- 首先，沿着平行于 y 轴的不同线切蛋糕:线 x=a1, x=a2,..,x=aA。
- 接下来，沿着平行于 x 轴的 B 条不同的线切开蛋糕:线 y=b1, y=b2,...,y=bB。
因此，蛋糕将被分成(A+1)(B+1)个矩形块。高桥将只选择其中的一块来吃。在选定的片上打印出草莓的最小和最大可能数量。
在这里，可以保证最后一块的边缘没有草莓。有关更正式的描述，请参阅下面的约束。

二分 + 哈希表统计。
注意爆 int ！
======

Input 1
7 6
5
6 1
3 1
4 2
1 5
6 2
2
2 5
2
3 4
Output 1
0 2

Input 2
4 4
4
1 1
3 1
3 3
1 3
1
2
1
2
Output 2
1 1
 */