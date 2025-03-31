import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        List<Integer> ans = new ArrayList<>();
        // 共有 m+n-1 条（主/次）对角线，k 的范围 [1, m+n-1]
        // 主对角线（左上到右下） 令 k=i+j+1 左上角 k=1 右下角 k=m+n-1, j=k-i-1, i=k-j-1
        // 次对角线（右上到左下） 令 k=i-j+n 右上角 k=1 左下角 k=m+n-1, j=i-k+n, i=k+j-n
        for (int k = 1; k <= m + n - 1; k++) {
            int min_j = Math.max(k - 1 - (m - 1), 0);
            int max_j = Math.min(k - 1, n - 1);

            List<Integer> a = new ArrayList<>();
            for (int j = min_j; j <= max_j; j++) {
                int i = k - j - 1;
                a.add(mat[i][j]);
            }

            if (k % 2 == 0) Collections.reverse(a);
            ans.addAll(a);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
498. 对角线遍历
https://leetcode.cn/problems/diagonal-traverse/description/

给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 10^4
1 <= m * n <= 10^4
-10^5 <= mat[i][j] <= 10^5

模拟。
时间复杂度 O(mn)。
相似题目: 3446. 按对角线进行矩阵排序
https://leetcode.cn/problems/sort-matrix-by-diagonals/description/
 */