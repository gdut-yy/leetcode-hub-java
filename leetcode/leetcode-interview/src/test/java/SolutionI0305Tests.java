import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0305Tests {
    @Test
    public void example1() {
        SolutionI0305.SortedStack sortedStack = new SolutionI0305.SortedStack();
        sortedStack.push(1);
        sortedStack.push(2);
        Assertions.assertEquals(1, sortedStack.peek());
        sortedStack.pop();
        Assertions.assertEquals(2, sortedStack.peek());
    }

    @Test
    public void example2() {
        SolutionI0305.SortedStack sortedStack = new SolutionI0305.SortedStack();
        sortedStack.pop();
        sortedStack.pop();
        sortedStack.push(1);
        sortedStack.pop();
        Assertions.assertTrue(sortedStack.isEmpty());
    }
}