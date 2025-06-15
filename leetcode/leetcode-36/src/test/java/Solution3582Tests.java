import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3582Tests {
    private final Solution3582 solution3582 = new Solution3582();

    @Test
    public void example1() {
        String caption = "Leetcode daily streak achieved";
        String expected = "#leetcodeDailyStreakAchieved";
        Assertions.assertEquals(expected, solution3582.generateTag(caption));
    }

    @Test
    public void example2() {
        String caption = "can I Go There";
        String expected = "#canIGoThere";
        Assertions.assertEquals(expected, solution3582.generateTag(caption));
    }

    @Test
    public void example3() {
        String caption = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh";
        String expected = "#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh";
        Assertions.assertEquals(expected, solution3582.generateTag(caption));
    }
}