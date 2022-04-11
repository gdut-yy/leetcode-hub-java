import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cmbchina220410T2Tests {
    private final Cmbchina220410T2 cmbchina220410T2 = new Cmbchina220410T2();

    @Test
    public void example1() {
        int[][] roads = UtUtils.stringToInts2("[[0,1],[1,3],[1,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, cmbchina220410T2.numFlowers(roads));
    }

    @Test
    public void example2() {
        int[][] roads = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[2,5],[3,6],[5,4]]");
        int expected = 3;
        Assertions.assertEquals(expected, cmbchina220410T2.numFlowers(roads));
    }
}
