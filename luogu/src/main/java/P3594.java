import base.Unaccepted;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

@Unaccepted
public class P3594 {
    static int n;
    static long lim;
    static int d;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        lim = scanner.nextLong();
        d = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    record pair(int l, long s) {
    }

    private static String solve() {
        long ans = d;
        long sd = 0;
        for (int i = 0; i < d; i++) {
            sd += a[i];
        }
        Deque<pair> dq = new ArrayDeque<>(); // l, s
        dq.addLast(new pair(0, sd));
        long s = sd;
        int left = 0;
        for (int i = d; i < n; i++) {
            sd += a[i] - a[i - d];
            while (!dq.isEmpty() && sd >= dq.getLast().s) {
                dq.removeLast();
            }
            dq.addLast(new pair(i - d + 1, sd));

            s += a[i];
            while (s - dq.getFirst().s > lim) {
                s -= a[left];
                left++;
                while (dq.getFirst().l < left) {
                    dq.removeFirst();
                }
            }

            ans = Math.max(ans, i - left + 1);
        }
        return String.valueOf(ans);
    }
}
/*
P3594 [POI2015] WIL
https://www.luogu.com.cn/problem/P3594

灵茶の试炼 2023-12-07
题目大意：
输入 n(1≤n≤2e6) limit(0≤limit≤1e16) d(1≤d≤n) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你可以选择一个长度不超过 d 的连续子数组，把其中的元素都变成 0。
该操作至多执行一次。
输出最长连续子数组的长度，满足子数组元素和不超过 limit。

提示 1
清零的长度越长越好，所以「至多 d」应该是「恰好 d」。
提示 2
从特殊到一般：
d=0 要怎么做？
d=1 要怎么做？
d=2 要怎么做？
提示 3
大框架是写一个不定长滑动窗口，维护子数组的左端点 left。
什么时候移动 left 呢？如果【滑动窗口的元素和】减去滑动窗口内的【长为 d 的连续子数组和的最大值】 > limit，那么就一定要移动 left 了。
如何维护滑动窗口内的【长为 d 的连续子数组的最大值】？用单调队列（队首的和最大，队尾的和最小）维护。
原理见 单调队列【基础算法精讲 27】
移除队首无用数据：如果队首（对应的长为 d 的子数组左端点的）下标 < left，则弹出队首。
移除队尾无用数据：如果 [i-d+1,i] 的子数组和 sd >= 队尾，则弹出队尾。然后把 sd 和下标 i-d+1 入队。
https://www.luogu.com/paste/jmki5ukh
======

输入 #1
9 7 2
3 4 1 9 4 1 7 1 3
输出 #1
5
 */