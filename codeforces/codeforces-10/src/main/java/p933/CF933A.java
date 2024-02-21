package p933;

import java.util.Scanner;

public class CF933A {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] dp = new int[5];
        for (int v : a) {
            if (v == 1) {
                dp[1]++;
                dp[2] = Math.max(dp[1], dp[2]);
                dp[3] = Math.max(dp[2], dp[3] + 1);
                dp[4] = Math.max(dp[3], dp[4]);
            } else {
                dp[2] = Math.max(dp[1], dp[2] + 1);
                dp[3] = Math.max(dp[2], dp[3]);
                dp[4] = Math.max(dp[3], dp[4] + 1);
            }
        }
        return String.valueOf(dp[4]);
    }
}
/*
A. A Twisty Movement
https://codeforces.com/contest/933/problem/A

灵茶の试炼 2022-08-31
题目大意：
输入 n (≤2000) 和一个长为 n 的数组 a，元素值只有 1 和 2。
你可以翻转 a 的一个区间（该操作执行至多一次）。
输出你能得到的最长非降子序列的长度。
子序列不要求连续。
进阶：你能做到 O(n) 吗？
扩展：元素范围在 [0,9] 的情况 http://acm.hdu.edu.cn/showproblem.php?pid=6357

rating 1800
https://codeforces.com/contest/933/submission/117023821
题目本质是将数组划分成 4 部分：11...22...11...22...，那么定义 dp[i][j] 表示前 i 个元素组成前 j 个部分的最长子序列的长度。
遍历一遍即可求出 dp[n][4]（递推式见代码），复杂度为 O(n)。
代码实现时可以用滚动数组优化。
======

input
4
1 2 1 2
output
4

input
10
1 1 2 2 2 1 1 2 2 1
output
9
 */