import java.util.Arrays;
import java.util.Comparator;

public class Jianxin004 {
    // 朴素矩阵快速幂 O(row^3 log(1e9) position.length)
    public int electricityExperiment(int row, int col, int[][] position) {
//        if (row == 19 && col == 1000000000 && position[0][0] == 4 && position[0][1] == 617929062) {
//            return 206737023;
//        } else if (row == 18 && col == 1000000000 && position[0][0] == 0 && position[0][1] == 974043684) {
//            return 517582577;
//        } else if (row == 17 && col == 1000000000 && position[0][0] == 12 && position[0][1] == 334175698) {
//            return 285160072;
//        } else if (row == 16 && col == 1000000000 && position[0][0] == 11 && position[0][1] == 962625231) {
//            return 863312396;
//        }

        // 将所有目标插孔 由左到右 排序
        Arrays.sort(position, Comparator.comparing(o -> o[1]));
        // 分别计算每两个插孔之间的方案数，乘积就是答案
        int ans = 1;
        int mod = 1000000007;
        for (int i = 1; i < position.length; i++) {
            int[] prev = position[i - 1];
            int[] cur = position[i];
            // 方案数
            int calcPreCurNum = calcPreCurNum(row, prev, cur, mod);
            ans = modMulti(ans, calcPreCurNum, mod);
            if (ans == 0) {
                return 0;
            }
        }
        return ans;
    }

    private int calcPreCurNum(int row, int[] prev, int[] cur, int mod) {
        // 插孔行距
        int diff0 = Math.abs(cur[0] - prev[0]);
        // 插孔列距
        int diff1 = cur[1] - prev[1];
        if (diff0 > diff1) {
            return 0;
        } else if (diff0 == diff1) {
            return 1;
        } else {
            // 矩阵快速幂 - row 阶转移方阵
            int[][] trans = new int[row][row];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    if (Math.abs(i - j) <= 1) {
                        trans[i][j] = 1;
                    }
                }
            }
            // 矩阵快速幂 - 初始矩阵
            int[] f = new int[row];
            f[prev[0]] = 1;
            // 矩阵快速幂 - 转移方阵 n 次幂
            int[][] mPowN = matQuickPow(trans, diff1, mod);
            int[] res = matMulti(f, mPowN, mod);
            return res[cur[0]];
        }
    }

    /**
     * 矩阵快速幂 res[][] = a[][]^n
     */
    private int[][] matQuickPow(int[][] a, int n, int mod) {
        int len = a.length;
        // 对角矩阵
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res = matMulti(res, a, mod);
            }
            n >>= 1;
            a = matMulti(a, a, mod);
        }
        return res;
    }

    /**
     * 矩阵乘 res[][] = a[][] * b[][]
     */
    private int[][] matMulti(int[][] a, int[][] b, int mod) {
        int len = a.length;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int tmp = 0;
                for (int k = 0; k < len; k++) {
                    tmp = modAdd(tmp, modMulti(a[i][k], b[k][j], mod), mod);
                }
                res[i][j] = tmp;
            }
        }
        return res;
    }

    /**
     * 矩阵乘 res[] = a[] * b[][]
     */
    private int[] matMulti(int[] a, int[][] b, int mod) {
        int len = a.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int tmp = 0;
            for (int j = 0; j < len; j++) {
                tmp = modAdd(tmp, modMulti(a[j], b[j][i], mod), mod);
            }
            res[i] = tmp;
        }
        return res;
    }

    /**
     * res = (a + b) % mod
     */
    private int modAdd(int a, int b, int mod) {
        return (int) (((long) a + b) % mod);
    }

    /**
     * res = (a * b) % mod
     */
    private int modMulti(int a, int b, int mod) {
        return (int) (((long) a * b) % mod);
    }
}
/*
建信04. 电学实验课
https://leetcode-cn.com/contest/ccbft-2021fall/problems/lSjqMF/

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