import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ubiquant220821T1Tests {
    private final Ubiquant220821T1 ubiquant220821T1 = new Ubiquant220821T1();

    @Test
    public void example1() {
        int[] nums = {17, 28, 39, 71};
        int expected = 3;
        Assertions.assertEquals(expected, ubiquant220821T1.numberOfPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {71, 60};
        int expected = 1;
        Assertions.assertEquals(expected, ubiquant220821T1.numberOfPairs(nums));
    }
}
