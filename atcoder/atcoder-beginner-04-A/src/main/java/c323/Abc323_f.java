package c323;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc323_f {
    static long ax, ay, bx, by, cx, cy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        ax = scanner.nextLong();
        ay = scanner.nextLong();
        bx = scanner.nextLong();
        by = scanner.nextLong();
        cx = scanner.nextLong();
        cy = scanner.nextLong();
        System.out.println(solve());
    }

    // https://atcoder.jp/contests/abc323/editorial/7361
    private static String solve() {
        ax -= bx;
        ay -= by;

        cx -= bx;
        cy -= by;

        long[][] vis = new long[2][2];
        int id = 0;
        if (cx > 0) {
            vis[id][0] = -1;
            vis[id][1] = 0;
            id++;
        } else if (cx < 0) {
            vis[id][0] = 1;
            vis[id][1] = 0;
            id++;
        }
        if (cy > 0) {
            vis[id][0] = 0;
            vis[id][1] = -1;
            id++;
        } else if (cy < 0) {
            vis[id][0] = 0;
            vis[id][1] = 1;
            id++;
        }

        long ans = Math.abs(cx) + Math.abs(cy);
        if (id == 1) {
            ans += dist(ax, ay, vis[0][0], vis[0][1]);
        } else {
            ans += Math.min(dist(ax, ay, vis[0][0], vis[0][1]), dist(ax, ay, vis[1][0], vis[1][1])) + 2;
        }
        return String.valueOf(ans);
    }

    private static long dist(long x1, long y1, long x2, long y2) {
        if ((x1 == 0) && (x2 == 0) && (y1 * y2 < 0)) {
            return Math.abs(y1 - y2) + 2;
        }
        if ((y1 == 0) && (y2 == 0) && (x1 * x2 < 0)) {
            return Math.abs(x1 - x2) + 2;
        }
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static String solve1() {
        // b 点到 c 点
        long ans = Math.abs(bx - cx) + Math.abs(by - cy);

        long tx, ty;
        if (bx == cx) tx = bx;
        else if (bx < cx) tx = bx - 1;
        else tx = bx + 1;

        if (by == cy) ty = by;
        else if (by < cy) ty = by - 1;
        else ty = by + 1;

        // a 点到 t 点
        long d_at = Math.abs(ax - tx) + Math.abs(ay - ty);
        ans += d_at;

        // a 在 bc 连线上，多走 2 步
        if (ay == by && ay == cy && (bx < ax && ax < cx || cx < ax && ax < bx)) {
            ans += 2;
        } else if (ax == bx && ax == cx && (by < ay && ay < cy || cy < ay && ay < by)) {
            ans += 2;
        }

        // 从两个方向推
        if (Math.abs(bx - cx) > 0 && Math.abs(by - cy) > 0) {
            ans++;
        }
        return String.valueOf(ans);
    }
}
/*
F - Push and Carry
https://atcoder.jp/contests/abc323/tasks/abc323_f

题目大意：
高桥和货物在一个坐标平面上。
高桥目前在(XA,YA)，货物在(XB,YB)。他想把货物运到(XC,YC)。
当他在(x,y)时，他可以在一个动作中做出以下动作之一。
- 移动到(x+1,y) 如果货物在移动前位于(x+1,y)处，则将其移动到(x+2,y)处。
- 移动到(x−1,y) 如果搬运前货物位于(x−1,y)处，则将货物移至(x−2,y)处。
- 移动到(x,y+1) 如果货物在移动前位于(x,y+1)处，则将其移动到(x,y+2)处。
- 移动到(x,y-1) 如果搬运前货物位于(x,y−1)处，则将货物移至(x,y−2)处。
求将货物移动到(XC,YC)所需的最小动作数。

分类讨论
---
https://atcoder.jp/contests/abc323/editorial/7361
由于货物的初始位置(XB,YB)和最终位置(XC,YC)不同，高桥必须先移动到一个他可以推货物的位置，然后把货物带到目的地。
若设 Takahashi 与货物初始位置之间的曼哈顿距离为 d1 =|X1−X2|+|Y1−Y2|，且货物初始位置与最终位置之间的曼哈顿距离为 d2 =|X2−X3|+|Y2−Y3|，则至少需要(d1−1)+d2 = d1+d2−1 个动作。
此外，根据高桥和货物的初始相对位置，以及初始和最终货物之间的相对位置，最多可以再移动四步。
---
我们采用案例分析来处理这个问题。X 坐标的排序可以是三种(Xi<Xj,Xi=Xj,Xi>Xj)中的一种，因此两点的相对位置可以分为 3×3−1=8 种情况。
此外，我们需要考虑两对的相对位置，所以我们天真地需要考虑 64 种模式。通过适当地枚举模式并实现条件分支和计算，找出每个模式需要比(d1+d2−1)多多少个操作，您的代码将被接受。
在现实中，我们可以利用对称性将它们减少到 16 或 10 个模式，从而简化实现，缩短所需时间，并避免错误。
在这种方法中，大多数情况下的计算复杂度为 O(1)，因此即使是相当复杂的实现，执行时间限制也无关紧要。因此，问题已经解决了。
---
下面“细节”部分的描述侧重于简化证明而不是实现，因此您不必这样考虑。
======

Input 1
1 2 3 3 0 5
Output 1
9

Input 2
0 0 1 0 -1 0
Output 2
6

Input 3
-100000000000000000 -100000000000000000 100000000000000000 100000000000000000 -100000000000000000 -100000000000000000
Output 3
800000000000000003
 */
