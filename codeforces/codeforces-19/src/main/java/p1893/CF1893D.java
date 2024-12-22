package p1893;

import java.util.Arrays;
import java.util.Scanner;

public class CF1893D {
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
        reverseSort(b);

        StringBuilder output = new StringBuilder();
        int j = 0;
        for (int v : a) {
            for (; j < m && b[j] >= v; j++) {
                output.append(b[j]).append(" ");
            }
            output.append(v).append(" ");
        }
        for (int i = j; i < m; i++) {
            output.append(b[i]).append(" ");
        }
        return output.toString();
    }

    static void reverseSort(int[] a) {
        Arrays.sort(a);
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
    }
}
/*
B. Neutral Tonality
https://codeforces.com/contest/1893/problem/B

灵茶の试炼 2024-07-17
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) m(1≤m≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，长为 m 的数组 b(1≤b[i]≤1e9)。
把 b 中所有元素以任意顺序在任意位置插入 a 中，得到数组 c。
例如 a=[3,1,1]，b=[9,4,5]，插入后可以是 c=[3,1,4,1,5,9]。
你需要使 LIS(c) 最短。（LIS 是最长严格递增子序列）
输出任意符合要求的 c。

rating 1700
构造题。
从特殊到一般，如右图，思考如下情况：
a 单调递减。
a 单调递增。
min(a) = a[0]
min(a) ≠ a[0]
构造方法：
先把 b 从大到小排序。然后双指针遍历 a 和 b 合并成 c，在把 a[i] 加到 c 之前，必须把 >= a[i] 的 b[j] 都加到 c。
代码 https://codeforces.com/contest/1893/submission/270188456
======

Input
7
2 1
6 4
5
5 5
1 7 2 4 5
5 4 1 2 7
1 9
7
1 2 3 4 5 6 7 8 9
3 2
1 3 5
2 4
10 5
1 9 2 3 8 1 4 7 2 9
7 8 5 4 6
2 1
2 2
1
6 1
1 1 1 1 1 1
777
Output
6 5 4
1 1 7 7 2 2 4 4 5 5
9 8 7 7 6 5 4 3 2 1
1 3 5 2 4
1 9 2 3 8 8 1 4 4 7 7 2 9 6 5
2 2 1
777 1 1 1 1 1 1
 */
