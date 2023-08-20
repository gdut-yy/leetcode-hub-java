package p1718;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1718A2 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = n, xor = 0;
        Set<Integer> has = new HashSet<>();
        has.add(0);
        for (int v : a) {
            xor ^= v;
            if (has.contains(xor)) {
                ans--;
                has.clear();
                has.add(xor);
            } else {
                has.add(xor);
            }
        }
        return String.valueOf(ans);
    }
}
/*
A2. Burenka and Traditions (hard version)
https://codeforces.com/contest/1718/problem/A2

灵茶の试炼 2023-01-05
题目大意：
输入 t(≤500) 表示 t 组数据，每组数据输入 n(≤1e5) 和长为 n 的数组 a (0≤a[i]<2^30)。
所有数据的 n 之和不超过 1e5。
每次操作你可以把 a 的下标从 L 到 R 的元素都异或一个数，花费为 ceil((R-L+1)/2)。
输出把 a 的所有元素都变成 0 的最小代价。

https://codeforces.com/contest/1718/submission/187981040
提示 1：ceil((R-L+1)/2) 有什么性质？
提示 2：对一个长为 4 的子数组操作，相当于对两个长为 2 的子数组操作；对一个长为 3 的子数组操作，相当于对一个长为 2 和一个长为 1 的子数组操作。换句话说，可以只有长为 1 和 2 的操作。
提示 3：如果有一个子数组的异或和为 0，那么可以用若干长为 2 的子数组来操作，这样花费是长度-1。
提示 4：答案是 n - 异或和为 0 的不相交子数组的个数。
代码实现时可以用前缀和+哈希表快速判断。
为了保证不相交，在遇到相同前缀和时，需要把哈希表重置为 {0}，前缀和重置为 0。
也可以重置为 {xor}，这样前缀和无需重置。
======

input
7
4
5 5 5 5
3
1 3 2
2
0 0
3
2 5 7
6
1 2 3 3 2 1
10
27 27 34 32 2 31 23 56 52 4
5
1822 1799 57 23 55
output
2
2
0
2
4
7
4
 */
