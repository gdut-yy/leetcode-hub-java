import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3606Tests {
    private final Solution3606 solution3606 = new Solution3606();

    @Test
    public void example1() {
        String[] code = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] businessLine = {"restaurant", "grocery", "pharmacy", "restaurant"};
        boolean[] isActive = {true, true, true, true};
        List<String> expected = List.of("PHARMA5", "SAVE20");
        Assertions.assertEquals(expected, solution3606.validateCoupons(code, businessLine, isActive));
    }

    @Test
    public void example2() {
        String[] code = {"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"};
        String[] businessLine = {"grocery", "electronics", "invalid"};
        boolean[] isActive = {false, true, true};
        List<String> expected = List.of("ELECTRONICS_50");
        Assertions.assertEquals(expected, solution3606.validateCoupons(code, businessLine, isActive));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/coupon-code-validator/submissions/641614193/
        String[] code = {"1OFw", "0MvB"};
        String[] businessLine = {"electronics", "pharmacy"};
        boolean[] isActive = {true, true};
        List<String> expected = List.of("1OFw", "0MvB");
        Assertions.assertEquals(expected, solution3606.validateCoupons(code, businessLine, isActive));
    }
}