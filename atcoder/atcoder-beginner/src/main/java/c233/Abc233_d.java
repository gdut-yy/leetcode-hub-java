package c233;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc233_d {
    static int n;
    static long k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextLong();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        long s = 0;
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        for (int i = 0; i < n; i++) {
            s += a[i];
            ans += cnt.getOrDefault(s - k, 0);
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        }
        return String.valueOf(ans);
    }
}
/*
D - Count Interval
https://atcoder.jp/contests/abc233/tasks/abc233_d

灵茶の试炼 2023-08-28
题目大意：
输入 n(1≤n≤2e5) k(-1e15≤k≤1e15) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
输出元素和等于 k 的连续子数组个数。
如果你觉得本题太简单，请思考这个问题：
所有元素和等于 k 的连续子数组的长度之和。

用前缀和思考：
sum[R] - sum[L] = k
枚举 R，问题变成有多少个 sum[L]，也就是 sum[R]-k 的个数。
这可以用哈希表统计，代码如下。
https://atcoder.jp/contests/abc233/submissions/44903090
关于思考题的提示：
举例：
(R-L1) + (R-L2) + (R-L3)
= 3*R - (L1+L2+L3)
所以除了维护前缀和的出现次数，还需要维护下标之和。
======

Input 1
6 5
8 -3 5 7 0 -4
Output 1
3

Input 2
2 -1000000000000000
1000000000 -1000000000
Output 2
0
 */