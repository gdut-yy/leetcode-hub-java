import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6254Tests {
    private final Solution6254 solution6254 = new Solution6254();

    @Test
    public void example1() {
        int[] skill = {3, 2, 5, 1, 3, 4};
        int expected = 22;
        Assertions.assertEquals(expected, solution6254.dividePlayers(skill));
    }

    @Test
    public void example2() {
        int[] skill = {3, 4};
        int expected = 12;
        Assertions.assertEquals(expected, solution6254.dividePlayers(skill));
    }

    @Test
    public void example3() {
        int[] skill = {1, 1, 2, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution6254.dividePlayers(skill));
    }
}
