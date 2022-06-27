import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ccbft211029T4 {
    // 朴素矩阵快速幂 O(row^3 log(1e9) position.length)
    private static final long MOD = 1000000007;
    private static List<long[][][]> TRANS_CACHE_LIST;

    // 矩阵快速幂 O(row^3 log(1e9) position.length)
    public int electricityExperiment(int row, int col, int[][] position) {
        // 将所有目标插孔 由左到右 排序
        Arrays.sort(position, Comparator.comparingInt(x -> x[1]));
        // 预处理 转移矩阵 幂结果 list.get(row-1) 即 row 阶 [T, T^2, T^4, ..., T^(2^29)]
        pretreatment();

        long[] res = new long[row];
        // 第一个插孔的行坐标
        int firstPosition0 = position[0][0];
        res[firstPosition0] = 1;
        for (int i = 1; i < position.length; i++) {
            // 列间距
            int diff1 = position[i][1] - position[i - 1][1];
            // 预处理后 比 朴素快速幂 节约 1 次矩阵乘运算
            int idx = 0;
            while (diff1 != 0) {
                if ((diff1 & 1) == 1) {
                    // 当前 row 阶 T^(2^i)
                    long[][] curRowTran = TRANS_CACHE_LIST.get(row - 1)[idx];
                    res = matMultiply(curRowTran, res);
                }
                diff1 >>= 1;
                idx++;
            }
            // 非目标项置 0
            long tmp = res[position[i][0]];
            Arrays.fill(res, 0);
            res[position[i][0]] = tmp;
        }
        // 最后一个插孔的行坐标
        int lastPosition0 = position[position.length - 1][0];
        return (int) res[lastPosition0];
    }

    /**
     * 预处理 转移矩阵 幂结果
     */
    private void pretreatment() {
        if (TRANS_CACHE_LIST == null) {
            TRANS_CACHE_LIST = new ArrayList<>();
            // 1 <= row <= 20
            for (int i = 1; i <= 20; i++) {
                // 3 <= col <= 10^9
                // log(1e9) = 29.897 < 30
                long[][][] res = new long[30][i][i];
                // 转移矩阵
                res[0] = transferMatrix(i);
                for (int j = 1; j < 30; j++) {
                    res[j] = matMultiply(res[j - 1], res[j - 1]);
                }
                TRANS_CACHE_LIST.add(res);
            }
        }
    }

    /**
     * 转移矩阵
     */
    private long[][] transferMatrix(int row) {
        long[][] res = new long[row][row];
        for (int i = 0; i < row; i++) {
            res[i][i] = 1;
        }
        for (int i = 0; i < row - 1; i++) {
            res[i][i + 1] = 1;
        }
        for (int i = 0; i < row - 1; i++) {
            res[i + 1][i] = 1;
        }
        return res;
    }

    /**
     * 矩阵乘 res[][] = a[][] * b[][]
     */
    private long[][] matMultiply(long[][] a, long[][] b) {
        int row = a.length;
        long[][] res = new long[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < row; k++) {
                    res[i][j] += (a[i][k] * b[k][j]) % MOD;
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }

    /**
     * 矩阵乘 res[] = a[][] * b[]
     */
    private long[] matMultiply(long[][] a, long[] b) {
        int row = a.length;
        long[] res = new long[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                res[i] += ((a[i][j]) * b[j]) % MOD;
                res[i] %= MOD;
            }
        }
        return res;
    }
}
/*
建信04. 电学实验课
https://leetcode.cn/contest/ccbft-2021fall/problems/lSjqMF/

某电学实验使用了 row * col 个插孔的面包板，可视作二维矩阵，左上角记作 (0,0)。老师设置了若干「目标插孔」，
它们位置对应的矩阵下标记于二维数组 position。实验目标要求同学们用导线连接所有「目标插孔」，
即从任意一个「目标插孔」沿导线可以到达其他任意「目标插孔」。受实验导线长度所限，导线的连接规则如下：

一条导线可连接相邻两列的且行间距不超过 1 的两个插孔
每一列插孔中最多使用其中一个插孔（包括「目标插孔」）
若实验目标可达成，请返回使用导线数量最少的连接所有目标插孔的方案数；否则请返回 0。

注意：
输入数据保证每列最多仅有一个「目标插孔」；
答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1

示例 1：
输入：row = 5, col = 6, position = [[1,3],[3,2],[4,1]]
输出：0
解释：根据连接规则无法达成实验目标。

示例 2：
输入：row = 3，col = 4, position = [[0,3],[2,0]]
输出：3
解释：根据连接规则共有三种方案达成目标。

示例 3：
输入：row = 5, col = 6, position = [[1,3],[3,5],[2,0]]
输出：6
解释：根据连接规则共有六种方案达成目标。

提示：
1 <= row <= 20
3 <= col <= 10^9
1 < position.length <= 1000
0 <= position[i][0] < row
0 <= position[i][1] < col
 */