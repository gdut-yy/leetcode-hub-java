import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP71Tests {
    private final SolutionLCP71 solutionLCP71 = new SolutionLCP71();

    @Test
    public void example1() {
        String[] shape = {"....rl", "l.lr.r", ".l..r.", "..lr.."};
        int expected = 18;
        Assertions.assertEquals(expected, solutionLCP71.reservoir(shape));
    }

    @Test
    public void example2() {
        String[] shape = {".rlrlrlrl", "ll..rl..r", ".llrrllrr", "..lr..lr."};
        int expected = 18;
        Assertions.assertEquals(expected, solutionLCP71.reservoir(shape));
    }

    @Test
    public void example3() {
        String[] shape = {"rlrr", "llrl", "llr."};
        int expected = 6;
        Assertions.assertEquals(expected, solutionLCP71.reservoir(shape));
    }

    @Test
    public void example4() {
        String[] shape = {"...rl...", "..r..l..", ".r.rl.l.", "r.r..l.l", "l.l..rl.", ".l.lr.r.", "..l..r..", "...lr..."};
        int expected = 30;
        Assertions.assertEquals(expected, solutionLCP71.reservoir(shape));
    }
}
