import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP3990Tests {
    private final SolutionP3990 solutionP3990 = new SolutionP3990();

    @Test
    public void example1() {
        int k = 2;
        List<String> grid = solutionP3990.createGrid(k);
        Assertions.assertEquals(k, countPaths(grid));
    }

    @Test
    public void example2() {
        int k = 3;
        List<String> grid = solutionP3990.createGrid(k);
        Assertions.assertEquals(k, countPaths(grid));
    }

    /**
     * 统计构造网格中从左上角到右下角恰好有多少条只向右/向下移动的路径
     */
    private long countPaths(List<String> grid) {
        int m = grid.size();
        int n = grid.get(0).length();
        long[][] dp = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).charAt(j) == '#') {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
