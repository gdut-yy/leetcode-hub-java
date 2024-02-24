package p1249;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1249E {
    static int n, c;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        c = scanner.nextInt();
        a = new int[n];
        for (int i = 1; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 1; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[][] f = new int[n][2];
        f[1][0] = a[1];
        f[1][1] = c + b[1];
        for (int i = 2; i < n; i++) {
            f[i][0] = Math.min(f[i - 1][0], f[i - 1][1]) + a[i];
            f[i][1] = Math.min(f[i - 1][0] + c, f[i - 1][1]) + b[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(f[i][0], f[i][1]);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E. By Elevator or Stairs?
https://codeforces.com/contest/1249/problem/E

灵茶の试炼 2022-08-16
题目大意：
输入正整数 n(2≤n≤2e5) 和 c(≤1000)，以及长度均为 n-1 的整数数组 a 和 b，数组元素范围均为 [1,1000]。
走楼梯从 i 层到 i+1 层需要 a[i] 秒。
坐电梯从 i 层到 i+1 层需要 b[i] 秒。
如果你要从某一层开始坐电梯，你需要额外等待 c 秒。
输出从第 1 层走楼梯或者坐电梯到每一层，分别最少需要多少秒。
进阶：做到 O(1) 空间复杂度（不计输入输出）。

rating 1700
https://codeforces.com/contest/1249/submission/164834657
定义 f[i][0/1] 表示到达第 i 层，且是用楼梯/电梯到达时的最短时间。
枚举上一层和当前层走楼梯还是坐电梯，转移到对应的状态上。
具体转移方程见代码。
答案就是每一层的 min(f[i][0], f[i][1])。
利用滚动数组可以做到 O(1) 空间复杂度。
======

input
10 2
7 6 18 6 16 18 1 17 17
6 9 3 10 9 1 10 1 5
output
0 7 13 18 24 35 36 37 40 45

input
10 1
3 2 3 1 3 3 1 4 1
1 2 3 4 4 1 2 1 3
output
0 2 4 7 8 11 13 14 16 17
 */
