import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionLCP31Tests {
    private final SolutionLCP31 solutionLCP31 = new SolutionLCP31();

    @Test
    public void example1() {
        List<List<String>> maze = UtUtils.stringToStringList2("""
                [[".#.","#.."],["...",".#."],[".##",".#."],["..#",".#."]]
                """);
        Assertions.assertTrue(solutionLCP31.escapeMaze(maze));
    }

    @Test
    public void example2() {
        List<List<String>> maze = UtUtils.stringToStringList2("""
                [[".#.","..."],["...","..."]]
                """);
        Assertions.assertFalse(solutionLCP31.escapeMaze(maze));
    }

    @Test
    public void example3() {
        List<List<String>> maze = UtUtils.stringToStringList2("""
                [["...","...","..."],[".##","###","##."],[".##","###","##."],[".##","###","##."],[".##","###","##."],[".##","###","##."],[".##","###","##."]]
                """);
        Assertions.assertFalse(solutionLCP31.escapeMaze(maze));
    }
}
