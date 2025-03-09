import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution850Tests {
    private final Solution850 solution850 = new Solution850();

    @Test
    public void example1() {
        int[][] rectangles = UtUtils.stringToInts2("[[0,0,2,2],[1,0,2,3],[1,0,3,1]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution850.rectangleArea(rectangles));
    }

    @Test
    public void example2() {
        int[][] rectangles = UtUtils.stringToInts2("[[0,0,1000000000,1000000000]]");
        int expected = 49;
        Assertions.assertEquals(expected, solution850.rectangleArea(rectangles));
    }
}