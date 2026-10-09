import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class SolutionP631 {
    static class Excel {
        Formula[][] formulas;

        record Formula(HashMap<String, Integer> cells, int val) {
        }

        Deque<int[]> stack = new ArrayDeque<>();

        public Excel(int H, char W) {
            formulas = new Formula[H][(W - 'A') + 1];
        }

        public int get(int r, char c) {
            if (formulas[r - 1][c - 'A'] == null) {
                return 0;
            }
            return formulas[r - 1][c - 'A'].val;
        }

        public void set(int r, char c, int v) {
            formulas[r - 1][c - 'A'] = new Formula(new HashMap<>(), v);
            topologicalSort(r - 1, c - 'A');
            executeStack();
        }

        public int sum(int r, char c, String[] strs) {
            HashMap<String, Integer> cells = convert(strs);
            int summ = calculateSum(r - 1, c - 'A', cells);
            set(r, c, summ);
            formulas[r - 1][c - 'A'] = new Formula(cells, summ);
            return summ;
        }

        private void topologicalSort(int r, int c) {
            for (int i = 0; i < formulas.length; i++) {
                for (int j = 0; j < formulas[0].length; j++) {
                    if (formulas[i][j] != null &&
                            formulas[i][j].cells.containsKey("" + (char) ('A' + c) + (r + 1))) {
                        topologicalSort(i, j);
                    }
                }
            }
            stack.push(new int[]{r, c});
        }

        private void executeStack() {
            while (!stack.isEmpty()) {
                int[] top = stack.pop();
                if (!formulas[top[0]][top[1]].cells.isEmpty()) {
                    calculateSum(top[0], top[1], formulas[top[0]][top[1]].cells);
                }
            }
        }

        private HashMap<String, Integer> convert(String[] strs) {
            HashMap<String, Integer> res = new HashMap<>();
            for (String st : strs) {
                if (!st.contains(":")) {
                    res.put(st, res.getOrDefault(st, 0) + 1);
                } else {
                    String[] cells = st.split(":");
                    int si = Integer.parseInt(cells[0].substring(1)),
                            ei = Integer.parseInt(cells[1].substring(1));
                    char sj = cells[0].charAt(0), ej = cells[1].charAt(0);
                    for (int i = si; i <= ei; i++) {
                        for (char j = sj; j <= ej; j++) {
                            res.put("" + j + i, res.getOrDefault("" + j + i, 0) + 1);
                        }
                    }
                }
            }
            return res;
        }

        private int calculateSum(int r, int c, HashMap<String, Integer> cells) {
            int sum = 0;
            for (String s : cells.keySet()) {
                int x = Integer.parseInt(s.substring(1)) - 1, y = s.charAt(0) - 'A';
                sum += (formulas[x][y] != null ? formulas[x][y].val : 0) * cells.get(s);
            }
            formulas[r][c] = new Formula(cells, sum);
            return sum;
        }
    }
}
/*
$631. 设计 Excel 求和公式
https://leetcode.cn/problems/design-excel-sum-formula/description/

请你设计 Excel 中的基本功能，并实现求和公式。
实现 Excel 类：
- Excel(int height, char width)：用高度 height 和宽度 width 初始化对象。该表格是一个大小为 height x width 的整数矩阵 mat，其中行下标范围是 [1, height] ，列下标范围是 ['A', width] 。初始情况下，所有的值都应该为 零 。
- void set(int row, char column, int val)：将 mat[row][column] 的值更改为 val 。
- int get(int row, char column)：返回 mat[row][column] 的值。
- int sum(int row, char column, List<String> numbers)：将 mat[row][column] 的值设为由 numbers 表示的单元格的和，并返回 mat[row][column] 的值。此求和公式应该 长期作用于 该单元格，直到该单元格被另一个值或另一个求和公式覆盖。其中，numbers[i] 的格式可以为：
  - "ColRow"：表示某个单元格。
    - 例如，"F7" 表示单元格 mat[7]['F'] 。
  - "ColRow1:ColRow2"：表示一组单元格。该范围将始终为一个矩形，其中 "ColRow1" 表示左上角单元格的位置，"ColRow2" 表示右下角单元格的位置。
    - 例如，"B3:F7" 表示 3 <= i <= 7 和 'B' <= j <= 'F' 的单元格 mat[i][j] 。
注意：可以假设不会出现循环求和引用。
- 例如，mat[1]['A'] == sum(1, "B")，且 mat[1]['B'] == sum(1, "A") 。
示例 1：
输入：
["Excel", "set", "sum", "set", "get"]
[[3, "C"], [1, "A", 2], [3, "C", ["A1", "A1:B2"]], [2, "B", 2], [3, "C"]]
输出：
[null, null, 4, null, 6]
解释：
执行以下操作：
Excel excel = new Excel(3, "C");
 // 构造一个 3 * 3 的二维数组，所有值初始化为零。
 //   A B C
 // 1 0 0 0
 // 2 0 0 0
 // 3 0 0 0
excel.set(1, "A", 2);
 // 将 mat[1]["A"] 设置为 2 。
 //   A B C
 // 1 2 0 0
 // 2 0 0 0
 // 3 0 0 0
excel.sum(3, "C", ["A1", "A1:B2"]); // 返回 4
 // 将 mat[3]["C"] 设置为 mat[1]["A"] 的值与矩形范围的单元格和的和，该范围的左上角单元格位置为 mat[1]["A"] ，右下角单元格位置为 mat[2]["B"] 。
 //   A B C
 // 1 2 0 0
 // 2 0 0 0
 // 3 0 0 4
excel.set(2, "B", 2);
 // 将 mat[2]["B"] 设置为 2 。注意 mat[3]["C"] 也应该更改。
 //   A B C
 // 1 2 0 0
 // 2 0 2 0
 // 3 0 0 6
excel.get(3, "C"); // 返回 6
提示：
1 <= height <= 26
'A' <= width <= 'Z'
1 <= row <= height
'A' <= column <= width
-100 <= val <= 100
1 <= numbers.length <= 5
numbers[i] 的格式为 "ColRow" 或 "ColRow1:ColRow2" 。
最多会对 set 、get 和 sum 进行 100 次调用。
 */