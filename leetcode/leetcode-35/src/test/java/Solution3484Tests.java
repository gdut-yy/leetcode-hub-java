import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3484Tests {
    @Test
    public void example1() {
        Solution3484.Spreadsheet spreadsheet = new Solution3484.Spreadsheet(3); // 初始化一个具有 3 行和 26 列的电子表格

        // 返回 12 (5+7)
        Assertions.assertEquals(12, spreadsheet.getValue("=5+7"));

        // 设置 A1 为 10
        spreadsheet.setCell("A1", 10);

        // 返回 16 (10+6)
        Assertions.assertEquals(16, spreadsheet.getValue("=A1+6"));

        // 设置 B2 为 15
        spreadsheet.setCell("B2", 15);

        // 返回 25 (10+15)
        Assertions.assertEquals(25, spreadsheet.getValue("=A1+B2"));

        // 重置 A1 为 0
        spreadsheet.resetCell("A1");

        // 返回 15 (0+15)
        Assertions.assertEquals(15, spreadsheet.getValue("=A1+B2"));
    }
}