import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SfTech220619T3Tests {
    private final SfTech220619T3 sfTech220619T3 = new SfTech220619T3();

    @Test
    public void example1() {
        int[] nums = {54, 42, 62, 75, 82, 86, 86};
        int expected = 5;
        Assertions.assertEquals(expected, sfTech220619T3.findMaxCI(nums));
    }
}
