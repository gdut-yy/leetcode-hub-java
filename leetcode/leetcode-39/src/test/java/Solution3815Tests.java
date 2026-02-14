import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3815Tests {
    @Test
    public void example1() {
        // 初始化拍卖系统
        Solution3815.AuctionSystem auctionSystem = new Solution3815.AuctionSystem();

        // 用户 1 对商品 7 出价 5
        auctionSystem.addBid(1, 7, 5);

        // 用户 2 对商品 7 出价 6
        auctionSystem.addBid(2, 7, 6);

        // 返回 2，因为用户 2 的出价最高
        Assertions.assertEquals(2, auctionSystem.getHighestBidder(7));

        // 用户 1 更新对商品 7 的出价为 8
        auctionSystem.updateBid(1, 7, 8);

        // 返回 1，因为用户 1 的出价现在最高
        Assertions.assertEquals(1, auctionSystem.getHighestBidder(7));

        // 移除用户 2 对商品 7 的出价
        auctionSystem.removeBid(2, 7);

        // 返回 1，因为用户 1 是当前最高出价者
        Assertions.assertEquals(1, auctionSystem.getHighestBidder(7));

        // 返回 -1，因为商品 3 没有任何出价
        Assertions.assertEquals(-1, auctionSystem.getHighestBidder(3));
    }
}