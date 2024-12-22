package p1187;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1187B {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static char[] s;

    public static void main(String[] args) {
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer>[] pos = new ArrayList[26];
        Arrays.setAll(pos, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            pos[s[i] - 'a'].add(i);
        }

        int m = scanner.nextInt();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            s = scanner.next().toCharArray();

            int mx = 0;
            int[] cnt = new int[26];
            for (char c : s) {
                int b = c - 'a';
                mx = Math.max(mx, pos[b].get(cnt[b]));
                cnt[b]++;
            }
            ans[i] = mx + 1;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
B. Letters Shop
https://codeforces.com/contest/1187/problem/B

灵茶の试炼 2024-10-07
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的字符串 s，只包含小写英文字母。
然后输入 m(1≤m≤5e4) 和 m 个询问，每个询问输入一个长度 ≤2e5 字符串 t，只包含小写英文字母。
保证所有 t 的长度之和 ≤2e5。
对于每个询问，输出 s 的最短前缀长度，这个前缀包含一个子序列 p，允许交换 p 中的字母，使得 p = t。
保证答案一定存在。

rating 1300
记录 s 的第 1,2,3,... 个 a 的位置，第 1,2,3,... 个 b 的位置，第 1,2,3,... 个 c 的位置，依此类推。
对于每个询问，统计 t 的每种字母的个数，从而求出 a,b,c,... 这些字母在 s 中的位置，取其中最大值，加一得到答案。
代码 https://codeforces.com/problemset/submission/1187/284021375
======

Input
9
arrayhead
5
arya
harry
ray
r
areahydra
Output
5
6
5
2
9
 */
