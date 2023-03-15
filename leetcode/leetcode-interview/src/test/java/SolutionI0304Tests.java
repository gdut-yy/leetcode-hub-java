import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0304Tests {
    @Test
    public void example1() {
        SolutionI0304.MyQueue myQueue = new SolutionI0304.MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        Assertions.assertEquals(1, myQueue.peek());
        Assertions.assertEquals(1, myQueue.pop());
        Assertions.assertFalse(myQueue.empty());
    }
}
