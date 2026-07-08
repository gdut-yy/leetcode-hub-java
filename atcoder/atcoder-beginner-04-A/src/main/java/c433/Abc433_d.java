package c433;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc433_d {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long ans = 0;
        Map<String, Integer> cnt = new HashMap<>();
        long[] a = new long[n];
        int[] lens = new int[n];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            a[i] = Long.parseLong(s);
            lens[i] = s.length();
            String key = lens[i] + "," + (int) (a[i] % m);
            cnt.put(key, cnt.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            long v = a[i];
            long vm = v % m;
            int l = 1;
            for (long p10 = 10; p10 <= 1e10; p10 *= 10) {
                long r = vm * (p10 % m) % m;
                String key = l + "," + (int) ((m - r) % m);
                ans += cnt.getOrDefault(key, 0);
                l++;
            }
        }
        out.println(ans);
    }
}
/*
D - 183183
https://atcoder.jp/contests/abc433/tasks/abc433_d

灵茶の试炼 2026-06-15
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
定义 f(x, y) 表示把整数 x 和整数 y 按照十进制字符串拼起来，得到的整数。
例如 f(12, 345) = 12345。
输出有多少个下标对 (i, j) 满足 f(a[i], a[j]) 是 m 的倍数。
注意 i 和 j 之间没有大小要求，可以小于/等于/大于。

rating
枚举 a[j] 的十进制长度。
例如长度是 3，那么有 a[i]*1000 + a[j] 是 m 的倍数。
枚举 a[i]，我们需要知道有多少个 a[j]，十进制长度为 3 且满足 a[j] % m 等于 (m - a[i]*1000%m) % m。
用哈希表记录 pair (a[j] 的十进制长度, a[j]%m) 的出现次数。
代码 https://atcoder.jp/contests/abc433/submissions/76595576
======

Input 1
2 11
2 42
Output 1
2

Input 2
4 7
2 8 16 183
Output 2
4

Input 3
5 5
1000000000 1000000000 1000000000 1000000000 1000000000
Output 3
25

Input 4
12 13
80 68 862370 82217 8 56 5 168 672624 6 286057 11864
Output 4
10
 */
