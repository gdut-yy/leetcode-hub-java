import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SfTech220619T4Tests {
    private final SfTech220619T4 sfTech220619T4 = new SfTech220619T4();

    @Test
    public void example1() {
        double x = 1;
        double y = 3;
        double[] coords = {0, 0, 0, 4, 4, 4, 2, 2, 4, 0, 0, 0};
        Assertions.assertTrue(sfTech220619T4.isPointInPolygon(x, y, coords));
    }
}
