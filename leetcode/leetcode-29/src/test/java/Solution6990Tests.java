import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6990Tests {
    private final Solution6990 solution6990 = new Solution6990();

    @Test
    public void example1() {
        int purchaseAmount = 9;
        int expected = 90;
        Assertions.assertEquals(expected, solution6990.accountBalanceAfterPurchase(purchaseAmount));
    }

    @Test
    public void example2() {
        int purchaseAmount = 15;
        int expected = 80;
        Assertions.assertEquals(expected, solution6990.accountBalanceAfterPurchase(purchaseAmount));
    }
}