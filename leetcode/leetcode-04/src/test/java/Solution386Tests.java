import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution386Tests {
    private final Solution386.V1 solution386_v1 = new Solution386.V1();
    private final Solution386.V2 solution386_v2 = new Solution386.V2();

    @Test
    public void example1() {
        int n = 13;
        List<Integer> expected = List.of(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9);
        Assertions.assertEquals(expected, solution386_v1.lexicalOrder(n));
        Assertions.assertEquals(expected, solution386_v2.lexicalOrder(n));
    }

    @Test
    public void example2() {
        int n = 2;
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, solution386_v1.lexicalOrder(n));
        Assertions.assertEquals(expected, solution386_v2.lexicalOrder(n));
    }
}
