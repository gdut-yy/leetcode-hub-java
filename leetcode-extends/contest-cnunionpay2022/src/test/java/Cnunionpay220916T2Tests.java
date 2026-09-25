import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cnunionpay220916T2Tests {
    private final Cnunionpay220916T2 cnunionpay220916T2 = new Cnunionpay220916T2();

    @Test
    public void example1() {
        int[] station = UtUtils.stringToInts("[2,7,8,10]");
        int[] pos = UtUtils.stringToInts("[4,9]");
        int[] expected = {0, 2};
        Assertions.assertArrayEquals(expected, cnunionpay220916T2.explorationSupply(station, pos));
    }

    @Test
    public void example2() {
        int[] station = UtUtils.stringToInts("[2,5,8,14,17]");
        int[] pos = UtUtils.stringToInts("[1,14,11,2]");
        int[] expected = {0, 3, 2, 0};
        Assertions.assertArrayEquals(expected, cnunionpay220916T2.explorationSupply(station, pos));
    }
}
