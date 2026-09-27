import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3929Tests {
    private final SolutionP3929 solutionP3929 = new SolutionP3929();

    @Test
    public void example1() {
        int[] nums = UtUtils.stringToInts("[5,1,2,1]");
        int k = 2;
        long expected = 25;
        Assertions.assertEquals(expected, solutionP3929.minPartitionScore(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = UtUtils.stringToInts("[1,2,3,4]");
        int k = 1;
        long expected = 55;
        Assertions.assertEquals(expected, solutionP3929.minPartitionScore(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = UtUtils.stringToInts("[1,1,1]");
        int k = 3;
        long expected = 3;
        Assertions.assertEquals(expected, solutionP3929.minPartitionScore(nums, k));
    }
}
