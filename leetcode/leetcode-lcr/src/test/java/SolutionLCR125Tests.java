import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR125Tests {
    @Test
    public void example1() {
        SolutionLCR125.CQueue cQueue = new SolutionLCR125.CQueue();
        cQueue.appendTail(3);
        Assertions.assertEquals(3, cQueue.deleteHead());
        Assertions.assertEquals(-1, cQueue.deleteHead());
    }

    @Test
    public void example2() {
        SolutionLCR125.CQueue cQueue = new SolutionLCR125.CQueue();
        Assertions.assertEquals(-1, cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        Assertions.assertEquals(5, cQueue.deleteHead());
        Assertions.assertEquals(2, cQueue.deleteHead());
    }
}
