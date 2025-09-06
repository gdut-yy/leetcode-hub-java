import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP3481Tests {
    private final SolutionP3481 solutionP3481 = new SolutionP3481();

    @Test
    public void example1() {
        List<List<String>> replacements = UtUtils.stringToStringList2("""
                [["A","abc"],["B","def"]]
                """);
        String text = "%A%_%B%";
        String expected = "abc_def";
        Assertions.assertEquals(expected, solutionP3481.applySubstitutions(replacements, text));
    }

    @Test
    public void example2() {
        List<List<String>> replacements = UtUtils.stringToStringList2("""
                [["A","bce"],["B","ace"],["C","abc%B%"]]
                """);
        String text = "%A%_%B%_%C%";
        String expected = "bce_ace_abcace";
        Assertions.assertEquals(expected, solutionP3481.applySubstitutions(replacements, text));
    }
}