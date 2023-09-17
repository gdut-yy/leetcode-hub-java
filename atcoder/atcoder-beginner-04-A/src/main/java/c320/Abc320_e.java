package c320;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc320_e {
    static int n, m;
    static int[][] tws;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        tws = new int[m][3];
        for (int i = 0; i < m; i++) {
            tws[i][0] = scanner.nextInt();
            tws[i][1] = scanner.nextInt();
            tws[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        PriorityQueue<Integer> free = new PriorityQueue<>();
        // i, freeTime
        PriorityQueue<long[]> wait = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        for (int i = 0; i < n; i++) {
            free.add(i);
        }

        long[] ans = new long[n];
        for (int i = 0; i < m; i++) {
            int t = tws[i][0], w = tws[i][1], s = tws[i][2];
            while (!wait.isEmpty() && wait.peek()[1] <= t) {
                long[] p = wait.remove();
                int id = (int) p[0];
                free.add(id);
            }
            if (!free.isEmpty() && free.peek() <= t) {
                int id = free.remove();
                ans[id] += w;
                wait.add(new long[]{id, t + s});
            }
        }

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
E - Somen Nagashi
https://atcoder.jp/contests/abc320/tasks/abc320_e

题目大意：
有 N 个人聚集在一起参加一个名为“流动的面条”的活动。人们排成一排，从前到后依次编号为 1 到 N。
在活动过程中，发生了 M 次以下情况:
- 在 ti 时刻，有 wi 的面条飞了下来。排在前面的人得到所有的钱(如果没有人在这排，就没有人得到钱)。然后那个人走出这一行，在时间 ti + si 时回到他们原来的位置。
在时间 X 时返回该行的人被认为在时间 X 时在该行。
在所有 M 次出现之后，报告每个人得到的面条总数。
---
活动的程序如下:
在时刻 1，面条的数量为 1。1、2、3 号人在那一排，排在前面的人，也就是第一个人，拿到了面条，然后走出那一排。
在时间 2，有 10 个面条飞了下来。2 号和 3 号人在那一排，排在前面的人，也就是 2 号，拿到面条，然后走出那一排。
在时间 4 时，第 1 个人回到这一行。
在时间 4,100 条面条飞了下来。1 号和 3 号人在那一排，排在前面的人，也就是第一个人，拿到面条，然后走出那一排。
在时间 10 时，有 1000 条面条飞了下来。只有 3 号人在那一排，排在前面的 3 号人拿到了面条，然后离开了那一排。
在时间 100 的时候，有 10 亿条面条飞了下来。没人在那排，所以没人能吃到这些面条。
在时间 102 时，第二个人回到这一行。
在时间 10004 时，人员 1 返回到行。
在时间 1000000010 时，第 3 个人返回到行。
1 号人、2 号人、3 号人吃的面条总数分别是 101、10、1000。

双堆模拟。
======

Input 1
3 5
1 1 3
2 10 100
4 100 10000
10 1000 1000000000
100 1000000000 1
Output 1
101
10
1000

Input 2
3 1
1 1 1
Output 2
1
0
0

Input 3
1 8
1 1 1
2 2 2
3 3 3
4 4 4
5 5 5
6 6 6
7 7 7
8 8 8
Output 3
15
 */