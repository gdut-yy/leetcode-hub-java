package p1734;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1734C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        char[] cs = s.toCharArray();
        long[] cost = new long[n];
        // 倍数 k
        for (int k = 1; k <= n; k++) {
            // 隔 k 个删，直到遇到 '1'
            for (int i = k; i <= n; i += k) {
                if (cs[i - 1] == '0') {
                    // 记录最小值
                    if (cost[i - 1] == 0) {
                        cost[i - 1] = k;
                    }
                } else {
                    break;
                }
            }
        }
        return String.valueOf(Arrays.stream(cost).sum());
    }
}
/*
C. Removing Smallest Multiples
https://codeforces.com/contest/1734/problem/C

题目大意：
给定一个集合 S，它包含前 n 个正整数:1,2,...,n。
您可以对 S 执行以下操作任意次数(可能为零):
- 选取 1≤k≤n 的正整数 k，使得 S 中存在 k 的倍数。然后，从 S 中删除 k 的最小倍数。这个操作需要 k 的代价。
给定一个集合 T，它是 S 的一个子集。求出使 S 转化为 T 的最小操作总成本。我们可以证明这样的变换总是可能的。
---
每个测试用例的第二行包含一个长度为 n 的二进制字符串，描述集合 T。当且仅当 i 是 T 的元素时，字符串的第 i 个字符为'1'，否则为'0'。

贪心。从 1 开始枚举。
时间复杂度 O(nlogn) 无穷级数
======

input
6
6
111111
7
1101001
4
0000
4
0010
8
10010101
15
110011100101100
output
0
11
4
4
17
60
 */
