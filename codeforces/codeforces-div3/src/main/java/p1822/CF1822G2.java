package p1822;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1822G2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static final int K = (int) 1e6;
    private static final int MAX_N = (int) 1e9;

    private static String solve(int n, int[] a) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int ai : a) {
            cntMap.put(ai, cntMap.getOrDefault(ai, 0) + 1);
        }

        long res = 0L;
        // b = 1
        for (Integer c : cntMap.values()) {
            res += c * (c - 1L) * (c - 2);
        }
        // b >= 2
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            // 枚举 aj
            int num = entry.getKey();
            long val = entry.getValue();
            if (num > K) {
                // b <= 1000
                for (int b = 2; b * num <= MAX_N; b++) {
                    if (num % b == 0 && cntMap.containsKey(num / b) && cntMap.containsKey(num * b)) {
                        res += cntMap.get(num / b) * val * cntMap.get(num * b);
                    }
                }
            } else {
                for (int b = 2; b * b <= num; b++) {
                    // b 为 aj 的一个因子
                    if (num % b == 0) {
                        if ((long) num * b <= MAX_N && cntMap.containsKey(num / b) && cntMap.containsKey(num * b)) {
                            res += cntMap.get(num / b) * val * cntMap.get(num * b);
                        }
                        if (b * b != num) {
                            if ((long) num * num / b <= MAX_N && cntMap.containsKey(b) && cntMap.containsKey(num / b * num)) {
                                res += cntMap.get(b) * val * cntMap.get(num / b * num);
                            }
                        }
                    }
                }
                // b = num
                if (num > 1 && (long) num * num <= MAX_N && cntMap.containsKey(1) && cntMap.containsKey(num * num)) {
                    res += cntMap.get(1) * val * cntMap.get(num * num);
                }
            }
        }
        return String.valueOf(res);
    }
}
/*
G2. Magic Triples (Hard Version)
https://codeforces.com/contest/1822/problem/G2

题目大意：
这是这个问题的难点。唯一不同的是，在这个版本中，ai≤10^9。
对于给定的 n 个整数序列 a，一个三元组(i,j,k)被称为 magic，如果:
- 1≤i, j, k≤n。
- i j k 是两两不同的。
存在正整数 b 使得 ai·b=aj 且 aj·b=ak。
Kolya 收到了一个整数序列 a 作为礼物，现在想要为它计算魔法三元组的数量。帮他完成这个任务!
注意，整数 i, j 和 k 的顺序没有限制。

设 M=maxai，显然 M≤10^9,cnt[x] 数字 x 在数组 a 中出现的次数。
另外，让我们计算 b=1 的神奇三元组的个数。这样的三元组的总数为 ∑ni=1(cnt[ai]−1)⋅(cnt[ai]−2)。
接下来，我们计算 b≥2。我们对 aj 进行迭代，如果 aj≥M^2/3，则 aj·b=ak≤M，则 b≤M^1/3。否则，aj≤M^2/3，因为 ai·b=aj，那么 b 是 aj 的一个约数，这意味着将数字 aj 的约数迭代为 b 就足够了，
这些数字的约数可以找到 O(M^1/3)，这意味着如果你使用哈希表 cnt[x]，总复杂度将是 O(n·M^1/3·logn)，如果你使用 std::map，总复杂度将是 O(n·M^1/3·logn)。
======

input
7
5
1 7 7 2 7
3
6 2 18
9
1 2 3 4 5 6 7 8 9
4
1000 993 986 179
7
1 10 100 1000 10000 100000 1000000
8
1 1 2 2 4 4 8 8
9
1 1 1 2 2 2 4 4 4
output
6
1
3
0
9
16
45
 */
