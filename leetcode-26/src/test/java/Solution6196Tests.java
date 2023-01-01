import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6196Tests {
    private final Solution6196 solution6196 = new Solution6196();

    @Test
    public void example1() {
        String s = "165462";
        int k = 60;
        int expected = 4;
        Assertions.assertEquals(expected, solution6196.minimumPartition(s, k));
    }

    @Test
    public void example2() {
        String s = "238182";
        int k = 5;
        int expected = -1;
        Assertions.assertEquals(expected, solution6196.minimumPartition(s, k));
    }
}
