import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution825Tests {
    private final Solution825 solution825 = new Solution825();

    @Test
    public void example1() {
        int[] ages = {16, 16};
        int expected = 2;
        Assertions.assertEquals(expected, solution825.numFriendRequests(ages));
    }

    @Test
    public void example2() {
        int[] ages = {16, 17, 18};
        int expected = 2;
        Assertions.assertEquals(expected, solution825.numFriendRequests(ages));
    }

    @Test
    public void example3() {
        int[] ages = {20, 30, 100, 110, 120};
        int expected = 3;
        Assertions.assertEquals(expected, solution825.numFriendRequests(ages));
    }
}
