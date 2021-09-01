import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 三角形的高度
        int triangleM = triangle.size();
        // 自底向上 dp
        // +1 避免最后一层越界
        int[][] dp = new int[triangleM + 1][triangleM + 1];
        for (int i = triangleM - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
/*
120. 三角形最小路径和
https://leetcode-cn.com/problems/triangle/

动态规划。可以 自顶向下 或者 自底向上
自底向上可以规避一些边界条件。定义 dp[i][j] 为自底向上到 i,j 的最小路径和

         (0,0)
      (1,0) (1,1)
   (2,0) (2,1) (2,2)
(3,0) (3,1) (3,2) (3,3)

dp(2,0) = min((3,0), (3,1)) + (2,0)

时间复杂度 O(n^2)
空间复杂度 O(n^2) 可优化为 空间复杂度 O(n)
 */