import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ubiquant220821T4Tests {
    private final Ubiquant220821T4 ubiquant220821T4 = new Ubiquant220821T4();

    @Test
    public void example1() {
        int[] nums = UtUtils.stringToInts("[1,1]");
        int kind = 2;
        double expected = 3.00000;
        Assertions.assertEquals(expected, ubiquant220821T4.chipGame(nums, kind), 1e-5);
    }

    @Test
    public void example2() {
        int[] nums = UtUtils.stringToInts("[1,2]");
        int kind = 4;
        double expected = 3.833333;
        Assertions.assertEquals(expected, ubiquant220821T4.chipGame(nums, kind), 1e-5);
    }
}
