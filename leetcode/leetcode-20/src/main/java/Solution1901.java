public class Solution1901 {
    public int[] findPeakGrid(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        int max = 0;
        int[] res = new int[2];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] > max) {
                    max = mat[i][j];
                    res = new int[]{i, j};
                }
            }
        }
        return res;
    }
}
/*
1901. 找出顶峰元素 II
https://leetcode.cn/problems/find-a-peak-element-ii/

一个 2D 网格中的 顶峰元素 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 顶峰元素 mat[i][j] 并 返回其位置 [i,j] 。
你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 10^5
任意两个相邻元素均不相等.

不讲武德 直接找最大值。
时间复杂度 O(mn)
 */