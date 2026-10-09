import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP631Tests {
    @Test
    public void example1() {
        SolutionP631.Excel excel = new SolutionP631.Excel(3, 'C');
        // 构造一个 3 * 3 的二维数组，所有值初始化为零。
        //   A B C
        // 1 0 0 0
        // 2 0 0 0
        // 3 0 0 0

        excel.set(1, 'A', 2);
        // 将 mat[1]["A"] 设置为 2 。
        //   A B C
        // 1 2 0 0
        // 2 0 0 0
        // 3 0 0 0

        // 返回 4
        Assertions.assertEquals(4, excel.sum(3, 'C', new String[]{"A1", "A1:B2"}));
        // 将 mat[3]["C"] 设置为 mat[1]["A"] 的值与矩形范围的单元格和的和，该范围的左上角单元格位置为 mat[1]["A"] ，右下角单元格位置为 mat[2]["B"] 。
        //   A B C
        // 1 2 0 0
        // 2 0 0 0
        // 3 0 0 4

        excel.set(2, 'B', 2);
        // 将 mat[3]["C"] 设置为 mat[1]["A"] 的值与矩形范围的单元格和的和，该范围的左上角单元格位置为 mat[1]["A"] ，右下角单元格位置为 mat[2]["B"] 。
        //   A B C
        // 1 2 0 0
        // 2 0 0 0
        // 3 0 0 4

        // 返回 6，注意 mat[3]['C'] 也应同步更改
        Assertions.assertEquals(6, excel.get(3, 'C'));
        // 将 mat[2]["B"] 设置为 2 。注意 mat[3]["C"] 也应该更改。
        //   A B C
        // 1 2 0 0
        // 2 0 2 0
        // 3 0 0 6
    }
}
