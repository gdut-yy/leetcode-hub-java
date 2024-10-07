import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR159Tests {
    private final SolutionLCR159 solutionLCR159 = new SolutionLCR159();

    @Test
    public void example1() {
        int[] arr = {3, 2, 1};
        int k = 2;
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solutionLCR159.inventoryManagement(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {0, 1, 2, 1};
        int k = 1;
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solutionLCR159.inventoryManagement(arr, k));
    }
}
