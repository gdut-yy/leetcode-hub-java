import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3860Tests {
    private final SolutionP3860 solutionP3860 = new SolutionP3860();

    @Test
    public void example1() {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3860.uniqueEmailGroups(emails));
    }

    @Test
    public void example2() {
        String[] emails = {"A@B.com", "a@b.com", "ab+xy@b.com", "a.b@b.com"};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3860.uniqueEmailGroups(emails));
    }

    @Test
    public void example3() {
        String[] emails = {"a.b+c.d+e@DoMain.com", "ab+xyz@domain.com", "ab@domain.com"};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3860.uniqueEmailGroups(emails));
    }
}
