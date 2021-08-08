import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Solution51Tests {
    private final Solution51 solution51 = new Solution51();

    private final Comparator<List<String>> comparator = (o1, o2) -> {
        // o1.size() == o2.size();
        for (int i = 0; i < o1.size(); i++) {
            if (!Objects.equals(o1.get(i), o2.get(i))) {
                return o1.get(i).compareTo(o2.get(i));
            }
        }
        return 0;
    };

    @Test
    public void example1() {
        int n = 4;
        List<List<String>> actual = solution51.solveNQueens(n);
        List<List<String>> expected = new ArrayList<>(List.of(
                List.of(".Q..", "...Q", "Q...", "..Q."), List.of("..Q.", "Q...", "...Q", ".Q..")
        ));
//        List<List<String>> expected = new ArrayList<>(List.of(
//                List.of("..Q.", "Q...", "...Q", ".Q.."), List.of(".Q..", "...Q", "Q...", "..Q.")
//        ));
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int n = 1;
        List<List<String>> actual = solution51.solveNQueens(n);
        List<List<String>> expected = new ArrayList<>(List.of(List.of("Q")));
        actual.sort(comparator);
        expected.sort(comparator);
        Assertions.assertEquals(expected, actual);
    }
}
