package c323;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc323_c {
    static int n, m;
    static int[] a;
    static char[][] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        s = new char[n][m];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int max = 0;
        boolean dup = false;

        List<Integer> tots = new ArrayList<>(n);
        List<PriorityQueue<Integer>> maxHeaps = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int tot = i + 1;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = 0; j < m; j++) {
                if (s[i][j] == 'o') {
                    tot += a[j];
                } else {
                    maxHeap.add(a[j]);
                }
            }
            tots.add(tot);
            maxHeaps.add(maxHeap);

            if (max < tot) {
                max = tot;
                dup = false;
            } else if (max == tot) {
                dup = true;
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int tot = tots.get(i);
            PriorityQueue<Integer> maxHeap = maxHeaps.get(i);

            if (!dup && tot == max) continue;
            int cnt = 0;
            while (tot <= max) {
                tot += maxHeap.remove();
                cnt++;
            }
            ans[i] = cnt;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
C - World Tour Finals
https://atcoder.jp/contests/abc323/tasks/abc323_c

题目大意：
有 N 名选手参加的编程大赛世界巡回赛总决赛正在进行中，比赛时间已经过去了一半。本次比赛共有 M 个问题，问题 i 的得分是 500 到 2500 之间 100 的倍数，包括在内。
对于每个 i=1,...,N，你会得到一个字符串 Si，表示玩家 i 已经解决了哪些问题。Si 是由 0 和 x 组成的长度为 M 的字符串，如果玩家 i 已经解决了问题 j，则 Si 的第 j 个字符为 o，如果玩家 i 还没有解决问题，则 Si 的第 x 个字符为 x。在这里，没有一个玩家已经解决了所有的问题。
玩家 i 的总得分是他们解决的问题的得分之和，加上额外的 i 分。对于每一个 i=1,...,N，回答以下问题。
- 至少玩家 i 还没有解决多少问题，玩家 i 必须解决多少问题才能超过所有其他玩家的当前总分?
注意，在此语句和约束条件下，可以证明玩家 i 通过解决所有问题可以超过所有其他玩家的当前总分，因此答案总是有定义的。

模拟，其实可以去掉 dup
======

Input 1
3 4
1000 500 700 2000
xxxo
ooxx
oxox
Output 1
0
1
1

Input 2
5 5
1000 1500 2000 2000 2500
xxxxx
oxxxx
xxxxx
oxxxx
oxxxx
Output 2
1
1
1
1
0

Input 3
7 8
500 500 500 500 500 500 500 500
xxxxxxxx
oxxxxxxx
ooxxxxxx
oooxxxxx
ooooxxxx
oooooxxx
ooooooxx
Output 3
7
6
5
4
3
2
0
 */
