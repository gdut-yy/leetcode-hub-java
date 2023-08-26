package c091;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arc091_c {
    static int n, a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        if (a + b - 1 > n || (long) a * b < n) {
            return "-1";
        }
        int i = 0;
        a--;
        List<Integer> ans = new ArrayList<>();
        while (a >= 0) {
            int sz = Math.min(b, n - a);
            for (int j = i + sz; j > i; j--) {
                ans.add(j);
            }
            i += sz;
            n -= sz;
            a--;
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E - LISDL
https://atcoder.jp/contests/arc091/tasks/arc091_c

灵茶の试炼 2022-12-14
题目大意：
输入 n a b (≤3e5)。
构造一个 1~n 的排列，其 LIS 的长度为 a，LDS 的长度为 b。
如果不存在这样的排列，输出 -1，否则输出任意一个满足要求的排列。
注：LIS 指最长上升子序列，LDS 指最长下降子序列。

https://atcoder.jp/contests/arc091/submissions/37259778
手玩一下发现可以这样构造：
n=10 a=3 b=4
答案 = 4 3 2 1 8 7 6 5 10 9
n=10 a=4 b=5
答案 = 5 4 3 2 1 8 7 6 9 10
注意构造时，要为后面预留足够的数字，使得 LIS 的长度可以为 a。
从这里可以发现，如果 a+b-1 > n，则一个递增和递减都无法满足；
或者 a*b<n，构造 a 个长为 b 的递减也无法满足。
这两种都要输出 -1。
======

Input 1
5 3 2
Output 1
2 4 1 5 3

Input 2
7 7 1
Output 2
1 2 3 4 5 6 7

Input 3
300000 300000 300000
Output 3
-1
 */