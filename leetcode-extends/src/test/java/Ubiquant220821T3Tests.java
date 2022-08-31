import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ubiquant220821T3Tests {
    private final Ubiquant220821T3 ubiquant220821T3 = new Ubiquant220821T3();

    @Test
    public void example1() {
        int[] numbers = {50, 75, 100};
        int expected = 5;
        Assertions.assertEquals(expected, ubiquant220821T3.minOperations(numbers));
    }

    @Test
    public void example2() {
        int[] numbers = {10, 14};
        int expected = -1;
        Assertions.assertEquals(expected, ubiquant220821T3.minOperations(numbers));
    }
}
