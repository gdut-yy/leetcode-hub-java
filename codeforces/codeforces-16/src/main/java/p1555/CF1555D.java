package p1555;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1555D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        // 预处理
        pretreatment(n, s);

        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(solve(n, l, r));
        }
    }

    private static final String[] PERM3 = {"abc", "acb", "bac", "bca", "cab", "cba"};

    private static int[][] preSums;

    private static void pretreatment(int n, String s) {
        preSums = new int[6][n + 1];
        for (int i = 0; i < PERM3.length; i++) {
            for (int j = 0; j < n; j++) {
                preSums[i][j + 1] = preSums[i][j] + (s.charAt(j) != PERM3[i].charAt(j % 3) ? 1 : 0);
            }
        }
    }

    private static String solve(int n, int l, int r) {
        int ans = n;
        for (int[] preSum : preSums) {
            ans = Math.min(ans, preSum[r] - preSum[l - 1]);
        }
        return String.valueOf(ans);
    }
}
/*
D. Say No to Palindromes
https://codeforces.com/contest/1555/problem/D

灵茶の试炼 2023-04-05
题目大意：
输入 n(≤2e5) m(≤2e5) 和长为 n 的字符串 s，仅包含小写字母 'a' 'b' 'c'，下标从 1 开始。
然后输入 m 个询问，每个询问输入 L R(1≤L≤R≤n)。
对每个询问，要使 s[L] 到 s[R] 中没有长度大于等于 2 的回文子串，至少需要修改多少个字符？注意你只能使用 'a' 'b' 'c' 来修改。
每个询问是独立的，即修改操作不影响其他询问。

rating 1600
https://codeforces.com/contest/1555/submission/130420793
手玩一下发现只能由 abc 的某个排列重复多次，才能没有长度大于等于 2 的回文子串。
所以预处理 abc 的 6 种排列对应的修改次数的前缀和，就可以 O(1) 回答每个询问了。
======

input
5 4
baacb
1 3
1 5
4 5
2 3
output
1
2
0
1
 */
