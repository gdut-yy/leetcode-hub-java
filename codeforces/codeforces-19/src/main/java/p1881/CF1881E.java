package p1881;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1881E {
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

    static int[] memo;

    private static String solve() {
        memo = new int[n];
        Arrays.fill(memo, -1);
        int ans = dfs(0);
        return String.valueOf(ans);
    }

    static int dfs(int i) {
        if (i == n) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        // 不选
        int res = dfs(i + 1) + 1;
        // 选
        if (i + 1 + a[i] <= n) {
            res = Math.min(res, dfs(i + 1 + a[i]));
        }
        return memo[i] = res;
    }
}
/*
E. Block Sequence
https://codeforces.com/contest/1881/problem/E

灵茶の试炼 2024-11-05
题目大意：
给定一个长度为 n 的整数序列 a。
如果序列具有一系列块的形式，则称为美丽序列，每个块从其长度开始，即首先是块的长度，然后是其元素。例如，序列[3,3,4,5,2,6,1]和[1,8,4,5,2,6,1]是漂亮的(不同的块颜色不同)，而[1]，[1,4,3]，[3,2,1]不是。
在一次操作中，您可以从序列中删除任何元素。使给定序列美观所需的最小操作次数是多少?

记忆化搜索。选 或 不选
======

input
7
7
3 3 4 5 2 6 1
4
5 6 3 2
6
3 4 1 6 7 7
3
1 4 3
5
1 2 3 4 5
5
1 2 3 1 2
5
4 5 5 1 5
output
0
4
1
1
2
1
0
 */