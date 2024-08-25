package p382;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class CF382C {
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
        Arrays.sort(a);

        // 无穷多个
        if (n == 1) {
            return "-1";
        }
        // 2/3 个解
        if (n == 2) {
            int d = a[1] - a[0];
            // 易错
            if (d == 0) {
                return "1" + System.lineSeparator() + a[0];
            }
            if ((d & 1) == 0) {
                return "3" + System.lineSeparator() + (a[0] - d) + " " + (a[0] + d / 2) + " " + (a[1] + d);
            } else {
                return "2" + System.lineSeparator() + (a[0] - d) + " " + (a[1] + d);
            }
        }

        // 统计差值频次
        TreeMap<Integer, Integer> dTreeMap = new TreeMap<>();
        for (int i = 1; i < n; i++) {
            int d = a[i] - a[i - 1];
            dTreeMap.put(d, dTreeMap.getOrDefault(d, 0) + 1);
        }
        // 无解情况
        // 1 2 4 6 {1:1, 2:2}
        // 1 2 7 {1:1, 5:1}
        // 1 2 4 7 {1:1, 2:1, 3:1}
        if (dTreeMap.size() > 2
                || dTreeMap.size() == 2 && dTreeMap.firstKey() * 2 != dTreeMap.lastKey()
                || dTreeMap.size() == 2 && dTreeMap.lastEntry().getValue() > 1) {
            return "0";
        }
        // 2 个解（一头一尾）
        if (dTreeMap.size() == 1) {
            int d = dTreeMap.firstKey();
            // 易错
            if (d == 0) {
                return "1" + System.lineSeparator() + a[0];
            }
            return "2" + System.lineSeparator() + (a[0] - d) + " " + (a[n - 1] + d);
        }
        // 1 个解
        int d1 = dTreeMap.firstKey();
        int d2 = dTreeMap.lastKey();
        for (int i = 1; i < n; i++) {
            int d = a[i] - a[i - 1];
            if (d == d2) {
                return "1" + System.lineSeparator() + (a[i - 1] + d1);
            }
        }

        return "NA";
    }
}
/*
C. Arithmetic Progression
https://codeforces.com/contest/382/problem/C

灵茶の试炼 2023-03-29
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的整数数组 a(1≤a[i]≤1e8)。
请你往 a 中添加恰好一个整数 x，使得 a 排序后是一个等差数列。
输出 x 的个数，以及所有的 x（按升序输出）。
如果 x 有无穷多个，输出 -1。

rating 1700
https://codeforces.com/problemset/submission/382/199610473
分类讨论，样例基本上把所有情况都列出来了，具体见代码注释。
======

input
3
4 1 7
output
2
-2 10

input
1
10
output
-1

input
4
1 3 5 9
output
1
7

input
4
4 3 4 5
output
0

input
2
2 4
output
3
0 3 6
 */
