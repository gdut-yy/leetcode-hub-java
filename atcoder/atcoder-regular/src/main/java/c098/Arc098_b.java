package c098;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc098_b {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        int l = 0, r = 0;
        long or = 0;
        while (r < n) {
            while ((or & a[r]) != 0) {
                or ^= a[l];
                l++;
            }
            or |= a[r];
            ans += r - l + 1;
            r++;
        }
        return String.valueOf(ans);
    }
}
/*
D - Xor Sum 2
https://atcoder.jp/contests/arc098/tasks/arc098_b

灵茶の试炼 2023-09-27
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]<2^20)。
a 有多少个非空连续子数组，满足元素和等于元素异或和？
思考：改成子序列要怎么做？

这个等式意味着什么？
意味着二进制加法不能有任何进位，否则等式右边一定大于左边。
没有任何进位相当于什么？
相当于子数组中的任意两个数，同一个比特位上不能都是 1，也就是说，任意两个数的按位与（AND）为 0。
这题就是：
2401. 最长优雅子数组
可以用滑动窗口做到 O(n)，请看题解：
暴力枚举 / 双指针
https://atcoder.jp/contests/abc098/submissions/45104677
======

Input 1
4
2 5 4 6
Output 1
5

Input 2
9
0 0 0 0 0 0 0 0 0
Output 2
45

Input 3
19
885 8 1 128 83 32 256 206 639 16 4 128 689 32 8 64 885 969 1
Output 3
37
 */