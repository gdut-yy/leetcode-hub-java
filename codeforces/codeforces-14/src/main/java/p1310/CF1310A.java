package p1310;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1310A {
    static int n;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        long ans = 0;
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0, cur = 0;
        long costSum = 0;
        while (i < n || !maxHeap.isEmpty()) {
            if (maxHeap.isEmpty()) {
                cur = a[i][0];
            }
            // 所有等于 cur 的元素的花费入堆
            for (; i < n && a[i][0] == cur; i++) {
                maxHeap.add((long) a[i][1]);
                costSum += a[i][1];
            }
            // 弹出一个最大花费，表示这个元素不需要继续增大
            costSum -= maxHeap.remove();
            ans += costSum;

            cur++;
        }
        return String.valueOf(ans);
    }
}
/*
A. Recommendations
https://codeforces.com/contest/1310/problem/A

灵茶の试炼 2022-05-26
题目大意：
给你两个数组 a 和 t，长度相同且不超过 2e5，1<=a[i]<=1e9, 1<=t[i]<=1e5。
你可以执行任意多次操作。每次操作，你可以给某个 a[i]+=1，该次操作的花费为 t[i]。
请问要使 a 中所有数字均不相同，最小花费是多少？

rating 1700
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1310a
https://www.luogu.com.cn/problem/solution/CF1310A
按 a[i] 从小到大遍历，把 a[i] 相同的元素分为一组。
比如 a=[1,1,1,2,9,9]，那么一开始把等于 1 的元素的花费丢到一个大根堆中，其中有一个 1 是不需要增大的，把最大的花费弹出，表示对应的那个 1 不需要增大。
然后把等于 2 的元素的花费丢到大根堆中，同样把最大的花费弹出，表示对应的那个元素不需要继续增大。
然后把等于 3 的元素的花费丢到大根堆中，由于此时没有等于 3 的元素，直接从堆中弹出一个最大的花费。
模拟上述过程，同时用一个变量 costSum 表示堆中的花费之和，每次弹出最大花费后，累加 costSum，即为答案。
======

input
5
3 7 9 7 8
5 2 5 7 5
output
6

input
5
1 2 3 4 5
1 1 1 1 1
output
0
 */
