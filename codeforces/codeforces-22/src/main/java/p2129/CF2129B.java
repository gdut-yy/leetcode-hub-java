package p2129;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2129B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    // 方法一
    private static void solve() {
        int n = scanner.nextInt();
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            pos[v] = i;
        }

        int[] a = new int[n];
        for (int v = 1; v <= n; v++) {
            int i = pos[v];
            int inv1 = 0, inv2 = 0;

            // 检查左边的元素
            for (int j = 0; j < i; j++) {
                int w = a[j];
                if (w == 0 || w > v) {
                    inv1++;
                }
                if (w > n * 2 - v) {
                    inv2++;
                }
            }

            // 检查右边的元素
            for (int j = i + 1; j < n; j++) {
                int w = a[j];
                if (w > 0 && w < v) {
                    inv1++;
                }
                if (w < n * 2 - v) {
                    inv2++;
                }
            }

            if (inv1 < inv2) {
                a[i] = v;
            } else {
                a[i] = n * 2 - v;
            }
        }

        // 计算逆序对数量
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    ans++;
                }
            }
        }
        out.println(ans);
    }

    // 方法二
    private static void solve1() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    l++;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[i]) {
                    r++;
                }
            }
            ans += Math.min(l, r);
        }
        out.println(ans);
    }
}
/*
B. Stay or Mirror
https://codeforces.com/contest/2129/problem/B

灵茶の试炼 2025-08-13
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤5e3。
每组数据输入 n(2≤n≤5e3) 和 1~n 的排列 p。
对于每个 p[i]，可以保持不变，也可以改成 2n-p[i]。
目标是让 p 的逆序对个数最小。
输出最小逆序对个数。

rating 1600
从特殊情况入手。想一想，等于 1 的那个数，是保持不变，还是变成 2n-1？对于逆序对的贡献分别是多少？
继续，等于 2 的那个数，是保持不变，还是变成 2n-2？对于逆序对的贡献分别是多少？
方法一
我们可以维护一个数组 a，一开始均为 0，表示未填入数字。
按照元素值从小到大考虑。v=1,2,3,...,n。
对于元素 v，遍历 a，可以算出不变时的与 a 相关的逆序对个数：对于没填入的位置的元素，无论变还是不变，一定比 v 大！
对于 2n-v 来说，没填入的位置的元素，无论变还是不变，一定比 2n-v 小！
这样便能算出 v 是变还是不变。
最后遍历 a 算出逆序对个数。
方法二
对于 1 来说，逆序对的贡献为 min(1 不变，1 变成 2n-1) = min(1 左边的数的个数，1 右边的数的个数)。注意左右两边的数都是大于 1 的。
去掉 1，问题变成规模为 n-1 的子问题。对于 2 来说，逆序对的贡献为 min(2 左边的大于 2 的数的个数，2 右边的大于 2 的数的个数)。
依此类推。对于每个 p[i]，计算 min(p[i] 左边的大于 p[i] 的数的个数，p[i] 右边的大于 p[i] 的数的个数)。
每个 p[i] 的计算公式是互相独立的，我们可以按照任意顺序计算（而不是从小到大），所以可以直接从左到右遍历 p 计算。
注：用值域树状数组可以加速，从而做到 O(nlogn)。
方法一 https://codeforces.com/contest/2129/submission/333074244
方法二 https://codeforces.com/contest/2129/submission/333725017
方法一备份
方法二备份
======

Input
5
2
2 1
3
2 1 3
4
4 3 2 1
5
2 3 1 5 4
6
2 3 4 1 5 6
Output
0
1
0
2
2
 */
