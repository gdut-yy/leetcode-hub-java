import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tianchi221022T2Tests {
    private final Tianchi221022T2 tianchi221022T2 = new Tianchi221022T2();

    @Test
    public void example1() {
        String[] grid = {"...", "L.L", "RR.", "L.R"};
        int expected = 12;
        Assertions.assertEquals(expected, tianchi221022T2.getLength(grid));
    }

    @Test
    public void example2() {
        String[] grid = {"R.", ".."};
        int expected = 1;
        Assertions.assertEquals(expected, tianchi221022T2.getLength(grid));
    }
}
