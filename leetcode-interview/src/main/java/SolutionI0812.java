import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionI0812 {
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
面试题 08.12. 八皇后
https://leetcode-cn.com/problems/eight-queens-lcci/

设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。

同: 51. N 皇后
https://leetcode-cn.com/problems/n-queens/
 */