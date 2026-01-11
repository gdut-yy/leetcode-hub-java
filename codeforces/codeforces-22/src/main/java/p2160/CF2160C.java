package p2160;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2160C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        if (n > 0) {
            n /= n & -n;
        }
        int m = bitsLen(n);
        if (m % 2 > 0 && (n >> (m / 2) & 1) > 0 || n != Integer.reverse(n) >>> Integer.numberOfLeadingZeros(n)) {
            out.println("NO");
        } else {
            out.println("YES");
        }
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
C. Reverse XOR
https://codeforces.com/contest/2160/problem/C

灵茶の试炼 2025-11-25
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 n(0≤n<2^30)。
是否存在一个正整数 x，使得 x XOR rev(x) = n？
其中 rev(x) 表示翻转 x 的二进制（不含前导零）后的整数。例如 rev(1101) = 1011。
输出 YES 或 NO。
进阶：做到 O(1) 时间。

rating 1300
如果 x 的最高位和最低位不同，那么异或后，n 的最高位和最低位都是 1。
如果 x 的最高位和最低位相同，那么异或后，n（补前导零，二进制长度和 x 相同）的最高位和最低位都是 0。
其余镜像位置同理。
特别地，如果 x 的二进制长度是奇数，那么 n 的正中间一定是 0。
反过来，如果 n（可以补前导零）是二进制回文数，且（如果长度是奇数的话）正中间是 0，那么存在 x。
比如 n=1010，补一个前导零得到 01010，满足要求。
也可以去掉 n 的尾零后，判断 n 是否为二进制回文数，且（如果长度是奇数的话）正中间是 0。
通过计算 n /= lowbit(n)，可以去掉 n 的尾零。
用库函数 Reverse(n) >> LeadingZeros(n) 可以 O(1) 得到 n 反转后的值。判断其是否等于 n，等于即说明 n 是二进制回文数。
其他语言怎么写 Reverse 可以看 我的题解 的方法二。https://leetcode.cn/problems/minimum-number-of-flips-to-reverse-binary-string/solution/liang-chong-fang-fa-cong-olog-n-dao-o1py-nhiq/
代码 https://codeforces.com/contest/2160/submission/350492151
代码备份（上面打不开的同学看这个）
======

Input
6
0
3
6
8
10
11
Output
YES
YES
YES
NO
YES
NO
 */
