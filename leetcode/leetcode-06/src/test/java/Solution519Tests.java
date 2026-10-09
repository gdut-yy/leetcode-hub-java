import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution519Tests {
    @Test
    public void example1() {
        Solution519.Solution solution = new Solution519.Solution(3, 1);
        Set<String> flipped = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int[] cell = solution.flip();
            Assertions.assertEquals(0, cell[1]);
            Assertions.assertTrue(cell[0] >= 0 && cell[0] < 3);
            // 同一格子不会被翻转两次
            Assertions.assertTrue(flipped.add(cell[0] + "," + cell[1]));
        }
        Assertions.assertEquals(3, flipped.size());

        solution.reset();
        int[] cell = solution.flip();
        Assertions.assertEquals(0, cell[1]);
        Assertions.assertTrue(cell[0] >= 0 && cell[0] < 3);
    }
}
