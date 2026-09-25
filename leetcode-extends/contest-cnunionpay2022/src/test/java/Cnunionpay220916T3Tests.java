import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cnunionpay220916T3Tests {
    private final Cnunionpay220916T3 cnunionpay220916T3 = new Cnunionpay220916T3();

    @Test
    public void example1() {
        int storeLimit = 10;
        int[] power = UtUtils.stringToInts("[1,3,4,3,6]");
        int[][] supply = UtUtils.stringToInts2("[[0,2,3]]");
        int expected = 4;
        Assertions.assertEquals(expected, cnunionpay220916T3.storedEnergy(storeLimit, power, supply));
    }

    @Test
    public void example2() {
        int storeLimit = 6;
        int[] power = UtUtils.stringToInts("[6,5,2,1,0]");
        int[][] supply = UtUtils.stringToInts2("[[0,1,2],[2,3,3]]");
        int expected = 0;
        Assertions.assertEquals(expected, cnunionpay220916T3.storedEnergy(storeLimit, power, supply));
    }
}
