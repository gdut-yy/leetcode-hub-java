package c249;

import java.nio.charset.StandardCharsets;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Abc249_f {
    static int n, k;
    static int[][] ty;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        ty = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            ty[i][0] = scanner.nextInt();
            ty[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        // wtf?
        long ans = (long) -1e18;
        long s = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = n; i >= 0; i--) {
            int t = ty[i][0], y = ty[i][1];
            if (t != 2) {
                ans = Math.max(ans, y + s);
                if (k == 0) {
                    break;
                }
                // 必须 skip
                k--;
            } else if (y >= 0) {
                s += y;
            } else {
                // skip
                minHeap.add(-y);
            }

            if (minHeap.size() > k) {
                // 选一个最大的负数不 skip
                s -= minHeap.remove();
            }
        }
        return String.valueOf(ans);
    }
}
/*
F - Ignore Operations
https://atcoder.jp/contests/abc249/tasks/abc249_f

灵茶の试炼 2023-01-03
题目大意：
初始时 x=0。
输入 n k(k≤n≤2e5)，以及 n 个操作，每个操作是如下两种之一：
"1 y"，表示把 x 替换成 y；
"2 y"，表示 x+=y。(-1e9≤y≤1e9)
你可以跳过至多 k 个操作，你需要最大化最后的 x，输出这个最大值。

https://atcoder.jp/contests/abc249/submissions/37631511
提示 1：由于操作 1 会覆盖之前的所有操作，因此倒序思考这些操作更合适。
提示 2：假设某个操作 1 是最后一次操作 1，那么在它之后的操作 1 都应该 skip。
提示 3：如果 skip 的操作达到了 k，后面又遇到了操作 2，那么我们应该「撤销」之前的 skip，也就是把最大的负数 y 撤销掉（绝对值最小的 y）。
提示 4：用堆来实现。（这个套路也叫反悔堆）
代码实现时可以在最前面插入一个 "1 0" 方便统一操作。
======

Input 1
5 1
2 4
2 -3
1 2
2 1
2 -3
Output 1
3

Input 2
1 0
2 -1000000000
Output 2
-1000000000

Input 3
10 3
2 3
2 -1
1 4
2 -1
2 5
2 -9
2 2
1 -6
2 5
2 -3
Output 3
15
 */