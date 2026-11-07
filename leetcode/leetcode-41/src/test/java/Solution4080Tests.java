import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4080Tests {
    @Test
    public void example1() {
        // 初始有 20 排空座位
        Solution4080.BusBooking booking = new Solution4080.BusBooking(20);

        // 预订 "B3"。这是一个中间座位，需要 1 秒。当前总时间为 1。
        booking.toggle("B3");

        // 预订 "A3"。这是一个靠窗座位，其相邻的中间座位 "B3" 已经被预订，因此需要 3 秒。当前总时间为 1 + 3 = 4。
        booking.toggle("A3");

        // 返回 4，因为按照 toggle 的调用顺序，"B3" 需要 1 秒，"A3" 需要 3 秒。
        Assertions.assertEquals(4, booking.getTotalTime());

        // 返回 2。如果先预订 "A3"，再预订 "B3"，就可以避免额外延迟，因此预订两个座位共需要 2 秒。
        Assertions.assertEquals(2, booking.getMinTime());

        // 预订 "C3"。这是一个中间座位，需要 1 秒。当前总时间为 4 + 1 = 5。
        booking.toggle("C3");

        // 预订 "D3"。这是一个靠窗座位，其相邻的中间座位 "C3" 已经被预订，因此需要 3 秒。当前总时间为 5 + 3 = 8。
        booking.toggle("D3");

        // 返回 8，因为按照 toggle 的调用顺序，各座位的时间开销依次为 1、3、1、3。
        Assertions.assertEquals(8, booking.getTotalTime());

        // 返回 4。按照最优预订顺序，不会产生任何额外延迟，因此预订 4 个座位需要 4 * 1 = 4 秒。
        Assertions.assertEquals(4, booking.getMinTime());
    }

    @Test
    public void example2() {
        // 初始有 10 排空座位
        Solution4080.BusBooking booking = new Solution4080.BusBooking(10);

        // 预订 "C7"。这是一个中间座位，需要 1 秒。当前总时间为 1。
        booking.toggle("C7");

        // 预订 "D7"。这是一个靠窗座位，其相邻的中间座位 "C7" 已经被预订，因此需要 3 秒。当前总时间为 1 + 3 = 4。
        booking.toggle("D7");

        // 返回 4，因为按照 toggle 的调用顺序，"C7" 需要 1 秒，"D7" 需要 3 秒。
        Assertions.assertEquals(4, booking.getTotalTime());

        // "D7" 已经被预订，因此将其释放。这会移除它对应的 3 秒时间开销。当前总时间为 4 - 3 = 1。
        booking.toggle("D7");

        // "C7" 已经被预订，因此将其释放。这会移除它对应的 1 秒时间开销。当前总时间为 1 - 1 = 0，此时第 7 排为空。
        booking.toggle("C7");

        // 再次预订 "D7"。这是一个靠窗座位，这次其相邻的中间座位 "C7" 尚未被预订，因此只需要 1 秒。当前总时间为 0 + 1 = 1。
        booking.toggle("D7");

        // 返回 1，因为当前只有 "D7" 被预订，并且这次预订的时间开销为 1 秒。
        Assertions.assertEquals(1, booking.getTotalTime());

        // 返回 1。按照最优预订顺序，当前唯一一个已预订座位需要 1 * 1 = 1 秒。
        Assertions.assertEquals(1, booking.getMinTime());
    }
}
