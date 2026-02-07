import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3369Tests {
    @Test
    public void example1() {
        SolutionP3369.StatisticsTracker statisticsTracker = new SolutionP3369.StatisticsTracker();

        // 现在数据结构中有 [4]
        statisticsTracker.addNumber(4);

        // 现在数据结构中有 [4, 4]
        statisticsTracker.addNumber(4);

        // 现在数据结构中有 [4, 4, 2]
        statisticsTracker.addNumber(2);

        // 现在数据结构中有 [4, 4, 2, 3]
        statisticsTracker.addNumber(3);

        // return 3
        Assertions.assertEquals(3, statisticsTracker.getMean());

        // return 4
        Assertions.assertEquals(4, statisticsTracker.getMedian());

        // return 4
        Assertions.assertEquals(4, statisticsTracker.getMode());

        // 现在数据结构中有 [4, 2, 3]
        statisticsTracker.removeFirstAddedNumber();

        // return 2
        Assertions.assertEquals(2, statisticsTracker.getMode());
    }

    @Test
    public void example2() {
        SolutionP3369.StatisticsTracker statisticsTracker = new SolutionP3369.StatisticsTracker();

        // 现在数据结构中有 [9]
        statisticsTracker.addNumber(9);

        // 现在数据结构中有 [9, 5]
        statisticsTracker.addNumber(5);

        // return 7
        Assertions.assertEquals(7, statisticsTracker.getMean());

        // 现在数据结构中有 [5]
        statisticsTracker.removeFirstAddedNumber();

        // 现在数据结构中有 [5, 5]
        statisticsTracker.addNumber(5);

        // 现在数据结构中有 [5, 5, 6]
        statisticsTracker.addNumber(6);

        // 现在数据结构中有 [5, 6]
        statisticsTracker.removeFirstAddedNumber();

        // return 6
        Assertions.assertEquals(6, statisticsTracker.getMedian());

        // 现在数据结构中有 [5, 6, 8]
        statisticsTracker.addNumber(8);

        // return 5
        Assertions.assertEquals(5, statisticsTracker.getMode());
    }
}