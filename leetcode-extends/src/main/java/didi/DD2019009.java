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
                int sz = dsu.sz[qId];
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
            fa[rootQ] = rootP;
            int sum = sz[rootP] + sz[rootQ];
            sz[rootP] = sum;
            sz[rootQ] = sum;
        }
    }

    // 判断两线段是否相交
    // https://oi-wiki.org/geometry/2d/#%E5%BF%AB%E9%80%9F%E6%8E%92%E6%96%A5%E5%AE%9E%E9%AA%8C%E4%B8%8E%E8%B7%A8%E7%AB%8B%E5%AE%9E%E9%AA%8C
    static boolean isCross(Segment l1, Segment l2) {
        // 快速排斥实验: 如果两条线段所在的矩形区域没有重叠，则这两条线段一定不相交。
        double[] leftBottom1 = l1.getLeftBottom();
        double[] topRight1 = l1.getTopRight();
        double[] leftBottom2 = l2.getLeftBottom();
        double[] topRight2 = l2.getTopRight();
        if (topRight1[0] < leftBottom2[0] || topRight1[1] < leftBottom2[1]
                || topRight2[0] < leftBottom1[0] || topRight2[1] < leftBottom1[1]) {
            return false;
        }

        // 跨立实验: 判断一个点在直线的哪边，如果线段两点均在另一线段所在直线的同一侧，则这两条线段不相交。
        double[] v = l1.getVector();
        // p1 = x1y1, p2 = x2y2
        double[] p1q = {l2.x1 - l1.x1, l2.y1 - l1.y1};
        double[] p2q = {l2.x2 - l1.x1, l2.y2 - l1.y1};
        if ((p1q[0] * v[1] - p1q[1] * v[0]) * (p2q[0] * v[1] - p2q[1] * v[0]) > 0) {
            return false;
        }
        v = l2.getVector();
        p1q = new double[]{l1.x1 - l2.x1, l1.y1 - l2.y1};
        p2q = new double[]{l1.x2 - l2.x1, l1.y2 - l2.y1};
        if ((p1q[0] * v[1] - p1q[1] * v[0]) * (p2q[0] * v[1] - p2q[1] * v[0]) > 0) {
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
        double[] getLeftBottom() {
            return new double[]{Math.min(x1, x2), Math.min(y1, y2)};
        }

        // 获取线段所在矩形区域 右上角坐标点
        double[] getTopRight() {
            return new double[]{Math.max(x1, x2), Math.max(y1, y2)};
        }

        // 获取线段向量
        double[] getVector() {
            return new double[]{x2 - x1, y2 - y1};
        }
    }
}