import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3692Tests {
    private final Solution3692 solution3692 = new Solution3692();

    @Test
    public void example1() {
        String s = "aaabbbccdddde";
        String expected = "ab";
        Assertions.assertEquals(expected, solution3692.majorityFrequencyGroup(s));
    }

    @Test
    public void example2() {
        String s = "abcd";
        String expected = "abcd";
        Assertions.assertEquals(expected, solution3692.majorityFrequencyGroup(s));
    }

    @Test
    public void example3() {
        String s = "pfpfgi";
//        String expected = "fp";
        String expected = "pf";
        Assertions.assertEquals(expected, solution3692.majorityFrequencyGroup(s));
    }
}