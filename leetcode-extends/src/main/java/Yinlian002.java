import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Yinlian002 {
    static class DiscountSystem {
        private final Map<Integer, Activity> hashMap;

        public DiscountSystem() {
            hashMap = new HashMap<>();
        }

        public void addActivity(int actId, int priceLimit, int discount, int number, int userLimit) {
            Activity activity = new Activity(actId, priceLimit, discount, number, userLimit);
            hashMap.put(actId, activity);
        }

        public void removeActivity(int actId) {
            hashMap.remove(actId);
        }

        public int consume(int userId, int cost) {
            // 若同时满足多个优惠活动时，则优先参加优惠减免最大的活动
            // 注：若有多个优惠减免最大的活动，优先参加 actId 最小的活动
            PriorityQueue<Activity> priorityQueue = new PriorityQueue<>((o1, o2) -> {
                if (o1.discount == o2.discount) {
                    return Integer.compare(o1.actId, o2.actId);
                }
                return Integer.compare(o2.discount, o1.discount);
            });

            for (Map.Entry<Integer, Activity> entry : hashMap.entrySet()) {
                Activity activity = entry.getValue();
                // 单笔消费的原价不小于 priceLimit 时，可享受 discount 的减免
                // 每个用户最多参与该优惠活动 userLimit 次
                // 该优惠活动共有 number 数量的参加名额
                if (cost >= activity.priceLimit
                        && activity.cntMap.getOrDefault(userId, 0) < activity.userLimit
                        && activity.cnt < activity.number) {
                    priorityQueue.add(activity);
                }
            }

            // 若可享受优惠减免，则 「支付金额 = 原价 - 优惠减免」
            if (!priorityQueue.isEmpty()) {
                Activity activity = priorityQueue.poll();
                Activity update = hashMap.get(activity.actId);
                update.cntMap.put(userId, update.cntMap.getOrDefault(userId, 0) + 1);
                update.cnt += 1;
                return cost - update.discount;
            } else {
                return cost;
            }
        }

        private static class Activity {
            int actId;
            int priceLimit;
            int discount;
            int number;
            int userLimit;
            Map<Integer, Integer> cntMap;
            int cnt;

            public Activity(int actId, int priceLimit, int discount, int number, int userLimit) {
                this.actId = actId;
                this.priceLimit = priceLimit;
                this.discount = discount;
                this.number = number;
                this.userLimit = userLimit;
                cntMap = new HashMap<>();
                cnt = 0;
            }
        }
    }
}
/*
银联-02. 优惠活动系统
https://leetcode-cn.com/contest/cnunionpay-2022spring/problems/kDPV0f/

「云闪付」作为各方联手打造的全新移动端统一入口，致力成为消费者省钱省心的移动支付管家。
请你设计一个「云闪付」优惠活动管理系统 DiscountSystem，具体功能如下：
- AddActivity(int actId, int priceLimit, int discount, int number, int userLimit) -- 表示创建编号为 actId 的优惠减免活动：
 - 单笔消费的原价不小于 priceLimit 时，可享受 discount 的减免
 - 每个用户最多参与该优惠活动 userLimit 次
 - 该优惠活动共有 number 数量的参加名额
- RemoveActivity(actId) -- 表示结束编号为 actId 的优惠活动
- Consume(int userId, int cost) -- 表示用户 userId 产生了一笔原价为 cost 的消费。请返回用户的实际支付金额。
 - 单次消费最多可参加一份优惠活动
 - 若可享受优惠减免，则 「支付金额 = 原价 - 优惠减免」
 - 若同时满足多个优惠活动时，则优先参加优惠减免最大的活动
注：若有多个优惠减免最大的活动，优先参加 actId 最小的活动
注意：
- actId 全局唯一
提示：
1 <= addActicity, removeActivity, consume 累计操作数 <= 10^3
0 <= actId, userId <= 1000
1 <= discount < priceLimit <= 10^5
1 <= cost <= 10^5
1 <= number <= 1000
1 <= userLimit <= 10

设计题。
 */