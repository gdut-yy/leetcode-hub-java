package p1304;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1304D {
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
        int m = s.length();
        char[] cs = s.toCharArray();

        // LIS 最短
        int[] ans1 = new int[n];
        int up = n;
        for (int i = 0; i < m; i++) {
            if (cs[i] == '>') {
                ans1[i] = up--;
            }
        }
        int down = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (ans1[i] > 0) continue;
            int end = i;
            while (i >= 0 && ans1[i] == 0) {
                i--;
            }
            i++;
            for (int j = i; j <= end; j++) {
                ans1[j] = down++;
            }
        }

        // LIS 最长
        int[] ans2 = new int[n];
        up = n;
        for (int i = m - 1; i >= 0; i--) {
            if (cs[i] == '<') {
                ans2[i + 1] = up--;
            }
        }
        down = 1;
        for (int i = 0; i < n; i++) {
            if (ans2[i] > 0) continue;
            int end = i;
            while (i < n && ans2[i] == 0) {
                i++;
            }
            i--;
            for (int j = i; j >= end; j--) {
                ans2[j] = down++;
            }
        }

        return Arrays.stream(ans1).mapToObj(String::valueOf).collect(Collectors.joining(" "))
                + System.lineSeparator()
                + Arrays.stream(ans2).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Shortest and Longest LIS
https://codeforces.com/contest/1304/problem/D

灵茶の试炼 2023-03-13
题目大意：
输入 t(≤1e4) 表示 t 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n-1 的字符串 s，仅包含 '<' 和 '>'。
s[i]='<' 表示 a[i]<a[i+1]，
s[i]='>' 表示 a[i]>a[i+1]。
请构造两个 1~n 的排列，符合字符串 s，且第一个数组的 LIS 最短，第二个数组的 LIS 最长。
如果有多种构造方案，输出任意一种。
思考题：在这题的基础上，构造长度恰好为 k 的 LIS。

最短：拆分成若干上升段，那么把最大的数字分配给最左边的上升段，剩余的最大数字分配给第二个上升段，依此类推。
最长：拆分成若干下降段，那么把最小的数字分配给最左边的下降段，剩余的最小数字分配给第二个下降段，依此类推。
相似题目: $484. 寻找排列
https://leetcode.cn/problems/find-permutation/
2375. 根据模式串构造最小数字
https://leetcode.cn/problems/construct-smallest-number-from-di-string/
======

input
3
3 <<
7 >><>><
5 >>><
output
1 2 3
1 2 3
5 4 3 7 2 1 6
4 3 1 7 5 2 6
4 3 2 1 5
5 4 2 1 3

1
9 <<<><>>>

3 4 5 9 2 8 7 6 1
1 6 7 8 2 9 5 4 3
 */
