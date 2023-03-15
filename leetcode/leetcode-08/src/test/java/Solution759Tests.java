import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution759Tests {
    private final Solution759 solution759 = new Solution759();

    @Test
    public void example1() {
        List<List<Solution759.Interval>> schedule = new ArrayList<>();
        schedule.add(List.of(new Solution759.Interval(1, 2), new Solution759.Interval(5, 6)));
        schedule.add(List.of(new Solution759.Interval(1, 3)));
        schedule.add(List.of(new Solution759.Interval(4, 10)));
        List<Solution759.Interval> expected = List.of(new Solution759.Interval(3, 4));
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution759.employeeFreeTime(schedule)));
    }

    @Test
    public void example2() {
        List<List<Solution759.Interval>> schedule = new ArrayList<>();
        schedule.add(List.of(new Solution759.Interval(1, 3), new Solution759.Interval(6, 7)));
        schedule.add(List.of(new Solution759.Interval(2, 4)));
        schedule.add(List.of(new Solution759.Interval(2, 5), new Solution759.Interval(9, 12)));
        List<Solution759.Interval> expected = List.of(new Solution759.Interval(5, 6), new Solution759.Interval(7, 9));
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution759.employeeFreeTime(schedule)));
    }
}
