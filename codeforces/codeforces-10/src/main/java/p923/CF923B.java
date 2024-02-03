package p923;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF923B {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long s = 0;
        long[] ans = new long[n];
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int v = a[i], t = b[i];
            heap.add(v + s);
            long res = 0;
            while (!heap.isEmpty() && heap.peek() <= s + t) {
                res += heap.remove() - s;
            }
            res += (long) heap.size() * t;
            ans[i] = res;
            s += t;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Producing Snow
https://codeforces.com/contest/923/problem/B

灵茶の试炼 2023-12-27
题目大意：
输入 n(1≤n≤1e5)，长为 n 的数组 a(0≤a[i]≤1e9)，长为 n 的数组 t(0≤t[i]≤1e9)。
下雪啦！0x3F 每天都要堆一个雪人。
在第 i 天的开始，0x3F 会堆一个体积为 a[i] 的雪人。
第 i 天的温度是 t[i]，体积为 x 的雪人在这天会融化掉 min(t[i], x) 的体积。
第 i 天新堆的雪人和之前堆的雪人都会融化。
对于每一天，输出这一天所有雪人融化掉的体积之和。

rating 1600
提示 1
如果我们把雪人从小到大排序，那么 <= t[i] 的全部融化，剩下的都会减少 t[i] 的体积。
这启发我们用一个小根堆来【模拟】。
提示 2
弹出 <= t[i] 的堆顶。
然后把堆中所有数都减少 t[i]。这要怎么快速完成？
提示 3
用 s 表示堆中元素需要减少的量。
对于第 i 天新堆的雪人，把 a[i]+s 入堆，就等价于【把 a[i] 入堆，且堆中所有元素都减少了 s】。
弹出 <= s+t[i] 的堆顶，就等价于【在堆中所有元素都减少了 s 的情况下，弹出 <= t[i] 的堆顶】。
https://codeforces.com/contest/923/submission/238433472
======

input
3
10 10 5
5 7 2
output
5 12 4

input
5
30 25 20 15 10
9 10 12 4 13
output
9 20 35 11 25
 */
