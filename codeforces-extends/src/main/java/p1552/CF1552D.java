package p1552;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1552D {
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

    // 判断 a 中是否存在两个子集，其子集和相等就行了
    private static String solve(int n, int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int mask = 0; mask < 1 << n; mask++) {
            int sum = 0;
            for (int k = 0; k < n; k++) {
                if ((mask >> k & 1) == 1) {
                    sum += a[k];
                }
            }
            if (set.contains(sum)) {
                return "YES";
            } else {
                set.add(sum);
            }
        }
        return "NO";
    }
}
/*
D. Array Differentiation
https://codeforces.com/contest/1552/problem/D

灵茶の试炼 2023-03-01
题目大意：
输入 t(≤20) 表示 t 组数据，每组数据输入 n(≤10) 和长为 n 的数组 a(-1e5≤a[i]≤1e5)。
如果存在一个长为 n 的数组 b，对于任意 i，都存在 j 和 k，使得 a[i]=b[j]-b[k]，则输出 YES，否则输出 NO。
注意 j 可以等于 k。

判断 a 中是否存在两个子集，其子集和相等就行了
证明见题解：
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1552d
======

input
5
5
4 -7 -1 5 10
1
0
3
1 10 100
4
-3 2 10 2
9
25 -171 250 174 152 242 100 -205 -258
output
YES
YES
NO
YES
YES
 */
