import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionI0812Tests {
    private final SolutionI0812 solutionI0812 = new SolutionI0812();

    @Test
    public void example1() {
        int n = 4;
        List<List<String>> actual = solutionI0812.solveNQueens(n);
        List<List<String>> expected = new ArrayList<>(Arrays.asList(
                Arrays.asList(".Q..", "...Q", "Q...", "..Q."), Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        ));
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
