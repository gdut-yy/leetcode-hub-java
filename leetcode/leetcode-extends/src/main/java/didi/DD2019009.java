package didi;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DD2019009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String[] lines = new String[n];
            scanner.nextLine();
            for (int j = 0; j < n; j++) {
                lines[j] = scanner.nextLine();
            }

            List<String> res = solve(n, lines);
            for (String re : res) {
                System.out.println(re);
            }
            System.out.println();
        }
    }

    private static final int MAX_N = 1000;

    private static List<String> solve(int n, String[] lines) {
        List<String> resList = new ArrayList<>();
        int id = 0;
        Segment[] segments = new Segment[MAX_N + 1];

        // 并查集
        DSU dsu = new DSU(MAX_N + 1);
        for (int i = 0; i < n; i++) {
            if (lines[i].startsWith("T")) {
                String[] tuple = lines[i].split(" ");
                double x1 = Double.parseDouble(tuple[1]);
                double y1 = Double.parseDouble(tuple[2]);
                double x2 = Double.parseDouble(tuple[3]);
                double y2 = Double.parseDouble(tuple[4]);
                Segment segment = new Segment(x1, y1, x2, y2);
                for (int j = 1; j <= id; j++) {
                    if (isCross(segments[j], segment)) {
                        dsu.union(j, id + 1);
                    }
                }
                segments[++id] = segment;
            } else {
                String[] tuple = lines[i].split(" ");
                int qId = Integer.parseInt(tuple[1]);
                int sz = dsu.sz[dsu.find(qId)];
                resList.add(String.valueOf(sz));
            }
        }
        return resList;
    }

    private static class DSU {
        // 父节点数组/祖先数组
        int[] fa;
        int[] sz;

        // 初始化
        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = new int[n];
            Arrays.fill(sz, 1);
        }

        // 查找
        int find(int x) {
            // 路径压缩
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        // 合并
        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // 合并到更小的节点
            if (rootP < rootQ) {
                fa[rootQ] = rootP;
                sz[rootP] += sz[rootQ];
            } else {
                fa[rootP] = rootQ;
                sz[rootQ] += sz[rootP];
            }
        }
    }

    // 判断两线段是否相交
    // https://oi-wiki.org/geometry/2d/#%E5%BF%AB%E9%80%9F%E6%8E%92%E6%96%A5%E5%AE%9E%E9%AA%8C%E4%B8%8E%E8%B7%A8%E7%AB%8B%E5%AE%9E%E9%AA%8C
    private static boolean isCross(Segment l1, Segment l2) {
        // 快速排斥实验: 如果两条线段所在的矩形区域没有公共区域，则这两条线段一定不相交。
        double[] rectangle1 = l1.getRectangle();
        double[] rectangle2 = l2.getRectangle();
        if (rectangle1[0] > rectangle2[2] || rectangle1[1] > rectangle2[3] || rectangle2[0] > rectangle1[2] || rectangle2[1] > rectangle1[3]) {
            return false;
        }

        // 跨立实验: 判断一个点在直线的哪边，如果线段两点均在另一线段所在直线的同一侧，则这两条线段不相交。
        // 直线上的一点 P 的直线的方向向量 v，想知道某个点 Q 在直线的哪边。
        double[] v = l1.getVector();
        // Q1 = [x1,y1], Q2 = [x2,y2]
        double[] pQ1 = {l2.x1 - l1.x1, l2.y1 - l1.y1};
        double[] pQ2 = {l2.x2 - l1.x1, l2.y2 - l1.y1};
        if ((pQ1[0] * v[1] - pQ1[1] * v[0]) * (pQ2[0] * v[1] - pQ2[1] * v[0]) > 0) {
            return false;
        }
        v = l2.getVector();
        pQ1 = new double[]{l1.x1 - l2.x1, l1.y1 - l2.y1};
        pQ2 = new double[]{l1.x2 - l2.x1, l1.y2 - l2.y1};
        if ((pQ1[0] * v[1] - pQ1[1] * v[0]) * (pQ2[0] * v[1] - pQ2[1] * v[0]) > 0) {
            return false;
        }
        return true;
    }

    private static class Segment {
        double x1, y1, x2, y2;

        public Segment(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        // 获取线段所在矩形区域 左下角坐标点
        double[] getRectangle() {
            return new double[]{Math.min(x1, x2), Math.min(y1, y2), Math.max(x1, x2), Math.max(y1, y2)};
        }

        // 获取线段向量
        double[] getVector() {
            return new double[]{x2 - x1, y2 - y1};
        }
    }
}
/*
DD-2019009. 交通轨迹分析
https://leetcode.cn/problems/NXNHyE/

为了分析道路交通状况，现在要对司机的行驶轨迹划分区域。假设司机的行驶轨迹是一条线段，如果两条行驶轨迹相交，则这两条轨迹属于同 一个区域。
随着时间的增加，轨迹数量会不断增加。现在有 n 条命令，以 T 开头的命令表示新增的司机的行驶轨迹，以 Q 开头的命令表示查询当 前状态下这条行驶轨迹所属的区域包含多少条行驶轨迹。
格式：
输入：
- 第一行是 t，表示多少组测试数据。
- 每组数据的第一行是 n，表示多少条命令。接下来 n 行:
  - 以 T 开头的表示新增的司机的行驶轨迹，T 后面跟着 4 个数字，分别代表起点的 x1,y1，终点的 x2,y2。
  - 以 Q 开头的表示查询该条行驶轨迹所属的区域当前包含多少条行驶轨迹。Q 后面的数字表示要查询的轨迹的 id。
    - 轨迹的 id 从 1 开始，随着轨迹增加。
  - 如下例子，T 0 0 10 0 表示轨迹起点是(0, 0)，终点是(10, 0)，轨迹 id 是 1。
  T 1 -1 1 1 表示轨迹起点是(1, -1)，终点是(1, 1)，轨迹 id 是 5。 Q 4 表示查询当前状态下 id 为 4 的轨迹所在区域包含的轨迹数量。
题目保证测试数据合法，不会查询还未出现的轨迹(例如，当前总共插入了 10 条轨迹，查询出现 Q 11 的情况)。
输出：
- 输出查询的结果，每行一个结果。不同组的测试数据之间有一个空行分隔。
示例：
输入：
2
8
T 0 0 10 0
T 5 0 15 0
Q 1
T 0 1 10 1
T 5 1 15 1
Q 4
T 1 -1 1 1
Q 1
3
T 0 0 1 1
T 0 1  1 0
Q 2
输出：
2
2
5

2
提示：
n <= 1000
 */