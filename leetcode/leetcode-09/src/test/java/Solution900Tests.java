import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution900Tests {
    @Test
    public void example1() {
        int[] encoding = {3, 8, 0, 9, 2, 5};

        // 这映射到序列 [8,8,8,5,5]。
        Solution900.RLEIterator rLEIterator = new Solution900.RLEIterator(encoding);

        // 耗去序列的 2 个项，返回 8。现在剩下的序列是 [8, 5, 5]。
        Assertions.assertEquals(8, rLEIterator.next(2));

        // 耗去序列的 1 个项，返回 8。现在剩下的序列是 [5, 5]。
        Assertions.assertEquals(8, rLEIterator.next(1));

        // 耗去序列的 1 个项，返回 5。现在剩下的序列是 [5]。
        Assertions.assertEquals(5, rLEIterator.next(1));

        // 耗去序列的 2 个项，返回 -1。 这是由于第一个被耗去的项是 5，但第二个项并不存在。由于最后一个要耗去的项不存在，我们返回 -1。
        Assertions.assertEquals(-1, rLEIterator.next(2));
    }
}