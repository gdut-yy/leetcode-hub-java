package p730;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF730I {
    static int n, p, s;
    static int[] oriA, oriB;
    static int[][] a; // v, i

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        p = scanner.nextInt();
        s = scanner.nextInt();
        oriA = new int[n];
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            oriA[i] = scanner.nextInt();
            a[i][0] = oriA[i];
            a[i][1] = i;
        }
        Arrays.sort(a, Comparator.comparingInt(o -> -o[0]));

        int ans = 0;
        int[] group = new int[n];
        for (int i = 0; i < p; i++) {
            int pv = a[i][0], pi = a[i][1];
            ans += pv;
            group[pi] = 1;
        }
        PriorityQueue<int[]> pqA = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
        for (int i = p; i < a.length; i++) {
            pqA.add(a[i]);
        }

        oriB = new int[n];
        PriorityQueue<int[]> pqB = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
        PriorityQueue<int[]> diff = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
        for (int i = 0; i < n; i++) {
            int v = oriA[i];
            oriB[i] = scanner.nextInt();
            if (group[i] == 0) {
                pqB.add(new int[]{oriB[i], i});
            } else {
                diff.add(new int[]{oriB[i] - v, i});
            }
        }

        for (; s > 0; s--) {
            while (group[pqA.peek()[1]] > 0) {
                pqA.remove(); // 懒删除
            }
            while (group[pqB.peek()[1]] > 0) {
                pqB.remove(); // 懒删除
            }
            int[] topA = pqA.peek();
            int[] topB = pqB.peek();
            int[] topD = diff.peek();
            if (topB[0] > topA[0] + topD[0]) { // 直接选 b
                ans += topB[0];
                group[topB[1]] = 2;
                pqB.remove();
            } else { // 反悔一个 a 变 b（a 那边选一个更小的）
                ans += topA[0] + topD[0];
                group[topA[1]] = 1;
                group[topD[1]] = 2;
                // diff[0] = pair{oriB[topA.i] - topA.v, topA.i}
                // heap.Fix(&diff, 0)
                diff.remove();
                diff.add(new int[]{oriB[topA[1]] - topA[0], topA[1]});
                pqA.remove();
            }
        }

        StringBuilder output = new StringBuilder();
        output.append(ans).append(System.lineSeparator());
        for (int i = 0; i < n; i++) {
            if (group[i] == 1) {
                output.append(i + 1).append(" ");
            }
        }
        output.append(System.lineSeparator());
        for (int i = 0; i < n; i++) {
            if (group[i] == 2) {
                output.append(i + 1).append(" ");
            }
        }
        System.out.println(output);
    }
}
/*
I. Olympiad in Programming and Sports
https://codeforces.com/contest/730/problem/I

灵茶の试炼 2024-04-05
题目大意：
输入 n(2≤n≤3000) p s (p≥1, s≥1, p+s≤n) 和长为 n 的数组 a(1≤a[i]≤3000)，长为 n 的数组 b(1≤b[i]≤3000)。
有 n 名学生，第 i 名学生的编程能力为 a[i]，运动能力为 b[i]。
你需要组建两支队伍：有 p 人的编程队，有 s 人的运动队。
一个学生不能同时参加两支队伍。
这 p+s 人的能力值之和最大是多少？学生 i 如果在编程队，他的能力值是 a[i]；如果在运动队，他的能力值是 b[i]。
输出最大能力值之和，编程队的学生编号，运动队的学生编号。学生编号从 1 开始。
多解输出任意一解。
加强版，O(nlogn)：
https://atcoder.jp/contests/agc018/tasks/agc018_c
相似题目: 1029. 两地调度
https://leetcode.cn/problems/two-city-scheduling/

rating 2000
反悔贪心，O(nlogn)。
先用编程能力最大的 p 名学生组成编程队，然后从 0 开始一个人一个人地构建运动队。
分类讨论：
1. 招人：从剩余学生中，选择运动能力最大的。
2. 挖人：从编程队中挖一名【运动能力减编程能力】最大的学生到运动队，然后编程队再招人，从剩余学生中，选择编程能力最大的。
上面这两种方法，谁能让能力总和变得更大，就用哪种方法。重复执行 s 次。
这可以用三个最大堆实现，它们分别维护：
1. 剩余学生中的编程能力值。
2. 剩余学生中的运动能力值。
3. 编程队中的【运动能力减编程能力】值。
为了输出具体方案，堆中还需要记录学生编号，以及用一个数组记录第 i 个学生在哪个队伍中。
https://codeforces.com/contest/730/submission/253180362
======

Input
5 2 2
1 3 4 5 2
5 3 2 1 4
Output
18
3 4
1 5

Input
4 2 2
10 8 8 3
10 7 9 4
Output
31
1 2
3 4

Input
5 3 1
5 2 5 1 7
6 3 1 6 3
Output
23
1 3 5
4

2 1 1
100 101
1 100
 */
