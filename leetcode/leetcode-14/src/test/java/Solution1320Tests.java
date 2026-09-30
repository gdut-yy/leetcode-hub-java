import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1320Tests {
    private final Solution1320 solution1320 = new Solution1320();

    @Test
    public void example1() {
        String word = "CAKE";
        int expected = 3;
        Assertions.assertEquals(expected, solution1320.minimumDistance(word));
    }

    @Test
    public void example2() {
        String word = "HAPPY";
        int expected = 6;
        Assertions.assertEquals(expected, solution1320.minimumDistance(word));
    }
}
