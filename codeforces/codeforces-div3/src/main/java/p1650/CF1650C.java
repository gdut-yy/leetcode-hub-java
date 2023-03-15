package p1650;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1650C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            scanner.nextLine();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] xw = new int[m][2];
            for (int j = 0; j < m; j++) {
                xw[j][0] = scanner.nextInt();
                xw[j][1] = scanner.nextInt();
            }

            List<String> res = solve(n, m, xw);
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int n, int m, int[][] xw) {
        // 记录序号 1~m
        Map<Integer, Integer> xwIdxMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            xwIdxMap.put(xw[i][0], i + 1);
        }

        // 按权重升序排列
        Arrays.sort(xw, Comparator.comparingInt(o -> o[1]));
        // 权重最小的 2n 个点
        int[][] xw2n = new int[n * 2][2];
        int sum = 0;
        for (int i = 0; i < n * 2; i++) {
            xw2n[i] = xw[i];
            sum += xw[i][1];
        }
        // 按坐标升序排列
        Arrays.sort(xw2n, Comparator.comparingInt(o -> o[0]));

        List<String> resList = new ArrayList<>();
        // 第 1 行
        resList.add(String.valueOf(sum));
        // 接下来 n 行
        int left = 0;
        int right = n * 2 - 1;
        for (int i = 0; i < n; i++) {
            int lIdx = xwIdxMap.get(xw2n[left][0]);
            int rIdx = xwIdxMap.get(xw2n[right][0]);
            resList.add(lIdx + " " + rIdx);
            left++;
            right--;
        }
        return resList;
    }
}
/*
C. Weight of the System of Nested Segments
https://codeforces.com/contest/1650/problem/C

题目大意：
首行给定整数 n 和 m，后面 m 行给整数 xi 和 wi，分别为坐标和权重，要求找出 n 组线段，使权重总和最小

贪心，输出最小 2n 个点，双指针进行配对即可。
=======

input
3

3 8
0 10
-2 1
4 10
11 20
7 -1
9 1
2 3
5 -2

3 6
-1 2
1 3
3 -1
2 4
4 0
8 2

2 5
5 -1
3 -2
1 0
-2 0
-5 -3

output
12
2 6
5 1
7 8

10
1 6
5 2
3 4

-6
5 1
4 2
 */