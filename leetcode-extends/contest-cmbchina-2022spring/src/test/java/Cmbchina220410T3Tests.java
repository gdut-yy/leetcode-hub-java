import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cmbchina220410T3Tests {
    private final Cmbchina220410T3 cmbchina220410T3 = new Cmbchina220410T3();

    @Test
    public void example1() {
        int height = 1;
        int width = 2;
        int[] indices = UtUtils.stringToInts("[3]");
        int[] expected = {0, 1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, cmbchina220410T3.lightSticks(height, width, indices));
    }

    @Test
    public void example2() {
        int height = 2;
        int width = 2;
        int[] indices = UtUtils.stringToInts("[2,5,6,7,8,10,11]");
        int[] expected = {2};
        Assertions.assertArrayEquals(expected, cmbchina220410T3.lightSticks(height, width, indices));
    }

    @Test
    public void example3() {
        int height = 1;
        int width = 1;
        int[] indices = UtUtils.stringToInts("[0,3]");
        int[] expected = {};
        Assertions.assertArrayEquals(expected, cmbchina220410T3.lightSticks(height, width, indices));
    }
}
