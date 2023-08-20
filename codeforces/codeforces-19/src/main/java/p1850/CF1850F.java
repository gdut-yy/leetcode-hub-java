package p1850;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1850F {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
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
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : a) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }

        int[] cnt = new int[n + 1];
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int k = entry.getKey(), c = entry.getValue();
            for (int i = k; i <= n; i += k) {
                cnt[i] += c;
            }
        }
        int ans = Arrays.stream(cnt).max().orElseThrow();
        return String.valueOf(ans);
    }
}
/*
F. We Were Both Children
https://codeforces.com/contest/1850/problem/F

题目大意：
Mihai 和 Slavic 正在观察一组 n 只青蛙，从 1 到 n 编号，最初都位于 0 点。青蛙 i 的跳跃长度是 ai。
每一秒钟，青蛙 i 向前跳 ai 个单位。在任何青蛙开始跳跃之前，Slavic 和 Mihai 可以在一个坐标上放置一个陷阱，以便捕获所有将通过相应坐标的青蛙。
然而，孩子们不能离家太远，所以他们只能在前 n 个点(即坐标在 1 和 n 之间的点)放置陷阱，孩子们不能在 0 点放置陷阱，因为他们害怕青蛙。
你能帮斯拉夫和米海弄清楚他们用陷阱最多能抓到多少只青蛙吗?

暴力，求最大频次。
======

input
7
5
1 2 3 4 5
3
2 2 2
6
3 1 3 4 9 10
9
1 3 2 4 2 3 7 8 5
1
10
8
7 11 6 8 12 4 4 8
10
9 11 9 12 1 7 2 5 8 10
output
3
3
3
5
0
4
4
 */
