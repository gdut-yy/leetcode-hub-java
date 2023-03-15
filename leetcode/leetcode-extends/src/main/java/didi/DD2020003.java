package didi;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DD2020003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, m, s));
    }

    private static String solve(int n, int m, String s) {
        char[] chars = s.toCharArray();

        int min = Integer.MAX_VALUE;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int idx = 0;
            int opt = 0;
            while (idx < n) {
                if (chars[idx] == ch) {
                    idx++;
                } else {
                    idx += m;
                    opt++;
                }
            }
            min = Math.min(min, opt);
        }
        return String.valueOf(min);
    }
}
/*
DD-2020003. 地砖染色
https://leetcode.cn/problems/qfOSVR/

沿着长 N 米、宽 1 米的走廊，连续铺有 N 块边长为 1 米的正方形地砖。假设所有颜色分为 26 种，用小写字母 a 到 z 表示，给定 N 块地砖的初始颜色，
每次可以选择一种颜色，然后将最多M块连续的地砖染成该颜色。那么至少要进行多少次染色，才能将所有地砖染成同一颜色?
格式：
输入：
- 第一行输入两个整数 N 和 M。
- 第二行输入由 N 个小写字母组成的字符串，描述 N 块地砖的初始颜色，相邻的两个小写字母代表相邻的两块地砖。
输出：
- 输出将所有地砖染成同一颜色的最少染色次数。
示例：
输入：
5 3
abcba
输出：1
提示：
1 ≤ M ≤ N ≤ 10^4
 */