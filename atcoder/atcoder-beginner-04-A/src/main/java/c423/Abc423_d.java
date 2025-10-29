package c423;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc423_d {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int K = scanner.nextInt();

        PriorityQueue<Event> events = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            events.add(new Event(a, 1, new Group(c, b, i)));
        }

        Deque<Group> waitingQueue = new ArrayDeque<>();
        long currentOccupancy = 0;
        long[] ans = new long[n];

        while (!events.isEmpty()) {
            long currentTime = events.peek().time;
            List<Event> batch = new ArrayList<>();

            while (!events.isEmpty() && events.peek().time == currentTime) {
                batch.add(events.poll());
            }

            for (Event event : batch) {
                if (event.type == 0) {
                    int leaving = (int) event.data;
                    currentOccupancy -= leaving;
                } else {
                    Group g = (Group) event.data;
                    waitingQueue.addLast(g);
                }
            }

            while (!waitingQueue.isEmpty()) {
                Group g = waitingQueue.peekFirst();
                if (currentOccupancy + g.c <= K) {
                    waitingQueue.pollFirst();
                    currentOccupancy += g.c;
                    ans[g.idx] = currentTime;
                    events.add(new Event(currentTime + g.b, 0, g.c));
                } else {
                    break;
                }
            }
        }
        out.println(Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
    }

    static class Event implements Comparable<Event> {
        long time;
        int type;
        Object data;

        public Event(long time, int type, Object data) {
            this.time = time;
            this.type = type;
            this.data = data;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time != other.time) {
                return Long.compare(this.time, other.time);
            }
            return Integer.compare(this.type, other.type);
        }
    }

    static class Group {
        int c, b, idx;

        public Group(int c, int b, int idx) {
            this.c = c;
            this.b = b;
            this.idx = idx;
        }
    }
}
/*
D - Long Waiting
https://atcoder.jp/contests/abc423/tasks/abc423_d

题目大意：
有一家餐厅最多可同时接待 K(1e7) 位顾客。餐厅前面有一条小街，小街上有一条排队通道。
在时间 0 时，餐厅内没有顾客，排队队伍也是空的。
今天，有 N(3e5) 组顾客预定前来就餐，他们按到达的先后顺序被编号为从 1 到 N。i 组由 Ci 人组成，在 Ai 时进入队列末尾，在进入餐厅后的 Bi 个时间单位离开餐厅。
每个群体都是在同时满足以下两个条件的最早时间离开队列进入餐厅的：
- 该组位于队列前列。换句话说，该组是当时仍在排队的人中最早加入的一组。
- 将该组人数与餐厅内所有当前排队的人数（包括在该时间段进入餐厅的人数，不包括离开餐厅的人数）相加，人数为 K 或更少。
求每组人进入餐厅的时间。

优先队列。
https://yuanbao.tencent.com/chat/naQivTmsDa/774c0752-8e30-459c-91d8-359f4b03ce8c
======

Input 1
4 10
30 300 3
60 45 4
90 45 5
120 45 2
Output 1
30
60
105
120

Input 2
4 10
30 300 10
60 45 2
90 45 3
120 45 4
Output 2
30
330
330
330

Input 3
10 24
279290 9485601 1
1094410 8022270 4
1314176 7214745 5
1897674 5924694 10
1921802 5769841 4
2506394 2765234 2
2558629 2727489 9
2681289 4061363 5
3022540 2291905 3
4407692 1313036 8
Output 3
279290
1094410
1314176
1897674
1921802
7691643
7822368
8528921
8528921
10549857
 */
