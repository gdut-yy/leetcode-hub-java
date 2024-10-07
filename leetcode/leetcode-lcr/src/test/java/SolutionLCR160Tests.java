import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR160Tests {
    @Test
    public void example1() {
        SolutionLCR160.MedianFinder medianFinder = new SolutionLCR160.MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        Assertions.assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        Assertions.assertEquals(2.0, medianFinder.findMedian());
    }

    @Test
    public void example2() {
        SolutionLCR160.MedianFinder medianFinder = new SolutionLCR160.MedianFinder();
        medianFinder.addNum(2);
        Assertions.assertEquals(2.0, medianFinder.findMedian());
        medianFinder.addNum(3);
        Assertions.assertEquals(2.5, medianFinder.findMedian());
    }
}
