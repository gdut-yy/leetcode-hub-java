package p1747;

import java.util.Scanner;

public class CF1747C {
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
        int mn = (int) 1e9;
        for (int i = 1; i < n; i++) {
            mn = Math.min(mn, a[i]);
        }

        return (a[0] > mn) ? "Alice" : "Bob";
    }
}
/*
C. Swap Game
https://codeforces.com/contest/1747/problem/C

灵茶の试炼 2024-02-05
题目大意：
输入 T(≤2e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，下标从 1 开始。
Alice 和 Bob 玩回合制游戏，Alice 先。
每回合，如果 a1=0，那么当前玩家输掉游戏，对手获胜。
否则当前玩家把 a1 减少一，然后选择一个下标在 [2,n] 中的数字和 a1 交换。
双方都以最佳方式游戏，输出最后谁赢了。

rating 1200
手玩题。试试几个 n=2 的例子，比如 [2,3]，[3,2]，[2,2] 等。
如果 a1 > min(a2~an)，那么 Alice 可以选其它数中的最小值和 a1 交换。每次轮到 Bob，他都要把这个最小值减一，然后再交换到 a2~an 中，这又会导致 a1 比 min(a2~an) 大。
所以最后 Bob 会得到 a1=0，Alice 赢。
如果 a1 <= min(a2~an)，那么无论 Alice 选哪个数，交换后，Bob 就面对一个 a1 > min(a2~an) 的局面了，Bob 赢。
https://codeforces.com/contest/1747/submission/244817141
======

input
3
2
1 1
2
2 1
3
5 4 4
output
Bob
Alice
Alice
 */
