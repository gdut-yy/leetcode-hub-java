package c137;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc137_c {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int x = a[n - 2], y = a[n - 1];
        if (x + 1 < y || (y - n) % 2 == 0) {
            return "Alice";
        }
        return "Bob";
    }
}
/*
C - Distinct Numbers
https://atcoder.jp/contests/arc137/tasks/arc137_c

灵茶の试炼 2023-08-25
题目大意：
输入 n(2≤n≤3e5) 和长为 n 的严格递增数组 a(0≤a[i]≤1e9)。
Alice 和 Bob 在玩一个回合制游戏，Alice 先手。
游戏规则如下：
1. 一开始，数轴上有 n 颗石子，第 i 颗石子的位置是 a[i]。
2. 每个回合，玩家只能移动最右边的那颗石子。且必须将它移动到在它左边的没有石子的非负整数空位上。例如 a=[2,4]，你只能移动位置 4 上的石子到位置 0 或 1 或 3。
3. 移动石子后，轮到另一个玩家继续移动这 n 颗石子中的最右边的石子。如此交替。
4. 无法移动的玩家输掉游戏，另一位玩家获胜。
如果 Alice 必胜，输出 Alice，否则输出 Bob。

https://www.luogu.com.cn/blog/endlesscheng/solution-at-arc137-c
======

Input 1
2
2 4
Output 1
Alice

Input 2
3
0 1 2
Output 2
Bob
 */