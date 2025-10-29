package c413;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Abc413_c {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        Deque<int[]> dq = new ArrayDeque<>();
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            if (op == 1) {
                int c = scanner.nextInt(); // c 个 x
                int x = scanner.nextInt();
                dq.addLast(new int[]{c, x});
            } else {
                int k = scanner.nextInt();
                long res = 0;
                while (k > 0) {
                    int[] first = dq.removeFirst();
                    int mn = Math.min(k, first[0]);
                    k -= mn;
                    res += (long) mn * first[1];
                    if (first[0] - mn > 0) {
                        dq.addFirst(new int[]{first[0] - mn, first[1]});
                    }
                }
                out.println(res);
            }
        }
    }
}
/*
C - Large Queue
https://atcoder.jp/contests/abc413/tasks/abc413_c

题目大意：
有一个空整数序列 A=() 。给你 Q 个查询，你需要按照给定的顺序处理它们。查询有两种类型：
- 类型 1 ：以 `1 c x` 格式给出。在 A 的末尾添加 x 的 c 副本。
- 类型 2 ：以 `2 k` 格式给出。从 A 中删除前 k 个元素，并输出删除的 k 个整数之和。保证此时 k 最多是 A 的长度。

双端队列模拟。
======

Input 1
5
1 2 3
1 4 5
2 3
1 6 2
2 5
Output 1
11
19

Input 2
10
1 75 22
1 81 72
1 2 97
1 84 82
1 2 32
1 39 57
2 45
1 40 16
2 32
2 42
Output 2
990
804
3024

Input 3
10
1 160449218 954291757
2 17217760
1 353195922 501899080
1 350034067 910748511
1 824284691 470338674
2 180999835
1 131381221 677959980
1 346948152 208032501
1 893229302 506147731
2 298309896
Output 3
16430766442004320
155640513381884866
149721462357295680
 */
