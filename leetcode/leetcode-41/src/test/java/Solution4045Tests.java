import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4045Tests {
    private final Solution4045 solution4045 = new Solution4045();

    @Test
    public void example1() {
        int[] position = {1, 5, 6, 20};
        int[] speed = {4, 3, 2, 3};
        int distance = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution4045.countGroups(position, speed, distance));
    }

    @Test
    public void example2() {
        int[] position = {1, 5, 9};
        int[] speed = {3, 2, 2};
        int distance = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution4045.countGroups(position, speed, distance));
    }

    @Test
    public void example3() {
        int[] position = {9};
        int[] speed = {8};
        int distance = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution4045.countGroups(position, speed, distance));
    }
}