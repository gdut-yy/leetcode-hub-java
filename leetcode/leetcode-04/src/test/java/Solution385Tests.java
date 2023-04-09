import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution385Tests {
    private final Solution385 solution385 = new Solution385();

    @Test
    public void example1() {
        String s = "324";
        Solution385.NestedInteger expected = new Solution385.NestedInteger(324);
        Solution385.NestedInteger actual = solution385.deserialize(s);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }

    @Test
    public void example2() {
        String s = "[123,[456,[789]]]";
        Solution385.NestedInteger nested3 = new Solution385.NestedInteger(789);
        Solution385.NestedInteger nested2_1 = new Solution385.NestedInteger(456);
        Solution385.NestedInteger nested2_2 = new Solution385.NestedInteger();
        nested2_2.add(nested3);
        Solution385.NestedInteger nested2 = new Solution385.NestedInteger();
        nested2.add(nested2_1);
        nested2.add(nested2_2);
        Solution385.NestedInteger nested1 = new Solution385.NestedInteger(123);
        Solution385.NestedInteger expected = new Solution385.NestedInteger();
        expected.add(nested1);
        expected.add(nested2);
        Solution385.NestedInteger actual = solution385.deserialize(s);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }
}