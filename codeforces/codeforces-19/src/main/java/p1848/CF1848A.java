package p1848;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1848A {
    static int n, m, k, x, y;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();
            x = scanner.nextInt();
            y = scanner.nextInt();
            xy = new int[k][2];
            for (int i = 0; i < k; i++) {
                xy[i][0] = scanner.nextInt();
                xy[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    // https://codeforces.com/contest/1848/submission/214049472
    private static String solve() {
        boolean vika = (x + y) % 2 == 1;
        for (int[] p : xy) {
            boolean friend = (p[0] + p[1]) % 2 == 1;
            // 奇偶性相同
            if (vika == friend) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
Codeforces Round 885 (Div. 2) https://www.bilibili.com/video/BV1CV4y1b72n/
A. Vika and Her Friends
https://codeforces.com/contest/1848/problem/A

题目大意：
Vika 和她的朋友们去商场购物，商场可以表示为边长为 n 和 m 的房间的矩形网格。每个房间有坐标(a,b)，其中 1≤a≤n,1≤b≤m。因此，如果|a−c|+|b−d|=1，我们称坐标为(c,d)的大厅为它的邻居。
厌倦了空洞的时尚话题，Vika 决定悄悄溜走。但由于她还没有机会参观任何一家商店，她不想离开购物中心。过了一段时间，她的朋友们注意到了维卡的失踪，开始寻找她。
目前，Vika 在一个坐标为(x,y)的房间里，她的 k 个朋友在一个坐标为(x1,y1)， (x2,y2)，…，(xk,yk)。坐标可以重合。注意，所有的女孩必须搬到邻近的房间去。
每一分钟，Vika 首先移动到她选择的一个相邻的房间，然后每个朋友(看到 Vika 的选择)也选择一个相邻的房间移动。
如果在一分钟结束时(也就是说，在所有的女孩都搬到邻近的房间之后)，至少有一个朋友和 Vika 在同一个房间里，她就会被抓住，所有其他的朋友都会被召唤出来。
告诉我们，Vika 能永远远离她那些烦人的朋友吗?或者过一段时间她会继续听那些空洞的时尚谈话吗?

棋盘染色
======

input
6
2 2 1
1 1
1 2
2 2 2
1 1
2 2
2 2
1 2 1
1 1
1 2
5 5 4
3 3
1 1
1 5
5 1
5 5
2 2 2
1 1
2 1
1 2
3 4 1
1 2
3 3
output
YES
NO
YES
NO
YES
YES
 */
