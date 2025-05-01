package p709;

import java.util.Arrays;
import java.util.Scanner;

public class CF709B {
    static int n, x;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        if (n == 1) return "0";
        Arrays.sort(a);
        int ans = Math.min(
                f(Arrays.copyOfRange(a, 0, n - 1)),
                f(Arrays.copyOfRange(a, 1, n))
        );
        return String.valueOf(ans);
    }

    static int f(int[] a) {
        return a[n - 2] - a[0] + Math.min(Math.abs(x - a[0]), Math.abs(x - a[n - 2]));
    }
}
/*
B. Checkpoints
https://codeforces.com/contest/709/problem/B

灵茶の试炼 2025-03-18
题目大意：
输入 n(1≤n≤1e5) x(-1e6≤x≤1e6) 和长为 n 的数组 a(-1e6≤a[i]≤1e6)。
一维数轴上有 n 个苹果，坐标记录在数组 a 中。
你一开始在 x 处。
你需要收集至少 n-1 个苹果。
输出最少移动距离。
进阶：改成收集 k(1≤k≤n) 个苹果呢？（见右侧题解）

rating 1500
先把 a 从小到大排序。
访问的点必定是 a 的连续子数组，要么是 [0,n-2]，要么是 [1,n-1]，两种情况都算一算，取最小值。
设子数组为 b，我们可以先左后右，或者先右后左，二者取最小值，答案为
b[-1] - b[0] + min(abs(x - b[0]), abs(x - b[-1]))。其中 b[-1] 表示 b 的最后一个数。
注意特判 n=1 的情况，此时答案为 0。
进阶做法见 力扣 2106. 摘水果。
代码 https://codeforces.com/problemset/submission/709/310505460
代码备份（洛谷）
======

Input
3 10
1 7 12
Output
7

Input
2 0
11 -10
Output
10

Input
5 0
0 0 1000 0 0
Output
0
 */
