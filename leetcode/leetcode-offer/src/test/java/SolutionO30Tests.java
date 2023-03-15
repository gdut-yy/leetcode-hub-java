import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO30Tests {
    @Test
    public void example1() {
        SolutionO30.MinStack minStack = new SolutionO30.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // 返回 -3.
        Assertions.assertEquals(-3, minStack.min());
        minStack.pop();
        // 返回 0.
        Assertions.assertEquals(0, minStack.top());
        // 返回 -2.
        Assertions.assertEquals(-2, minStack.min());
    }
}
