package c419;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Abc419_b {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int q = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (q-- > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                int x = scanner.nextInt();
                pq.add(x);
            } else {
                Integer res = pq.remove();
                out.println(res);
            }
        }
    }
}
/*
B - Get Min
https://atcoder.jp/contests/abc419/tasks/abc419_b

题目大意：
有一个空袋子。
给你 Q 个查询。请按顺序处理这些查询，并输出每个查询的答案- 2 。
每个查询属于以下类型之一。
- 类型 1 ：输入格式为 `1 x`.将一个写有整数 x 的球放入袋子中。
- 类型 2 ：输入格式为 `2`。从袋子里的球中挑出一个写有最小整数的球，并报告该整数作为答案。当袋子中没有球时，不会给出此查询。

优先队列。
======

Input 1
5
1 6
1 7
2
1 1
2
Output 1
6
1

Input 2
8
1 5
1 1
1 1
1 9
2
2
1 2
2
Output 2
1
1
2
 */
