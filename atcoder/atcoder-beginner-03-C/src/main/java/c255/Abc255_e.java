package c255;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc255_e {
    static int n, m;
    static int[] s, x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            s[i] = scanner.nextInt();
        }
        x = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Long, Integer> cnt = new HashMap<>();
        for (long v : x) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        long sum = 0, ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if ((i & 1) > 0) {
                sum -= s[i];
                for (int w : x) {
                    long k = sum + w;
                    cnt.put(k, cnt.getOrDefault(k, 0) + 1);
                }
            } else {
                sum += s[i];
                for (int w : x) {
                    long k = sum - w;
                    cnt.put(k, cnt.getOrDefault(k, 0) + 1);
                }
            }
        }

        for (Integer c : cnt.values()) {
            ans = Math.max(ans, c);
        }
        return String.valueOf(ans);
    }
}
/*
E - Lucky Numbers
https://atcoder.jp/contests/abc255/tasks/abc255_e

灵茶の试炼 2022-10-27
输入 n (2≤n≤1e5) 和 m(≤10)，长为 n-1 的数组 s 和长为 m 的严格递增数组 x，元素值范围在 [-1e9,1e9]。
数组 x 中的元素叫做幸运数。
对于一个长为 n 的序列 a，如果所有相邻元素满足 a[i]+a[i+1]=s[i]，则称为一个好序列。
输出好序列中最多能有多少个数是幸运数（重复数字也算，见样例）。

https://www.luogu.com.cn/blog/endlesscheng/solution-at-abc255-e
======

Input 1
9 2
2 3 3 4 -4 -7 -4 -1
-1 5
Output 1
4

Input 2
20 10
-183260318 206417795 409343217 238245886 138964265 -415224774 -499400499 -313180261 283784093 498751662 668946791 965735441 382033304 177367159 31017484 27914238 757966050 878978971 73210901
-470019195 -379631053 -287722161 -231146414 -84796739 328710269 355719851 416979387 431167199 498905398
Output 2
8
 */