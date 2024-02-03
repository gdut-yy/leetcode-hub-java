package p1882;

import java.util.Scanner;

public class CF1882B {
    static int n;
    static long[] mask;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            mask = new long[n];
            for (int i = 0; i < n; i++) {
                int k = scanner.nextInt();
                long msk = 0;
                for (int j = 0; j < k; j++) {
                    int s = scanner.nextInt() - 1;
                    msk |= 1L << s;
                }
                mask[i] = msk;
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long full = 0;
        for (long msk : mask) {
            full |= msk;
        }

        int ans = 0;
        for (int i = 0; i < 50; i++) {
            // 只看为 1 的位置
            if ((full >> i & 1) == 0) continue;

            long tot = 0;
            for (long msk : mask) {
                if ((msk >> i & 1) == 0) {
                    tot |= msk;
                }
            }
            int bitCount = Long.bitCount(tot);
            ans = Math.max(ans, bitCount);
        }
        return String.valueOf(ans);
    }
}
/*
B. Sets and Union
https://codeforces.com/contest/1882/problem/B

题目大意：
你有 n 组整数 S1 S2…Sn。如果有可能从集合 S1,S2,...,Sn 中选择一些(可能没有)使 S 等于它们的并集†，我们称集合 S 为可得集 S。如果 S1,S2,...,Sn 都不选，它们的并集是空集。
求一个可得的 S 中满足 S≠S1∪S2∪...∪Sn 的最大个数。
†集合 A1,A2,...,Ak 的并集定义为存在于这些集合中至少一个的元素的集合。它表示为 A1∪A2∪...∪Ak。例如:{2,4,6}∪{2,3}∪{3,6,7}={2,3,4,6,7}。

2^50 怎么暴力？如何贪心？
---
枚举所有数字，从全并集里面，尝试去掉这个数字（即删除包含这个数字的所有集合），再算当前集合的大小。
从所有情况中取最大，即可。
======

input
4
3
3 1 2 3
2 4 5
2 3 4
4
4 1 2 3 4
3 2 5 6
3 3 5 6
3 4 5 6
5
1 1
3 3 6 10
1 9
2 1 3
3 5 8 9
1
2 4 28
output
4
5
6
0
 */
