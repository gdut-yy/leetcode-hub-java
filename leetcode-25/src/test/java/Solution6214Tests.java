import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6214Tests {
    private final Solution6214 solution6214 = new Solution6214();

    @Test
    public void example1() {
        String[] event1 = {"01:15", "02:00"};
        String[] event2 = {"02:00", "03:00"};
        Assertions.assertTrue(solution6214.haveConflict(event1, event2));
    }

    @Test
    public void example2() {
        String[] event1 = {"01:00", "02:00"};
        String[] event2 = {"01:20", "03:00"};
        Assertions.assertTrue(solution6214.haveConflict(event1, event2));
    }

    @Test
    public void example3() {
        String[] event1 = {"10:00", "11:00"};
        String[] event2 = {"14:00", "15:00"};
        Assertions.assertFalse(solution6214.haveConflict(event1, event2));
    }
}
