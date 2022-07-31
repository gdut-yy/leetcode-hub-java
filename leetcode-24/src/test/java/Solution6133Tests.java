import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6133Tests {
    private final Solution6133 solution6133 = new Solution6133();

    @Test
    public void example1() {
        int[] grades = {10, 6, 12, 7, 3, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution6133.maximumGroups(grades));
    }

    @Test
    public void example2() {
        int[] grades = {8, 8};
        int expected = 1;
        Assertions.assertEquals(expected, solution6133.maximumGroups(grades));
    }
}
