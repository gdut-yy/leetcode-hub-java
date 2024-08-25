package p1677;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1677B {
    static int n, m;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        boolean[] col = new boolean[m];
        int col1 = 0;
        int window1 = 0;
        int[] f = new int[m];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '1' && !col[i % m]) {
                col[i % m] = true;
                // 多了一个有 1 的列
                col1++;
            }
            window1 += c & 1;
            if (i >= m) {
                window1 -= s.charAt(i - m) & 1;
            }
            // 最新进来的 m 个人中有 1
            if (window1 > 0) {
                // 本质是 f[i] = f[i-m] + 1，但可以用长为 m 的数组滚动
                f[i % m]++;
            }
            ans.add(col1 + f[i % m]);
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Tokitsukaze and Meeting
https://codeforces.com/contest/1677/problem/B

灵茶の试炼 2023-08-02
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n*m 之和 ≤1e6。
每组数据输入 n m(1≤n*m≤1e6) 和长为 n*m 的 01 字符串 s。
有 n*m 个人参加会议，会议厅的座位有 n 行 m 列。
从第一个人开始，依次入场。规则如下：
有人入场时，已入场的人同时向右移动一位，最右的人移动到下一行的最左边。（见样例一）
第 i 个人标记为 s[i]。
输出 n*m 个数，其中第 i 个数表示：第 i 个人入场后，有多少行和列包含至少一个 1？

rating 1700
https://codeforces.com/contest/1677/submission/216653925
好题！迷你，精巧，还同时考察了多个知识点。
先说列怎么统计：
提示 1：从「不变量」入手思考：第 i 个人总是和第 i-m,i-2m,i-3m,... 个人在同一列。
提示 2：如果 i-m,i-2m,i-3m,... 中没有 1，那么当 s[i]=1 入场，从这一刻开始，包含至少一个 1 的列的数量永久增加 1。
然后说行怎么统计：
提示 1：考虑第 i 个人入场时，包含至少一个 1 的行的数量。这等于「第 i-m 个人入场时，包含至少一个 1 的行的数量」加上「最新入场的这 m 个人中是否有 1」。
提示 2：滑动窗口维护「最新入场的这 m 个人中的 1 的个数」，记作 window1。
DP 维护「第 i 个人入场时，包含至少一个 1 的行的数量」，即
f[i] = f[i-m] + (window1 > 0)
这个转移方程可以滚动优化成 f[i%m] += window1 > 0，从而避免讨论 i<m 的情况（此时 i-m 是负数）。
======

input
3
2 2
1100
4 2
11001101
2 4
11001101
output
2 3 4 3
2 3 4 3 5 4 6 5
2 3 3 3 4 4 4 5
 */
