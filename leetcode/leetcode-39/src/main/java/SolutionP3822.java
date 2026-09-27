import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionP3822 {
    static class OrderManagementSystem {
        static class Order {
            String orderType;
            int price;
        }

        Map<Integer, Order> idToOrder;
        Map<String, Map<Integer, Set<Integer>>> typeToPriceOrders;

        public OrderManagementSystem() {
            this.idToOrder = new HashMap<>();
            this.typeToPriceOrders = new HashMap<>();
        }

        public void addOrder(int orderId, String orderType, int price) {
            Order order = new Order();
            order.orderType = orderType;
            order.price = price;
            idToOrder.put(orderId, order);
            typeToPriceOrders.putIfAbsent(orderType, new HashMap<>());
            typeToPriceOrders.get(orderType).putIfAbsent(price, new HashSet<>());
            typeToPriceOrders.get(orderType).get(price).add(orderId);
        }

        public void modifyOrder(int orderId, int newPrice) {
            Order order = idToOrder.get(orderId);
            String orderType = order.orderType;
            int oldPrice = order.price;
            order.price = newPrice;
            Map<Integer, Set<Integer>> priceOrders = typeToPriceOrders.get(orderType);
            priceOrders.get(oldPrice).remove(orderId);
            priceOrders.putIfAbsent(newPrice, new HashSet<>());
            priceOrders.get(newPrice).add(orderId);
        }

        public void cancelOrder(int orderId) {
            Order order = idToOrder.remove(orderId);
            String orderType = order.orderType;
            int price = order.price;
            typeToPriceOrders.get(orderType).get(price).remove(orderId);
        }

        public int[] getOrdersAtPrice(String orderType, int price) {
            Map<Integer, Set<Integer>> priceOrders = typeToPriceOrders.getOrDefault(orderType, new HashMap<Integer, Set<Integer>>());
            Set<Integer> orderIdsSet = priceOrders.getOrDefault(price, new HashSet<Integer>());
            int size = orderIdsSet.size();
            int[] orderIds = new int[size];
            int index = 0;
            for (int orderId : orderIdsSet) {
                orderIds[index] = orderId;
                index++;
            }
            return orderIds;
        }
    }
}
/*
$3822. 设计订单管理系统
https://leetcode.cn/problems/design-order-management-system/description/

请设计一个简单的交易平台订单管理系统。
每个订单都有一个关联的 orderId，一个 orderType（"buy" 或 "sell"）和一个 price。
订单除非被取消，否则被视为 有效。
实现 OrderManagementSystem 类：
- OrderManagementSystem()：初始化订单管理系统。
- void addOrder(int orderId, string orderType, int price)：添加一个具有给定属性的新 有效 订单。保证 orderId 互不相同。
- void modifyOrder(int orderId, int newPrice)：修改现有订单的 价格。保证 该订单存在且有效。
- void cancelOrder(int orderId)：取消一个现有的订单。保证 该订单存在且有效。
- vector<int> getOrdersAtPrice(string orderType, int price)：返回所有匹配给定 orderType 和 price 的 有效 订单的 orderId。如果不存在此类订单，则返回空列表。
注意：可以按任意顺序返回 orderId。
示例 1：
输入：
["OrderManagementSystem", "addOrder", "addOrder", "addOrder", "getOrdersAtPrice", "modifyOrder", "modifyOrder", "getOrdersAtPrice", "cancelOrder", "cancelOrder", "getOrdersAtPrice"]
[[], [1, "buy", 1], [2, "buy", 1], [3, "sell", 2], ["buy", 1], [1, 3], [2, 1], ["buy", 1], [3], [2], ["buy", 1]]
输出：
[null, null, null, null, [2, 1], null, null, [2], null, null, []]
解释：
OrderManagementSystem orderManagementSystem = new OrderManagementSystem();
orderManagementSystem.addOrder(1, "buy", 1); // 一个 ID 为 1 的买入订单以价格 1 添加。
orderManagementSystem.addOrder(2, "buy", 1); // 一个 ID 为 2 的买入订单以价格 1 添加。
orderManagementSystem.addOrder(3, "sell", 2); // 一个 ID 为 3 的买入订单以价格 2 添加。
orderManagementSystem.getOrdersAtPrice("buy", 1); // 两个买入订单（ID 1 和 2）在价格 1 是有效的，所以结果是 [2, 1]。
orderManagementSystem.modifyOrder(1, 3); // 更新订单 1：价格变为 3。
orderManagementSystem.modifyOrder(2, 1); // 更新订单 2，但价格依然是 1。
orderManagementSystem.getOrdersAtPrice("buy", 1); // 在价格 1 只有订单 2 还有效，所以结果是 [2]。
orderManagementSystem.cancelOrder(3); // ID为 3 的卖出订单已被取消并从有效订单中移除。
orderManagementSystem.cancelOrder(2); // ID为 2 的卖出订单已被取消并从有效订单中移除。
orderManagementSystem.getOrdersAtPrice("buy", 1); // 在价格 1 没有剩余的有效订单，所以结果是 []。
提示：
1 <= orderId <= 2000
orderId 在所有订单中是 互不相同 的。
orderType 是 "buy" 或 "sell"。
1 <= price <= 10^9
调用 addOrder，modifyOrder，cancelOrder 和 getOrdersAtPrice 的总次数不超过 2000。
对于 modifyOrder 或 cancelOrder，指定的 orderId 保证 存在且有效。
 */