package p626;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF626F {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);
    private static final long[][][] memo = new long[200][101][1001];

    private static String solve() {
        Arrays.sort(a, 0, n);

//        memo = new long[200][101][1001];
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        long ans = dfs(n - 1, 0, k);
        return String.valueOf(ans);
    }

    private static long dfs(int i, int groups, int leftK) {
        if (leftK < 0 || groups > i + 1) { // groups > i+1 说明剩余数字不够组成最小值
            return 0;
        }
        if (i < 0) {
            if (groups == 0) {
                return 1;
            }
            return 0;
        }
        if (memo[i][groups][leftK] != -1) {
            return memo[i][groups][leftK];
        }

        int newLeftK = leftK - (a[i + 1] - a[i]) * groups;
        long res = dfs(i - 1, groups + 1, newLeftK); // a[i] 作为最大值
        res += dfs(i - 1, groups, newLeftK) * (groups + 1); // 不参与最大最小：从 groups 中选一个组   这里 +1 是只有一个数的组的方案数
        if (groups > 0) {
            res += dfs(i - 1, groups - 1, newLeftK) * groups; // a[i] 作为最小值：从 groups 中选一个组
        }
        res %= MOD; // 记忆化
        return memo[i][groups][leftK] = res;
    }
}
/*
F. Group Projects
https://codeforces.com/contest/626/problem/F

灵茶の试炼 2023-06-30
题目大意：
输入 n(1≤n≤200) k(0≤k≤1000) 和长为 n 的数组 a(1≤a[i]≤500)。
有 n 个人，第 i 个人的能力值为 a[i]。
把这 n 个人分成若干组，一个组的不平衡度定义为组内最大值减最小值。
特别地，如果组内只有一个人，那么不平衡度为 0。
要求所有组的不平衡度之和不超过 k。
有多少种分组方案？模 1e9+7。
注：一个组是 a 的子序列，不要求连续。

rating 2400
先排序。
提示 1：把作为最小值的数看成左括号，作为最大值的数看成右括号。由于作为最小值的个数不能低于作为最大值的个数，所以这和括号问题是相似的，可以用解决括号问题的技巧来思考。
提示 2：如何优雅地计算不平衡度呢？假设从小到大有 a b c d 四个数，选了 a c d，那么 d-a = (d-c) + (c-b) + (b-a)。注意这里算上了没有选的 b。
这意味着我们只需要考虑相邻两个数对不平衡度的影响。
提示 3：记忆化搜索，我的实现是从 n-1 开始，递归到 -1。先选最大值，再选最小值。
定义 dfs(i, groups, leftK) 表示前 i 个数中，有最大值但是尚未确定最小值的组有 groups 个，剩余不平衡度为 leftK。
需要考虑四种情况：
1. a[i] 作为一个新的组的最大值（创建一个新的组）。
2. a[i] 作为某个组的最小值（有 groups 种选择方案）。
3. a[i] 单独形成一个组（这个组只有一个数）。
4. a[i] 添加到某个组中（有 groups 种选择方案）。
具体见代码 https://codeforces.com/contest/626/submission/211471819
注：这题用到的思路和我在【1681. 最小不兼容性】这题评论区发的代码是类似的
https://leetcode.cn/problems/minimum-incompatibility/discussion/comments/2051770
======

input
3 2
2 4 5
output
3

input
4 3
7 8 9 10
output
13

input
4 0
5 10 20 21
output
1
 */
