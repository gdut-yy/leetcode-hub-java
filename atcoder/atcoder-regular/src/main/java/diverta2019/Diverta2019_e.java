package diverta2019;

import java.util.Arrays;
import java.util.Scanner;

public class Diverta2019_e {
    static int n;
    static int[] a;

    static class Tuple {
        long s0, s1, pre0;

        public Tuple(long s0, long s1, long pre0) {
            this.s0 = s0;
            this.s1 = s1;
            this.pre0 = pre0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        Tuple[] f = new Tuple[1 << 20];
        Arrays.setAll(f, e -> new Tuple(1, 0, 0));

        int xor = 0;
        int cnt0 = 1;
        for (int v : a) {
            xor ^= v;
            if (xor == 0) {
                cnt0++;
            } else {
                Tuple t = f[xor];
                // f[i][0] = 一堆 f[j][1] 的和 = s1，这里直接把 f[i][0] 加到 s0 中
                t.s0 = (t.s0 + t.s1 * (cnt0 - t.pre0)) % MOD;
                // f[i][1] = 一堆 f[j][0] 的和 = s0，这里直接把 f[i][1] 加到 s1 中
                t.s1 = (t.s1 + t.s0) % MOD;
                t.pre0 = cnt0;
            }
        }
        if (xor > 0) {
            // 答案 = f[n][1] = 一堆 f[j][0] 的和 = s0
            // 注意不能写 f[xor].s1，因为前缀异或和的末尾如果有多个 xor，我们只能选一个
            return String.valueOf(f[xor].s0);
        }
        long ans = quickPow(2, cnt0 - 2); // 只选 0 的方案数
        for (Tuple t : f) {
            // 答案 = f[n][0] = 一堆 f[j][1] 的和 = s1
            // 注意不能写 t.s0，因为前缀异或和的末尾如果有多个 0，我们只能选一个
            ans += t.s1;
        }
        return String.valueOf(ans % MOD);
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
E - XOR Partitioning
https://atcoder.jp/contests/diverta2019/tasks/diverta2019_e

灵茶の试炼 2023-09-22
题目大意：
输入 n(1≤n≤5e5) 和长为 n 的数组 a(0≤a[i]<2^20)。
把数组 a 划分成若干段连续子数组，一共有 2^(n-1) 种划分方案。
问：其中有多少种划分方案，可以让每段子数组的异或和都一样？
答案模 1e9+7。

rating 2423
请看题解：
https://www.luogu.com.cn/blog/endlesscheng/solution-at-diverta2019-e
======

Input 1
3
1 2 3
Output 1
3

Input 2
3
1 2 2
Output 2
1

Input 3
32
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
Output 3
147483634

Input 4
24
1 2 5 3 3 6 1 1 8 8 0 3 3 4 6 6 4 0 7 2 5 4 6 2
Output 4
292
 */