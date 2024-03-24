package p1619;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1619E {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] cnt = new int[n + 1];
        for (int v : a) {
            cnt[v]++;
        }

        List<Long> ans = new ArrayList<>();
        ans.add((long) cnt[0]);

        int s = 0;
        Deque<Integer> ex = new ArrayDeque<>();
        long fill = 0;
        for (int i = 0; i < n; i++) {
            int c = cnt[i];
            s += c;
            if (s <= i) {
                for (int j = 0; j < n - i; j++) {
                    ans.add(-1L);
                }
                break;
            }
            if (c == 0) {
                fill += i - ex.pop();
            }
            ans.add(fill + cnt[i + 1]);
            for (int j = 0; j < c - 1; j++) {
                ex.push(i);
            }
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E. MEX and Increments
https://codeforces.com/contest/1619/problem/E

灵茶の试炼 2022-09-21
题目大意：
输入 t (≤1e4) 表示 t 组数据，每组数据输入 n(≤2e5) 和一个长为 n 的数组 a (0≤a[i]≤n)。所有数据的 n 之和不超过 2e5。
每次操作，你可以把数组中的一个数加一。
定义 mex(a) 表示不在 a 中的最小非负整数。
定义 f(i) 表示使 mex(a) = i 的最小操作次数。如果无法做到，则 f(i) = -1。
输出 n+1 个数：f(0), f(1), ..., f(n)。

rating 1700
https://codeforces.com/contest/1619/submission/146932917
提示 1：什么情况下会输出 -1？
当 ≤ i 的元素不足 i+1 个时。
提示 2：从小到大计算 f(i)。
因为 f(i) 可以在 f(i-1) 的基础上操作。
提示 3：在计算 f(i) 时，如果数组中没有 i-1，那么需要操作哪个数呢？
在「多余」的数中，比 i 小且最大的数。
例如 [0,1,1,2,4] 中，1 就是多余的数，这个数可以变大。
提示 4：用栈存储多余的数，栈顶就是提示 3 中需要操作的数。
======

input
5
3
0 1 3
7
0 1 2 3 4 3 2
4
3 0 0 0
7
4 6 2 3 5 0 5
5
4 0 1 0 4
output
1 1 0 -1
1 1 2 2 1 0 2 6
3 0 1 4 3
1 0 -1 -1 -1 -1 -1 -1
2 1 0 2 -1 -1
 */
