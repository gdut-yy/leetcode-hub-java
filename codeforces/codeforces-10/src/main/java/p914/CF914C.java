package p914;

import java.util.Arrays;
import java.util.Scanner;

public class CF914C {
    static char[] s;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);
    static int[][] memo;

    private static String solve() {
        // 注意特判
        if (k == 0) return "1";
        if (k == 1) return String.valueOf(s.length - 1);

        int n = s.length;
        memo = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        long ans = 0;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[Integer.bitCount(i)] + 1;
            if (f[i] == k) {
                ans += f(0, i, true);
            }
        }
        return String.valueOf(ans % MOD);
    }

    static int f(int i, int left1, boolean isLimit) {
        if (i == s.length) {
//            return !isLimit && left1 == 0 ? 1 : 0; // 小于 n, 加上 !isLimit
            return left1 == 0 ? 1 : 0;
        }
        if (!isLimit && memo[i][left1] != -1) return memo[i][left1];
        int res = 0;
        int up = isLimit ? s[i] - '0' : 1;
        for (int d = 0; d <= Math.min(up, left1); d++) {
            res += f(i + 1, left1 - d, isLimit && d == up);
            res %= MOD;
        }
        if (!isLimit) {
            memo[i][left1] = res;
        }
        return res;
    }
}
/*
C. Travelling Salesman and Special Numbers
https://codeforces.com/contest/914/problem/C

灵茶の试炼 2024-10-16
题目大意：
旅行推销员花了很多时间旅行，因此他容易感到无聊。为了打发时间，他喜欢对数字进行运算。其中一种运算是将正整数 x 简化为二进制表示 x 中设置为 1 的位数。例如，对于数字 13 来说， 13_10=1101_2 是正确的，因此它有 3 位，而 13 将在一次运算中还原为 3 。
如果将一个数还原为 1 所需的最少运算次数是 k ，那么他就称这个数为特殊数。
他想知道有多少个不大于 n 的特殊数。请帮助这位旅行推销员，因为他即将到达目的地！
由于答案可能很大，请输出 10^9+7 的模数。
---
输入二进制数 s，范围 1≤s<2^1000，不含前导零。
然后输入 k(0≤k≤1000)。
定义 f(x) 为 x 的二进制表示中的 1 的个数。
定义 f*(x) 为使 f(f(...f(x))) = 1 的最少嵌套（迭代）次数。也就是不断地把 x 更新为 f(x)，最少要更新多少次，才能使 x 变成 1。
例如 f*(6) = 2，因为 f(f(6)) = f(2) = 1。
输出 [1,s] 中有多少个数 x 满足 f*(x) = k。
答案模 1e9+7。
押题成功！2024.11.10 周赛第四题

rating 1800
根据定义，我们有
f*(x) = f*(f(x)) + 1
从小到大递推，即可算出 1 ~ len(s) 的所有 f*(x) 值。
对于满足 f*(x) = k-1 的所有 x，我们需要计算，[1,s] 中有多少个二进制数，恰好有 x 个 1？
这些恰好有 x 个 1 的二进制数，满足 f*(x) = k。
用数位 DP 解决。
特判：k=0 时返回 1，因为 1 无需操作。
特判：k=1 时返回 len(s) - 1，因为 10,100,1000,... 这些数都只需操作 1 次。
代码实现时，可以定义 f*(1) = 1，上文中 f*(x) == k-1 的判断可以简化为 f*(x) == k。
https://codeforces.com/contest/914/submission/284516934
相似题目: 3352. 统计小于 N 的 K 可约简整数
https://leetcode.cn/problems/count-k-reducible-numbers-less-than-n/description/
======

Input
110
2
Output
3

Input
111111011
2
Output
169

100011110011110110100
7

110100110
0
 */
