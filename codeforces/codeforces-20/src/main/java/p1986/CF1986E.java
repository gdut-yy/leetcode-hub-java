package p1986;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1986E {
    static int n, k;
    static Map<Integer, List<Integer>> g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            g = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt();
                g.computeIfAbsent(v % k, e -> new ArrayList<>()).add(v / k);
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long ans = 0;
        boolean odd = false;
        for (List<Integer> a : g.values()) {
            a.sort(null);
            int m = a.size();
            long s = 0;
            for (int i = m - 2; i >= 0; i -= 2) {
                s += a.get(i + 1) - a.get(i);
            }
            if (m % 2 == 0) {
                ans += s;
                continue;
            }

            if (odd) {
                ans = -1;
                break;
            }
            odd = true;

            long minS = s;
            for (int i = 1; i < m; i += 2) {
                s += a.get(i) - a.get(i - 1) - (a.get(i + 1) - a.get(i));
                minS = Math.min(minS, s);
            }
            ans += minS;
        }
        return String.valueOf(ans);
    }
}
/*
E. Beautiful Array
https://codeforces.com/contest/1986/problem/E

灵茶の试炼 2024-10-23
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤1e5) k(1≤k≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你可以重排 a。
然后执行如下操作若干次：
选择一个下标 i，把 a[i] 增加 k。
输出使 a 变成回文数组的最小操作次数。
如果无法做到，输出 -1。

rating 1700
想一想，k=1 要怎么做？
如果 n 是偶数，把 a 从小到大排序，相邻元素两两一组，差值之和即为答案。用交换法可以证明这是最优的。
如果 n 是奇数，考虑前后缀分解，枚举作为回文中心的元素（这个数不用变）。
对于一般情况，把元素按照模 k 的结果分组。每组按照上述方法计算。
代码 https://codeforces.com/problemset/submission/1986/287338053
备份代码（洛谷）
======

Input
11
1 1000000000
1
2 1
624323799 708290323
3 1
3 2 1
4 1
7 1 5 3
5 1
11 2 15 7 10
7 1
1 8 2 16 8 16 31
13 1
2 1 1 3 3 11 12 22 45 777 777 1500 74
10 2
1 2 1 2 1 2 1 2 1 2
11 2
1 2 1 2 1 2 1 2 1 2 1
13 3
2 3 9 14 17 10 22 20 18 30 1 4 28
5 1
2 3 5 3 5
Output
0
83966524
1
4
6
1
48
-1
0
14
0
 */
