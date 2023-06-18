import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6901Tests {
    private final Solution6901 solution6901 = new Solution6901();

    @Test
    public void example1() {
        int mainTank = 5;
        int additionalTank = 10;
        int expected = 60;
        Assertions.assertEquals(expected, solution6901.distanceTraveled(mainTank, additionalTank));
    }

    @Test
    public void example2() {
        int mainTank = 1;
        int additionalTank = 2;
        int expected = 10;
        Assertions.assertEquals(expected, solution6901.distanceTraveled(mainTank, additionalTank));
    }
}