import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution3815 {
    static class AuctionSystem {
        private Map<Integer, Map<Integer, Integer>> userBids;
        private Map<Integer, TreeSet<Bid>> itemBids;
        private Map<String, Bid> userItemBidMap;

        public AuctionSystem() {
            userBids = new HashMap<>();
            itemBids = new HashMap<>();
            userItemBidMap = new HashMap<>();
        }

        public void addBid(int userId, int itemId, int bidAmount) {
            removeBidIfExists(userId, itemId);
            Bid newBid = new Bid(userId, itemId, bidAmount);
            userBids.computeIfAbsent(userId, k -> new HashMap<>())
                    .put(itemId, bidAmount);
            itemBids.computeIfAbsent(itemId, k -> new TreeSet<>())
                    .add(newBid);
            userItemBidMap.put(getKey(userId, itemId), newBid);
        }

        public void updateBid(int userId, int itemId, int newAmount) {
            addBid(userId, itemId, newAmount);
        }

        public void removeBid(int userId, int itemId) {
            removeBidIfExists(userId, itemId);
        }

        public int getHighestBidder(int itemId) {
            TreeSet<Bid> bids = itemBids.get(itemId);
            if (bids == null || bids.isEmpty()) {
                return -1;
            }
            return bids.first().userId;
        }

        private String getKey(int userId, int itemId) {
            return userId + ":" + itemId;
        }

        private void removeBidIfExists(int userId, int itemId) {
            String key = getKey(userId, itemId);
            Bid oldBid = userItemBidMap.get(key);

            if (oldBid != null) {
                Map<Integer, Integer> userBidMap = userBids.get(userId);
                if (userBidMap != null) {
                    userBidMap.remove(itemId);
                    if (userBidMap.isEmpty()) {
                        userBids.remove(userId);
                    }
                }
                TreeSet<Bid> bids = itemBids.get(itemId);
                if (bids != null) {
                    bids.remove(oldBid);
                    if (bids.isEmpty()) {
                        itemBids.remove(itemId);
                    }
                }
                userItemBidMap.remove(key);
            }
        }

        record Bid(int userId, int itemId, int bidAmount) implements Comparable<Bid> {
            @Override
            public int compareTo(Bid other) {
                if (this.bidAmount != other.bidAmount) {
                    return Integer.compare(other.bidAmount, this.bidAmount);
                }
                return Integer.compare(other.userId, this.userId);
            }
        }
    }
}
/*
3815. 设计拍卖系统
https://leetcode.cn/problems/design-auction-system/description/

第 485 场周赛 T3。

请你设计一个拍卖系统，该系统可以实时管理来自多个用户的出价。
每个出价都与一个 userId（用户 ID）、一个 itemId（商品 ID）和一个 bidAmount（出价金额）相关联。
实现 AuctionSystem 类：
- AuctionSystem(): 初始化 AuctionSystem 对象。
- void addBid(int userId, int itemId, int bidAmount): 为 itemId 添加 userId 的一条新的出价，金额为 bidAmount。如果同一个 userId 已经对 itemId 出过价，则 用新的 bidAmount 替换 原有出价。
- void updateBid(int userId, int itemId, int newAmount): 将 userId 对 itemId 的已有出价更新为 newAmount。题目数据 保证 此出价 一定存在。
- void removeBid(int userId, int itemId): 移除 userId 对 itemId 的出价。题目数据  保证 此出价 一定存在。
- int getHighestBidder(int itemId): 返回对 itemId 出价最高的用户 userId。如果有多个用户的出价 相同且最高，返回 userId 较大的用户。如果该商品没有任何出价，则返回 -1。
提示：
1 <= userId, itemId <= 5 * 10^4
1 <= bidAmount, newAmount <= 10^9
最多调用 5 * 10^4 次 addBid、updateBid、removeBid 和 getHighestBidder。
输入保证，对于 updateBid 和 removeBid 操作，给定的 userId 和 itemId 的出价一定有效。

平衡树。
https://yuanbao.tencent.com/chat/naQivTmsDa/de575c30-1d8d-4073-8cad-217f007f3fcb
 */