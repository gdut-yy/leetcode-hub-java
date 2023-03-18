package p1525;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1525D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        // 结论：这些人的相对顺序不会改变，交叉移动的方案不会更优
        List<Integer> seats = new ArrayList<>();
        List<Integer> peoples = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 0/1
            if (a[i] == 0) {
                seats.add(i);
            } else {
                peoples.add(i);
            }
        }
        // m 个人
        int m = peoples.size();

        // f[i][j] 表示考虑前 i 把椅子坐前 j 个人的最小耗时之和
        // 0-1 背包优化
        int[] f = new int[m + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;
        for (int i : seats) {
            for (int j = m - 1; j >= 0; j--) {
                f[j + 1] = Math.min(f[j + 1], f[j] + Math.abs(i - peoples.get(j)));
            }
        }
        return String.valueOf(f[m]);
    }
}
/*
D. Armchairs
https://codeforces.com/contest/1525/problem/D

灵茶の试炼 2023-03-03
题目大意：
给定整数 n 和长度为 n 的数组 a。编号 1 ~ n。其中 a[i] 只有 0/1。保证 1 的数量不大于 n/2。
a[i] = 0 表示位置 i 处有一把椅子，a[i] = 1 表示位置 i 处有一个人。
一把椅子只能坐一个人。
一个人从 i 移动到 j 的耗时为 abs(i-j)。
问让人们从他们的扶手椅上挪到其他椅子上，所有人的耗时之和最小是多少？

https://codeforces.com/contest/1525/submission/195527208
提示 1：贪心地想，最后一个人坐的椅子一定在其它人的右边（如果不是这样，交叉移动是不会更优的）。
提示 2：统计椅子和人的坐标。考虑前 i 把椅子坐前 j 个人的最小耗时和，记作 f[i][j]。
提示 3：第 i 把椅子不选，f[i-1][j]；选，f[i-1][j-1] + abs(chair[i]-people[j])
因此 f[i][j] = min(f[i-1][j], f[i-1][j-1] + abs(chair[i]-people[j]))
注意可以像 0-1 背包那样空间优化 + 倒序遍历。
相似题目: 2463. 最小移动总距离
https://leetcode.cn/problems/minimum-total-distance-traveled/
======

input
7
1 0 0 1 0 0 1
output
3

input
6
1 1 1 0 0 0
output
9

input
5
0 0 0 0 0
output
0
 */
