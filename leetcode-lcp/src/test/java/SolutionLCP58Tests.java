import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP58Tests {
    private final SolutionLCP58 solutionLCP58 = new SolutionLCP58();

    @Test
    public void example1() {
        String[][] shapes = UtUtils.stringToStrings2("""
                [["000","110","000"],["110","011","000"],["110","011","110"],["000","010","111"],["011","111","011"],["011","010","000"]]
                """);
        Assertions.assertTrue(solutionLCP58.composeCube(shapes));
    }

    @Test
    public void example2() {
        String[][] shapes = UtUtils.stringToStrings2("""
                [["101","111","000"],["000","010","111"],["010","011","000"],["010","111","010"],["101","111","010"],["000","010","011"]]
                """);
        Assertions.assertFalse(solutionLCP58.composeCube(shapes));
    }
}
