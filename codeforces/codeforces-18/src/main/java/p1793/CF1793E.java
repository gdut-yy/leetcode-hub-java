package p1793;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1793E {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int[] f = new int[n + 1];
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = a[i - 1];
            if (i >= v) {
                f[i] = f[i - v] + 1;
                ans[f[i] + n - i] = i;
            } else {
                ans[1 + n - v] = i;
            }
            f[i] = Math.max(f[i], f[i - 1]);
        }
        for (int i = n - 1; i > 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            out.println(ans[x]);
        }
    }
}
/*
E. Velepin and Marketing
https://codeforces.com/contest/1793/problem/E

灵茶の试炼 2026-03-20
题目大意：
输入 n(2≤n≤3e5) 和长为 n 的数组 a(1≤a[i]≤n)。
然后输入 q(1≤n≤3e5) 和 q 个询问，每个询问输入 k(2≤k≤n)。
有 n 位读者。对于第 i 位读者，如果至少有 a[i] 个人（包括他自己）都看同一种书，他会开心。
对于每个询问，独立回答如下问题：
现有 k 种不同的书。如何分配读者，使得每种书都至少有一位读者，且开心人数尽量多？输出最大开心人数。

rating 2600
反向思考：枚举开心人数 x=1,2,3,...,n，对应的 k 最大是多少？
核心思路：比如 x=10，我们需要求出这 10 个人至多分成多少组，每一组内的人都看同一种书。比如分成 3 组，那么 3 加上剩余的 n-10 个人（这些人每人读不同的书），得到 k = 3 + n - 10。
这 x 个人，a[i] 越大越好，还是越小越好？
越小越好。a[i] 越小，越容易满足。
所以把 a 从小到大排序后，需要让前 x 个人开心。
这 x 个人，最多可以划分成多少组？每一组内的人都看同一种书，且都开心。
为了让分组数尽量多，把要求相近（a[i] 相近）的人聚在一起是更优的，所以排序后，连续划分是最优的。
考虑 DP：
定义 f[i] 表示把（前 i 个人中的）至多 i 个人分组，可以得到的最大组数。每一组内的人都看同一种书，且都开心。
注：定义成「至多」是为了防止出现 a[i] 比较大，无法分到任何一组的情况。如果定义成恰好，那么此时 f[i] = 0，计算转移不方便。
对于 a[i]（下标从 1 开始）：
- 如果不包含 a[i]，那么问题变成把至多 i-1 个人分组，可以得到的最大组数，即 f[i-1]。
- 如果包含 a[i]，那么必须有 a[i] 个人和他一组，问题变成把至多 i-a[i] 个人分组，可以得到的最大组数，即 f[i-a[i]]，再加上包含 a[i] 的这一组。注：前提是 a[i] <= i。
两种情况取最大值，得 f[i] = max(f[i-1], f[i-a[i]] + 1)。
枚举开心人数 i=1,2,3,...,n，对应的 k 最大是多少？
定义 ans[k] 表示有 k 种书时，最大开心人数。
如果 a[i] <= i，我们要让这 i 个人都开心：
- 先满足 a[i]，即 a[i] 个人分成一组。
- 剩余 i-a[i] 个人（不一定全选），可以得到 f[i-a[i]] 组。
- 另一些没有选的人呢？由于这些人的 a[j] <= a[i]，所以放入 a[i] 这一组中，一定都开心。
- 一共 f[i-a[i]] + 1 组，每组一种书。
- 剩余 n-i 个人，每人看一种不同的书。
- 一共 book = f[i-a[i]] + 1 + n-i 种书。更新 ans[book] = i。
注：由于 i 是从小到大枚举的，这里更新 ans 无需用 max，直接覆盖即可。
如果 a[i] > i，我们要让这 i 个人都开心：
- 从后面再补充一些人进来，一共 a[i] 个人，读同一种书（只有一个组），其中一定有 i 个人开心。
- 剩余 n-a[i] 个人，每人看一种不同的书。
- 一共 book = 1 + n-a[i] 种书。更新 ans[book] = i。
但这样做，可能某些 ans[k] 没有被赋值。
比如 ans[10] = 5，ans[8] = 6，ans[9] 没被赋值。
对于 k+1 种书，我们合并其中的两种书（剩下 k 种书），把两组合并为一组，更容易满足要求，开心的人数不会变少。
所以 ans[k] 至少是 ans[k+1]。
所以最后再求一遍 ans 的后缀最大值，即可得到最终的 ans。直接 O(1) 查表回答询问。
代码 https://codeforces.com/problemset/submission/1793/367317143
代码备份（上面打不开的同学看这个）
======

Input
5
1 2 2 2 2
3
2
3
4
Output
5
5
3

Input
6
1 2 3 4 5 6
2
2
3
Output
5
4

Input
6
4 4 1 4 4 4
3
2
3
4
Output
6
5
1
 */
