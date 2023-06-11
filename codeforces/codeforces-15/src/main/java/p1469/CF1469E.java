package p1469;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1469E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int q = scanner.nextInt();
        while (q-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, k, s));
        }
    }

    private static String solve(int n, int k, String s) {
        if (n == 1) {
            return "YES" + System.lineSeparator() + (s.charAt(0) & 1);
        }
        // k2 := bits.Len(uint(n)) - 1
        int k2 = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
        int left = k - k2;
        if (left <= 0) {
            boolean[] has = new boolean[1 << k];
            int mask = (1 << (k - 1)) - 1;
            // 注意 java.lang.NumberFormatException: For input string: "" under radix 2
            int x =(k - 1 > 0) ? Integer.parseInt(s.substring(0, k - 1), 2) : 0;
            for (char c : s.substring(k - 1).toCharArray()) {
                x = x << 1 | (c & 1);
                has[x] = true;
                x &= mask;
            }
            for (int i = (1 << k) - 1; i >= 0; i--) {
                if (!has[i]) {
                    String bin = "0".repeat(k) + Integer.toBinaryString(((1 << k) - 1) ^ i);
                    return "YES" + System.lineSeparator()
                            + bin.substring(bin.length() - k);
                }
            }
            return "NO";
        } else {
            boolean[] has = new boolean[1 << k2];
            int mask = (1 << (k2 - 1)) - 1;
            int c1 = 0;
            for (char c : s.substring(0, left - 1).toCharArray()) {
                if (c == '1') {
                    c1++;
                }
            }
            // k2 必然 >= 2 不用考虑空串情况
            int x = Integer.parseInt(s.substring(left, left + k2 - 1), 2);
            for (int i = left - 1; i + k2 < n; i++) {
                c1 += s.charAt(i) & 1;
                x = x << 1 | (s.charAt(i + k2) & 1);
                if (c1 == left) {
                    has[x] = true;
                }
                x &= mask;
                c1 -= s.charAt(i - left + 1) & 1;
            }
            for (int i = (1 << k2) - 1; i >= 0; i--) {
                if (!has[i]) {
                    String bin = "0".repeat(k2) + Integer.toBinaryString(((1 << k2) - 1) ^ i);
                    return "YES" + System.lineSeparator()
                            + "0".repeat(left)
                            + bin.substring(bin.length() - k2);
                }
            }
        }
        return "";
    }
}
/*
E. A Bit Similar
https://codeforces.com/contest/1469/problem/E

灵茶の试炼 2023-04-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e6。
每组数据输入 n k(1≤k≤n≤1e6) 和长为 n 的 01 字符串 s。
定义两个长为 k 的字符串 x 和 y「一点点相同」：存在某个下标 i，使得 x[i] = y[i]。
你需要找到一个长为 k 的字典序最小的 01 串 t，使得 t 与 s 的每个长为 k 的子串都「一点点相同」。
如果不存在这样的 t，输出 NO；否则输出 YES 和 t。

https://www.luogu.com.cn/blog/endlesscheng/solution-cf1469e
======

input
7
4 2
0110
4 2
1001
9 3
010001110
9 3
101110001
10 3
0101110001
10 10
1111111111
11 10
11111111110
output
YES
11
YES
00
YES
010
YES
101
NO
YES
0000000001
YES
0000000010
 */
