import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        // 初始化
        Arrays.fill(queens, -1);

        // 列、主对角线、副对角线
        // 在 O(1) 的时间内判断该位置所在的列和两条斜线上是否已经有皇后
        List<Set<Integer>> colMainAntiDiagonals = List.of(new HashSet<>(), new HashSet<>(), new HashSet<>());

        // 迭代
        dfs(res, queens, n, 0, colMainAntiDiagonals);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param res                  结果集
     * @param queens               每行放置的皇后的列下标
     * @param n                    入参 n
     * @param row                  行
     * @param colMainAntiDiagonals 列、主对角线、副对角线
     */
    private void dfs(List<List<String>> res, int[] queens, int n, int row, List<Set<Integer>> colMainAntiDiagonals) {
        // 列
        Set<Integer> columns = colMainAntiDiagonals.get(0);
        // 主对角线
        Set<Integer> mainDiagonals = colMainAntiDiagonals.get(1);
        // 副对角线
        Set<Integer> antiDiagonals = colMainAntiDiagonals.get(2);

        if (row == n) {
            List<String> board = generateBoard(queens, n);
            res.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int mainDiagonal = row - i;
                if (mainDiagonals.contains(mainDiagonal)) {
                    continue;
                }
                int antiDiagonal = row + i;
                if (antiDiagonals.contains(antiDiagonal)) {
                    continue;
                }
                // 操作
                queens[row] = i;
                columns.add(i);
                mainDiagonals.add(mainDiagonal);
                antiDiagonals.add(antiDiagonal);
                // 下一迭代
                dfs(res, queens, n, row + 1, colMainAntiDiagonals);
                // 回退操作
                queens[row] = -1;
                columns.remove(i);
                mainDiagonals.remove(mainDiagonal);
                antiDiagonals.remove(antiDiagonal);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
/*
51. N 皇后
https://leetcode-cn.com/problems/n-queens/

回溯算法。
经典八皇后问题，数学家高斯穷其一生也没有计算出正确答案。而我们借助计算机可秒出答案。

为了降低总时间复杂度，每次放置皇后时需要快速判断每个位置是否可以放置皇后，
显然，最理想的情况是在 O(1) 的时间内判断该位置所在的列和两条斜线上是否已经有皇后。

时间复杂度 O(n!)
空间复杂度 O(n)
 */
