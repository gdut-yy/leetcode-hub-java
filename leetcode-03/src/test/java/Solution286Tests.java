import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution286Tests {
    private final Solution286 solution286 = new Solution286();

    @Test
    public void example1() {
        int[][] rooms = UtUtils.stringToInts2("[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]");
        int[][] expected = UtUtils.stringToInts2("[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]");
        solution286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }

    @Test
    public void example2() {
        int[][] rooms = UtUtils.stringToInts2("[[-1]]");
        int[][] expected = UtUtils.stringToInts2("[[-1]]");
        solution286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }

    @Test
    public void example3() {
        int[][] rooms = UtUtils.stringToInts2("[[2147483647]]");
        int[][] expected = UtUtils.stringToInts2("[[2147483647]]");
        solution286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }

    @Test
    public void example4() {
        int[][] rooms = UtUtils.stringToInts2("[[0]]");
        int[][] expected = UtUtils.stringToInts2("[[0]]");
        solution286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }
}
