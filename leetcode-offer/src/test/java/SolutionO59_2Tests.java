import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO59_2Tests {
    @Test
    public void example1() {
        SolutionO59_2.MaxQueue maxQueue = new SolutionO59_2.MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        Assertions.assertEquals(2, maxQueue.max_value());
        Assertions.assertEquals(1, maxQueue.pop_front());
        Assertions.assertEquals(2, maxQueue.max_value());
    }

    @Test
    public void example2() {
        SolutionO59_2.MaxQueue maxQueue = new SolutionO59_2.MaxQueue();
        Assertions.assertEquals(-1, maxQueue.pop_front());
        Assertions.assertEquals(-1, maxQueue.max_value());
    }
}
