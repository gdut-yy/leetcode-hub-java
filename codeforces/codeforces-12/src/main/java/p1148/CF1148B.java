package p1148;

import java.util.Scanner;

public class CF1148B {
    static int n, m, ta, tb, k;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ta = scanner.nextInt();
        tb = scanner.nextInt();
        k = scanner.nextInt();
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

    private static String solve() {
        if (k >= Math.min(n, m)) {
            return "-1";
        }

        int ans = 0, j = 0;
        for (int i = 0; i < k + 1; i++) {
            int t = a[i];
            while (j < m && b[j] < t + ta) {
                j++;
            }
            if (j + k - i >= m) {
                return "-1";
            }
            ans = Math.max(ans, j + k - i);
        }
        return String.valueOf(b[ans] + tb);
    }
}
/*
B. Born This Way
https://codeforces.com/contest/1148/problem/B

灵茶の试炼 2024-10-29
题目大意：
输入 n m(1≤n,m≤2e5) ta tb(1≤ta,tb≤1e9) k(1≤k≤n+m)，长为 n 的严格递增数组 a(1≤a[i]≤1e9) 和长为 m 的严格递增数组 b(1≤b[i]≤1e9)。
从 A 地飞往 B 地的航班有 n 个，第 i 个航班的起飞时刻为 a[i]，航行时间为 ta。
从 B 地飞往 C 地的航班有 m 个，第 i 个航班的起飞时刻为 b[i]，航行时间为 tb。
转机时间忽略不计。
你可以 ban 掉其中的 k 个航班。
最大化到达 C 的最早（最小）时刻。
如果可以让人无法到达 C，输出 -1。

rating 1600
先特判 k >= min(n,m) 的情况，直接 ban 掉所有 a 或者所有 b，输出 -1。
枚举 ban 掉 a 的 0~i-1 的航班，双指针计算最小的满足 b[j] >= a[i]+ta 的 j。
那么 ban 掉 b 的后续 k-i 个航班，从 b[j+k-i] 时刻起飞。
答案为 b[j+k-i 的最大值] + tb。
如果 j+k-i >= m，输出 -1。
时间复杂度 O(n+m)。
代码 https://codeforces.com/contest/1148/submission/287880738
代码备份（洛谷）
======

Input
4 5 1 1 2
1 3 5 7
1 2 3 9 10
Output
11

Input
2 2 4 4 2
1 10
10 20
Output
-1

Input
4 3 2 3 1
1 999999998 999999999 1000000000
3 4 1000000000
Output
1000000003
 */