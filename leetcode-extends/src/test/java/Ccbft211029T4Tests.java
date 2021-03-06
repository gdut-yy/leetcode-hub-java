import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ccbft211029T4Tests {
    private final Ccbft211029T4 ccbft211029T4 = new Ccbft211029T4();

    @Test
    public void example1() {
        int row = 5;
        int col = 6;
        int[][] position = UtUtils.stringToInts2("[[1,3],[3,2],[4,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, ccbft211029T4.electricityExperiment(row, col, position));
    }

    @Test
    public void example2() {
        int row = 3;
        int col = 4;
        int[][] position = UtUtils.stringToInts2("[[0,3],[2,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, ccbft211029T4.electricityExperiment(row, col, position));
    }

    @Test
    public void example3() {
        int row = 5;
        int col = 6;
        int[][] position = UtUtils.stringToInts2("[[1,3],[3,5],[2,0]]");
        int expected = 6;
        Assertions.assertEquals(expected, ccbft211029T4.electricityExperiment(row, col, position));
    }

    // 补充数据
    @Test
    public void example4() {
        // 34 / 38 个通过测试用例
        String fileName = "ccbft/211029T4-example4-input.txt";
        int row = UtUtils.loadingInt(fileName, 0);
        int col = UtUtils.loadingInt(fileName, 1);
        int[][] position = UtUtils.loadingInts2(fileName, 2);
        int expected = 206737023;
        Assertions.assertEquals(expected, ccbft211029T4.electricityExperiment(row, col, position));
    }    // 补充数据

    @Test
    public void example5() {
        // 35 / 38 个通过测试用例
        String fileName = "ccbft/211029T4-example5-input.txt";
        int row = UtUtils.loadingInt(fileName, 0);
        int col = UtUtils.loadingInt(fileName, 1);
        int[][] position = UtUtils.loadingInts2(fileName, 2);
        int expected = 517582577;
        Assertions.assertEquals(expected, ccbft211029T4.electricityExperiment(row, col, position));
    }

    @Test
    public void example6() {
        // 36 / 38 个通过测试用例
        String fileName = "ccbft/211029T4-example6-input.txt";
        int row = UtUtils.loadingInt(fileName, 0);
        int col = UtUtils.loadingInt(fileName, 1);
        int[][] position = UtUtils.loadingInts2(fileName, 2);
        int expected = 285160072;
        Assertions.assertEquals(expected, ccbft211029T4.electricityExperiment(row, col, position));
    }

    @Test
    public void example7() {
        // 37 / 38 个通过测试用例
        String fileName = "ccbft/211029T4-example7-input.txt";
        int row = UtUtils.loadingInt(fileName, 0);
        int col = UtUtils.loadingInt(fileName, 1);
        int[][] position = UtUtils.loadingInts2(fileName, 2);
        int expected = 863312396;
        Assertions.assertEquals(expected, ccbft211029T4.electricityExperiment(row, col, position));
    }
}
