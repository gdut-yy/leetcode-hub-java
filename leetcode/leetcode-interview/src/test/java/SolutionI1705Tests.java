import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1705Tests {
    private final SolutionI1705 solutionI1705 = new SolutionI1705();

    @Test
    public void example1() {
        String[] array = UtUtils.stringToStrings("""
                ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
                """);
        String[] expected = UtUtils.stringToStrings("""
                ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
                """);
        Assertions.assertArrayEquals(expected, solutionI1705.findLongestSubarray(array));
    }

    @Test
    public void example2() {
        String[] array = UtUtils.stringToStrings("""
                ["A","A"]
                """);
        String[] expected = UtUtils.stringToStrings("""
                []
                """);
        Assertions.assertArrayEquals(expected, solutionI1705.findLongestSubarray(array));
    }
}