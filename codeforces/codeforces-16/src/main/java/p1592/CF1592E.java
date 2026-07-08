package p1592;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1592E {
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
        int ans = 0, ts = 0, xor = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] vis = new int[1 << 20];
        int[] pre = new int[1 << 20];
        for (int b = 0; b < 20; b++) {
            ts++;
            for (int i = 0; i < n; i++) {
                int v = a[i];
                if (((v >> b) & 1) == 0) {
                    ts++;
                    continue;
                }
                if (vis[xor] < ts) {
                    vis[xor] = ts;
                    pre[xor] = i;
                }
                xor ^= v >> b;
                if (vis[xor] == ts) {
                    ans = Math.max(ans, i - pre[xor] + 1);
                }
            }
        }
        out.println(ans);
    }
}
/*
E. Bored Bakry
https://codeforces.com/contest/1592/problem/E

灵茶の试炼 2026-02-27
题目大意：
输入 n(1≤n≤1e6) 和长为 n 的数组 a(1≤a[i]≤1e6)。
输出 a 的最长连续子数组的长度，满足子数组 AND > 子数组 XOR（子数组所有元素的按位与 > 子数组所有元素的异或和）。
如果没有这样的子数组，输出 0。

rating 2400
如果 a 中只有 0 和 1，怎么做？
子数组必须都是 1，且恰好有偶数个 1，这样 AND = 1，XOR = 0，AND > XOR。
如果 a 中只有 0,1,2,3 呢？
二进制有两位，枚举 AND > XOR 发生在高位还是低位。
如果高位 AND > XOR，那么同上，子数组元素的高位必须都是 1，且恰好有偶数个 1。
如果高位 AND = XOR，低位 AND > XOR（低位 1 > 0），说明子数组元素的低位都是 1，且恰好有偶数个 1（这样 XOR 的低位才是 0）。由于子数组长度是偶数，高位不可能是 1 = 1（因为偶数个 1 的 XOR 是 0），所以只能是 0 = 0。结合高位和低位，我们发现了一个神奇的结论：子数组的 XOR = 0！
所以做法是：
枚举 AND > XOR 发生的那一位 k，忽略低于 k 位的信息。
寻找第 k 位都是 1 的子数组，且子数组 a[i] >> k 的异或和等于 0。
找一个最长子数组，异或和等于 0，怎么做？前缀异或和，枚举右维护左。
维护前缀异或和首次出现的下标，再次遇到相同的前缀异或和时，计算下标之差加一，更新答案的最大值。
代码 https://codeforces.com/contest/1592/submission/322604914
代码备份（上面打不开的同学看这个）
======

Input
2
5 6
Output
2

Input
3
2 4 3
Output
0

Input
6
8 1 3 3 1 2
Output
4
 */
