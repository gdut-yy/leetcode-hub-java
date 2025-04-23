package c117;

import java.util.Scanner;

public class Abc117_d {
    static int n;
    static long k;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextLong();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    static final int MX = 40;

    private static String solve() {
        long[] cnt = new long[MX];
        for (long v : a) {
            for (long j = v; j > 0; j &= j - 1) {
                cnt[Long.numberOfTrailingZeros(j)]++;
            }
        }
        long[] suf = new long[MX + 1];
        for (int i = 0; i < cnt.length; i++) {
            long c = cnt[i];
            suf[i + 1] = suf[i] + (Math.max(c, n - c) << i);
        }

        k++;
        long pre = 0;
        long ans = 0;
        for (int i = MX - 1; i >= 0; i--) {
            if ((k >> i & 1) > 0) {
                ans = Math.max(ans, pre + (cnt[i] << i) + suf[i]);
                pre += (n - cnt[i]) << i;
            } else {
                pre += cnt[i] << i;
            }
        }
        return String.valueOf(ans);
    }
}
/*
D - XXOR
https://atcoder.jp/contests/abc117/tasks/abc117_d

灵茶の试炼 2025-02-05
题目大意：
输入 n(1≤n≤1e5) k(0≤k≤1e12) 和长为 n 的数组 a(0≤a[i]≤1e12)。
选择一个 [0,k] 中的整数 x，最大化 (x XOR a[1]) + (x XOR a[2]) + ... + (x XOR a[n])。
输出这个最大值。

核心思路：
拆位，对于每个比特位，如果这一位 1 多，那么 x 这一位取 0 更合适；如果这一位 0 多，那么 x 这一位取 1 更合适。
设从低到高第 i 个比特位的 1 的个数是 cnt1[i]，那么这个比特位对答案的贡献是 max(cnt1[i], n-cnt1[i]) << i。
但是，x 的值受到 k 的约束，怎么处理？
为方便计算，下面讨论的是 k+1。
从最高位 i=39 开始枚举。
如果 k+1 在最高位是 1，且 x 在这一位是 0，那么 x 在更低的比特位上可以是 0 也可以是 1（不受 k 的约束）。
直接累加所有 max(cnt1[i], n-cnt1[i]) << j（其中 j < i），更新答案的最大值。
更新之后，剩下需要讨论的是 x 在这一位一定是 1 的情况。我们先把 (n-cnt1[i]) << i 加入变量 pre 中，然后把 i 减一，继续讨论后续的比特位。
如果 k+1 在第 i 位是 0，那么 x 在这一位也只能是 0，跳过。把 cnt1[i] << i 加入变量 pre 中。
如果 k+1 在第 i 位是 1，且 x 在这一位是 0，那么更低的比特位可以随便选（不受约束），累加 max(cnt1[i], n-cnt1[i]) << j（其中 j < i），再加上 pre 以及 cnt1[i] << i，更新答案的最大值。
代码实现时，可以提前计算低 i 位的所有 max(cnt1[i], n-cnt1[i]) << i 之和，记作 suf[i+1]。
代码 https://atcoder.jp/contests/abc117/submissions/62189285
======

Input 1
3 7
1 6 3
Output 1
14

Input 2
4 9
7 4 0 3
Output 2
46

Input 3
1 0
1000000000000
Output 3
1000000000000
 */
