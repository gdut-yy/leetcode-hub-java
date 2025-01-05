import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1733Tests {
    private final Solution1733 solution1733 = new Solution1733();

    @Test
    public void example1() {
        int n = 2;
        int[][] languages = UtUtils.stringToInts2("[[1],[2],[1,2]]");
        int[][] friendships = UtUtils.stringToInts2("[[1,2],[1,3],[2,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1733.minimumTeachings(n, languages, friendships));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] languages = UtUtils.stringToInts2("[[2],[1,3],[1,2],[3]]");
        int[][] friendships = UtUtils.stringToInts2("[[1,4],[1,2],[3,4],[2,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1733.minimumTeachings(n, languages, friendships));
    }
}