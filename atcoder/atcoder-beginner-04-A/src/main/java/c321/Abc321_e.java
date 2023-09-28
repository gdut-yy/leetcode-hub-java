package c321;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc321_e {
    static long n, x, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            x = scanner.nextLong();
            k = scanner.nextLong();
            System.out.println(solve());
        }
    }

    static long[] pow2;

    private static String solve() {
        // 树有 max_level 层
        int max_level = Long.numberOfTrailingZeros(Long.highestOneBit(n));
        // 点 x 在 x_level 层
        int x_level = Long.numberOfTrailingZeros(Long.highestOneBit(x));

        pow2 = new long[max_level + 1];
        pow2[0] = 1;
        for (int i = 1; i < max_level + 1; i++) {
            pow2[i] = pow2[i - 1] * 2;
        }

        long ans = 0;
        for (int up = 0; up <= Math.min(x_level, k); up++) {
            long down = k - up;
            long lvl = x_level - up + down;
            if (lvl > max_level) continue;

            if (down == 0) {
                ans++;
            } else {
                long root = x / pow2[up];
                long points = getPoints(root, (int) down);
                // 去重，一条边往上走后不能往下走
                if (up > 0) {
                    long v = x / pow2[up - 1];
                    points -= getPoints(v, (int) (down - 1));
                }
                ans += points;
            }
        }
        return String.valueOf(ans);
    }

    private static long getPoints(long v, int down) {
        return Math.min(pow2[down], Math.max(0, n - v * pow2[down] + 1));
    }
}
/*
E - Complete Binary Tree
https://atcoder.jp/contests/abc321/tasks/abc321_e

题目大意：
有一棵树，有 N 个顶点，编号为 1 到 N。对于每个 i(2≤i≤N)，有一条边连接顶点 i 和顶点⌊2/i⌋。没有其他边了。
在这棵树中，找出与顶点 X 的距离为 k 的顶点的个数。这里，两个顶点 u 和 v 之间的距离定义为连接顶点 u 和 v 的简单路径上的边的个数。
你有 T 个测试用例需要解决。

不能建图，只能推公式。
完全二叉树性质
======

Input 1
5
10 2 0
10 2 1
10 2 2
10 2 3
10 2 4
Output 1
1
3
4
2
0

Input 2
10
822981260158260522 52 20
760713016476190629 2314654 57
1312150450968417 1132551176249851 7
1000000000000000000 1083770654 79
234122432773361868 170290518806790 23
536187734191890310 61862 14
594688604155374934 53288633578 39
1000000000000000000 120160810 78
89013034180999835 14853481725739 94
463213054346948152 825589 73
Output 2
1556480
140703128616960
8
17732923532771328
65536
24576
2147483640
33776997205278720
7881299347898368
27021597764222976
 */
