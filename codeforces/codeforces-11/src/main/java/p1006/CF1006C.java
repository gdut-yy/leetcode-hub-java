package p1006;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1006C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve1());
    }

    // 方法一
    private static String solve() {
        Map<Long, Integer> cnt = new HashMap<>();
        long pre = 0, suf = 0;
        long ans = 0;
        for (int v : a) {
            pre += v;
            cnt.merge(pre, 1, Integer::sum);
        }
        for (int i = n - 1; i >= 0; i--) {
            cnt.merge(pre, -1, Integer::sum);
            pre -= a[i];
            suf += a[i];
            if (cnt.getOrDefault(suf, 0) > 0) {
                ans = Math.max(ans, suf);
            }
        }
        return String.valueOf(ans);
    }

    // 方法二
    private static String solve1() {
        int r = n - 1;
        long pre = 0, suf = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            pre += a[i];
            for (; r >= 0 && suf < pre; r--) {
                suf += a[r];
            }
            if (r < i) {
                break;
            }
            if (suf == pre) {
                ans = Math.max(ans, pre);
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Three Parts of the Array
https://codeforces.com/contest/1006/problem/C

灵茶の试炼 2025-05-12
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 d(1≤d[i]≤1e9)。
把 d 分成三个连续子数组 A B C，即 d = A+B+C。子数组可以为空。
要求 sum(A) = sum(C)。
输出 sum(A) 的最大值。

rating 1200
方法一：前后缀分解
计算前缀和与后缀和，枚举前缀和 pre，找后缀和中有没有 pre。需要用哈希表统计后缀和的出现次数，方便判断。
代码一 https://codeforces.com/contest/1006/submission/318567755
方法二：相向双指针
计算前缀和 pre，同时用另一个从 n-1 开始的指针 r 维护后缀和 suf，如果 suf < pre 就左移 r。
代码二 https://codeforces.com/contest/1006/submission/318567988
代码备份（洛谷）二合一
======

Input
5
1 3 1 1 4
Output
5

Input
5
1 3 2 1 4
Output
4

Input
3
4 1 2
Output
0
 */
