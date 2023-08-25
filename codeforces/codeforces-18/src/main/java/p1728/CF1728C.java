package p1728;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1728C {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] small = new int[10];
        Map<Integer, Integer> big = new HashMap<>();
        for (int v : a) {
            if (v < 10) {
                small[v]++;
            } else {
                big.put(v, big.getOrDefault(v, 0) + 1);
            }
        }
        for (int v : b) {
            if (v < 10) {
                small[v]--;
            } else {
                big.put(v, big.getOrDefault(v, 0) - 1);
            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : big.entrySet()) {
            int v = entry.getKey(), c = entry.getValue();
            ans += Math.abs(c);
            int k = 0;
            while (v > 0) {
                k++;
                v /= 10;
            }
            small[k] += c;
        }
        for (int i = 2; i < 10; i++) {
            ans += Math.abs(small[i]);
        }
        return String.valueOf(ans);
    }
}
/*
C. Digital Logarithm
https://codeforces.com/contest/1728/problem/C

灵茶の试炼 2023-08-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和两个长为 n 的数组 a b (1≤a[i],b[i]<1e9)。
每次操作，把其中一个数组的一个元素替换成这个数的十进制长度。比如 123 替换成 3。
若干次操作后，将 a 和 b 排序，要求所有 a[i]=b[i]。
输出最小操作次数。

https://codeforces.com/problemset/submission/1728/217090588
注意到所有元素都 < 1e9，这意味着把一个数字替换一次，一定会得到一个 < 10 的数，替换两次，一定会得到 1。
那么先把 a 和 b 中 >= 10 的数求交集，这些交集中的数无需替换，直接忽略，其余数字都需要替换。
替换后，所有数都 < 10 了，把 >= 2 的数求交集，这些交集中的数无需替换，直接忽略，其余数字都需要替换。
再次替换后，a 中 1 的个数一定等于 b 中 1 的个数。程序结束。
所以只需要考虑两个问题：>= 10 的不在交集的数的个数，以及（替换后）>= 2 的不在交集的数的个数。
======

input
4
1
1
1000
4
1 2 3 4
3 1 4 2
3
2 9 3
1 100 9
10
75019 709259 5 611271314 9024533 81871864 9 3 6 4865
9503 2 371245467 6 7 37376159 8 364036498 52295554 169
output
2
0
2
18
 */
