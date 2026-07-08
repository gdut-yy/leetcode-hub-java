package c461;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc461_d {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) V1.solve();
        out.flush();
    }

    static class V1 {
        private static void solve() {
            int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
            long ans = 0;
            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next();
                int[] s = new int[m];
                for (int i2 = i; i2 >= 0; i2--) {
                    for (int j = 0; j < m; j++) {
                        s[j] += a[i2].charAt(j) - '0';
                    }
                    ans += f(s, k);
                }
            }
            out.println(ans);
        }

        static long f(int[] a, int k) {
            Map<Integer, Integer> cnt = new HashMap<>();
            long res = 0;
            int s = 0;
            for (int x : a) {
                cnt.put(s, cnt.getOrDefault(s, 0) + 1);
                s += x;
                if (s >= k) {
                    res += cnt.getOrDefault(s - k, 0);
                }
            }
            return res;
        }
    }

    // 写法二
    static class V2 {
        private static void solve() {
            int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
            long ans = 0;
            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next();
                int[] s = new int[m];
                for (int i2 = i; i2 >= 0; i2--) {
                    for (int j = 0; j < m; j++) {
                        s[j] += a[i2].charAt(j) - '0';
                    }
                    ans += f(s, k);
                }
            }
            out.println(ans);
        }

        static long f(int[] a, int k) {
            long res = 0;
            int s1 = 0, s2 = 0, l1 = 0, l2 = 0;
            for (int i = 0; i < a.length; i++) {
                int x = a[i];
                s1 += x;
                s2 += x;
                while (l1 <= i && s1 >= k) {
                    s1 -= a[l1];
                    l1++;
                }
                while (s2 > k) {
                    s2 -= a[l2];
                    l2++;
                }
                res += l1 - l2;
            }
            return res;
        }
    }
}
/*
D - Count Subgrid Sum = K
https://atcoder.jp/contests/abc461/tasks/abc461_d

灵茶の试炼 2026-06-23
题目大意：
输入 n m(1≤n,m≤500) k(0≤k≤n*m) 和 n 行 m 列的 01 矩阵 a。
输出 a 有多少个非空子矩阵，元素和恰好为 k。

rating
本题和 LC1074. 元素和为目标值的子矩阵数量 是一样的。
优化：注意本题元素均非负，可以用「恰好型滑动窗口」代替前缀和+哈希表。见 LC930. 和相同的二元子数组。
写法一：前缀和+哈希表 3599 ms https://atcoder.jp/contests/abc461/submissions/76765029
写法二：恰好型滑动窗口 430 ms https://atcoder.jp/contests/abc461/submissions/76765167
======

Input 1
3 4 3
1001
1101
0110
Output 1
8

Input 2
5 4 20
0101
1010
0101
1010
0101
Output 2
0

Input 3
15 20 17
10111101101100000100
01100000000010000011
01110010111000111000
11001100000111011000
10100001100011100010
01101000101010000101
10110001111110000100
10110011101100101101
01010001110011001001
01010110010001100110
01110100011110011110
01100000100111010010
11001101100111101100
10111100010101111011
00101101011100010000
Output 3
448
 */
