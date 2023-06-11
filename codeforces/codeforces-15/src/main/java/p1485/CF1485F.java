package p1485;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1485F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve(n, b));
        }
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve(int n, int[] b) {
        int[] sf = new int[n + 1];
        Map<Long, Integer> last = new HashMap<>();
        long s = 0L;
        int f = 0;
        for (int i = n - 1; i >= 0; i--) {
            s += b[i];
            int j = last.getOrDefault(s, 0);
            if (j > 0) {
                f = (sf[i + 1] - sf[j + 1] + MOD) % MOD;
            } else {
                f = (sf[i + 1] + 1) % MOD;
            }
            sf[i] = (sf[i + 1] + f) % MOD;
            last.put(s, i);
        }
        return String.valueOf(f);
    }
}
/*
F.  or Prefix Sum
https://codeforces.com/contest/1485/problem/F

灵茶の试炼 2023-04-21
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(≤2e5) 和长为 n 的数组 b(-1e9≤b[i]≤1e9)，下标从 1 开始。
构造下标从 1 开始的数组 a，对于每个 i，满足 b[i] = a[i] 或者 b[i] = a[1] + a[2] + ... + a[i]。
输出有多少个不同的 a，模 1e9+7。

https://codeforces.com/contest/1485/submission/202820084
提示 1：两个 a 不同，当且仅当这两个 a 的前缀和不同。那么考虑 a 的前缀和有多少不同的。
提示 2：设 a 的前缀和为 s，则有：
s1 = a1 = b1
s2 = s1 + a2 = b2 或 s1 + b2
s3 = s2 + a3 = b3 或 s2 + b3
……
画出的分支图以及样例一见右。注意对于样例一，b3=b1+b2+b3，所以下面只有一个分支
提示 3：定义 f[i] 表示从 a[i] 开始的不同后缀的个数。
右图最左边的 1 这棵树就是 f[1]，-1 这棵树就表示 f[2]，右下的 1 这棵树就表示 f[3]。
设 j 是最小的满足 a[i] + ... + a[j-1] = 0 的下标，那么
f[i] = f[i+1] + ... + f[j]
如果 j 不存在，那么
f[i] = f[i+1] + ... f[n] + 1
从状态转移方程可以看出，需要倒序循环计算 f。
所以，记录 a 的后缀和的位置信息，可以算出 j。记录 f 的后缀和，可以 O(1) 算出 f[i]。
答案为 f[1]。
======

input
4
3
1 -1 1
4
1 2 3 4
10
2 -1 1 -2 2 3 -5 0 2 -1
4
0 0 0 1
output
3
8
223
1
 */
