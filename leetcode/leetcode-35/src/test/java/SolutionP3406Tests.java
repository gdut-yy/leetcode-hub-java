import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3406Tests {
    private final SolutionP3406 solutionP3406 = new SolutionP3406();

    @Test
    public void example1() {
        String word = "dbca";
        int numFriends = 2;
        String expected = "dbc";
        Assertions.assertEquals(expected, solutionP3406.answerString(word, numFriends));
    }

    @Test
    public void example2() {
        String word = "gggg";
        int numFriends = 4;
        String expected = "g";
        Assertions.assertEquals(expected, solutionP3406.answerString(word, numFriends));
    }
}