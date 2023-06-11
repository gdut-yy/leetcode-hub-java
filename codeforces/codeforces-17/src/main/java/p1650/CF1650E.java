package p1650;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1650E {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, d, a));
        }
    }

    private static String solve(int n, int d, int[] a) {
        int min = d;
        int minPos = 0;
        for (int i = 1; i <= n; i++) {
            int interval = a[i] - a[i - 1] - 1;
            if (min > interval) {
                min = interval;
                minPos = i;
            }
        }

        List<Integer> schedule = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (i != minPos) {
                schedule.add(a[i]);
            }
        }

        int max = cnt(n, d, schedule);
        if (minPos - 1 >= 0) {
            schedule.set(minPos - 1, a[minPos]);
        }
        max = Math.max(max, cnt(n, d, schedule));
        return String.valueOf(max);
    }

    private static int cnt(int n, int d, List<Integer> schedule) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int interval = schedule.get(i) - schedule.get(i - 1) - 1;
            max = Math.max(max, interval);
            min = Math.min(min, interval);
        }
        return Math.min(min, Math.max(d - schedule.get(schedule.size() - 1) - 1, (max - 1) / 2));
    }
}
/*
E. Rescheduling the Exam
https://codeforces.com/contest/1650/problem/E

题目大意：
给定整数 n, d 和长度为 n 的数组 a。有 n 门考试，持续 d 天。可以将任何一个考试移动到任意一天，u 为所有间隔的最小值，求 u 的最大值。

对每个考试有两种选择：放到间隔最大的中间 (max-1)/2；放到课程最后 d-a[n]-1；
======

input
9

3 12
3 5 9

2 5
1 5

2 100
1 2

5 15
3 6 9 12 15

3 1000000000
1 400000000 500000000

2 10
3 4

2 2
1 2

4 15
6 11 12 13

2 20
17 20
output
2
1
1
2
99999999
3
0
1
9
 */

