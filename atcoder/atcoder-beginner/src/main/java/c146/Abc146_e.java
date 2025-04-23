package c146;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc146_e {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = (s[i] + a[i] - 1) % k;
        }

        long ans = 0;
        Map<Long, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n + 1; i++) {
            ans += cnt.merge(s[i], 1, Integer::sum) - 1;
            if (i >= k - 1) {
                cnt.merge(s[i - k + 1], -1, Integer::sum);
            }
        }
        return String.valueOf(ans);
    }
}
/*
E - Rem of Sum is Num
https://atcoder.jp/contests/abc146/tasks/abc146_e

灵茶の试炼 2025-01-30
题目大意：
输入 n(1≤n≤2e5) k(1≤k≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
输出 a 的非空连续子数组 b 的个数，满足 sum(b) % k = len(b)。

由于 sum(b)%k < k，所以子数组的长度至多为 k-1。
考虑前缀和，我们有 (s[r] - s[l]) % k = r - l = (r - l) % k。
所以 s[r] - s[l] 和 r - l 模 k 同余。
移项得 ((s[r] - r) - (s[l] - l)) % k = 0。
哈希表统计 (s[i]-i)%k 的个数，用【枚举右维护左】解决。
注意子数组的长度至多为 k-1，所以还要滑窗（移除左端点元素）。
注：s[i]-i 等价于计算 a[i]-1 的前缀和。
注：由于本题保证 a[i] >= 1，所以无需考虑负数取模的问题。
代码 https://atcoder.jp/contests/abc146/submissions/62059396
======

Input 1
5 4
1 4 2 3 5
Output 1
4

Input 2
8 4
4 2 4 2 4 2 4 2
Output 2
7

Input 3
10 7
14 15 92 65 35 89 79 32 38 46
Output 3
8
 */
