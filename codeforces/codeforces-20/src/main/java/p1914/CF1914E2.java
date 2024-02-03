package p1914;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1914E2 {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int scoreA = a[i] - 1;
            int scoreB = -(b[i] - 1);
            Node node = new Node(scoreA, scoreB, i);
            nodes.add(node);
        }
        nodes.sort((o1, o2) -> Integer.compare(o2.scoreA - o2.scoreB, o1.scoreA - o1.scoreB));

        long ans = 0;
        for (int i = 0; i < n; i += 2) {
            ans += nodes.get(i).scoreA;
        }
        for (int i = 1; i < n; i += 2) {
            ans += nodes.get(i).scoreB;
        }
        return String.valueOf(ans);
    }

    private static class Node {
        int scoreA, scoreB, i;

        public Node(int scoreA, int scoreB, int i) {
            this.scoreA = scoreA;
            this.scoreB = scoreB;
            this.i = i;
        }
    }
}
/*
E2. Game with Marbles (Hard Version)
https://codeforces.com/contest/1914/problem/E1
https://codeforces.com/contest/1914/problem/E2

题目大意：
这个问题的简单版本和困难版本的区别仅仅在于对测试用例数量和 n 的限制。在简单版本中，测试用例的数量不超过 10^3 个，n 不超过 6 个。
这个问题的简单版本和困难版本的区别仅仅在于对测试用例数量和 n 的限制。在硬版本中，测试用例的个数不超过 10^4 个，且 n 除以所有测试用例的值之和不超过 2⋅10^5。此外，在单个测试用例中对 n 没有额外的约束。

最近，爱丽丝和鲍勃的父母给了他们 n 个不同颜色的弹珠。爱丽丝收到了 a1 颗颜色为 1 的弹珠，a2 颗颜色为 2 的弹珠，…，彩色弹珠。Bob 收到了 b1 颗颜色为 1 的弹珠，b2 颗颜色为 2 的弹珠，…n, n 个颜色的弹珠。所有的 ai 和 bi 都在 1 到 10^9 之间。
经过一番讨论，Alice 和 Bob 想出了下面的游戏:玩家轮流，从 Alice 开始。在他们的回合中，一名玩家选择一种颜色 i，这样两名玩家都至少有一个这种颜色的弹珠。然后，玩家丢弃一颗颜色为 i 的弹珠，对手也丢弃所有颜色为 i 的弹珠。游戏结束时，没有颜色 i，使双方玩家至少有一个弹珠的颜色。
游戏中的分数是游戏结束时 Alice 剩下的弹珠数和 Bob 剩下的弹珠数之差。换句话说，游戏中的分数等于(A - B)，其中 A 是 Alice 拥有的弹珠数，B 是游戏结束时 Bob 拥有的弹珠数。Alice 想要最大化分数，而 Bob 想要最小化分数。
在游戏结束时计算分数，如果两个玩家都发挥最佳。

贪心。
======

input
5
3
4 2 1
1 2 4
4
1 20 1 20
100 15 10 20
5
1000000000 1000000000 1000000000 1000000000 1000000000
1 1 1 1 1
3
5 6 5
2 1 7
6
3 2 4 2 5 5
9 4 7 9 2 5
output
1
-9
2999999997
8
-6
 */