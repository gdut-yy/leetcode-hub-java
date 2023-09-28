package c321;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Abc321_b {
    static int n, x;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        x = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n - 1; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MAX_N = 105;

    private static String solve() {
        int left = 0;
        int right = MAX_N;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left == MAX_N ? -1 : left);
    }

    private static boolean checkMid(int mid) {
        a[n - 1] = mid;

        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> a[o]));

        int s = 0;
        for (int i = 1; i < n - 1; i++) {
            s += a[ids[i]];
        }
        return s >= x;
    }
}
/*
B - Cutoff
https://atcoder.jp/contests/abc321/tasks/abc321_b

题目大意：
考试的结构如下。
- 考试包括 N 轮，称为第 1 到 N 轮。
- 每一轮，你会得到一个介于 0 到 100 之间的整数分数。
- 你的最终成绩是除最高分和最低分外的 N - 2 分的总和。
  - 形式上，设 S=(s1, s2,...,sn)为每轮得分按升序排序的序列，则最终分数为 s2 + s3 + ... + sn−1。
现在，N - 1 轮考试已经结束，你在第 i 轮的分数是 a1。
如果最终成绩为 X 或更高，请在 N 轮中打印您必须获得的最低分数。
如果无论你在第 N 轮中得到什么分数，你的最终分数都不会是 X 或更高，那么就打印-1。
请注意，你在第 N 轮中的分数只能是 0 到 100 之间的整数。

======

Input 1
5 180
40 60 80 50
Output 1
70

Input 2
3 100
100 100
Output 2
0

Input 3
5 200
0 0 99 99
Output 3
-1

Input 4
10 480
59 98 88 54 70 24 8 94 46
Output 4
45
 */
