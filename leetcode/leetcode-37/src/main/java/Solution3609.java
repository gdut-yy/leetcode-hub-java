public class Solution3609 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void swap() {
            int tmp = x;
            x = y;
            y = tmp;
        }
    }

    public int minMoves(int sx, int sy, int tx, int ty) {
        Node point_s = new Node(sx, sy), point_t = new Node(tx, ty);
        // 坐标值只会增加，因此退得比初始坐标还小则无解
        if (sx > tx || sy > ty) return -1;
        // 退到了初始坐标
        if (sx == tx && sy == ty) return 0;

        // x = y 的特殊情况
        if (tx == ty) {
            // 让初始值为 0 的那一维退回 0
            if (sx == 0) {
                point_s.swap();
                point_t.swap();
            }
            int t = minMoves(point_s.x, point_s.y, point_t.x, 0);
            return t >= 0 ? t + 1 : -1;
        }

        if (tx < ty) {
            point_s.swap();
            point_t.swap();
        }
        // 按 x 和 2y 的关系决定怎么退
        if (point_t.x >= 2 * point_t.y) {
            if (point_t.x % 2 != 0) return -1;
            int t = minMoves(point_s.x, point_s.y, point_t.x / 2, point_t.y);
            return t >= 0 ? t + 1 : -1;
        } else {
            int t = minMoves(point_s.x, point_s.y, point_t.x - point_t.y, point_t.y);
            return t >= 0 ? t + 1 : -1;
        }
    }
}
/*
3609. 到达目标点的最小移动次数
https://leetcode.cn/problems/minimum-moves-to-reach-target-in-grid/description/

第 457 场周赛 T4。

给你四个整数 sx、sy、tx 和 ty，表示在一个无限大的二维网格上的两个点 (sx, sy) 和 (tx, ty)。
你的起点是 (sx, sy)。
在任何位置 (x, y)，定义 m = max(x, y)。你可以执行以下两种操作之一：
- 移动到 (x + m, y)，或者
- 移动到 (x, y + m)。
返回到达 (tx, ty) 所需的 最小 移动次数。如果无法到达目标点，则返回 -1。
提示：
0 <= sx <= tx <= 10^9
0 <= sy <= ty <= 10^9

逆向思维 + 分类讨论。
1.如果 tx = ty
  1.1 如果 sx > 0，那么只能把 ty 变成 0
  1.2 如果 sy > 0，那么只能把 tx 变成 0
  1.3 如果 sx = sy = 0？起点动不了，所以无法到达终点
2. 如果 x > y，只能做操作一 不等式的三歧性
  2.1 x > 2y 把 x 减半（前提就是 x 是偶数）
  2.2 x < 2y 把 x 减去 y
  2.3 x = 2y 把 x 减半得到 y，把 x 减去 y 也得到 y，所以是一样的，可以整合到 2.2
相似题目: 780. 到达终点
https://leetcode.cn/problems/reaching-points/
rating 2451 (clist.by)
 */