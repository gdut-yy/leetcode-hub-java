import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution582Tests {
    private final Solution582 solution582 = new Solution582();

    @Test
    public void example1() {
        List<Integer> pid = List.of(1, 3, 10, 5);
        List<Integer> ppid = List.of(3, 0, 5, 3);
        int kill = 5;
        List<Integer> expected = new ArrayList<>(List.of(5, 10));
        List<Integer> actual = solution582.killProcess(pid, ppid, kill);
        Collections.sort(expected);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        List<Integer> pid = List.of(1);
        List<Integer> ppid = List.of(0);
        int kill = 1;
        List<Integer> expected = new ArrayList<>(List.of(1));
        List<Integer> actual = solution582.killProcess(pid, ppid, kill);
        Collections.sort(expected);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }
}
