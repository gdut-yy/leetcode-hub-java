package p190;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF190D {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();

        int l = 0, r = 0;
        while (r < n) {
            cnt.put(a[r], cnt.getOrDefault(a[r], 0) + 1);
            while (cnt.get(a[r]) >= k) {
                cnt.put(a[l], cnt.getOrDefault(a[l], 0) - 1);
                l++;
            }
            ans += l;
            r++;
        }
        return String.valueOf(ans);
    }
}
/*
D. Non-Secret Cypher
https://codeforces.com/contest/190/problem/D

灵茶の试炼 2023-06-01
输入 n k(1≤k≤n≤4e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
统计有多少个连续子数组 b，满足 b 中有至少 k 个数都相同。

rating 1900
https://codeforces.com/problemset/submission/190/208012570
同向双指针。
固定右端点 right，移动左端点 left，让子数组 [left-1, right] 中至多有一个数出现 k 次。
如果已经出现了 k 个相同的数，那么 [left', right] 都是符合要求的，其中 left' < left。
=====

input
4 2
1 2 1 2
output
3

input
5 3
1 2 1 1 3
output
2

input
3 1
1 1 1
output
6
 */
