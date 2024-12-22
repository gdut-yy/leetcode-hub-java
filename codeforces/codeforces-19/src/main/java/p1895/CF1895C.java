package p1895;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1895C {
    static int n;
    static List<String>[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new ArrayList[6];
        Arrays.setAll(a, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            a[s.length()].add(s);
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if ((i + j) % 2 > 0) {
                    continue;
                }
                int m = (i + j) / 2;
                int[] cnt = new int[100];
                for (String s : a[i]) {
                    int sum = 50;
                    for (int k = 0; k < s.length(); k++) {
                        char b = s.charAt(k);
                        if (k < m) {
                            sum += b - '0';
                        } else {
                            sum -= b - '0';
                        }
                    }
                    cnt[sum]++;
                }
                for (String s : a[j]) {
                    int sum = 50;
                    for (int k = 0; k < s.length(); k++) {
                        char b = s.charAt(k);
                        if (i + k < m) {
                            sum -= b - '0';
                        } else {
                            sum += b - '0';
                        }
                    }
                    ans += cnt[sum];
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Torn Lucky Ticket
https://codeforces.com/contest/1895/problem/C

灵茶の试炼 2024-09-09
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的字符串数组 a，每个字符串的长度均在 [1,5] 内，且只包含数字字符 '1'~'9'。
定义【好字符串】满足：偶数长度，且左半的数字之和等于右半的数字之和。
输出有多少对 (i,j) 满足 a[i]+a[j] 是好字符串。
注意 i 和 j 的大小没有限制，i<j，i=j，i>j 都可以。

rating 1400
本题 i 和 j 的大小没有限制，相比【枚举右，维护左】的做法，下面的做法更简单。
1. 把字符串按照长度分组。
2. 枚举 a[i] 的长度 N，以及 a[j] 的长度 M。只考虑 N + M 是偶数的情况。
3. 设 mid = (N + M) / 2。
4. 计算 a[i] 的数字和：遍历 a[i]，加上下标 < mid 的数字，减去下标 >= mid 的数字。（下标从 0 开始）
5. 用一个名为 cnt 的数组或 map 统计 a[i] 的数字和及出现次数。
6. 计算 a[j] 的数字和：遍历 a[j]，减去 (N + 下标) < mid 的数字，加上 (N + 下标) >= mid 的数字。（下标从 0 开始）
7. 去 cnt 中找有多少个 a[i] 能与 a[j] 匹配（数字和相等），加入答案。
代码 https://codeforces.com/contest/1895/submission/280007302
======

Input
10
5 93746 59 3746 593 746 5937 46 59374 6
Output
20

Input
5
2 22 222 2222 22222
Output
13

Input
3
1 1 1
Output
9
 */
