import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionLCP74 {
    public int fieldOfGreatestBlessing(int[][] forceField) {
        // 离散化 begin
        Set<Double> xSet = new HashSet<>();
        Set<Double> ySet = new HashSet<>();
        for (int[] fo : forceField) {
            double x1 = fo[0] + fo[2] / 2.0, y1 = fo[1] + fo[2] / 2.0;
            double x2 = fo[0] - fo[2] / 2.0, y2 = fo[1] - fo[2] / 2.0;
            xSet.add(x1);
            xSet.add(x2);
            ySet.add(y1);
            ySet.add(y2);
        }
        int xsz = xSet.size();
        double[] xArr = new double[xsz];
        int id = 0;
        for (double x : xSet) {
            xArr[id++] = x;
        }
        Arrays.sort(xArr);
        int ysz = ySet.size();
        double[] yArr = new double[ysz];
        id = 0;
        for (double x : ySet) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        // 离散化 end

        PrefixSum2d prefixSum2d = new PrefixSum2d(new int[xsz][ysz]);
        for (int[] fo : forceField) {
            double x1 = fo[0] + fo[2] / 2.0, y1 = fo[1] + fo[2] / 2.0;
            double x2 = fo[0] - fo[2] / 2.0, y2 = fo[1] - fo[2] / 2.0;

            int x1id = getId(xArr, x1), x2id = getId(xArr, x2);
            int y1id = getId(yArr, y1), y2id = getId(yArr, y2);

            prefixSum2d.rangeAdd(x2id, y2id, x1id, y1id, 1);
        }
        int max = 0;
        // 原数组
        int[][] originArr = prefixSum2d.originalArray();
        for (int i = 0; i < xsz; i++) {
            for (int j = 0; j < ysz; j++) {
                max = Math.max(max, originArr[i][j]);
            }
        }
        return max;
    }

    private int getId(double[] yArr, double x) {
        return Arrays.binarySearch(yArr, x);
    }

    private static class PrefixSum2d {
        private final int M;
        private final int N;
        private final int[][] preSum2d;
        private final int[][] diff2d;

        public PrefixSum2d(int[][] matrix) {
            this.M = matrix.length;
            this.N = matrix[0].length;
            // 预处理前缀和
            preSum2d = new int[M + 1][N + 1];
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    // 当前格 = 上 + 左 - 左上 + 原值
                    preSum2d[i][j] = preSum2d[i - 1][j] + preSum2d[i][j - 1] - preSum2d[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
            // 差分 init
            diff2d = new int[M + 1][N + 1];
        }

        // 二维前缀和：求 matrix [row1,col1] 到 [row2,col2] 的累加和
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum2d[row2 + 1][col2 + 1] - preSum2d[row2 + 1][col1] - preSum2d[row1][col2 + 1] + preSum2d[row1][col1];
        }

        // 二维差分：matrix [row1,col1] 到 [row2,col2] 全部增加 inc
        public void rangeAdd(int row1, int col1, int row2, int col2, int inc) {
            diff2d[row1][col1] += inc;
            diff2d[row1][col2 + 1] -= inc;
            diff2d[row2 + 1][col1] -= inc;
            diff2d[row2 + 1][col2 + 1] += inc;
        }

        // 二维差分：获取原数组
        public int[][] originalArray() {
            int[][] res = new int[M][N];
            // 0 行
            res[0][0] = diff2d[0][0];
            for (int j = 1; j < N; j++) {
                res[0][j] = res[0][j - 1] + diff2d[0][j];
            }
            // 0 列
            for (int i = 1; i < M; i++) {
                res[i][0] = res[i - 1][0] + diff2d[i][0];
            }
            // 1 行 1 列。。。
            for (int i = 1; i < M; i++) {
                for (int j = 1; j < N; j++) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1] - res[i - 1][j - 1] + diff2d[i][j];
                }
            }
            return res;
        }
    }
}
/*
LCP 74. 最强祝福力场
https://leetcode.cn/problems/xepqZ5/

LCCUP'23 春季个人赛 T3。

小扣在探索丛林的过程中，无意间发现了传说中“落寞的黄金之都”。而在这片建筑废墟的地带中，小扣使用探测仪监测到了存在某种带有「祝福」效果的力场。
经过不断的勘测记录，小扣将所有力场的分布都记录了下来。forceField[i] = [x,y,side] 表示第 i 片力场将覆盖以坐标 (x,y) 为中心，边长为 side 的正方形区域。
若任意一点的 力场强度 等于覆盖该点的力场数量，请求出在这片地带中 力场强度 最强处的 力场强度。
注意：
- 力场范围的边缘同样被力场覆盖。
提示：
1 <= forceField.length <= 100
forceField[i].length == 3
0 <= forceField[i][0], forceField[i][1] <= 10^9
1 <= forceField[i][2] <= 10^9

离散化 + 二维差分
 */