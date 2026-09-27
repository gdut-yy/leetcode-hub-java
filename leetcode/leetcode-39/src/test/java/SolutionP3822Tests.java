import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3822Tests {
    @Test
    public void example1() {
        SolutionP3822.OrderManagementSystem orderManagementSystem = new SolutionP3822.OrderManagementSystem();

        // 一个 ID 为 1 的买入订单以价格 1 添加。
        orderManagementSystem.addOrder(1, "buy", 1);

        // 一个 ID 为 2 的买入订单以价格 1 添加。
        orderManagementSystem.addOrder(2, "buy", 1);

        // 一个 ID 为 3 的买入订单以价格 2 添加。
        orderManagementSystem.addOrder(3, "sell", 2);

        // 两个买入订单（ID 1 和 2）在价格 1 是有效的，所以结果是 [2, 1]。
        Assertions.assertArrayEquals(new int[]{1, 2}, orderManagementSystem.getOrdersAtPrice("buy", 1));

        // 更新订单 1：价格变为 3。
        orderManagementSystem.modifyOrder(1, 3);

        // 更新订单 2，但价格依然是 1。
        orderManagementSystem.modifyOrder(2, 1);

        // 在价格 1 只有订单 2 还有效，所以结果是 [2]。
        Assertions.assertArrayEquals(new int[]{2}, orderManagementSystem.getOrdersAtPrice("buy", 1));

        // ID为 3 的卖出订单已被取消并从有效订单中移除。
        orderManagementSystem.cancelOrder(3);

        // ID为 2 的卖出订单已被取消并从有效订单中移除。
        orderManagementSystem.cancelOrder(2);

        // 在价格 1 没有剩余的有效订单，所以结果是 []。
        Assertions.assertArrayEquals(new int[]{}, orderManagementSystem.getOrdersAtPrice("buy", 1));
    }
}
