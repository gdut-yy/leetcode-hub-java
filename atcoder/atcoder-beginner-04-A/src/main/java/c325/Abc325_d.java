package c325;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Abc325_d {
    static int n;
//    static long[][] td;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
//        td = new long[n][2];
//        for (int i = 0; i < n; i++) {
//            td[i][0] = scanner.nextLong();
//            td[i][1] = scanner.nextLong();
//        }

        mp = new TreeMap<>();
        endMax = 0;
        for (int i = 0; i < n; i++) {
            long t = scanner.nextLong();
            long d = scanner.nextLong();
            mp.computeIfAbsent(t, e -> new ArrayList<>()).add(t + d);
            endMax = Math.max(endMax, t + d);
        }
        System.out.println(solve());
    }

    // 到达时间 离开时间
    static TreeMap<Long, List<Long>> mp;
    static long endMax;

    private static String solve() {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        int ans = 0;
        long time = 1;
        while (time <= endMax) {
            // 加入刚开始的
            List<Long> ends = mp.getOrDefault(time, new ArrayList<>());
            mp.remove(time);
            minHeap.addAll(ends);

            // 优化 time 步进幅度
            if (minHeap.isEmpty() && !mp.isEmpty()) {
                time = mp.firstKey();
                continue;
            }
            if (minHeap.isEmpty()) {
                break;
            }

            // 移除已结束的
            while (!minHeap.isEmpty() && minHeap.peek() < time) {
                minHeap.remove();
            }
            if (!minHeap.isEmpty()) {
                minHeap.remove();
                ans++;
            }
            time++;
        }
        return String.valueOf(ans);
    }
}
/*
D - Printing Machine
https://atcoder.jp/contests/abc325/tasks/abc325_d

题目大意：
传送带上有 N 个标有 1 到 N 的产品在流动。传送带上连接一台 Keyence 打印机，产品 i 从现在开始进入打印机的范围 ti 微秒，并在 di 微秒后离开它。
Keyence 打印机可以在打印机范围内的一个产品上立即打印(特别是，可以在产品进入或离开打印机范围的那一刻进行打印)。然而，在打印一次后，它需要 1 微秒的充电时间才能再次打印。当产品和打印机的打印时间选择最佳时，打印机可以打印的最大产品数量是多少?

优先队列
相似题目: 1353. 最多可以参加的会议数目
https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended/
======

Input 1
5
1 1
1 1
2 1
1 2
1 4
Output 1
4

Input 2
2
1 1
1000000000000000000 1000000000000000000
Output 2
2

Input 3
10
4 1
1 2
1 4
3 2
5 1
5 1
4 1
2 1
4 1
2 4
Output 3
6
 */
