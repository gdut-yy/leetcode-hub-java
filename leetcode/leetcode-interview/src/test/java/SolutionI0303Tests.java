import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0303Tests {
    @Test
    public void example1() {
        SolutionI0303.StackOfPlates stackOfPlates = new SolutionI0303.StackOfPlates(1);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        Assertions.assertEquals(2, stackOfPlates.popAt(1));
        Assertions.assertEquals(1, stackOfPlates.pop());
        Assertions.assertEquals(-1, stackOfPlates.pop());
    }

    @Test
    public void example2() {
        SolutionI0303.StackOfPlates stackOfPlates = new SolutionI0303.StackOfPlates(2);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.push(3);
        Assertions.assertEquals(2, stackOfPlates.popAt(0));
        Assertions.assertEquals(1, stackOfPlates.popAt(0));
        Assertions.assertEquals(3, stackOfPlates.popAt(0));
    }
}