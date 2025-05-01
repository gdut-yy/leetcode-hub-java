package p2033;

import java.util.Scanner;
import java.util.TreeSet;

public class CF2033D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        // HashSet Time limit exceeded on test 16
//        HashSet<Long> has = new HashSet<>();
        TreeSet<Long> has = new TreeSet<>();
        has.add(0L);
        long ps = 0;
        for (int v : a) {
            ps += v;
            if (has.contains(ps)) {
                ans++;
                has.clear();
            }
            has.add(ps);
        }
        return String.valueOf(ans);
    }
}
/*
D. Kousuke's Assignment
https://codeforces.com/contest/2033/problem/D

灵茶の试炼 2024-12-30
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(-1e5≤a[i]≤1e5)。
从 a 中选出若干非空连续子数组，要求任意两个子数组都不相交，且每个子数组的元素和都是 0。
输出你最多可以选多少个子数组。

rating 1300
计算 a 的前缀和数组 s，其中 s[0]=0，s[i+1]=s[i]+a[i]。
问题变成找到若干个子数组 [l,r)，这些子数组互不相交，且 s[l] = s[r]。
初始化前缀和集合 set={}。
从左往右，如果 s[i] 在 set 中，我们找到了一个子数组，把答案加一，然后把 set 清空。（如果现在不选这个子数组，后面可能就没机会了，或者说我们无法得到更优解。）
每次循环的末尾，把 s[i] 加到 set 中。
如果用一个变量计算前缀和 s，则初始化 set={0}。
推荐做做我的数据结构题单中的前缀和题目。
代码 https://codeforces.com/contest/2033/submission/298382026
代码备份（洛谷）
======

Input
3
5
2 1 -3 2 1
7
12 -4 4 43 -3 -5 8
6
0 -4 0 3 0 1
Output
1
2
3
 */
