package p487;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

public class CF487B {
    static int n, maxD, minL;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        maxD = scanner.nextInt();
        minL = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int inf = (int) 1e9;

//    private static String solve1() {
//        Deque<Integer> small = new ArrayDeque<>(); // minDq.getFirst() 为区间内最小值
//        Deque<Integer> big = new ArrayDeque<>(); // maxDq.getFirst() 为区间内最大值
//        Deque<Integer> dpMQ = new ArrayDeque<>();
//
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, inf);
//        dp[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            int v = a[i];
//            // small.push(v)
//            while (!small.isEmpty() && v <= small.getLast()) small.removeLast();
//            small.addLast(v);
//            // big.push(v)
//            while (!big.isEmpty() && v >= big.getLast()) big.removeLast();
//            big.addLast(v);
//            if (i < minL) continue;
//            // dpMQ.push(dp[i-minL])
//            while (!dpMQ.isEmpty() && dp[i - minL] <= dpMQ.getLast()) dpMQ.removeLast();
//            dpMQ.addLast(dp[i - minL]);
//            // 注意：朴素的单调队列，这里会有问题
//            while (!dpMQ.isEmpty() && big.getFirst() - small.getFirst() > maxD) {
//                small.removeFirst();
//                big.removeFirst();
//                dpMQ.removeFirst();
//            }
//            if (!dpMQ.isEmpty()) {
//                dp[i] = dpMQ.getFirst() + 1;
//            }
//        }
//        if (dp[n] >= inf) dp[n] = -1;
//        return String.valueOf(dp[n]);
//    }

    private static String solve() {
        Mq small = new Mq((a, b) -> a.val <= b.val);
        Mq big = new Mq((a, b) -> a.val >= b.val);
        Mq dpMq = new Mq((a, b) -> a.val <= b.val);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int v = a[i];
            push(small, v);
            push(big, v);
            if (i < minL) continue;
            push(dpMq, dp[i - minL]);
            while (dpMq.size > 0 && top(big) - top(small) > maxD) {
                pop(small);
                pop(big);
                pop(dpMq);
            }
            if (dpMq.size > 0) {
                dp[i] = top(dpMq) + 1;
            }
        }
        if (dp[n] >= inf) dp[n] = -1;
        return String.valueOf(dp[n]);
    }

    static void push(Mq q, int v) {
        q.size++;
        Data d = new Data(v, 1);
        while (!q.data.isEmpty() && q.less.apply(d, q.data.get(q.data.size() - 1))) {
            d.del += q.data.get(q.data.size() - 1).del;
            q.data.remove(q.data.size() - 1);
        }
        q.data.add(d);
    }

    static void pop(Mq q) {
        q.size--;
        if (q.data.get(0).del > 1) {
            q.data.get(0).del--;
        } else {
            q.data.remove(0);
        }
    }

    static int top(Mq q) {
        return q.data.get(0).val;
    }

    static class Data {
        int val, del;

        public Data(int val, int del) {
            this.val = val;
            this.del = del;
        }
    }

    static class Mq {
        List<Data> data;
        int size;
        BiFunction<Data, Data, Boolean> less;

        public Mq(BiFunction<Data, Data, Boolean> less) {
            this.data = new ArrayList<>();
            this.size = 0;
            this.less = less;
        }
    }
}
/*
B. Strip
https://codeforces.com/contest/487/problem/B

灵茶の试炼 2023-10-27
题目大意：
输入 n(1≤n≤1e5) s(0≤n≤1e9) L(1≤n≤1e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
你需要把 a 分割成若干段（连续子数组），满足：
1. 每段长度至少为 L。
2. 每段的最大值减最小值 <= s。
输出至少要把 a 分成多少段。
如果无法做到，输出 -1。
思考：用 O(n) 时间复杂度实现。

rating 2000
当子数组右端点固定时，左端点的最小值也是固定的，因为要满足子数组的最大值减最小值 <= s。
左端点最小值怎么求？可以用两个 单调队列，分别维护子数组内的最大值和最小值，如果发现最大值减最小值 > s 就像滑动窗口那样，移动左端点 left。循环结束后就得到了左端点的最小值。
定义 f[i] 表示分割前 i 个数的最小段数，那么有
f[i] = min(f[left], f[left+1], ... f[i-L]) + 1
如果 left > i-L 则 f[i] = inf
上面这个【区间最小值】也可以用单调队列维护，因为区间的左右端点都是随着 i 的增加而增加的。
初始值 f[0]=0。
答案为 f[n]。如果 f[n]=inf 则输出 -1。
https://codeforces.com/contest/487/submission/121388184
======

input
7 2 2
1 3 1 2 4 1 2
output
3

input
7 2 2
1 100 1 100 1 100 1
output
-1
 */
