public class Solution3484 {
    static class Spreadsheet {
        private final int[][] cells;

        public Spreadsheet(int rows) {
            cells = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            int[] pos = parseCell(cell);
            cells[pos[0]][pos[1]] = value;
        }

        public void resetCell(String cell) {
            int[] pos = parseCell(cell);
            cells[pos[0]][pos[1]] = 0;
        }

        public int getValue(String formula) {
            String expr = formula.substring(1);
            String[] parts = expr.split("\\+");
            int x = getComponentValue(parts[0]);
            int y = getComponentValue(parts[1]);
            return x + y;
        }

        private int[] parseCell(String cell) {
            char colChar = cell.charAt(0);
            int col = colChar - 'A';
            String rowStr = cell.substring(1);
            int row = Integer.parseInt(rowStr) - 1;
            return new int[]{row, col};
        }

        private int getComponentValue(String s) {
            if (s.matches("[A-Z]\\d+")) {
                int[] pos = parseCell(s);
                return cells[pos[0]][pos[1]];
            } else {
                return Integer.parseInt(s);
            }
        }
    }
}
/*
3484. 设计电子表格
https://leetcode.cn/problems/design-spreadsheet/description/

第 152 场双周赛 T2。

电子表格是一个网格，它有 26 列（从 'A' 到 'Z'）和指定数量的 rows。每个单元格可以存储一个 0 到 105 之间的整数值。
请你实现一个 Spreadsheet 类：
- Spreadsheet(int rows) 初始化一个具有 26 列（从 'A' 到 'Z'）和指定行数的电子表格。所有单元格最初的值都为 0 。
- void setCell(String cell, int value) 设置指定单元格的值。单元格引用以 "AX" 的格式提供（例如，"A1"，"B10"），其中字母表示列（从 'A' 到 'Z'），数字表示从 1 开始的行号。
- void resetCell(String cell) 重置指定单元格的值为 0 。
- int getValue(String formula) 计算一个公式的值，格式为 "=X+Y"，其中 X 和 Y 要么 是单元格引用，要么非负整数，返回计算的和。
注意： 如果 getValue 引用一个未通过 setCell 明确设置的单元格，则该单元格的值默认为 0 。
提示：
1 <= rows <= 10^3
0 <= value <= 10^5
公式保证采用 "=X+Y" 格式，其中 X 和 Y 要么是有效的单元格引用，要么是小于等于 10^5 的 非负 整数。
每个单元格引用由一个大写字母 'A' 到 'Z' 和一个介于 1 和 rows 之间的行号组成。
总共 最多会对 setCell、resetCell 和 getValue 调用 10^4 次。

哈希表模拟。
 */