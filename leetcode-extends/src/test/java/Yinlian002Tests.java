import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Yinlian002Tests {
    @Test
    public void example1() {
        // 初始化系统
        Yinlian002.DiscountSystem obj = new Yinlian002.DiscountSystem();

        // 创建编号 1 的优惠活动，单笔消费原价不小于 15 时，可享受 5 的减免，优惠活动共有 7 个名额，每个用户最多参与该活动 2 次
        obj.addActivity(1, 15, 5, 7, 2);

        // 用户 101 消费了 16，满足优惠活动 1 条件，返回实际支付 16 - 5 = 11
        Assertions.assertEquals(11, obj.consume(101, 16));

        // 结束编号为 1 的优惠活动
        obj.removeActivity(1);

        // 用户 101 消费了 19，目前不存在任何优惠活动，需按原价支付，返回 19
        Assertions.assertEquals(19, obj.consume(102, 19));
    }

    @Test
    public void example2() {
        // 初始化系统
        Yinlian002.DiscountSystem obj = new Yinlian002.DiscountSystem();

        // 创建编号 1 的优惠活动，单笔消费原价不小于 10 时，可享受 6 的减免，优惠活动共有 3 个名额，每个用户最多参与该活动 2 次
        obj.addActivity(1, 10, 6, 3, 2);

        // 创建编号 2 的优惠活动，单笔消费原价不小于 15 时，可享受 8 的减免，优惠活动共有 8 个名额，每个用户最多参与该活动 2 次
        obj.addActivity(2, 15, 8, 8, 2);

        // 用户 101 消费了 13，仅满足优惠活动 1 条件，返回实际支付 13 - 6 = 7 用户 101 参加 1 次活动 1，活动 1 剩余 2 个名额
        Assertions.assertEquals(7, obj.consume(101, 13));

        // 用户 101 消费了 8，不满足任何活动，返回支付原价 8
        Assertions.assertEquals(8, obj.consume(101, 8));

        // 结束编号为 2 的活动
        obj.removeActivity(2);

        // 用户 101 消费了 17，满足优惠活动 1 条件，返回实际支付 17 - 6 = 11 用户 101 参加 2 次活动 1，活动 1 剩余 1 个名额
        Assertions.assertEquals(11, obj.consume(101, 17));

        // 用户 101 消费了 11，满足优惠活动 1 条件，但已达到参加次数限制，返回支付原价 11
        Assertions.assertEquals(11, obj.consume(101, 11));

        // 用户 102 消费了 16，满足优惠活动 1 条件，返回实际支付 16 - 6 = 10 用户 102 参加 1 次活动 1，活动 1 无剩余名额
        Assertions.assertEquals(10, obj.consume(102, 16));

        // 用户 102 消费了 21，满足优惠活动 1 条件，但活动 1 已无剩余名额，返回支付原价 21
        Assertions.assertEquals(21, obj.consume(102, 21));
    }
}
