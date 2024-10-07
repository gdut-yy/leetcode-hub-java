import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0301Tests {
    @Test
    public void example1() {
        SolutionI0301.TripleInOne tripleInOne = new SolutionI0301.TripleInOne(1);
        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);
        Assertions.assertEquals(1, tripleInOne.pop(0));
        Assertions.assertEquals(-1, tripleInOne.pop(0));
        Assertions.assertEquals(-1, tripleInOne.pop(0));
        Assertions.assertTrue(tripleInOne.isEmpty(0));
    }

    @Test
    public void example2() {
        SolutionI0301.TripleInOne tripleInOne = new SolutionI0301.TripleInOne(2);
        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);
        tripleInOne.push(0, 3);
        Assertions.assertEquals(2, tripleInOne.pop(0));
        Assertions.assertEquals(1, tripleInOne.pop(0));
        Assertions.assertEquals(-1, tripleInOne.pop(0));
        Assertions.assertEquals(-1, tripleInOne.peek(0));
    }
}