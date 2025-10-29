package p2065;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF2065G {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int mx = (int) (2e5 + 1);
    static ArrayList<Integer>[] pf = new ArrayList[mx];

    static {
        Arrays.setAll(pf, e -> new ArrayList<>());
        for (int i = 2; i < mx; i++) {
            if (pf[i].isEmpty()) {
                for (int j = i; j < mx; j += i) {
                    pf[j].add(i);
                }
            }
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        long ans = 0;
        int[] cnt = new int[n + 1];
        int[] cnt2 = new int[n + 1];
        int singleP = 0;
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            List<Integer> a = pf[v];
            if (a.size() > 2) {
                continue;
            }
            int p = a.getFirst();
            if (a.size() == 2) {
                int q = a.get(1);
                if (p * q == v) {
                    ans += cnt[v] + cnt[p] + cnt[q] + 1;
                    cnt2[p]++;
                    cnt2[q]++;
                }
            } else if (p * p == v) {
                ans += cnt[v] + cnt[p] + 1;
                cnt2[p]++;
            } else if (p == v) {
                ans += cnt2[p] + singleP - cnt[p];
                singleP++;
            }
            cnt[v]++;
        }
        out.println(ans);
    }
}
/*
G. Skibidus and Capping
https://codeforces.com/contest/2065/problem/G

灵茶の试炼 2025-07-23
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(2≤a[i]≤n)。
如果 x 能表示为两个质数的乘积（两个质数可以相等），那么称 x 为半质数。
输出有多少对 (i,j) 满足 i <= j 且 LCM(a[i], a[j]) 是半质数。

rating 1700
枚举右维护左 + 分类讨论。
枚举 a[j]，计算有多少个 a[i]。
分类讨论：
1. 如果 a[j] 有 >= 3 个质因子，continue。这里把 p^3 或者 p^2 * q 等也算多个质因子。
2. 如果 v=a[j] 是半质数，且等于 2 个不同质数 p 和 q 的乘积。那么左边的 a[i] 可以是 v，可以是 p，也可以是 q。用一个 cnt 数组统计左边的每个元素的出现次数，把答案增加 cnt[v] + cnt[p] + cnt[q] + 1，其中 +1 是因为本题允许 i=j。
3. 如果 v=a[j] 是半质数，且等于质数 p 的平方。同上，把答案增加 cnt[v] + cnt[p] + 1。
4. 如果 a[j] 是质数 p。有两种组合情况：
   a[i] 是半质数且 a[i] 是 p 的倍数。用一个数组 cnt2[p] 统计是 p 的倍数的半质数。把答案增加 cnt2[p]。
   a[i] 是不等于 p 的质数。用一个变量 singleP 统计左边的质数个数。把答案增加 singleP - cnt[p]。
代码 https://codeforces.com/contest/2065/submission/329912516
代码备份（Ubuntu Pastebin）
======

Input
3
4
2 2 3 4
6
2 2 3 4 5 6
9
2 2 4 5 7 8 9 3 5
Output
5
12
18
 */
