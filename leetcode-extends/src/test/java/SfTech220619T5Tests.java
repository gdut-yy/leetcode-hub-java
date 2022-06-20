import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SfTech220619T5Tests {
    private final SfTech220619T5 sfTech220619T5 = new SfTech220619T5();

    @Test
    public void example1() {
        int[][] distance = UtUtils.stringToInts2("[[0,1,3], [1,0,3], [3,3,0]]");
        int n = 2;
        Assertions.assertTrue(sfTech220619T5.isCompliance(distance, n));
    }

    @Test
    public void example2() {
        int[][] distance = UtUtils.stringToInts2("[[0,3,3],[3,0,3],[3,3,0]]");
        int n = 2;
        Assertions.assertFalse(sfTech220619T5.isCompliance(distance, n));
    }
}
