import java.util.TreeMap;

public class Solution3453 {
    // 浮点数二分
    static class V1 {
        public double separateSquares(int[][] squares) {
            long totArea = 0;
            int maxY = 0;
            for (int[] sq : squares) {
                int l = sq[2];
                totArea += (long) l * l;
                maxY = Math.max(maxY, sq[1] + l);
            }

            double left = 0;
            double right = maxY;
            for (int i = 0; i < 47; i++) {
                double mid = (left + right) / 2;
                if (check(squares, mid, totArea)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return (left + right) / 2; // 区间中点误差小
        }

        private boolean check(int[][] squares, double y, long totArea) {
            double area = 0;
            for (int[] sq : squares) {
                double yi = sq[1];
                if (yi < y) {
                    double l = sq[2];
                    area += l * Math.min(y - yi, l);
                }
            }
            return area >= totArea / 2.0;
        }
    }

    static class V2 {
        // 整数二分（二分整数 y * M）
//        private static final int M = 100_000;
//
//        public double separateSquares(int[][] squares) {
//            long totArea = 0;
//            int maxY = 0;
//            for (int[] sq : squares) {
//                int l = sq[2];
//                totArea += (long) l * l;
//                maxY = Math.max(maxY, sq[1] + l);
//            }
//
//            long left = 0;
//            long right = (long) maxY * M;
//            while (left + 1 < right) {
//                long mid = (left + right) >>> 1;
//                if (check(squares, mid, totArea)) {
//                    right = mid;
//                } else {
//                    left = mid;
//                }
//            }
//            return (double) right / M;
//        }
//
//        private boolean check(int[][] squares, long multiY, double totArea) {
//            long area = 0;
//            for (int[] sq : squares) {
//                long y = sq[1];
//                if (y * M < multiY) {
//                    long l = sq[2];
//                    area += l * Math.min(multiY - y * M, l * M);
//                }
//            }
//            return area * 2 >= totArea * M;
//        }

        // 整数二分（二分最小的整数 y），浮点数部分通过解方程
        public double separateSquares(int[][] squares) {
            long totArea = 0;
            int maxY = 0;
            for (int[] sq : squares) {
                int l = sq[2];
                totArea += (long) l * l;
                maxY = Math.max(maxY, sq[1] + l);
            }

            int left = 0;
            int right = maxY;
            while (left + 1 < right) {
                int mid = (left + right) >>> 1;
                if (calcArea(squares, mid) * 2 >= totArea) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            int y = right;

            long areaY = calcArea(squares, y);
            long sumL = areaY - calcArea(squares, y - 1);
            return y - (areaY * 2 - totArea) / (sumL * 2.0); // 这样写误差更小
        }

        private long calcArea(int[][] squares, int y) {
            long area = 0;
            for (int[] sq : squares) {
                int yi = sq[1];
                if (yi < y) {
                    int l = sq[2];
                    area += (long) l * Math.min(y - yi, l);
                }
            }
            return area;
        }
    }

    // 差分
    static class V3 {
        public double separateSquares(int[][] squares) {
            long totArea = 0;
            TreeMap<Integer, Long> diff = new TreeMap<>();
            for (int[] sq : squares) {
                int y = sq[1];
                long l = sq[2];
                totArea += l * l;
                diff.merge(y, l, Long::sum);
                diff.merge(y + (int) l, -l, Long::sum);
            }

            long area = 0;
            long sumL = 0;
            int preY = 0; // 不好计算下一个 y，改成维护上一个 y
            for (var e : diff.entrySet()) {
                int y = e.getKey();
                area += sumL * (y - preY); // 底边长 * 高 = 新增面积
                if (area * 2 >= totArea) {
                    return y - (area * 2 - totArea) / (sumL * 2.0);
                }
                preY = y;
                sumL += e.getValue(); // 矩形底边长度之和
            }
            return -1;
        }
    }
}
/*
3453. 分割正方形 I
https://leetcode.cn/problems/separate-squares-i/description/

第 150 场双周赛 T2。

给你一个二维整数数组 squares ，其中 squares[i] = [xi, yi, li] 表示一个与 x 轴平行的正方形的左下角坐标和正方形的边长。
找到一个最小的 y 坐标，它对应一条水平线，该线需要满足它以上正方形的总面积 等于 该线以下正方形的总面积。
答案如果与实际答案的误差在 10^-5 以内，将视为正确答案。
注意：正方形 可能会 重叠。重叠区域应该被 多次计数 。
提示：
1 <= squares.length <= 5 * 10^4
squares[i] = [xi, yi, li]
squares[i].length == 3
0 <= xi, yi <= 10^9
1 <= li <= 10^9
所有正方形的总面积不超过 10^12。

浮点数二分 / 整数二分 / 差分。
由于浮点数精度问题，赛后增加了 所有正方形的总面积不超过 10^12 条件。
 */