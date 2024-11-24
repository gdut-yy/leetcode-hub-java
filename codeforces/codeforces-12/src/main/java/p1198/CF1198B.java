package p1198;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1198B {
    static int n, q;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        q = scanner.nextInt();
        int[] sufMax = new int[q];
        int[] changeTime = new int[n];
        for (int t = 0; t < q; t++) {
            int op = scanner.nextInt();
            if (op == 1) {
                int p = scanner.nextInt() - 1;
                int x = scanner.nextInt();

                a[p] = x;
                changeTime[p] = t;
            } else {
                int x = scanner.nextInt();
                sufMax[t] = x;
            }
        }
        for (int i = q - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i], sufMax[i + 1]);
        }
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            output.add(Math.max(a[i], sufMax[changeTime[i]]));
        }
        System.out.println(output.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static String solve() {
        return "";
    }
}
/*
B. Welfare State
https://codeforces.com/contest/1198/problem/B

灵茶の试炼 2024-02-21
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)，下标从 1 开始。
然后输入 q(1≤n≤2e5) 和 q 个操作。
有两种操作：
"1 p x"：将 a[p] 变为 x。
"2 x"：将 a 中所有小于 x 的数变为 x。
其中 0≤x≤1e9。
输出所有操作完成后的数组 a。

rating 1600
a[i] 的最终值：
要么是最后一次对下标 i 的操作 1 的 x 值（如果没有操作 1 就是初始值）。
要么是在最后一次对下标 i 的操作 1 之后的，操作 2 的最大 x。
所以额外创建两个数组，维护：
对于每个下标 i，操作 1 的最后一次发生的时间 changeTime[i]。
操作 2 的后缀最大值 sufMax[i]，表示发生在第 i 次操作到最后一次操作之间的操作 2 的最大值。
a[i] 的最终值 = max(a[i], sufMax[changeTime[i]])。
操作 1 可以直接更新 a[i]。
https://codeforces.com/problemset/submission/1198/247412775
======

input
4
1 2 3 4
3
2 3
1 2 2
2 1
output
3 2 3 4

input
5
3 50 2 1 10
3
1 2 0
2 8
1 3 20
output
8 8 20 8 10
 */
