import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR122Tests {
    private final SolutionLCR122 solutionLCR122 = new SolutionLCR122();

    @Test
    public void example1() {
        String path = "a.aef.qerf.bb";
        String expected = "a aef qerf bb";
        Assertions.assertEquals(expected, solutionLCR122.pathEncryption(path));
    }
}
