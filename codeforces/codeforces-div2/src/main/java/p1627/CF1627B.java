package p1627;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1627B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(solve(n, m));
        }
    }

    private static String solve2(int n, int m) {
        int x1 = 0;
        int y1 = 0;
        int x2 = n - 1;
        int y2 = m - 1;
        int[][] nums = new int[n][m];
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dis1 = (i - x1) + (j - y1);
                int dis2 = (i - x1) + (y2 - j);
                int dis3 = (x2 - i) + (j - y1);
                int dis4 = (x2 - i) + (y2 - j);
                nums[i][j] = Math.max(dis1, Math.max(dis2, Math.max(dis3, dis4)));
                resList.add(String.valueOf(nums[i][j]));
            }
        }
        Collections.sort(resList);
        return String.join(" ", resList);
    }

    private static String solve(int n, int m) {
        int x1 = 0;
        int y1 = 0;
        int x2 = n - 1;
        int y2 = m - 1;
        int[][] nums = new int[n][m];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dis1 = (i - x1) + (j - y1);
                int dis2 = (i - x1) + (y2 - j);
                int dis3 = (x2 - i) + (j - y1);
                int dis4 = (x2 - i) + (y2 - j);
                nums[i][j] = Math.max(dis1, Math.max(dis2, Math.max(dis3, dis4)));
                list.add(nums[i][j]);
            }
        }

        // List<Integer> => String
        Collections.sort(list);
        return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Not Sitting
https://codeforces.com/contest/1627/problem/B

题目大意：
给出整数 n, m 表示教室行数列数，Tina 将 k 个座位涂色，Rahul 不坐涂色的座位但会尽量接近 Tina，Tina 会尽量远离 Rahul，求 Rahul 和 Tina 之间最小距离。

贪心。Tina 必然会优先涂教室中部的座位，然后躲在角落，Rahul 必然会尽量选择教室中部的位置，譬如 5 * 5 的情况：
5 4 3 4 5
1 3 2 3 4
3 2 1 2 3
4 3 2 3 4
5 4 3 4 5
数字越小，优先级越高。
======

input
2
4 3
1 2

output
3 3 4 4 4 4 4 4 5 5 5 5
1 1
 */