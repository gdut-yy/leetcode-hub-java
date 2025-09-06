public class SolutionP3391 {
    static class Matrix3D {
        private final int n;
        private final int[][][] matrix;
        private final int[] sums;

        public Matrix3D(int n) {
            this.n = n;
            this.matrix = new int[n][n][n];
            this.sums = new int[n];
        }

        public void setCell(int x, int y, int z) {
            update(x, y, z, 1);
        }

        public void unsetCell(int x, int y, int z) {
            update(x, y, z, 0);
        }

        public int largestMatrix() {
            int largestIndex = n - 1;
            for (int x = n - 2; x >= 0; x--) {
                if (sums[x] > sums[largestIndex]) {
                    largestIndex = x;
                }
            }
            return largestIndex;
        }

        private void update(int x, int y, int z, int newValue) {
            if (newValue != matrix[x][y][z]) {
                sums[x] -= matrix[x][y][z];
                matrix[x][y][z] = newValue;
                sums[x] += matrix[x][y][z];
            }
        }
    }
}
/*
$3391. 设计一个高效的层跟踪三维二进制矩阵
https://leetcode.cn/problems/design-a-3d-binary-matrix-with-efficient-layer-tracking/description/

给定一个 n x n x n 的 二进制 三维数组 matrix。
实现 Matrix3D 类：
- Matrix3D(int n) 用三维二进制数组 matrix 初始化对象，其中 所有 元素都初始化为 0。
- void setCell(int x, int y, int z) 将 matrix[x][y][z] 的值设为 1。
- void unsetCell(int x, int y, int z) 将 matrix[x][y][z] 的值设为 0。
- int largestMatrix() 返回包含最多 1 的 matrix[x] 的下标 x。如果这样的对应值有多个，返回 最大的 x。
提示：
1 <= n <= 100
0 <= x, y, z < n
最多总共调用 10^5 次 setCell 和 unsetCell。
最多调用 10^4 次 largestMatrix。

模拟。
 */