import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP33Tests {
    private final SolutionLCP33 solutionLCP33 = new SolutionLCP33();

    @Test
    public void example1() {
        int[] bucket = {1, 3};
        int[] vat = {6, 8};
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP33.storeWater(bucket, vat));
    }

    @Test
    public void example2() {
        int[] bucket = {9, 0, 1};
        int[] vat = {0, 2, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP33.storeWater(bucket, vat));
    }
}
