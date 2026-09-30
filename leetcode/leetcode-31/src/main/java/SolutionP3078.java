import java.util.HashMap;
import java.util.Map;

public class SolutionP3078 {
    private int[][] board;
    private String[] pattern;
    private int pm, pn;

    // https://leetcode.cn/problems/match-alphanumerical-pattern-in-matrix-i/solutions/2685978/bian-li-mo-ni-15xing-ji-jian-shuang-bai-2a4r3/
    public int[] findPattern(int[][] board, String[] pattern) {
        int m = board.length;
        int n = board[0].length;
        this.board = board;
        this.pattern = pattern;
        pm = pattern.length;
        pn = pattern[0].length();

        for (int i = 0; i <= m - pm; i++) {
            for (int j = 0; j <= n - pn; j++) {
                if (doCheck(i, j)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean doCheck(int x, int y) {
        Map<Character, Integer> has = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            has.put((char) (i + '0'), i);
        }
        char[] px = new char[10];

        for (int i = 0; i < pm; i++) {
            for (int j = 0; j < pn; j++) {
                int va = board[x + i][y + j];
                char vb = pattern[i].charAt(j);
                if (has.containsKey(vb)) {
                    if (has.get(vb) != va) {
                        return false;
                    }
                } else if (px[va] != 0) {
                    return false;
                } else {
                    has.put(vb, va);
                    px[va] = vb;
                }
            }
        }
        return true;
    }
}
/*
$3078. 矩阵中的字母数字模式匹配 I
https://leetcode.cn/problems/match-alphanumerical-pattern-in-matrix-i/description/

给定一个二维整数矩阵 board 和一个二维字符矩阵 pattern。其中 0 <= board[r][c] <= 9 并且 pattern 的每个元素是一个数字或一个小写英文字母。
你的任务是找到 匹配 board 的子矩阵 pattern。
如果我们能用一些数字（每个 不同 的字母对应 不同 的数字）替换 pattern 中包含的字母使得结果矩阵与整数矩阵 part 相同，我们称整数矩阵 part 与 pattern 匹配。换句话说，
- 这两个矩阵具有相同的维数。
- 如果 pattern[r][c] 是一个数字，那么 part[r][c] 必须是 相同的 数字。
- 如果 pattern[r][c] 是一个字母 x：
  - 对于每个 pattern[i][j] == x，part[i][j] 一定与 part[r][c] 相同。
  - 对于每个 pattern[i][j] != x，part[i][j] 一定与 part[r][c] 不同。
返回一个长度为 2 的数组，包含匹配 pattern 的 board 的子矩阵左上角的行号和列号。如果有多个这样的子矩阵，返回行号更小的子矩阵。如果依然有多个，则返回列号更小的子矩阵。如果没有符合的答案，返回 [-1, -1]。
示例 1：
1	2	2
2	2	3
2	3	3
a	b
b	b
输入：board = [[1,2,2],[2,2,3],[2,3,3]], pattern = ["ab","bb"]
输出：[0,0]
示例 2：
1	1	2
3	3	4
6	6	6
a	b
6	6
输入：board = [[1,1,2],[3,3,4],[6,6,6]], pattern = ["ab","66"]
输出：[1,1]
示例 3：
1	2
2	1
x	x
输入：board = [[1,2],[2,1]], pattern = ["xx"]
输出：[-1,-1]
提示：
1 <= board.length <= 50
1 <= board[i].length <= 50
0 <= board[i][j] <= 9
1 <= pattern.length <= 50
1 <= pattern[i].length <= 50
pattern[i][j] 表示为一个数字的字符串或一个小写英文字母。
 */
