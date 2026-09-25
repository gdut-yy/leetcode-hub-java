public class Autox220828T4 {
    private int[] parent;

    public boolean[] antPass(int[][] geometry, int[][] path) {
        int n = geometry.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 两两判断几何对象是否接触，并合并连通分量
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected(geometry[i], geometry[j])) {
                    union(i, j);
                }
            }
        }

        boolean[] res = new boolean[path.length];
        for (int i = 0; i < path.length; i++) {
            int start = path[i][0];
            int end = path[i][1];
            res[i] = (find(start) == find(end));
        }
        return res;
    }

    // 并查集查找
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // 并查集合并
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[px] = py;
        }
    }

    // 判断两个几何对象是否接触
    private boolean isConnected(int[] g1, int[] g2) {
        if (g1.length == 4 && g2.length == 4) {
            return segmentSegment(g1, g2);
        } else if (g1.length == 4 && g2.length == 3) {
            return segmentCircle(g1, g2);
        } else if (g1.length == 3 && g2.length == 4) {
            return segmentCircle(g2, g1);
        } else {
            return circleCircle(g1, g2);
        }
    }

    // 计算叉积
    private long cross(long ax, long ay, long bx, long by) {
        return ax * by - ay * bx;
    }

    // 判断点 (px, py) 是否在线段 (x1, y1)-(x2, y2) 上（含端点）
    private boolean onSegment(long x1, long y1, long x2, long y2, long px, long py) {
        return Math.min(x1, x2) <= px && px <= Math.max(x1, x2) &&
                Math.min(y1, y2) <= py && py <= Math.max(y1, y2);
    }

    // 线段与线段相交（包括端点接触）
    private boolean segmentSegment(int[] s1, int[] s2) {
        long x1 = s1[0], y1 = s1[1], x2 = s1[2], y2 = s1[3];
        long x3 = s2[0], y3 = s2[1], x4 = s2[2], y4 = s2[3];

        long d1 = cross(x2 - x1, y2 - y1, x3 - x1, y3 - y1);
        long d2 = cross(x2 - x1, y2 - y1, x4 - x1, y4 - y1);
        long d3 = cross(x4 - x3, y4 - y3, x1 - x3, y1 - y3);
        long d4 = cross(x4 - x3, y4 - y3, x2 - x3, y2 - y3);

        // 跨立实验
        if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) &&
                ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
            return true;
        }

        // 共线情况
        if (d1 == 0 && onSegment(x1, y1, x2, y2, x3, y3)) return true;
        if (d2 == 0 && onSegment(x1, y1, x2, y2, x4, y4)) return true;
        if (d3 == 0 && onSegment(x3, y3, x4, y4, x1, y1)) return true;
        if (d4 == 0 && onSegment(x3, y3, x4, y4, x2, y2)) return true;

        return false;
    }

    // 线段与圆相交（圆为圆周）
    private boolean segmentCircle(int[] seg, int[] cir) {
        long x1 = seg[0], y1 = seg[1], x2 = seg[2], y2 = seg[3];
        long cx = cir[0], cy = cir[1], r = cir[2];
        long r2 = r * r;

        long dA = (x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy);
        long dB = (x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy);

        // 线段完全在圆内部（不含圆周），无交点
        if (dA < r2 && dB < r2) {
            return false;
        }

        long dx = x2 - x1;
        long dy = y2 - y1;
        long len2 = dx * dx + dy * dy;

        // 线段退化为点
        if (len2 == 0) {
            return dA <= r2;
        }

        long dot = (cx - x1) * dx + (cy - y1) * dy;

        if (dot <= 0) {
            // 最近点是端点 A
            return dA <= r2;
        } else if (dot >= len2) {
            // 最近点是端点 B
            return dB <= r2;
        } else {
            // 垂足在线段上，计算点到直线距离
            long cross = dx * (cy - y1) - dy * (cx - x1);
            double dist = Math.abs(cross) / Math.sqrt(len2);
            return dist <= r + 1e-9;
        }
    }

    // 圆与圆相交（包括相切、内含但接触）
    private boolean circleCircle(int[] c1, int[] c2) {
        long x1 = c1[0], y1 = c1[1], r1 = c1[2];
        long x2 = c2[0], y2 = c2[1], r2 = c2[2];

        long dx = x1 - x2;
        long dy = y1 - y2;
        long d2 = dx * dx + dy * dy;

        long sum = r1 + r2;
        long diff = Math.abs(r1 - r2);

        // 相交或相切的条件：|r1-r2| <= d <= r1+r2
        return d2 >= diff * diff && d2 <= sum * sum;
    }
}
/*
AutoX-4. 蚂蚁爬行
https://leetcode.cn/contest/autox2023/problems/TcdlJS/

在一张稿纸上画了若干由线条构成的的线段和正圆形。geometry[i] 表示对于第 i 个线条有：
- 若 geometry[i].length 为 4 ，表示为一条线段，[x1, y1, x2, y2] 表示该线段的两个端点坐标分别为 (x1,y1) 和 (x2,y2)。
- 若 geometry[i].length 为 3 ，表示为一个正圆形，[x, y, r] 表示其圆心坐标和半径分别为 (x,y) 和 r
现有一群小蚂蚁在这些线条上爬行，path[i] = [start, end] 表示第 i 只蚂蚁从第 start 个线条前往第 end 个线条。在爬行过程中，对于任意两个线条，只要有接触（公共点），小蚂蚁就能从一个爬到另一个。请判断这些小蚂蚁能否到达各自的目的地。
示例 1：
输入：
geometry = [[2,5,7,3],[1,1,4,2],[4,3,2]]
path = [[0,1],[1,2],[0,2]]
输出：[true,true,true]
解释：如下图所示：
所有的几何对象都是可互通的，所有蚂蚁都可以到达目的地。
示例 2：
输入：
geometry = [[4,1,1],[3,2,1],[1,4,5,4]]
path = [[0,1],[2,0]]
输出：[true,false]
解释：如下图所示:
geometry[0] 和 geometry[1] 相接触，geometry[2] 不与任何几何对象接触，因此蚂蚁 1 无法到达，
提示：
2 <= geometry.length <= 1000
0 <= geometry[i][0],geometry[i][1] <= 10^5
对于线段，0 <= geometry[i][2],geometry[i][3] <= 10^5
对于正圆形，1 <= geometry[i][2] <= 10^5
1 <= path.length <= 1000
0 <= path[i][0], path[i][1] < geometry.length

https://leetcode.cn/circle/discuss/iTuZLj/
 */