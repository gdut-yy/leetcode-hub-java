package c210;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Abc210_e {
    static int n, m;
    static int[][] op;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        op = new int[m][2];
        for (int i = 0; i < m; i++) {
            op[i][0] = scanner.nextInt();
            op[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        Arrays.sort(op, Comparator.comparingInt(o -> o[1]));
        for (int[] o : op) {
            int g = getGCD(n, o[0]);
            ans += (long) (n - g) * o[1];
            n = g;
        }
        if (n > 1) {
            ans = -1;
        }
        return String.valueOf(ans);
    }

    private static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
E - Ring MST
https://atcoder.jp/contests/abc210/tasks/abc210_e

灵茶の试炼 2022-11-15
题目大意：
输入 n(≤1e9) 和 m(≤1e5)，表示一个 n 个点，0 条边的图（节点编号从 0 开始），以及 m 个操作。
每个操作输入两个数 a(1≤a≤n-1) 和 c(≤1e9)，表示你可以花费 c，任意选择一个 [0,n-1] 内的数字 x，把 x 和 (x+a)%n 连边。
这 m 个操作，每个都可以执行任意多次，可以按任意顺序执行。
输出让图连通需要的最小花费。
如果无法做到，输出 -1。

https://atcoder.jp/contests/abc210/submissions/36506266
根据 Kruskal，按照 c 从小到大排序，对于每个操作，执行的次数等于执行前后连通块的数量之差。
由于每个操作需要尽可能多地执行，手玩一下可以发现，执行后的连通块数量等于 gcd(n, a0, a1, ..., ai)。
详细证明见右。
如果最后 gcd > 1，则输出 -1。
======

Input 1
4 2
2 3
3 5
Output 1
11

Input 2
6 1
3 4
Output 2
-1
 */