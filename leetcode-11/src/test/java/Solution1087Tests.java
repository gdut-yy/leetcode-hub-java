import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution1087Tests {
    private final Solution1087 solution1087 = new Solution1087();

    @Test
    public void example1() {
        String s = "{a,b}c{d,e}f";
        String[] expected = {"acdf", "acef", "bcdf", "bcef"};
        Assertions.assertArrayEquals(expected, solution1087.expand(s));
    }

    @Test
    public void example2() {
        String s = "abcd";
        String[] expected = {"abcd"};
        Assertions.assertArrayEquals(expected, solution1087.expand(s));
    }

    // 补充用例
    @Test
    public void example3() {
        String s = "{a,b}{z,x,y}";
        String[] expected = {"ax", "ay", "az", "bx", "by", "bz"};
        Assertions.assertArrayEquals(expected, solution1087.expand(s));
    }
}
