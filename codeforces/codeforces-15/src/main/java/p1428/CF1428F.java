package p1428;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1428F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        int cnt1 = 0;

        int[] lastIdx = new int[n + 1];
        Arrays.fill(lastIdx, -1);

        long ans = 0L, sum = 0L;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt1++;
                sum += i - lastIdx[cnt1];
            } else {
                while (cnt1 > 0) {
                    lastIdx[cnt1] = i - cnt1;
                    cnt1--;
                }
            }
            ans += sum;
        }
        return String.valueOf(ans);
    }
}
/*
F. Fruit Sequences
https://codeforces.com/contest/1428/problem/F

灵茶の试炼 2023-04-28
题目大意：
输入 n(1≤n≤5e5) 和长为 n 的字符串 s，只包含 '0' 和 '1'。
定义 f(t) 为 t 中最长连续 '1' 的长度。（如果 t 中没有 ‘1’，f(t)=0）
枚举 s 的所有子串 t，输出 f(t) 的和。

rating 2400
https://codeforces.com/contest/1428/submission/203608811
增量法。
定义 last[ones] 表示上一次出现连续 ones 个 1 的起始位置。
定义 sum 表示以 s[i] 结尾的字符串的 f(t) 之和。答案就是一边遍历 s，一边累加 sum。
于是重点关注 sum 是怎么变的。从 s[i-1] 到 s[i]，sum 增加了多少。
维护到 s[i] 连续出现了 ones 个 1。
如果 s[i] 是 1，考察 last[ones]。右端点为 i，左端点大于 last[ones] 的子串的 f 值都增加了 1，所以 sum 增加了 i-last[ones]。
如果 s[i] 是 0，那么连续 1 中断了，在此时去更新 last[1], last[2], last[3], ..., last[ones]。为什么 s[i]=1 的时候不更新？那样时间复杂度是 O(n^2) 的，在 s[i]=0 时更新是均摊 O(1)。
相似题目: 2262. 字符串的总引力
https://leetcode.cn/problems/total-appeal-of-a-string/
======

input
4
0110
output
12

input
7
1101001
output
30

input
12
011100011100
output
156
 */
