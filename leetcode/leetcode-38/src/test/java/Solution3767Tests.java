import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3767Tests {
    private final Solution3767 solution3767 = new Solution3767();

    @Test
    public void example1() {
        int[] technique1 = {5, 2, 10};
        int[] technique2 = {10, 3, 8};
        int k = 2;
        long expected = 22;
        Assertions.assertEquals(expected, solution3767.maxPoints(technique1, technique2, k));
    }

    @Test
    public void example2() {
        int[] technique1 = {10, 20, 30};
        int[] technique2 = {5, 15, 25};
        int k = 2;
        long expected = 60;
        Assertions.assertEquals(expected, solution3767.maxPoints(technique1, technique2, k));
    }

    @Test
    public void example3() {
        int[] technique1 = {1, 2, 3};
        int[] technique2 = {4, 5, 6};
        int k = 0;
        long expected = 15;
        Assertions.assertEquals(expected, solution3767.maxPoints(technique1, technique2, k));
    }
}