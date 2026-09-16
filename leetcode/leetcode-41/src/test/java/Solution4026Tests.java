import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4026Tests {
    private final Solution4026 solution4026 = new Solution4026();

    @Test
    public void example1() {
        String skill = "aa";
        String station = "aaaa";
        int expected = 3;
        Assertions.assertEquals(expected, solution4026.maximumGap(skill, station));
    }

    @Test
    public void example2() {
        String skill = "xyz";
        String station = "xyzz";
        int expected = 2;
        Assertions.assertEquals(expected, solution4026.maximumGap(skill, station));
    }

    @Test
    public void example3() {
        String skill = "cbc";
        String station = "cbcdbc";
        int expected = 4;
        Assertions.assertEquals(expected, solution4026.maximumGap(skill, station));
    }
}