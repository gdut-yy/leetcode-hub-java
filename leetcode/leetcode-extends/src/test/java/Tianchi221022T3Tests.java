import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tianchi221022T3Tests {
    private final Tianchi221022T3 tianchi221022T3 = new Tianchi221022T3();

    @Test
    public void example1() {
        int[] order = {5, 5, 6, 5};
        int limit = 2;
        int[] expected = {5, 5, 6};
        Assertions.assertArrayEquals(expected, tianchi221022T3.arrangeBookshelf(order, limit));
    }

    @Test
    public void example2() {
        int[] order = {5, 5, 6, 5};
        int limit = 3;
        int[] expected = {5, 5, 6, 5};
        Assertions.assertArrayEquals(expected, tianchi221022T3.arrangeBookshelf(order, limit));
    }

    @Test
    public void example3() {
        int[] order = {3, 3, 9, 8, 9, 2, 8};
        int limit = 1;
        int[] expected = {3, 8, 9, 2};
        Assertions.assertArrayEquals(expected, tianchi221022T3.arrangeBookshelf(order, limit));
    }

    @Test
    public void example4() {
        int[] order = {2, 1, 2, 2, 1, 3, 3, 1, 3, 3};
        int limit = 2;
        int[] expected = {1, 2, 2, 1, 3, 3};
        Assertions.assertArrayEquals(expected, tianchi221022T3.arrangeBookshelf(order, limit));
    }
}
