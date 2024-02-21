package p1168;

import java.util.Scanner;

public class CF1168A {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int left = 0;
        int right = m;
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

    static boolean checkMid(int lim) {
        int pre = 0;
        for (int v : a) {
            // (pre-v+m)%m 表示把 v 改成 pre，需要的操作次数
            // 无法修改成 pre
            if ((pre - v + m) % m > lim) {
                // 无法保证单调非降
                if (v < pre) {
                    return false;
                }
                // 只能 v 不变了
                pre = v;
            }
        }
        return true;
    }
}
/*
A. Increasing by Modulo
https://codeforces.com/contest/1168/problem/A

灵茶の试炼 2022-09-02
题目大意：
输入 n (1≤n≤3e5)、m (1≤m≤3e5) 和一个长为 n 的数组 a，元素值在 [0,m-1] 内。
每次操作，你可以选择 a 中的某些数，把每个数 x 改成 (x+1)%m。
输出使 a 变成单调非降的最少操作次数。
反向思考：给定 n 和 m，如何构造出一个让最少操作次数最大的数组 a？

rating 1700
https://codeforces.com/problemset/submission/1168/170572944
提示 1：至多需要操作多少次？
m 次。所有数可以变成 0。
提示 2：二分答案。
提示 3：遍历 a，设 pre 为 a[i-1] 修改后的值（初始 pre=0），如果 a[i] 可以修改成 pre，那这样是最优的；如果 a[i] 无法修改成 pre，且 a[i] < pre，则无法满足单调非降，二分判定 false；否则保持 a[i] 不变是最优的。若中途没有 false 则二分判定 true。
具体实现和注释见代码。
思考：
你能找到一个比 m 更小的二分上界吗？
二分下界可以根据输入来优化吗？
======

input
5 3
0 0 0 1 2
output
0

input
5 7
0 6 1 3 2
output
1
 */