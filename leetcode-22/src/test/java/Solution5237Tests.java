import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Solution5237Tests {
    private final Solution5237 solution5237 = new Solution5237();

    @Test
    public void example1() {
        String s = "aabb";
        int expected = 2;
        Assertions.assertEquals(expected, solution5237.minMovesToMakePalindrome(s));
    }

    @Test
    public void example2() {
        String s = "letelt";
        int expected = 2;
        Assertions.assertEquals(expected, solution5237.minMovesToMakePalindrome(s));
    }

    // 补充用例
    @Test
    @Disabled
    public void example3() {
        String s = "eqvvhtcsaaqtqesvvqch";
        int expected = 2;
        Assertions.assertEquals(expected, solution5237.minMovesToMakePalindrome(s));
    }
}
