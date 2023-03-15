import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Autox220828T1Tests {
    private final Autox220828T1 autox220828T1 = new Autox220828T1();

    @Test
    public void example1() {
        int num = 3;
        int[] block = {5, 9, 8, 6};
        int expected = 11;
        Assertions.assertEquals(expected, autox220828T1.getLengthOfWaterfallFlow(num, block));
    }

    @Test
    public void example2() {
        int num = 2;
        int[] block = {9, 1, 1, 1, 1, 1};
        int expected = 9;
        Assertions.assertEquals(expected, autox220828T1.getLengthOfWaterfallFlow(num, block));
    }
}
