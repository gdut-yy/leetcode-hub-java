import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6084Tests {
    private final Solution6084 solution6084 = new Solution6084();

    @Test
    public void example1() {
        String[] messages = {"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"};
        String[] senders = {"Alice", "userTwo", "userThree", "Alice"};
        String expected = "Alice";
        Assertions.assertEquals(expected, solution6084.largestWordCount(messages, senders));
    }

    @Test
    public void example2() {
        String[] messages = {"How is leetcode for everyone", "Leetcode is useful for practice"};
        String[] senders = {"Bob", "Charlie"};
        String expected = "Charlie";
        Assertions.assertEquals(expected, solution6084.largestWordCount(messages, senders));
    }
}
