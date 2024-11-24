package p760;

import java.util.Scanner;
import java.util.function.Function;

public class CF760B {
    static int n, tot, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        tot = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        tot -= n;
        long ans = 1 + sortSearch(tot, m -> {
            m++;
            long st = Math.max(m - k + 1, 0);
            long cnt = (st + m) * (m - st + 1) / 2;
            st = Math.max(m - (n - k), 0);
            cnt += (st + m - 1) * (m - st) / 2;
            return cnt > tot;
        });
        return String.valueOf(ans);
    }

    static long sortSearch(long n, Function<Long, Boolean> f) {
        long l = 0, r = n;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
B. Frodo and pillows
https://codeforces.com/contest/760/problem/B

灵茶の试炼 2024-05-21
题目大意：
输入 n m (1≤n≤m≤1e9) k(1≤k≤n)。
有一个长为 n 的数组 a，已知其所有元素均为正整数，元素和等于 m 且 |a[i]-a[i+1]| <= 1。
问：a[k] 最大能是多少？

rating 1500
二分答案。
a[k] 越大，元素和越大，反之越小，有单调性，故可二分答案。
设 a[k]=mx，那么数组元素最佳是按照
...
a[k-2] = mx-2
a[k-1] = mx-1
a[k] = mx
a[k+1] = mx-1
a[k+2] = mx-2
...
分配，这样元素和尽量小。
按照上述规则，计算等差数列和 cnt，通过比较 cnt 与 m 的大小来调整二分边界。
注意用 64 位整数。
https://codeforces.com/contest/760/submission/261035812
======

Input
4 6 2
Output
2

Input
3 10 3
Output
4

Input
3 6 1
Output
3
 */
