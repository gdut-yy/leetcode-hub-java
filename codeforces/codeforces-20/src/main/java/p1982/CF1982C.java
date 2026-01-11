package p1982;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1982C {
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
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        int[] a = new int[n];
        int ans = 0, s = 0, left = 0;

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            s += a[i];
            while (s > r) {
                s -= a[left];
                left++;
            }

            if (s >= l) {
                ans++;
                s = 0;
                left = i + 1;
            }
        }
        out.println(ans);
    }
}
/*
C. Boring Day
https://codeforces.com/contest/1982/problem/C

灵茶の试炼 2025-11-17
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤1e5) L R(1≤L≤R≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
每次操作，删除 a 的一个非空前缀。
如果该次操作删除的元素之和在闭区间 [L,R] 中，那么得到一分，否则不得分。
操作直到 a 为空。
输出最大总得分。

rating 1200
如果有不想要的前缀，那么直接删掉就行。所以我们可以任取想要的子数组。
问题相当于计算 a 最多有多少个不相交的非空子数组，每个子数组的元素和都在 [L,R] 中。
由于 a 中都是非负数，可以考虑滑窗。
如果窗口元素和 > R，右移左端点。
如果右移后元素和 >= L，那么找到一个合法子数组，立刻分割。然后重置元素和 s = 0，左端点 left = i+1。
这里用到了一个贪心的结论：分割的位置越早越好，这样留给后面的数更多，后面算出来的答案也就更大。
注：如果 a 中有负数，可以用前缀和+有序集合解决。
代码 https://codeforces.com/contest/1982/submission/348703055
代码备份（上面打不开的同学看这个）
======

Input
8
5 3 10
2 1 11 3 7
10 1 5
17 8 12 11 7 11 21 13 10 8
3 4 5
3 4 2
8 12 25
10 7 5 13 8 9 12 7
2 3 3
5 2
9 7 9
2 10 5 1 3 7 6 2 3
1 8 10
9
5 5 6
1 4 2 6 4
Output
3
0
1
4
0
3
1
2
 */
