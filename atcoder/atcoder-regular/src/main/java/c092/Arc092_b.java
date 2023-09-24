package c092;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Arc092_b {
    static int n;
    static Integer[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        for (int k = 0; k < 29; k++) {
            int mask = (1 << (k + 1)) - 1;
            Arrays.sort(a, Comparator.comparingInt(o -> o & mask));
            Arrays.sort(b, Comparator.comparingInt(o -> o & mask));
            int cnt = 0;
            int i = n - 1, j = n - 1;
            int p = n - 1, q = n - 1;
            int l1 = 1 << k, r1 = (1 << (k + 1)) - 1;
            int l2 = 3 << k, r2 = (1 << (k + 2)) - 1;
            for (Integer v : a) {
                while (i >= 0 && (v & mask) + (b[i] & mask) >= l1) i--;
                while (j >= 0 && (v & mask) + (b[j] & mask) > r1) j--;
                while (p >= 0 && (v & mask) + (b[p] & mask) >= l2) p--;
                while (q >= 0 && (v & mask) + (b[q] & mask) > r2) q--;
                cnt ^= i ^ j ^ p ^ q;
            }
            ans |= (cnt & 1) << k;
        }
        return String.valueOf(ans);
    }
}
/*
D - Two Sequences
https://atcoder.jp/contests/arc092/tasks/arc092_b

灵茶の试炼 2023-09-01
题目大意：
输入 n(1≤n≤2e5) 和两个长为 n 的数组 a b，元素范围在 [0,2^28)。
从 a 中选一个数 a[i]，从 b 中选一个数 b[j]，相加得到 a[i]+b[j]。这一共有 n^2 个数字。
输出这 n^2 个数的异或和。

二进制题目，常用技巧之一是拆位，但这只能用于各个比特位互相独立的情况。
本题加法有进位，破坏了这种独立性，这要如何处理呢？
其实也可以拆位（我叫它加法拆位）。
按照 mod (2^k) 拆位，例如要计算从低到高第三个比特位，可以 mod 8（即 AND 7）。
记 s = a[i]%8 + b[j]%8。
要想知道这 n^2 个 s 中，从低到高第三个比特位有多少个 1，相当于求满足下式的 s 的个数：
100 <= s <= 111 或 1100 <= s <= 1111（数字为二进制）。
这可以在按照 mod 8 排序后，用五个指针做。一个指针遍历 a[i]，另外 4 个指针在 b 上，对应着上式的 4 个区间端点。
注意：相加可能会进位到第 29 个比特位，在枚举的时候请注意上界。
https://atcoder.jp/contests/arc092/submissions/44922461
优化：
注意到 s <= 1<<(k+2)-1 是恒成立的，上面代码中的 q 恒等于 n-1。
而 n 个 n-1 的异或和一定是偶数（最低位一定是 0），所以可以完全去掉 q。
优化后
https://atcoder.jp/contests/arc092/submissions/44922567
======

Input 1
2
1 2
3 4
Output 1
2

Input 2
6
4 6 0 0 3 3
0 5 6 5 0 3
Output 2
8

Input 3
5
1 2 3 4 5
1 2 3 4 5
Output 3
2

Input 4
1
0
0
Output 4
0
 */