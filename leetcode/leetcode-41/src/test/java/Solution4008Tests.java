import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4008Tests {
    private final Solution4008 solution4008 = new Solution4008();

    @Test
    public void example1() {
        int[] monsters = {5, 10, 15};
        int[][] boosts = UtUtils.stringToInts2("[[1,1,10]]");
        long expected = 30;
        Assertions.assertEquals(expected, solution4008.minInitialStrength(monsters, boosts));
    }

    @Test
    public void example2() {
        int[] monsters = {5, 10, 15};
        int[][] boosts = UtUtils.stringToInts2("[[1,2,10],[1,2,5]]");
        long expected = 5;
        Assertions.assertEquals(expected, solution4008.minInitialStrength(monsters, boosts));
    }
}