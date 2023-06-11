package p1807;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CF1807F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int i1 = scanner.nextInt();
            int j1 = scanner.nextInt();
            int i2 = scanner.nextInt();
            int j2 = scanner.nextInt();
            String d = scanner.next();
            System.out.println(solve(n, m, i1, j1, i2, j2, d));
        }
    }

    private static String solve(int n, int m, int i1, int j1, int i2, int j2, String d) {
        int dx = d.charAt(0) == 'D' ? 1 : -1;
        int dy = d.charAt(1) == 'R' ? 1 : -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i1, j1, dx, dy});
        Set<String> visitSet = new HashSet<>();

        // 碰撞次数
        int hits = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.remove();
            int cx = tuple[0], cy = tuple[1];

            int tx = i2 - cx, ty = j2 - cy;
            if (tx / dx == ty / dy && tx / dx >= 0) {
                return String.valueOf(hits);
            }

            // 移动步数
            int k = Math.max(m, n);
            k = dx == 1 ? Math.min(k, n - cx) : Math.min(k, cx - 1);
            k = dy == 1 ? Math.min(k, m - cy) : Math.min(k, cy - 1);
            cx += k * dx;
            cy += k * dy;

            // 左右墙反弹
            if ((dy == -1 && cy == 1) || (dy == 1 && cy == m)) {
                dy = -dy;
            }
            // 上下墙反弹
            if ((dx == -1 && cx == 1) || (dx == 1 && cx == n)) {
                dx = -dx;
            }

            String key = cx + ":" + cy + ":" + dx + ":" + dy;
            if (visitSet.contains(key)) continue;
            visitSet.add(key);
            queue.add(new int[]{cx, cy, dx, dy});

            hits++;
        }

        return "-1";
    }
}
/*
F. Bouncy Ball
https://codeforces.com/contest/1807/problem/F

题目大意：
给你一个可以用 n×m 网格表示的房间。在(i1,j1)位置(第 i1 行和第 j1 列的交点)有一个球，它开始在四个方向之一对角线运动:
球向右向下，用 DR 表示;这意味着在一步之后，球的位置从(i,j)到(i+1,j+1)。
球向下向左运动，记为 DL;这意味着在一步之后，球的位置从(i,j)到(i+1,j−1)。
球向上向右，用 UR 表示;这意味着在一步之后，球的位置从(i,j)到(i−1,j+1)。
球向上向左，用 UL 表示;这意味着在一步之后，球的位置从(i,j)到(i−1,j−1)。
在每一步之后，球保持它的方向，除非它撞到墙壁(也就是说，在下一步，这个方向使它离开了房间的边界)。在这种情况下，球的方向沿着墙的轴翻转;如果球碰到角落，两个方向都翻转了。任何这种情况都被称为反弹。球从未停止运动。
在上面的例子中，球从(1,7)开始，走 DL，直到它到达底部壁，然后它反弹并继续向 UL 方向前进。球到达左墙后，反弹并继续向 UR 方向运动。当球到达上壁时，它反弹并继续向 DR 方向移动。到达右下角后，它反弹一次，并继续向 UL 方向，依此类推。
你的任务是找出球在到达单元格(i2,j2)之前要经过多少次反弹，或者通过打印 −1 来报告它从未到达单元格(i2,j2)。
请注意，球首先进入一个单元格，然后才会在需要时反弹。

模拟。
相似题目: A. Robot Cleaner
https://codeforces.com/contest/1623/problem/A
======

input
6
5 7 1 7 2 4 DL
5 7 1 7 3 2 DL
3 3 1 3 2 2 UR
2 4 2 1 2 2 DR
4 3 1 1 1 3 UL
6 4 1 2 3 4 DR
output
3
-1
1
-1
4
0
 */
