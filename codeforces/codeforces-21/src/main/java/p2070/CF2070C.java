package p2070;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.Function;

public class CF2070C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        char[] s = scanner.next().toCharArray();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int ans = sortSearch((int) 1e9, (mx -> {
            int left = k;
            boolean re = true;
            for (int i = 0; i < n; i++) {
                int v = a[i];
                if (v <= mx) {
                    continue;
                }
                if (s[i] == 'R') {
                    re = true;
                } else if (re) {
                    re = false;
                    left--;
                }
            }
            return left >= 0;
        }));
        out.println(ans);
    }

    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
C. Limited Repainting
https://codeforces.com/contest/2070/problem/C

灵茶の试炼 2025-09-16
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(1≤n≤3e5) k(0≤k≤n)，长为 n 的只包含 R 和 B 的字符串 s，长为 n 的数组 a(1≤a[i]≤1e9)。
有一条长为 n 的纸带，包含 n 个单元格。最初，所有单元格都是红色。
每次操作，选择一段连续的单元格，涂成蓝色。
至多操作 k 次。
对于第 i 个单元格，其惩罚值定义如下：
如果第 i 个单元格的最终颜色不等于 s[i]（R 表示红色，B 表示蓝色），那么其惩罚值为 a[i]，否则惩罚值为 0。
最小化最大的惩罚值。

rating 1500
最小化最大值，考虑二分答案。
设上界为 mx。
只看大于 mx 的元素。
如果是 R，那么视作分割线。
如果是 B，一定要涂色。
在两个 R 之间的 B 只需要涂色一次。
统计涂色次数，与 k 比大小。
代码 https://codeforces.com/contest/2070/submission/336695797
代码备份（上面打不开的同学看这个）
======

Input
5
4 1
BRBR
9 3 5 4
4 1
BRBR
9 5 3 4
4 2
BRBR
9 3 5 4
10 2
BRBRBBRRBR
5 1 2 4 5 3 6 1 5 4
5 5
RRRRR
5 3 1 2 4
Output
3
3
0
4
0
 */
