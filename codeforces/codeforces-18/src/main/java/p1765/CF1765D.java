package p1765;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1765D {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);

        long ans = n;
        for (long x : a) {
            ans += x;
        }

        int l = 0, r = n - 1;
        while (l < r) {
            if (a[l] + a[r] <= m) {
                l++;
                if (l < r) {
                    ans -= 2;
                } else {
                    ans -= 1;
                }
            }
            r--;
        }
        return String.valueOf(ans);
    }
}
/*
D. Watch the Videos
https://codeforces.com/contest/1765/problem/D

灵茶の试炼 2023-07-19
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤1e9) 和长为 n 的数组 a(1≤a[i]≤m)。
硬盘可用空间为 m。
有 n 个视频，下载第 i 个需要 a[i] 分钟，占用 a[i] 的硬盘空间。
同一时间只能下载一个视频，一旦视频开始下载，就会立刻占用 a[i] 的硬盘空间。
视频下完才能看。每个视频都恰好花 1 分钟看完，看完后可以立刻删除视频，释放空间。
你可以在看视频的同时下载另一个视频（如果硬盘空间足够的话）。
你需要下载并看完这 n 个视频。
问：到看完最后一个视频，最少要用多少分钟？

rating 1700
https://codeforces.com/contest/1765/submission/214219665
最多要花 n + sum(a) 分钟。在这基础上，考虑如何安排可以在看视频的同时下载。
受到救生艇这题的启发，排序+双指针，如果 a[l]+a[r]<=m，那么先下载 a[r]，看 a[r] 的同时下载 a[l]，那么看 a[l] 的同时，又可以下载另外一个视频（因为 a[l] 加上一个<=a[r] 的必然 <= m）。
所以只要 a[l]+a[r]<=m，那么就可以节省 2 分钟，除非 a[l] 是最后一个视频，那么最后一分钟只能看，此时只能节省 1 分钟。
相似题目: 881. 救生艇
https://leetcode.cn/problems/boats-to-save-people/
======

input
5 6
1 2 3 4 5
output
16

input
5 5
1 2 3 4 5
output
17

input
4 3
1 3 2 3
output
12
 */
