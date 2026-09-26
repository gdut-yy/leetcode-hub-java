import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCS02Tests {
    private final SolutionLCS02 solutionLCS02 = new SolutionLCS02();

    @Test
    public void example1() {
        int[] questions = {2, 1, 6, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCS02.halfQuestions(questions));
    }

    @Test
    public void example2() {
        int[] questions = {1, 5, 1, 3, 4, 5, 2, 5, 3, 3, 8, 6};
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCS02.halfQuestions(questions));
    }
}
