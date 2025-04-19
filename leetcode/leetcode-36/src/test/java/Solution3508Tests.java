import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3508Tests {
    @Test
    public void example1() {
        // 初始化路由器，内存限制为 3。
        Solution3508.Router router = new Solution3508.Router(3);

        // 数据包被添加，返回 True。
        Assertions.assertTrue(router.addPacket(1, 4, 90));

        // 数据包被添加，返回 True。
        Assertions.assertTrue(router.addPacket(2, 5, 90));

        // 这是一个重复数据包，返回 False。
        Assertions.assertFalse(router.addPacket(1, 4, 90));

        // 数据包被添加，返回 True。
        Assertions.assertTrue(router.addPacket(3, 5, 95));

        // 数据包被添加，[1, 4, 90] 被移除，因为数据包数量超过限制，返回 True。
        Assertions.assertTrue(router.addPacket(4, 5, 105));

        // 转发数据包 [2, 5, 90] 并将其从路由器中移除。
        Assertions.assertArrayEquals(new int[]{2, 5, 90}, router.forwardPacket());

        // 数据包被添加，返回 True。
        Assertions.assertTrue(router.addPacket(5, 2, 110));

        // 唯一目标地址为 5 且时间在 [100, 110] 范围内的数据包是 [4, 5, 105]，返回 1。
        Assertions.assertEquals(1, router.getCount(5, 100, 110));
    }

    @Test
    public void example1_1() {
        // 初始化路由器，内存限制为 3。
        Solution3508.Router2 router = new Solution3508.Router2(3);

        // 数据包被添加，返回 True。
        Assertions.assertTrue(router.addPacket(1, 4, 90));

        // 数据包被添加，返回 True。
        Assertions.assertTrue(router.addPacket(2, 5, 90));

        // 这是一个重复数据包，返回 False。
        Assertions.assertFalse(router.addPacket(1, 4, 90));

        // 数据包被添加，返回 True。
        Assertions.assertTrue(router.addPacket(3, 5, 95));

        // 数据包被添加，[1, 4, 90] 被移除，因为数据包数量超过限制，返回 True。
        Assertions.assertTrue(router.addPacket(4, 5, 105));

        // 转发数据包 [2, 5, 90] 并将其从路由器中移除。
        Assertions.assertArrayEquals(new int[]{2, 5, 90}, router.forwardPacket());

        // 数据包被添加，返回 True。
        Assertions.assertTrue(router.addPacket(5, 2, 110));

        // 唯一目标地址为 5 且时间在 [100, 110] 范围内的数据包是 [4, 5, 105]，返回 1。
        Assertions.assertEquals(1, router.getCount(5, 100, 110));
    }

    @Test
    public void example2() {
        // 初始化路由器，内存限制为 2。
        Solution3508.Router router = new Solution3508.Router(2);

        // 返回 True。
        Assertions.assertTrue(router.addPacket(7, 4, 90));

        // 返回 [7, 4, 90]。
        Assertions.assertArrayEquals(new int[]{7, 4, 90}, router.forwardPacket());

        // 没有数据包可以转发，返回 []。
        Assertions.assertArrayEquals(new int[0], router.forwardPacket());
    }

    @Test
    public void example2_1() {
        // 初始化路由器，内存限制为 2。
        Solution3508.Router2 router = new Solution3508.Router2(2);

        // 返回 True。
        Assertions.assertTrue(router.addPacket(7, 4, 90));

        // 返回 [7, 4, 90]。
        Assertions.assertArrayEquals(new int[]{7, 4, 90}, router.forwardPacket());

        // 没有数据包可以转发，返回 []。
        Assertions.assertArrayEquals(new int[0], router.forwardPacket());
    }
}