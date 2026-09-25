import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cmbchina220410T4Tests {
    private final Cmbchina220410T4 cmbchina220410T4 = new Cmbchina220410T4();

    @Test
    public void example1() {
        int[] priceA = UtUtils.stringToInts("[1,2,5]");
        int[] priceB = UtUtils.stringToInts("[2,2,2]");
        int expected = 4;
        Assertions.assertEquals(expected, cmbchina220410T4.goShopping(priceA, priceB));
    }

    @Test
    public void example2() {
        int[] priceA = UtUtils.stringToInts("[1,6,1]");
        int[] priceB = UtUtils.stringToInts("[2,2,6]");
        int expected = 4;
        Assertions.assertEquals(expected, cmbchina220410T4.goShopping(priceA, priceB));
    }

    @Test
    public void example3() {
        int[] priceA = UtUtils.stringToInts("[3,13,5,12]");
        int[] priceB = UtUtils.stringToInts("[28,12,20,7]");
        int expected = 21;
        Assertions.assertEquals(expected, cmbchina220410T4.goShopping(priceA, priceB));
    }
}
